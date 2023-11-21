
public class LinkedList<T> extends Node<T> {
	private Node<T> head;
	private Node<T> current;

	public LinkedList() {
		head = current = null;
	}

	public boolean empty() {
		return head == null;
		// big O(1)
	}

	public boolean last() {
		return current.next == null;// big O(1)
	}

	public boolean full() {
		return false;// big O(1)
	}

	public void findfirst() {
		current = head;// big O(1)
	}

	public void findnext() {
		current = current.next;// big O(1)
	}

	public Event retrieve() {
		return current.data;// big O(1)
	}

	public void update(Event val) {
		current.data = val;// big O(1)
	}
	public boolean searchnameBooleanlist( Contact contact) { // if he find the name return true
		findfirst();
		if (empty())
			return false;
		while (!last()) {
			if (current.Data.equals(contact)) // if he find the name
				return true;
			findnext();
		}
		if (current.Data.equals(contact)) // if the name in the last
			return true;

		return false;
	}
	public boolean isconflict(Contact contact, String time) {
		current = head;
		while (current != null) {
			if (current.data.getDateandtime().equalsIgnoreCase(time) ) 
				if(current.data.listC.searchnameBooleanlist( contact))
				return true; // check if contact have conflict or not
			current = current.next;
		}
		return false;
	}
	public void Scheduleevent(String title, String dateandtime, String location, Contact contact,Boolean appointment,LinkedList<Event> l) {
	if (empty()) {
		Event x = new Event(title, dateandtime, location,appointment);
		x.listC.insertContact(contact);
		current = head =new Node<T>(x);
		return;
	}
	l.findfirst();
	if(appointment);else {
	while(current!=null) {
	if(current.data.getTitle().equalsIgnoreCase(title)&&current.data.isAppointment()==false) {
		current.data.listC.insertContact(contact);
		return;
	}
	current=current.next;}}
	Event x = new Event(title, dateandtime, location,appointment);
	x.listC.insertContact(contact);
	l.findfirst();
	if (x.compareTo(head.data) < 0) { // the name is frist alphabetically
		Node tmp = head;
		head = new Node<T>(x);
		head.next = tmp;
	} else {
		while (current.next != null && x.compareTo(current.next.data) > 0)
			current = current.next; // the name goes to its alphabetical place
		Node tmp = current.next;
		current.next = new Node<T>(x);
		current = current.next;
		current.next = tmp;

	}
		
	}	
	public void insertContact (Contact val) {
		Node<T> tmp;
		if (empty()) {
			current = head = new Node<T> (val);
		}
		else {
			tmp = current.next;
			current.next = new Node<T> (val);
			current = current.next;
			current.next = tmp;
		}
	}
	public void test() {//test
		if (this.empty()) {
			System.out.println("The linked list is empty.");
			return;
		}
		current = head;
		Node<T> x=head;
		while (current != null) {
			if (current == head) {
				System.out.println("Title: " + current.data.getTitle());
				current.data.listC.printalphabetically1();
			}
				
			else {
				System.out.println("Title: " + current.data.getTitle());
				current.data.listC.printalphabetically1();}
            x=current;
			current = current.next;
		}
	}
	public void printalphabetically1() {//test
		if (this.empty()) {
			System.out.println("The linked list is empty.");
			return;
		}
		current = head;
		Node<T> x=head;
		while (current != null) {
			
				System.out.println("Contact " + current.Data.getName());
			
			current = current.next;
		}
	}	
	public void printalphabetically() {
		if (this.empty()) {
			System.out.println("The linked list is empty.");
			return;
		}
		current = head;
		while (current != null) {
		    System.out.println("Title: " + current.data.getTitle());
			current = current.next;
		}
	}
	public void removecontactlist( String contact) {

		
		current = head;
		// Case 1: Remove the head node
		

		// Case 2: Remove a node other than the head
		Node<T> prev = head;
		Node<T> curr = head.next;

		while (curr != null) {
			if (curr.Data.getName().equalsIgnoreCase(contact)) {
				prev.next = curr.next;
				
				
			}
			prev = curr;
			curr = curr.next;
		}
		if (head.Data.getName().equalsIgnoreCase(contact)) {
			head = head.next;
			
		}
	}
	public void removeevent( String contact) {
		if (empty()) {
			return;
		}
		
		current = head;
		
		
		Node<T> prev = head;
		Node<T> curr = head.next;
		while(curr!=null) {
			curr.data.listC.removecontactlist(contact);
			if(curr.data.listC.empty())
				prev.next = curr.next;	
			prev = curr;
			curr = curr.next;
		}
		current.data.listC.removecontactlist(contact);
		// Case 1: Remove the head node
		if (current.data.listC.empty()) {
			head = head.next;
		}
		
		
	}
	public void searchByContactName(LinkedList<T> l,String name) {
		current=head;	
		while(current!=null) {
			if(current.data.isAppointment()){
				if(current.data.listC.head.Data.getName().equalsIgnoreCase(name))
					System.out.println("Event found!\nEvent Title: "+l.data.getTitle()+"\nContact name: "+l.Data.getName()+"\nEvent date and time (MM/DD/YYYY HH:MM) "+l.data.getDateandtime()+"\nEvent location: "+l.data.getLocation());
			}
			else 
			{
			Node<Contact> tmp=current.data.listC.head;//the list for contact names
			while(tmp!=null) {
			if(tmp.Data.getName().equalsIgnoreCase(name)) {
				System.out.println("Contact found!\nEvent Title: "+l.data.getTitle()+"\nContact name: "+l.Data.getName()+"\nEvent date and time (MM/DD/YYYY HH:MM) "+l.data.getDateandtime()+"\nEvent location: "+l.data.getLocation());
			}
			tmp=tmp.next;
			}
			current=current.next;
	}
		}
	}
	public void searchByEventName(LinkedList<T> l,String title) {
		current=head;
		while(current!=null) {
			if(l.data.getTitle().equalsIgnoreCase(title)) {
				System.out.println("Event found!\nEvent Title: "+l.data.getTitle()+"\nContact name: "+l.Data.getName()+"\nEvent date and time (MM/DD/YYYY HH:MM) "+l.data.getDateandtime()+"\nEvent location: "+l.data.getLocation());
			}
		}current=current.next;
	}
	}	
	
	
	
	
	
	

