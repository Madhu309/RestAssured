package TestFramework.RestAssuredProject;
	
	import static io.restassured.RestAssured.given;
	import org.testng.annotations.Test;
	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.Properties;
	import java.util.logging.LogManager;
	import java.util.logging.Logger;
	import java.nio.file.Files;
	import java.nio.file.Paths;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import io.restassured.http.ContentType;
	import io.restassured.path.json.JsonPath;
	import io.restassured.path.xml.XmlPath;
	public class  WeatherUpdate  {
	    
	    String consumerKey="flO6QbFtC58JD3pRcePaii2Jl";
	    String consumerSeceret="9hSSrQzNGqeSq23hLt4AyGR1IpGH9RB7ec4Fgfn6Q0oqK02Vh1";
	    String token="1365152181725188101-nqfRtiKuGSt4OeXOgieO5CeNmO5ESM";
	    String Secret="sNgWPFPQeQxwT9Nk07tsAmxKcWaRC5Um1XIr3UbdrI5pe";
	            
	@Test
	public void Weather() {
	        
	        RestAssured.baseURI="https://api.twitter.com/1.1/search/";
	        Response res=given().auth().oauth(consumerKey,consumerSeceret,token,Secret).
	        queryParam("q","#Bangalore #Weather").when().
	        get("tweets.json").then().extract().response();
	        
	        String responseString=res.asString();
	        JsonPath js=new JsonPath(responseString);
	        
	        ArrayList<Object> arr=new ArrayList<Object>();
	        arr.addAll(js.getList("statuses"));
	        Iterator itr=arr.iterator();
	        while(itr.hasNext())
	        {
	            System.out.println(itr.next());
	        }               
	}

	 

	@DataProvider
	public Object[][] location() {
	    
	    Object loc[][]= new Object[4][2];
	    loc[0][0]="India";
	    loc[0][1]="23424848";
	    loc[1][0]="US";
	    loc[1][1]="23424977";    
	    loc[2][0]="UK";
	    loc[2][1]="23424975";    
	    loc[3][0]="ISRAEL";    
	    loc[3][1]="23424852";    
	    return loc;
	                        
	}
	}

