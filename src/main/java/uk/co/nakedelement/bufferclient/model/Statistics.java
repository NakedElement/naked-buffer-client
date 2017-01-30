package uk.co.nakedelement.bufferclient.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class Statistics
{
	@JsonProperty("followers")
	private int followers;

	public int getFollowers()
	{
		return followers;
	}

	public void setFollowers(int followers)
	{
		this.followers = followers;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder("followers=");
		builder.append(getFollowers());
		return builder.toString();
	}

}
