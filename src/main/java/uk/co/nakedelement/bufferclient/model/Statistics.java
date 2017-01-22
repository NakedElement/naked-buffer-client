package uk.co.nakedelement.bufferclient.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Statistics
{
	@XmlElement(name="followers")
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
