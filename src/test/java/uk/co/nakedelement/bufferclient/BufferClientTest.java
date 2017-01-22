package uk.co.nakedelement.bufferclient;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uk.co.nakedelement.bufferclient.model.Profile;
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
	public void getProfiles()
	{
		assertFalse(client.getProfiles().isEmpty());
	}
	
	@Test
	public void getPendingUpdates()
	{
		final List<Profile> profiles = new ArrayList<>();
		profiles.addAll(client.getProfiles());
		System.out.println(client.getPendingUpdates(profiles.get(0)));
	}

}
