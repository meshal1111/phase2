
public class Phonebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactBST<Contact> BST = new ContactBST<Contact>();
		BST.insert("b", "1", "a", "a", "a", "a");
		BST.insert("c", "1", "a", "a", "a", "a");
		BST.insert("a t", "1", "a", "a", "a", "a");
		BST.printInOrder(BST.findroot(BST));
		System.out.println("==============");
		BST.remove_key("b");
		BST.printInOrder(BST.findroot(BST));
		BST.insert("a c", "1", "a", "a", "a", "a");
		System.out.println("==============");
		BST.printInOrder(BST.findroot(BST));
		System.out.println("==============");
		BST.findByFirstName("a",BST.findroot(BST));
	}

}
