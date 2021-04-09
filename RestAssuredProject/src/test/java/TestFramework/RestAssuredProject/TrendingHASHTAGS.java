package TestFramework.RestAssuredProject;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TrendingHASHTAGS extends base {
	 String INDIA="23424848";
	 String	 US="23424977";
	 String	 UK="23424975";
	 String ISRAEL="23424852";
    Integer statusCode=200;
	Properties prop=new Properties();
	private static Logger log=LogManager.getLogger(TrendingHASHTAGS.class.getName());
	@Test(dataProvider="getData")
	public void API_test(String location) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\selenium\\TestNG\\RestAssuredProject\\src\\main\\java\\TestFramework\\RestAssuredProject\\data.properties");
		prop.load(fis);
		RestAssured.baseURI="https://api.twitter.com/1.1/trends/";
		Response res=given().auth().oauth(prop.getProperty("consumerKey"),prop.getProperty("consumerSeceret"),prop.getProperty("token"),prop.getProperty("Secret")).
		queryParam("id",location).
		when().
		get("place.json").then().assertThat().statusCode(200).extract().response();
		String response=res.asString();
		log.info(response);
		JsonPath js=new JsonPath(response);
		List<String> abc=js.get("trends.name");
		Listtoelement(abc);
		
	}
	@DataProvider
	public String[] getData()
	{
		String[] abcd= {INDIA,US,UK,ISRAEL};
		return abcd;
	}
	@AfterTest
	public void print() {
		if(statusCode==200) {
			log.info("Indian trends are displayed");
			log.info("trends in us:");
			log.info("trends in uk:");
			log.info("trends in israel:");
		}
	}

}
