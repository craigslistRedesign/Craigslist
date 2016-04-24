package com.listings;
import java.util.ArrayList;


public class Books {
	private ArrayList<Listing> listings;



	public ArrayList<Listing> getAllListings(String location)

	{

	listings = Database.getListing("for_sale", "books", location);


	return listings;

	}

	}

