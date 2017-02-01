package uk.co.nakedelement.bufferclient.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Updates
{
	  @XmlElement(name="total")
	  private int total;
	  
	  @XmlElement(name="total")
	  private Update[] updates;

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
			final StringBuilder builder = new StringBuilder("total=");
			builder.append(getTotal());
			builder.append(", [");
			for(final Update update : getUpdates())
			{
				builder.append("{");
				builder.append(update);
				builder.append("}, ");
			}
			builder.append("]");
			return builder.toString();
		}	
}