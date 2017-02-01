package uk.co.nakedelement.bufferclient.model;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Schedules
{
	@XmlElement(name="schedule")
	private Collection<ScheduleTime> schedules;

	public Collection<ScheduleTime> getSchedules()
	{
		return schedules;
	}

	public void setSchedules(Collection<ScheduleTime> schedules)
	{
		this.schedules = schedules;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder("schedules=");
		builder.append(getSchedules());
		return builder.toString();
	}
}
