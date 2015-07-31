package com.youtube.rest.status;

//class used to return the health of this API -> com.youtube.rest

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/status") //this is the root path
public class V1_status {

	//global variable 
	//static mean only one instance of this
	//final: means one this app gets booted it cannot be changed
	private static final String api_version = "00.01.00";
	
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
}