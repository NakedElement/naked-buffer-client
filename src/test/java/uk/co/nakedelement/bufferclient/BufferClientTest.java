package uk.co.nakedelement.bufferclient;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import uk.co.nakedelement.bufferclient.model.Profile;
import uk.co.nakedelement.bufferclient.model.ScheduleTime;
import uk.co.nakedelement.bufferclient.model.Shuffle;
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
		System.out.println(client.getPendingUpdates(getProfile()));
	}
	
	@Test
	public void shuffleUpdates()
	{
		final Shuffle result = client.shuffleUpdates(getProfile(), 10, true);
		assertTrue(result.isSuccess());
	}
	
	@Test
	public void shuffleUpdatesCountOnly()
	{
		final Shuffle result = client.shuffleUpdates(getProfile(), 10);
		assertTrue(result.isSuccess());
	}
	
	@Test
	public void shuffleUpdatesUtcOnly()
	{
		final Shuffle result = client.shuffleUpdates(getProfile(), true);
		assertTrue(result.isSuccess());
	}
	
	@Test
	public void shuffleUpdatesProfileOnly()
	{
		final Shuffle result = client.shuffleUpdates(getProfile());
		assertTrue(result.isSuccess());
	}
	
	//@Ignore
	@Test
	public void createUpdate()
	{
		System.out.println(client.createUpdate(client.getProfiles(), "Test me! " + UUID.randomUUID().toString()));
	}
	
	@Test
	public void getScheduleTimes()
	{
		final Collection<ScheduleTime> schedules = client.getScheduleTimes(getProfile());
		System.out.println(schedules);
	}
	
	private Profile getProfile()
	{
		final List<Profile> profiles = new ArrayList<>();
		profiles.addAll(client.getProfiles());
		return profiles.get(0);
	}

}
