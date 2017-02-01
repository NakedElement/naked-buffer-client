package uk.co.nakedelement.bufferclient.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Updates
{
	@JsonProperty("success")
	private boolean success;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("total")
	private int total;
	  
	@JsonProperty("updatesl")
	private Update[] updates;
	  
	  

		public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}
		
		public Update[] getUpdates() {
			return updates;
		}

		public void setUpdates(Update[] updates) {
			this.updates = updates;
		}

		@Override
		public String toString()
		{
			final StringBuilder builder = new StringBuilder();
			
			if (!isSuccess())
			{
				builder.append("message=");
				builder.append(getMessage());
			}
			else
			{
				
				builder.append("total=");
				builder.append(getTotal());
				builder.append(", [");
				for(final Update update : getUpdates())
				{
					builder.append("{");
					builder.append(update);
					builder.append("}, ");
				}
				builder.append("]");
			}
			return builder.toString();
		
		}	
}