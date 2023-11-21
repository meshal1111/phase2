
public class Phonebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactBST<Contact> BST = new ContactBST<Contact>();
		LinkedList<Event> li = new LinkedList<Event>();
		BST.insert("b", "1", "a", "a", "a", "a");
		BST.insert("c", "12", "a", "a", "a", "a");
		BST.insert("a t", "13", "a", "a", "a", "a");
		BST.printInOrder(BST.findroot(BST));
		System.out.println("==============");
		BST.remove_key("b",li);
		BST.printInOrder(BST.findroot(BST));
		BST.insert("a c", "1", "ab", "ab", "ab", "a");
		System.out.println("==============");
		BST.printInOrder(BST.findroot(BST));
		System.out.println("==============");
		BST.findByFirstName("a",BST.findroot(BST));
		System.out.println(BST.searchByName("a t"));
		BST.searchByBirthday(BST.findroot(BST), "ab");
		System.out.println(BST.searchByPhoneBoolean(BST.findroot(BST), "1"));
		System.out.println(BST.searchByPhone(BST.findroot(BST), "13"));
		System.out.println("==============");
		System.out.println("==============");
		li.Scheduleevent("z","1" , "a",BST.searchByName("a t") , true, li);
		li.Scheduleevent("x","2" , "a",BST.searchByName("a t") , true, li);
		li.Scheduleevent("x","a" , "a",BST.searchByName("a c") , true, li);
		li.Scheduleevent("a","a" , "a",BST.searchByName("a t") , false, li);
		li.Scheduleevent("a","a" , "a",BST.searchByName("a c") , false, li);
		li.Scheduleevent("a","a" , "a",BST.searchByName("c") , false, li);
		li.test();
		System.out.println("==============");
		System.out.println("==============");
		//System.out.println(li.isconflict(BST.searchByName("a t"), "1"));
		System.out.println("==============");
		System.out.println("==============");
		System.out.println("==============");
		System.out.println("==============");
		//BST.remove_key("a c",li);
		li.test();
		System.out.println("==============");
		System.out.println("==============");
		System.out.println("==============");
		System.out.println("==============");
		//BST.printInOrder(BST.findroot(BST));
		li.searchByContactName(li, "a t");
	}

}
