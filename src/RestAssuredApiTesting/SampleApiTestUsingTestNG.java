package RestAssuredApiTesting;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class SampleApiTestUsingTestNG {	
	
	@Test
	public void sampleApiTest()
	{
		Response resp = RestAssured.get("http://api.fixer.io/2000-01-03");
		int code=resp.getStatusCode();
		System.out.println("Status code is "+code);
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void sampleApiTest2()
	{
		Response resp = RestAssured.get("https://postman-echo.com/get?test=123");
		int code=resp.getStatusCode();
		System.out.println("Status code is "+code);
		Assert.assertEquals(code, 200);
	}
}
