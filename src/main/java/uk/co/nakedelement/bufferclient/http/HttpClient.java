package uk.co.nakedelement.bufferclient.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

public class HttpClient
{
	private static final Logger log = Logger.getLogger(HttpClient.class);
	
	private static final String ENCODING = "UTF-8";
	
	private final String baseUrl;

	public HttpClient(String baseUrl)
	{
		this.baseUrl = baseUrl;
	}

	public Response get(String url)
	{
		return get(url, new HashMap<>());
	}
	
	public Response get(String url, Map<String, String> params)
	{
		try 
		{
			final String finalUrl = buildUrl(url);
						
			final HttpGet request = new HttpGet(finalUrl);
			buildRequest(request, params);            
            log.debug(request.getURI());
            
			final HttpResponse response = execute(request);
			return new Response(response.getStatusLine().getStatusCode(), toString(response.getEntity().getContent()));
		}
		catch (IOException | URISyntaxException e)
		{
			log.error(e);
			throw new HttpClientException(e);
		}
	}
	
	private static HttpRequestBase buildRequest(HttpRequestBase request, Map<String, String> params) throws URISyntaxException
	{
		final List<NameValuePair> nameValuePairs = new ArrayList<>();
		for(final String key : params.keySet())
			nameValuePairs.add(new BasicNameValuePair(key, params.get(key)));				
		
		final URI uri = new URIBuilder(request.getURI()).addParameters(nameValuePairs).build();
        request.setURI(uri);
        return request;
	}
	
	private static HttpResponse execute(HttpRequestBase request) throws IOException
	{
		return HttpClientBuilder.create().build().execute(request);		
	}
	
	private String buildUrl(String url)
	{
		final StringBuilder builder = new StringBuilder(baseUrl);
		builder.append(url);
		return builder.toString();
	}
	
	private static String toString(InputStream in) throws IOException
	{
		return IOUtils.toString(in, ENCODING);
	}	
}
