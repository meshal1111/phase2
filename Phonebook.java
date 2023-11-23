package phase2;
import java.util.Scanner;

public class Phonebook {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner name = new Scanner(System.in);
		Scanner phonenumber = new Scanner(System.in);
		Scanner email = new Scanner(System.in);
		Scanner address = new Scanner(System.in);
		Scanner birthday = new Scanner(System.in);
		Scanner note = new Scanner(System.in);
		Scanner choose = new Scanner(System.in);
		Scanner test = new Scanner(System.in);
		Scanner title = new Scanner(System.in);
		Scanner dateandtime = new Scanner(System.in);
		Scanner location = new Scanner(System.in);
		int x = 0;
		ContactBST<Contact> BST = new ContactBST<Contact>();
		LinkedList<Event> li = new LinkedList<Event>();
		while (x != 9) {
			// interface
			System.out.println("Welcome to the Linked Tree Phonebook!\r\n" + "Please choose an option:\r\n"
					+ "1. Add a contact\r\n" + "2. Search for a contact\r\n" + "3. Delete a contact\r\n"
					+ "4. Schedule an event\r\n" + "5. Print event details\r\n" + "6. Print contacts by first name\r\n"
					+ "7. Print all events alphabetically\r\n" + "8. print contacts that share event\r" + "9. Exit");
              // casting
			boolean validInput = false;
			 while (!validInput) {
			try {
				x = Integer.parseInt(input.nextLine());
				validInput = true; // Exit the loop if input is valid
			} catch (Exception e) {
				System.out.println("Invalid input enter number");
				
			}}
			String n, p, e, a, b, N, t, T = null, dt = null, l = null, sn, sp, se, sa, sb, re, en;
			int q=0, ei=0;
			switch (x) {
			case 1:
				System.out.println("enter the name:");
				n = name.nextLine();
				System.out.println("enter your phonenumber:");
				p = phonenumber.nextLine();
				System.out.println("enter your email:");
				e = email.nextLine();
				System.out.println("enter your address:");
				a = address.nextLine();
				System.out.println("enter your birthday and play include it like that YY/MM/DD:");
				b = birthday.nextLine();
				System.out.println("enter the note if you want:");
				N = note.nextLine();
				System.out.println("  the name: " + n + "\r  the phonenumber: " + p + "\r  the email: " + e
						+ "\r  the address: " + a + "\r  the birthday: " + b + "\r  the note: " + N + "\r ");
				System.out.println("\r");
				if (BST.searchByNameBoolean( n) || BST.searchByNameBoolean( p)) {
					System.out.println("this name/phone already added");
					break;
				}
				BST.insert( n, p, e, a, b, N);
				System.out.println("all has been succefully added!");
				break;
			case 2:
				System.out.println("Enter search criteria:\r\n" + "1. Name\r\n" + "2. Phone Number\r\n"
						+ "3. Email Address\r\n" + "4. Address\r\n" + "5. Birthday");
				boolean validInput2 = false;
				 while (!validInput2) {
				try {
				q = Integer.parseInt(input.nextLine());
				validInput2 = true; // Exit the loop if input is valid
				} catch (Exception s) {
					System.out.println("Invalid input enter number");
					
				}}
				switch (q) {
				case 1:
					System.out.println("enter the name you want to search: ");
					sn = name.nextLine();

					Contact contact = BST.searchByName(sn);
					if (contact == null)
						System.out.println("there is no name in the list");
					else
						System.out.println("the contact is found!\r the name is: " + contact.getName()
								+ "\rthe phonenumber is: " + contact.getPhonenumber() + "\rthe email is: "
								+ contact.getEmail() + "\rthe address is: " + contact.getAddress()
								+ "\rthe birth day is: " + contact.getBirthday() + "\rthe Note you wrote is: "
								+ contact.getNotes() + "\r");

					break;
				case (2):
					System.out.println("enter the phone number you want to search: ");
					sp = name.nextLine();

					Contact contact1 = BST.searchByName(sp);
					if (contact1 == null)
						System.out.print("there is no name in the list");
					else
						System.out.println("the contact is found!\r the name is: " + contact1.getName()
								+ "\rthe phonenumber is: " + contact1.getPhonenumber() + "\rthe email is: "
								+ contact1.getEmail() + "\rthe address is: " + contact1.getAddress()
								+ "\rthe birth day is: " + contact1.getBirthday() + "\rthe Note you wrote is: "
								+ contact1.getNotes() + "\r");
					break;
				case (3):
					System.out.println("enter the email you want to search: ");
					se = name.nextLine();
					BST.searchByEmail(BST.findroot(BST), se);
					System.out.println("\r");
					break;
				case (4):
					System.out.println("enter the address you want to search: ");
					sa = name.nextLine();
					BST.searchByAddress(BST.findroot(BST), sa);
					System.out.println("\r");
					break;
				case (5):
					System.out.println("enter the birthday you want to search: ");
					sb = name.nextLine();
					BST.searchByBirthday(BST.findroot(BST), sb);
					System.out.println("\r");
					break;
				default:

				}
				break;

			case (3):
				System.out.println("what name do you want to remove?");
				re = name.nextLine();
				BST.remove_key(re);
				break;
			case (4):
				System.out.println("enter the the contact to participate in the event:");
				en = name.nextLine();
				Contact contact = BST.searchByName(en);
				if (contact == null) {
					System.out.println("we are sorry there is no name in the list");
					break;
				} else {
					System.out.println("1-event 2- appointment");
					q = Integer.parseInt(input.nextLine());
					if(q==1) {
						li.Scheduleevent(T, dt, l, BST.searchByName( en),false,li);
						System.out.println("the event has been succefully scheduled!");
					break;}
					
					else {
						li.Scheduleevent(T, dt, l, BST.searchByName( en),true,li);
						System.out.println("the appointment has been succefully scheduled!");
					break;
					}
					
				}
				
			case (5):
				System.out.println("enter search critiria\r1.contact name\r2.event title");
			boolean validInput5 = false;
			 while (!validInput5) {
			try {
				ei = Integer.parseInt(input.nextLine());
				validInput5 = true; // Exit the loop if input is valid
			} catch (Exception m) {
				System.out.println("Invalid input enter number");
				
			}}
				if (ei == 1) {
					System.out.println("enter the contact: ");
					t = test.nextLine();
					Contact contact2 = BST.searchByName( t);
					if (contact2 == null)
						System.out.println("we are sorry there is no name in the list\r");
					else {
						System.out.println("the contact has been found!");
						li.searchByContactName(li,t);
						System.out.println("\r");
						break;
					}
				} else if (ei == 2) {
					System.out.println("enter the event title: ");
					t = test.nextLine();
					li.searchByEventName(li, t);
					System.out.println("\r");
					break;
				} else
					System.out.println("wrong number");
				    break;
			case (6):
				System.out.println("enter the contact frist name: ");
				t = test.nextLine();
				BST.findByFirstName(t,BST.findroot(BST));
				System.out.println("\r");
				break;
			case (7):
				li.printalphabetically();
				break;
			case (8):
				System.out.println("thank you for using our code!");
				break;
			default:
				System.out.println("wrong number try again!");

			}
		}

	}
	

}
		


	}

}
