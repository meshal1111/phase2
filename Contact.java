
public class Contact implements Comparable<Contact>{
	//Attibute
	 private String name;
	 private String phonenumber;
	 private String email;
	 private String address;
	 private String birthday;
	 private String notes;
	 
	 //Constructor
	 public Contact(String na,String p,String e,String a,String b,String no) {
		 name=na;
		 phonenumber=p;
		 email=e;
		 address=a;
		 birthday=b;
		 notes=no;
		}
	//setters and getters
	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	//sort by name
	@Override
	public int compareTo(Contact otherContact) {
		  
			  return this.name.compareToIgnoreCase(otherContact.name);
		  
	}
	 
	 
}
