package uk.co.nakedelement.bufferclient.http;

public class Response
{
	private final int status;
	private final String content;	
	
	public Response(int status, String content)
	{
		super();
		this.status = status;
		this.content = content;
	}

	public int getStatus()
	{
		return status;
	}
	
	public String getContent()
	{
		return content;
	}
	
	@Override
	public String toString()
	{
		return getContent();
	}
	
}
