package uk.co.nakedelement.bufferclient.model;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Statistics
{
	@JsonProperty("followers")
	private int followers;
	
	@JsonProperty("connections")
	private int connections;

	public int getConnections() {
		return connections;
	}

	public void setConnections(int connections) {
		this.connections = connections;
	}

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
		builder.append(", connections=");
		builder.append(getConnections());
		return builder.toString();
	}

}
