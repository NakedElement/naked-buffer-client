package uk.co.nakedelement.bufferclient.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Shuffle
{
	@XmlElement(name="success")
	private boolean success;
	
	@XmlElement(name="time_to_shuffle")
	private double timeToShuffle;

	public boolean isSuccess()
	{
		return success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public double getTimeToShuffle()
	{
		return timeToShuffle;
	}

	public void setTimeToShuffle(double timeToShuffle)
	{
		this.timeToShuffle = timeToShuffle;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder("success=");
		builder.append(isSuccess());
		builder.append(", time to shuffle=");
		builder.append(getTimeToShuffle());
		return builder.toString();
	}
	
	
}
