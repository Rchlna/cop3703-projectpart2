
public class Interaction {
	
	public String id;
	public String date;
	public String time;
	public String description;

	public Interaction(String id, String date, String time, String description) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
