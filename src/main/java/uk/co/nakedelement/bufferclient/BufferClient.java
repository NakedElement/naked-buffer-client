package uk.co.nakedelement.bufferclient;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import uk.co.nakedelement.bufferclient.http.HttpClient;
import uk.co.nakedelement.bufferclient.model.Profile;
import uk.co.nakedelement.bufferclient.model.ScheduleTime;
import uk.co.nakedelement.bufferclient.model.Shuffle;
import uk.co.nakedelement.bufferclient.model.Updates;

public class BufferClient
{
	private static final Logger log = Logger.getLogger(BufferClient.class);
	
	private static final String BASE_URL = "https://api.bufferapp.com/1/";
	
	private HttpClient client;
	
	private final String accessToken;
	
	public BufferClient(String accessToken)
	{
		this.accessToken = accessToken;
		client = new HttpClient(BASE_URL);
	}

	public Collection<Profile> getProfiles()
	{		
		try
		{
			final Map<String, String> params = new HashMap<>();		
			final String json = get("profiles.json", params);
			log.debug(json);			
			return new ObjectMapper().readValue(json, TypeFactory.defaultInstance().constructCollectionType(Collection.class, Profile.class));
		}
		catch(IOException e)
		{
			throw new BufferClientException(e);
		}
	}
	
	public Updates getPendingUpdates(Profile profile)
	{
		try
		{
		final Map<String, String> params = new HashMap<>();
		final String json = get("profiles/" + profile.getId() + "/updates/pending.json", params);
		log.debug(json);
		return new ObjectMapper().readValue(json, Updates.class);
		}
		catch(IOException e)
		{
			throw new BufferClientException(e);
		}
	}
	
	public Collection<ScheduleTime> getScheduleTimes(Profile profile)
	{
		try
		{
			final Map<String, String> params = new HashMap<>();
			final String json = get("profiles/" + profile.getId() + "/schedules.json", params);
			log.debug(json);
			return new ObjectMapper().readValue(json, TypeFactory.defaultInstance().constructCollectionType(Collection.class, ScheduleTime.class));
		}
		catch(IOException e)
		{
			throw new BufferClientException(e);
		}
	}
	
	public Shuffle shuffleUpdates(Profile profile, Integer count)
	{
		return shuffleUpdates(profile, count, null);
	}
	
	public Shuffle shuffleUpdates(Profile profile, Boolean utc)
	{
		return shuffleUpdates(profile, null, utc);
	}
	
	public Shuffle shuffleUpdates(Profile profile)
	{
		return shuffleUpdates(profile, null, null);
	}	
	
	public Shuffle shuffleUpdates(Profile profile, Integer count, Boolean utc)
	{
		try
		{
			final Map<String, String> params = new HashMap<>();
			final Map<String, String> bodyParams = new HashMap<>();
			if (count != null)
				bodyParams.put("count", count.toString());
			if (utc != null)
				bodyParams.put("utc", utc.toString());
			final String json = post("profiles/" + profile.getId() + "/updates/shuffle.json", params, bodyParams);
			log.debug(json);
			return new ObjectMapper().readValue(json, Shuffle.class);
		}
		catch(IOException e)
		{
			throw new BufferClientException(e);
		}
	}
	
	public Updates createUpdate(Collection<Profile> profiles, String text, Boolean shorten, String url)
	{
		try
		{
			final Map<String, String> params = new HashMap<>();
			final Map<String, String> bodyParams = new HashMap<>();
			bodyParams.put("text", text);
			bodyParams.put("shorten", shorten.toString());
			bodyParams.put("media[photo]", url);
			for(final Profile profile : profiles)
				bodyParams.put("profile_ids[]", profile.getId());	
			
			final String json = post("updates/create.json", params, bodyParams);
			log.debug(json);
			return new ObjectMapper().readValue(json, Updates.class);
		}
		catch(IOException e)
		{
			throw new BufferClientException(e);
		}
	}
	
	private String get(String url, Map<String, String> params)
	{
		addAccessToken(params);
		return client.get(url, params).getContent();
	}
	
	private String post(String url, Map<String, String> params, Map<String, String> bodyParams)
	{
		addAccessToken(params);
		return client.post(url, params, bodyParams).getContent();
	}
	
	private void addAccessToken(Map<String, String> params)
	{
		params.put("access_token", accessToken);
	}

}
