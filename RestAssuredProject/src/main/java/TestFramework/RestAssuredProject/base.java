package TestFramework.RestAssuredProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.testng.annotations.BeforeSuite;

public class base {
	public Properties prop;

	
	public void tweet() throws IOException{
    prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\selenium\\TestNG\\RestAssuredProject\\src\\main\\java\\TestFramework\\RestAssuredProject\\data.properties");
	prop.load(fis);
	}
	public void Listtoelement(List abc)
	{
	String s=abc.toString();
	String result=s.substring(2,s.length()-2);
	String arr[]=result.split(",");
	for(int i=0;i<6;i++)
	{
		System.out.println(arr[i]);
	}
	}
	
}
