package TestFramework.RestAssuredProject;

	import static io.restassured.RestAssured.given;
	import org.testng.annotations.Test;
	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	import java.io.IOException;
	import io.restassured.path.json.JsonPath;
	public class BlockUser extends base {
	        String consumerKey="flO6QbFtC58JD3pRcePaii2Jl";
	        String consumerSeceret="9hSSrQzNGqeSq23hLt4AyGR1IpGH9RB7ec4Fgfn6Q0oqK02Vh1";
	        String token="1365152181725188101-nqfRtiKuGSt4OeXOgieO5CeNmO5ESM";
	        String Secret="sNgWPFPQeQxwT9Nk07tsAmxKcWaRC5Um1XIr3UbdrI5pe";
	                
	    
	    @Test
	    public void block_user() throws IOException {
	        RestAssured.baseURI="https://api.twitter.com/1.1/blocks/";
	        Response res=given().auth().oauth(consumerKey,consumerSeceret,token,Secret).
	        queryParam("id","1364827973526806529").when().post("create.json").then().extract().response();
	        String response=res.asString();
	        JsonPath jp=new JsonPath(response);
	        String name=jp.get("name");
	        System.out.println(name);
	    }

	 

	}
	 

