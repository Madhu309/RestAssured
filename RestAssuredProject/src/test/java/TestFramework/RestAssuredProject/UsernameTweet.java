package TestFramework.RestAssuredProject;
	import static io.restassured.RestAssured.given;
	import org.testng.annotations.Test;
	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Iterator;
	import io.restassured.path.json.JsonPath;

	 

	public class UsernameTweet extends base{
		    String consumerKey="flO6QbFtC58JD3pRcePaii2Jl";
	        String consumerSeceret="9hSSrQzNGqeSq23hLt4AyGR1IpGH9RB7ec4Fgfn6Q0oqK02Vh1";
	        String token="1365152181725188101-nqfRtiKuGSt4OeXOgieO5CeNmO5ESM";
	        String Secret="sNgWPFPQeQxwT9Nk07tsAmxKcWaRC5Um1XIr3UbdrI5pe";
	                

	    @Test
	    public void displayusername_tweet() throws IOException {
	        
	        RestAssured.baseURI="https://api.twitter.com/1.1/search/";
	        Response res=given().auth().oauth(consumerKey,consumerSeceret,token,Secret).
	                queryParam("q", "#Qualitest").when().
	                get("tweets.json").then().extract().response();
	        String response=res.asString();
	        JsonPath jp=new JsonPath(response);
            
	        ArrayList<Object> arr=new ArrayList<Object>();
	        ArrayList<Object> arr1=new ArrayList<Object>();
	        arr.addAll(jp.getList("statuses.text"));
	        arr1.addAll(jp.getList("statuses.user.name"));
	    
	        Iterator itr=arr.iterator();
	        Iterator itr1=arr1.iterator();
	        
	        while(itr.hasNext())
	        {        
	            System.out.println("Tweet:"+itr.next()+" UserName"+itr1.next());
	        }
	    
	}
	}
