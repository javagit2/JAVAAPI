
import java.io.*;
import java.net.*;
import org.json.simple.*;	//json-simple-1.1 jar 


public class Requests {

	   public static String getHTML(String urlToRead) throws Exception {
	      
		  StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      
	      return result.toString();
	   }

	   
	   	   
	   public static void main(String[] args) throws Exception
	   {
		 String url = "https://bpdts-test-app.herokuapp.com/city/London/users";
		 
		 System.out.println("JSON file returned: ");
	     System.out.println(getHTML(url));
	     System.out.println();
	     
	     org.json.simple.parser.JSONParser parser =  new org.json.simple.parser.JSONParser();	
	     JSONArray a = (JSONArray) parser.parse(getHTML(url));
		 
	     System.out.println("Number of entries returned: ");
	     System.out.println(a.size());
	     System.out.println();
	     
	     System.out.println("JSON details: ");
	     
	     for (Object o : a)
    	  {
    	    JSONObject person = (JSONObject) o;

    	    String id = (String) person.get("id").toString();
    	    System.out.println(id);

    	    String first_name = (String) person.get("first_name").toString();
    	    System.out.println(first_name);

    	    String last_name = (String) person.get("last_name").toString();
    	    System.out.println(last_name);
    	    
    	    String email = (String) person.get("email").toString();
    	    System.out.println(email);
	    
	   	    String ip_address = (String) person.get("ip_address").toString();
	   	    System.out.println(ip_address);
	   	    
	   	    String latitude = (String) person.get("latitude").toString();
	   	    System.out.println(latitude);
	   	    
	   	    String longitude = (String) person.get("latitude").toString();
	   	    System.out.println(longitude);
	    
	   	    
    	  }  
	     
	   }
	   
}

// London, UK, Latitude and longitude coordinates are: 51.509865, -0.118092.

