package uk.co.nakedelement.bufferclient;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import uk.co.nakedelement.bufferclient.http.HttpClient;
import uk.co.nakedelement.bufferclient.model.Profile;

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

	public Collection<Profile> getProfiles() throws JsonParseException, JsonMappingException, IOException
	{
		
		final Map<String, String> params = new HashMap<>();
		final String json = get("profiles.json", params);
		log.debug(json);
		final ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(Collection.class, Profile.class));
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
