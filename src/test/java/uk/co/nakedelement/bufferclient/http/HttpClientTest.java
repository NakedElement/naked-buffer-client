package uk.co.nakedelement.bufferclient.http;

import org.junit.Before;
import org.junit.Test;

import uk.co.nakedelement.bufferclient.TestingProperties;

public class HttpClientTest
{
	private HttpClient client;
	
	private TestingProperties props;
	
	@Before
	public void setUp() throws Exception
	{
		props = new TestingProperties("buffer_client_test.properties");		
		client = new HttpClient("https://api.bufferapp.com/1/");
	}

	@Test
	public void test()
	{
		System.out.println(client.get("profiles.json?access_token=" + props.getProperty("access_token")));
	}
}
