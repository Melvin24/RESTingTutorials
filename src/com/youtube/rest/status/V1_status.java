package com.youtube.rest.status;

//class used to return the health of this API -> com.youtube.rest

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.sql.*;

//import the 'dao' package into this class so that we can get the connection
import com.youtube.dao.*;

@Path("/v1/status") //this is the root path
public class V1_status {

	//global variable 
	//static mean only one instance of this
	//final: means one this app gets booted it cannot be changed
	private static final String api_version = "00.02.00";
	
	//first method is going to return the title 
	//"@" is used to tell jersey what to look for and how to handle request, basically how the restfult webservice know what it needs to do
	//@GET is a GET HTTP Call i.e the URL you enter on the browser
	//@Produce is the format of the product, how it is going to be encoded
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<h1>Java Web Service</h1>";
	}
	
	//cant have two Get methods so creating another path 
	@Path("/version")//so need to type /api/status/version since it is nested
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion(){
		return "<h1>Version: " + api_version + "</h1>";
	}
	
	//this is a simple method to get a connection and output the date and time
	//this is very good to check if you DB is working fine 
	//creating a method that will get the connection from the .dao package
	//then use that connection to retrieve some data and output it to the users 
	//defining the annotation so that it is publicly available
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception{
		
		PreparedStatement query = null;//precompiled sql statement
		String myString = null;
		String returnString = null;
		Connection conn = null;//store the connection commingfrom the dao package
		
		try{
			conn = Oracle308tube.Oracle308tuneConn().getConnection();
			query = conn.prepareStatement("select to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS') DATETIME " +
									"from sys.dual");
			ResultSet rs = query.executeQuery();
			
			while(rs.next()){
				myString = rs.getString("DATETIME");
			}
			
			query.close();
			conn.close();
			//string to return bacl to the user 
			returnString = "<p> Database Status</p>" +
					"<p>Database Date/Time return: " + myString + "</p>" ;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{//gets execute if an exception is caugh 
			//basically used to clean up 
			if(conn != null){
				conn.close();
			}
		}
		
		return returnString;
		
	}
	
}