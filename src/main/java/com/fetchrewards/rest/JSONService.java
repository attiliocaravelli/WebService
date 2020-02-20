package com.fetchrewards.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("/assessment")
public class JSONService {

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(String jsonArrayEmails) {
		  String result = "Error";
		  Set<String> emails = new HashSet<String>();
		  //Creating a JSONParser object
	      JSONParser jsonParser = new JSONParser();
	      try 
	      {
	         //Parsing the contents of the JSON file
	         JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonArrayEmails);
	         //Retrieving the array
	         JSONArray jsonArray = (JSONArray) jsonObject.get("emails");
	         //Iterating the contents of the array
	         Iterator<?> iterator = jsonArray.iterator();
	         while(iterator.hasNext()) 
	         {
	            String email = (String)iterator.next();
	            int i = email.indexOf('@');
	  	        String username = email.substring(0, i);
	  	        String domain = email.substring(i);
	  	        if (username.contains("+")) {
	  	          username = username.substring(0, username.indexOf('+'));
	  	        }
	  	        // Note: one should escape the specific character '.',
	  	        // since it is treated as a regex expression.
	  	        username = username.replaceAll("\\.", "");
	  	        emails.add(username + domain);
	         }
	         result = String.valueOf(emails.size());
	      } catch (ParseException e) 
	      {
	            result = e.toString();
	      }
	      return Response.status(201).entity(result).build();
	}
}