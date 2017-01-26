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
	
	private String get(String url, Map<String, String> params)
	{
		addAccessToken(params);
		return client.get(url, params).getContent();
	}
	
	private void addAccessToken(Map<String, String> params)
	{
		params.put("access_token", accessToken);
	}

}
