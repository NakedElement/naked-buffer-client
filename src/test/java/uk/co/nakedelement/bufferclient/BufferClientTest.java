package uk.co.nakedelement.bufferclient;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import uk.co.nakedelement.bufferclient.tools.TestingProperties;

public class BufferClientTest
{
	private TestingProperties props;
	
	private BufferClient client;
	
	@Before
	public void setUp() throws Exception
	{
		props = new TestingProperties("buffer_client_test.properties");
		client = new BufferClient( props.getProperty("access_token") );
	}

	@Test
	public void getProfiles() throws JsonParseException, JsonMappingException, IOException
	{
		System.out.println(client.getProfiles());
	}

}
