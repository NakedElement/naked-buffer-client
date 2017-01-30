package uk.co.nakedelement.bufferclient.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Counts
{
	@JsonProperty("daily_suggestions")
	private int dailySuggestions;
	
	@JsonProperty("drafts")
	private int drafts;
	
	@JsonProperty("reminders")
	private int reminders;
	
	@JsonProperty("sent")
	private int sent;
	
	@JsonProperty("pending")
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
