package com.listings;
import java.sql.Blob;
import java.util.Date;


public class Listing {

	private String title;
	private String description;
	private String category;
	private String subcategory;
	private String currency;
	private int price;
	private String location;
	private String language;
	private String sellername;
	private String selleremail;
	private String sellercontact;
	private Date date;
	private String image;
	
	public void setTitle(String t)
	{
		this.title = t;
	}
	public String getTitle()
	{
		return this.title;
	}
	
	public void setDescription(String d)
	{
		this.description = d;
	}
	public String getDescription()
	{
		return this.description;
	}
	
	public void setCategory(String c)
	{
		this.category = c;
	}
	public String getCategory()
	{
		return this.category;
	}
	
	public void setSubcategory(String s)
	{
		this.subcategory = s;
	}
	public String getSubcategory()
	{
		return this.subcategory;
	}
	
	public void setCurrency(String c)
	{
		this.currency = c;
	}
	public String getCurrency()
	{
		return this.currency;
	}
	
	public void setPrice(int p)
	{
		this.price = p;
	}
	public int getPrice()
	{
		return this.price;
	}
	
	public void setLocation(String l)
	{
		this.location = l;
	}
	public String getLocation()
	{
		return this.location;
	}
	
	public void setLanguage(String l)
	{
		this.language = l;
	}
	public String getLanguage()
	{
		return this.language;
	}
	
	public void setSellername(String s)
	{
		this.sellername = s;
	}
	public String getSellername()
	{
		return this.sellername;
	}
	
	public void setSelleremail(String s)
	{
		this.selleremail = s;
	}
	public String getSelleremail()
	{
		return this.selleremail;
	}
	
	public void setSellercontact(String s)
	{
		this.sellercontact = s;
	}
	public String getSellercontact()
	{
		return this.sellercontact;
	}
	
	public void setDate(Date d)
	{
		this.date = d;
	}
	public Date getDate()
	{
		return this.date;
	}
	
	public void setImage(String i)
	{
		this.image = i;
	}
	public String getImage()
	{
		return this.image;
	}
}
