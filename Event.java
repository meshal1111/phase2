
public class Event implements Comparable<Event> {
	// Attibute
	private String title;
	private String dateandtime;
	private String location;
	private boolean appointment;
	public LinkedList<Contact> listC;

	// Constructor
	public Event(String title, String dateandtime, String location, Boolean appointment) {
		this.title = title;
		this.dateandtime = dateandtime;
		this.location = location;
		this.appointment = appointment;
		listC = new LinkedList<Contact>();
	}

	// setters and getters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAppointment() {
		return appointment;
	}

	public void setAppointment(boolean appointment) {
		this.appointment = appointment;
	}

	public String getDateandtime() {
		return dateandtime;
	}

	public void setDateandtime(String dateandtime) {
		this.dateandtime = dateandtime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	// sort by title
	@Override
	public int compareTo(Event otherEvent) {

		return this.title.compareToIgnoreCase(otherEvent.title);

	}
}
