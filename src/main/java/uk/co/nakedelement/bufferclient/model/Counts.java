package uk.co.nakedelement.bufferclient.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Counts
{
	@XmlElement(name="daily_suggestions")
	private int dailySuggestions;
	
	@XmlElement(name="drafts")
	private int drafts;
	
	@XmlElement(name="reminders")
	private int reminders;
	
	@XmlElement(name="sent")
	private int sent;
	
	@XmlElement(name="pending")
	private int pending;

	public int getDailySuggestions()
	{
		return dailySuggestions;
	}

	public void setDailySuggestions(int dailySuggestions)
	{
		this.dailySuggestions = dailySuggestions;
	}

	public int getDrafts()
	{
		return drafts;
	}

	public void setDrafts(int drafts)
	{
		this.drafts = drafts;
	}

	public int getReminders()
	{
		return reminders;
	}

	public void setReminders(int reminders)
	{
		this.reminders = reminders;
	}

	public int getSent()
	{
		return sent;
	}

	public void setSent(int sent)
	{
		this.sent = sent;
	}

	public int getPending()
	{
		return pending;
	}

	public void setPending(int pending)
	{
		this.pending = pending;
	}	
	
	
}
