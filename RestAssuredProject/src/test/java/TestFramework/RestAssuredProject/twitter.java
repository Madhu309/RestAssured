package TestFramework.RestAssuredProject;
import static io.restassured.RestAssured.given;
import TestFramework.RestAssuredProject.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
	

	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;
public class twitter extends base {
	private static Logger log=LogManager.getLogger(twitter.class.getName());

	@Test
	public void getTweet() throws IOException
	{
		tweet();

		RestAssured.baseURI=prop.getProperty("twitterHOST");
		Response res=given().auth().oauth(prop.getProperty("consumerKey"),prop.getProperty("consumerSeceret"),prop.getProperty("token"),prop.getProperty("Secret")).
		queryParam("count","1")
		.when().get("/home_timeline.json").then().extract().response();
		String response=res.asString();
		//System.out.println(response);
		log.info(response);
		JsonPath js=new JsonPath(response);
		String id=js.get("id").toString();
		log.info(id);
		String text=js.get("text").toString();
		log.info(text);
		
	}
	@Test
	public void createTweet() throws IOException
	{
		tweet();

		RestAssured.baseURI=prop.getProperty("twitterHOST");
		Response res=given().auth().oauth(prop.getProperty("consumerKey"),prop.getProperty("consumerSeceret"),prop.getProperty("token"),prop.getProperty("Secret")).
		queryParam("status","I am learning API testing using RestAssured Java#Qualitest")
		.when().post("/update.json").then().extract().response();
		
		String response=res.asString();
		log.info(response);
		JsonPath js=new JsonPath(response);
		String id=js.get("id").toString();
		log.info(id);
		String text=js.get("text").toString();
		log.info(text);
		
		//given().auth().oauth(prop.getProperty("consumerKey"),prop.getProperty("consumerSeceret"),prop.getProperty("token"),prop.getProperty("Secret")).
		//when().post("/destroy/"+id+".json").then().assertThat().statusCode(200);
		
	}

}
