package uk.co.nakedelement.bufferclient.http;

public class HttpClientException extends RuntimeException
{
	private static final long serialVersionUID = 1260107944251503113L;

	public HttpClientException(Throwable t)
	{
		super(t);
	}
}
