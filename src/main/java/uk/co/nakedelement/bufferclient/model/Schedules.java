package uk.co.nakedelement.bufferclient.model;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Schedules
{
	private Collection<ScheduleTime> schedules;

	public Collection<ScheduleTime> getSchedules()
	{
		return schedules;
	}

	public void setSchedules(Collection<ScheduleTime> schedules)
	{
		this.schedules = schedules;
	}
	
}
