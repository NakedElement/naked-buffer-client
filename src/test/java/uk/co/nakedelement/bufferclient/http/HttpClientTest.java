package uk.co.nakedelement.bufferclient.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.Map;

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
		final Map<String,String> params = new HashMap<>();
		params.put("access_token", props.getProperty("access_token"));
		final Response response = client.get("profiles.json", params);
		assertEquals(200, response.getStatus());
		assertFalse(response.getContent().isEmpty());
	}
}
