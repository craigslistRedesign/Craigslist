package com.listings;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Extend HttpServlet class

public class CraigslistServlet extends HttpServlet {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
	
  public void init() throws ServletException
  {
	  
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
	  HttpSession session = request.getSession();
	  String address = null;
	  
	  if(request.getParameter("image")!=null){
		Listing record = Database.getListing(request.getParameter("image"));
		session.setAttribute("Listing", record);
		address = "/BookDetails.jsp";
	  }	  
	  else{
	  
	  List<Listing> list = new ArrayList<Listing>();
	  list = Database.getListing(request.getParameter("category"), request.getParameter("subcategory"), "Washington D.C.");
	  session.setAttribute("list",list);
	  address = "/Books.jsp";
	  }
	  RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	  dispatcher.forward(request, response);
	  
  }
  
  public void destroy()
  {

  }
}
