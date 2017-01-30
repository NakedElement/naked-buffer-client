package uk.co.nakedelement.bufferclient.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Profile
{
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("avatar")
	private String avatar;
	
	@JsonProperty("service")
	private String service;	
	
	@JsonProperty("counts")
	private Counts counts;
	
	@JsonProperty("statistics")
	private Statistics statistics;
	
	@JsonProperty("schedules")
	private ScheduleTime[] schedules;
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setAvatar(String avatar)
	{
		this.avatar = avatar;
	}
	
	public void setService(String service)
	{
		this.service = service;
	}	
	
	public void setCounts(Counts counts)
	{
		this.counts = counts;
	}	

	public void setStatistics(Statistics statistics)
	{
		this.statistics = statistics;
	}	

	public ScheduleTime[] getSchedules()
	{
		return schedules;
	}

	public void setSchedules(ScheduleTime[] schedules)
	{
		this.schedules = schedules;
	}

	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder("id=");
		builder.append(getId());
		return builder.toString();
	}	
}
