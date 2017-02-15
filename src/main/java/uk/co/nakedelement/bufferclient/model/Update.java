package uk.co.nakedelement.bufferclient.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Update
{
	@XmlElement(name="id")
	private String id;
	
	@XmlElement(name="clicks_caveat")
	private boolean clicks_caveat;
	
	@XmlElement(name="client_id")
  private String client_id;
	
	@XmlElement(name="created_at")
  private int created_at;
	
	@XmlElement(name="day")
  private String day;
	
	@XmlElement(name="due_at")
  private int due_at;
	
	@XmlElement(name="due_time")
  private String due_time;
	
	@XmlElement(name="library_update_id")
  private String library_update_id;
	
  @XmlElement(name="connections")
  private String connections;

	@XmlElement(name="perm_approvable")
  private boolean perm_approvable;
	
	@XmlElement(name="perm_editable")
  private boolean perm_editable;
	
	@XmlElement(name="pinned")
  private boolean pinned;
	
	@XmlElement(name="profile_id")
  private String profile_id;
	
	@XmlElement(name="profile_service")
  private String profile_service;
	
	@XmlElement(name="retweeted_tweet_id")
  private String retweeted_tweet_id;
	
	@XmlElement(name="scheduled_at")
  private int scheduled_at;
	
	@XmlElement(name="shared_now")
 private boolean shared_now;
	
	@XmlElement(name="status")
  private String status;
	
	@XmlElement(name="text")
  private String text;

	@XmlElement(name="text_formatted")
  private String text_formatted;
	
	@XmlElement(name="text_md5")
  private String text_md5;
	
	@XmlElement(name="type")
  private String type;
	
	@XmlElement(name="updated_at")
  private int updated_at;
	
	@XmlElement(name="user_id")
  private String user_id;
	
	@XmlElement(name="via")
  private String via;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	public boolean isClicks_caveat() {
		return clicks_caveat;
	}

	public void setClicks_caveat(boolean clicks_caveat) {
		this.clicks_caveat = clicks_caveat;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public int getCreated_at() {
		return created_at;
	}

	public void setCreated_at(int created_at) {
		this.created_at = created_at;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getDue_at() {
		return due_at;
	}

	public void setDue_at(int due_at) {
		this.due_at = due_at;
	}

	public String getDue_time() {
		return due_time;
	}

	public void setDue_time(String due_time) {
		this.due_time = due_time;
	}

	public String getLibrary_update_id() {
		return library_update_id;
	}

	public void setLibrary_update_id(String library_update_id) {
		this.library_update_id = library_update_id;
	}

	public boolean isPerm_approvable() {
		return perm_approvable;
	}

	public void setPerm_approvable(boolean perm_approvable) {
		this.perm_approvable = perm_approvable;
	}

	public boolean isPerm_editable() {
		return perm_editable;
	}

	public void setPerm_editable(boolean perm_editable) {
		this.perm_editable = perm_editable;
	}

	public boolean isPinned() {
		return pinned;
	}

	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}

	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	public String getProfile_service() {
		return profile_service;
	}

	public void setProfile_service(String profile_service) {
		this.profile_service = profile_service;
	}

	public String getRetweeted_tweet_id() {
		return retweeted_tweet_id;
	}

	public void setRetweeted_tweet_id(String retweeted_tweet_id) {
		this.retweeted_tweet_id = retweeted_tweet_id;
	}

	public int getScheduled_at() {
		return scheduled_at;
	}

	public void setScheduled_at(int scheduled_at) {
		this.scheduled_at = scheduled_at;
	}

	public boolean isShared_now() {
		return shared_now;
	}

	public void setShared_now(boolean shared_now) {
		this.shared_now = shared_now;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText_formatted() {
		return text_formatted;
	}

	public void setText_formatted(String text_formatted) {
		this.text_formatted = text_formatted;
	}

	public String getText_md5() {
		return text_md5;
	}

	public void setText_md5(String text_md5) {
		this.text_md5 = text_md5;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(int updated_at) {
		this.updated_at = updated_at;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}
	
	public String getConnections() {
		return connections;
	}

	public void setConnections(String connections) {
		this.connections = connections;
	}

	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder("id=");
		builder.append(getId());
		builder.append(", clicks_caveat=");
		builder.append(isClicks_caveat());
		builder.append(", client_id=");
		builder.append(getClient_id());
		builder.append(", created_at=");
		builder.append(getCreated_at());
		builder.append(", day=");
		builder.append(getDay());
		builder.append(", due_at=");
		builder.append(getDue_at());
		builder.append(", due_time=");
		builder.append(getDue_time());
		builder.append(", library_update_id=");
		builder.append(getLibrary_update_id());
		builder.append(", perm_editable=");
		builder.append(isPerm_editable());
		builder.append(", pinned=");
		builder.append(isPinned());
		builder.append(", profile_id=");
		builder.append(getProfile_id());
		builder.append(", profile_service=");
		builder.append(getProfile_service());
		builder.append(", connections=");
		builder.append(getConnections());
		builder.append(", retweeted_tweet_id=");
		builder.append(getRetweeted_tweet_id());
		builder.append(", scheduled_at=");
		builder.append(getScheduled_at());
		builder.append(", shared_now=");
		builder.append(isShared_now());
		builder.append(", status=");
		builder.append(getStatus());
		builder.append(", text=");
		builder.append(getText());
		builder.append(", text_formatted=");
		builder.append(getText_formatted());
		builder.append(", text_md5=");
		builder.append(getText_md5());
		builder.append(", type=");
		builder.append(getType());
		builder.append(", updated_at=");
		builder.append(getUpdated_at());
		builder.append(", user_id");
		builder.append(getUser_id());
		builder.append(", via");
		builder.append(getVia());
		return builder.toString();
	}
}
