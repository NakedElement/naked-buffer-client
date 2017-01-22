package uk.co.nakedelement.bufferclient.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScheduleTime
{
	@XmlElement(name="days")
	private String[] days;
	
	@XmlElement(name="times")
	private String[] times;

	public String[] getDays()
	{
		return days;
	}

	public void setDays(String[] days)
	{
		this.days = days;
	}

	public String[] getTimes()
	{
		return times;
	}

	public void setTimes(String[] times)
	{
		this.times = times;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder("days=[");
		for(final String day : days)
		{
			builder.append(day);
			builder.append(", ");
		}
		builder.append("], times=[");
		for(final String time : times)
		{
			builder.append(time);
			builder.append(", ");
		}
		builder.append("]");
		return builder.toString();
	}

}
