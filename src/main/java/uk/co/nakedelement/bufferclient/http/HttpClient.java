package uk.co.nakedelement.bufferclient.http;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
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
		try 
		{
			final String finalUrl = buildUrl(url);
			log.debug("GET " + finalUrl);
			final HttpResponse response = execute(new HttpGet(finalUrl));
			return new Response(response.getStatusLine().getStatusCode(), toString(response.getEntity().getContent()));
		}
		catch (IOException e)
		{
			log.error(e);
			throw new HttpClientException(e);
		}
	}
	
	private static HttpResponse execute(HttpRequestBase request) throws ClientProtocolException, IOException
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
