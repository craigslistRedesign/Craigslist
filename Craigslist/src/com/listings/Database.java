package com.listings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Database {

	/*
	 * Helper method to get a connection to the database.
	 */
	private static Connection getDatabaseConnection() {

		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager
					.getConnection(
							"jdbc:oracle:thin:@swe645instance.caigiz7a8ag7.us-west-2.rds.amazonaws.com:1521:swe645",
							"swe645", "Swe645Spring");
		} catch (SQLException e) {
			System.out
					.println("The connection to the database was unsuccessful.");
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("the oracle driver was not found for loading!");
		}

		return con;
	}

	public static void saveListing(Listing l) {
		try {

			Connection connection = getDatabaseConnection();

			PreparedStatement saveListing = connection
					.prepareStatement("INSERT INTO listings (title,description,category,subcategory,currency,price,"
							+ "location,language,timestamp,sellername,selleremail,sellerphone) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

			saveListing.setString(1, l.getTitle());
			saveListing.setString(2, l.getDescription());
			saveListing.setString(3, l.getCategory());
			saveListing.setString(4, l.getSubcategory());
			saveListing.setString(5, l.getCurrency());
			saveListing.setInt(6, l.getPrice());
			saveListing.setString(7, l.getLocation());
			saveListing.setString(8, l.getLanguage());
			saveListing.setDate(9, new java.sql.Date(l.getDate().getTime()));
			saveListing.setString(10, l.getSellername());
			saveListing.setString(11, l.getSelleremail());
			saveListing.setString(12, l.getSellercontact());

			saveListing.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			System.out
					.println("ERROR: Could not add the student record to the database. Please check to make sure that a student with the given student ID does not already exist");
			e.printStackTrace();
		}

	}
	
	public static ArrayList<Listing> getListing(String category, String subcategory, String location) 
	{
		Connection connection = null;
		try {

			ArrayList<Listing> listings = new ArrayList<Listing>();
			connection = getDatabaseConnection();

			PreparedStatement saveListing = connection
					.prepareStatement("SELECT * FROM listings WHERE category=? AND subcategory=? AND location=?");
			
			saveListing.setString(1, category);
			saveListing.setString(2, subcategory);
			saveListing.setString(3, location);
			
			ResultSet rs = saveListing.executeQuery();

			while (rs.next()) {
				Listing l;
				l = makeFromResultSet(rs);
				listings.add(l);
			}
			
			
			return listings;

		} catch (SQLException e) {
			System.out
					.println("ERROR: Could not fetch the the list from database....something wrong in the query");
			e.printStackTrace();
			return null;
		}finally{
			try{
			connection.close();
			}catch(SQLException se){
				System.out.println("unable to close the connection");
			}
		}

	}
	
	public static Listing getListing(String image) 
	{
		Connection connection = null;
		try {

			Listing l = null;
			connection = getDatabaseConnection();

			PreparedStatement saveListing = connection
					.prepareStatement("SELECT * FROM listings WHERE image=?");
			
			saveListing.setString(1, image);
			
			ResultSet rs = saveListing.executeQuery();

			while (rs.next()) {				
				l = makeFromResultSet(rs);				
			}
			return l;

		} catch (SQLException e) {
			System.out
					.println("ERROR: Could not fetch the the list from database....something wrong in the query");
			e.printStackTrace();
			return null;
		}finally{
			try{
			connection.close();
			}catch(SQLException se){
				System.out.println("unable to close the connection");
			}
		}

	}
	
	private static Listing makeFromResultSet(ResultSet rs) throws SQLException {

		Listing l = new Listing();
	
		l.setTitle(rs.getString("title"));
		l.setDescription(rs.getString("description"));
		l.setCategory(rs.getString("category"));
		l.setSubcategory(rs.getString("subcategory"));
		l.setImage(rs.getString("image"));
		l.setCurrency(rs.getString("currency"));
		l.setPrice(rs.getInt("price"));
		l.setLocation(rs.getString("location"));
		l.setLanguage(rs.getString("language"));
		l.setDate(new Date(rs.getDate("timestamp").getTime()));
		l.setSellername(rs.getString("sellername"));
		l.setSelleremail(rs.getString("selleremail"));
		l.setSellercontact(rs.getString("sellerphone"));
	
		return l;
	}
	
}
