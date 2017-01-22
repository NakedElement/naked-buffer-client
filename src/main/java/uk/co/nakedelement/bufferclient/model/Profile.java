package uk.co.nakedelement.bufferclient.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Profile
{
	@XmlElement(name="id")
	private String id;
	
	@XmlElement(name="avatar")
	private String avatar;
	
	@XmlElement(name="service")
	private String service;	
	
	@XmlElement(name="counts")
	private Counts counts;
	
	@XmlElement(name="statistics")
	private Statistics statistics;
	
	@XmlElement(name="schedules")
	private ScheduleTime[] schedules;
	
	public void setId(String id)
	{
		this.id = id;
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
		return id;
	}	
}
