package SunilProject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {
  @Test
  public void only4Foreigner() throws IOException, ParseException {
	  JSONParser jsonparser=new JSONParser();
	  
	  FileReader reader =new FileReader(".\\src\\test\\resources\\JSONFiles\\project.json");
	  
	  Object obj =jsonparser.parse(reader);
	  
	  JSONObject rcbjsonobj=(JSONObject)obj;
	  
	  String teamName=(String) rcbjsonobj.get("name");
	  String location=(String) rcbjsonobj.get("location");
	  
	  System.out.println("Team name is :"+teamName+" and location is "+location);
	  
	  JSONArray array=(JSONArray)rcbjsonobj.get("player");
	  int counter=0;
	  for(int i=0;i<array.size();i++) {
		  JSONObject player =(JSONObject) array.get(i);
		  
		  
		  String country=(String) player.get("country");

		  
		  System.out.println(country);
		  
		  if(country.equals("India")) {
			  
		  } else {
			  counter++;
		  }
	  }
	  Assert.assertEquals(counter, 4, "Foreign players more than 4 in team");
  }
}
