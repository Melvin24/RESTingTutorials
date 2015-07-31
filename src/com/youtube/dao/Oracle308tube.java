package com.youtube.dao;

import javax.naming.*;
import javax.sql.*;

public class Oracle308tube {

	private static DataSource Oracle308tube = null;
	private static Context context = null;
	
	//public method used by other methods in order to get 
	//DB connection so that they can actually get data 
	public static DataSource Oracle308tuneConn() throws Exception {
		
		if(Oracle308tube != null){
			return Oracle308tube;
		}
		
		try{
			
			if(context==null){
				//if null initialise a new context
				context = new InitialContext();
			}
			
			//look up the datasource using its JNDI ID that we specified when 
			//creating the Database using localhost:7001/console
			//basically saying go to weblogic and look up the datasource of this JNDI ID
			Oracle308tube = (DataSource)context.lookup("308tubeOracle");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return Oracle308tube;
	}
	
}
