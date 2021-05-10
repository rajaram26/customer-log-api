package customer.log.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerlog")
public class CustomerLog {
	
	@Id
	private String id;
	private String name;
	private String log_type;
	private String date;
	private String time;

	
	public CustomerLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerLog(String id, String name, String log_type, String date, String time) {
		super();
		this.id = id;
		this.name = name;
		this.log_type = log_type;
		this.date = date;
		this.time = time;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLog_type() {
		return log_type;
	}
	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CustomerLog [id=" + id + ", name=" + name + ", log_type=" + log_type + ", date=" + date + ", time="
				+ time + "]";
	}
	

}
