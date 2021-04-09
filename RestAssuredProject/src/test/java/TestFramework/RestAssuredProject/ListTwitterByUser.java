package TestFramework.RestAssuredProject;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ListTwitterByUser extends base {
	private static Logger log=LogManager.getLogger(twitter.class.getName());

	@Test
	public void getUserTweet() throws IOException
	{
		tweet();

		RestAssured.baseURI=prop.getProperty("twitterHOST");
		Response res=given().auth().oauth(prop.getProperty("consumerKey"),prop.getProperty("consumerSeceret"),prop.getProperty("token"),prop.getProperty("Secret")).
		when().queryParam("exclude_replies","true").queryParam("include_rts","false").get("user_timeline.json").then().assertThat().statusCode(200).extract().response();
		String response=res.asString();
		log.info(response);
		JsonPath js=new JsonPath(response);
		
		List<String> ac=js.get("text");
		System.out.println(ac);

}
}

