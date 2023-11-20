
public class ContactBST <T>{
BSTNode<T> root, current;
	
	/** Creates a new instance of BST */
	public ContactBST() {
		root = current = null;
	}
	
	public boolean empty() {
		return root == null;
	}
	
	public boolean full() {
		return false;
	}
	
	public Contact retrieve () {
		return current.data;
	}
	public boolean findkey(String tkey) {
		BSTNode<T> p = root,q = root;
				
		if(empty())
			return false;
		
		while(p != null) {
			q = p;
			if(p.key.equalsIgnoreCase(tkey)) {
				current = p;
				return true;
			}
			else if(tkey.compareTo(p.key) < 0 )
				p = p.left;
			else
				p = p.right;
		}
		
		current = q;
		return false;
	}
	public boolean insert(String name, String phone, String email, String address, String birth,
			String note) {
		Contact val = new Contact(name, phone, email, address, birth, note);
		BSTNode<T> p, q = current;
		
		if(findkey(name)) {
			current = q;  // findkey() modified current
			return false; // key already in the BST
		}
		
		p = new BSTNode<T>(name, val);
		if (empty()) {
			root = current = p;
			return true;
		}
		else {
			// current is pointing to parent of the new key
			if (name.compareTo(current.key) < 0)
				current.left = p;
			else
				current.right = p;
			current = p;
			return true;
		}
	}
	public boolean remove_key (String tkey,LinkedList<Event> l){
		Boolean removed = false;
		BSTNode<T> p;
		p = remove_aux(tkey, root, removed);
		current = root = p;
		l.removeevent(tkey);
		
		return removed;
	}
	private BSTNode<T> remove_aux(String key, BSTNode<T> p, Boolean flag) {
		BSTNode<T> q, child = null;
		if(p == null)
			return null;
		if(key.compareTo(p.key) < 0)
			p.left = remove_aux(key, p.left, flag); //go left
		else if(key.compareTo(p.key) > 0)
			p.right = remove_aux(key, p.right, flag); //go right
		else { // key is found
			flag= true;
			if (p.left != null && p.right != null){ //two children
				q = find_min(p.right);
				p.key = q.key;
				p.data = q.data;
				p.right = remove_aux(q.key, p.right, flag);
			}
			else {
				if (p.right == null) //one child
					child = p.left;
				else if (p.left == null) //one child
					child = p.right;
				return child;
			}
		}
		return p;
	}
	private BSTNode<T> find_min(BSTNode<T> p){
		if(p == null)
			return null;
		
		while(p.left != null){
			p = p.left;
		}
		
		return p;
	}
	public static<T> void printInOrder(BSTNode<T> root) {//test
        if (root != null) {
            // Traverse the left subtree
            printInOrder(root.left);

            // Print the current node's value
            System.out.print(root.data.getName() + " ");

            // Traverse the right subtree
            printInOrder(root.right);
        }
	}
	public BSTNode<T> findroot(ContactBST<T> B) {//test
		BSTNode<T> p = B.root;
				return p;
	}
	public  void findByFirstName(String name,BSTNode<T> root) {
		
		if (root != null) {
			
            // Traverse the left subtree
			findByFirstName(name,root.left);

            String words[] = root.data.getName().split(" "); // split name
			if (words[0].equalsIgnoreCase(name)) {
				 
				System.out.println("contacts found\nName: " + root.data.getName() + "\nPhone Number: "
						+ root.data.getPhonenumber() + "\nEmail Address: " + root.data.getEmail()
						+ "\nAddress: " + root.data.getAddress()+ "\nBirthday: " + root.data.getBirthday()
						+ "\nNotes: " + root.data.getNotes());
			}
            

            // Traverse the right subtree
			findByFirstName(name,root.right);
        }
	}
	public  Boolean searchByNameBoolean(String tkey) {
		BSTNode<T> p = root,q = root;
		
		if(empty())
			return false;
		
		while(p != null) {
			q = p;
			if(p.key.equalsIgnoreCase(tkey)) {
				current = p;
				return true;
			}
			else if(tkey.compareTo(p.key) < 0 )
				p = p.left;
			else
				p = p.right;
		}
		
		current = q;
		return false;
	}
	public  Contact searchByName(String tkey) {
BSTNode<T> p = root,q = root;
		
		if(empty())
			return null;
		
		while(p != null) {
			q = p;
			if(p.key.equalsIgnoreCase(tkey)) {
				current = p;
				return current.data;
			}
			else if(tkey.compareTo(p.key) < 0 )
				p = p.left;
			else
				p = p.right;
		}
		
		current = q;
		return null;
	}
        public static<T> void searchByEmail(BSTNode<T> root,String Email) {
    		
    	
            if (root != null) {
                // Traverse the left subtree
            	searchByEmail(root.left,Email);

                // Print the current node's value
                if(root.data.getEmail().equalsIgnoreCase(Email)) {
                	System.out.println("contacts found\nName: " + root.data.getName() + "\nPhone Number: "
    						+ root.data.getPhonenumber() + "\nEmail Address: " + root.data.getEmail()
    						+ "\nAddress: " + root.data.getAddress()+ "\nBirthday: " + root.data.getBirthday()
    						+ "\nNotes: " + root.data.getNotes());
                }

                // Traverse the right subtree
                searchByEmail(root.right,Email);
            }
	}
        public static<T> void searchByBirthday(BSTNode<T> root,String Birth) {
    		
    	
            if (root != null) {
                // Traverse the left subtree
            	searchByBirthday(root.left,Birth);

                // Print the current node's value
                if(root.data.getEmail().equalsIgnoreCase(Birth)) {
                	System.out.println("contacts found\nName: " + root.data.getName() + "\nPhone Number: "
    						+ root.data.getPhonenumber() + "\nEmail Address: " + root.data.getEmail()
    						+ "\nAddress: " + root.data.getAddress()+ "\nBirthday: " + root.data.getBirthday()
    						+ "\nNotes: " + root.data.getNotes());
                }

                // Traverse the right subtree
                searchByBirthday(root.right,Birth);
            }
	}
        public static<T> void searchByAddress(BSTNode<T> root,String Address) {
    		
    	
            if (root != null) {
                // Traverse the left subtree
            	searchByAddress(root.left,Address);

                // Print the current node's value
                if(root.data.getEmail().equalsIgnoreCase(Address)) {
                	System.out.println("contacts found\nName: " + root.data.getName() + "\nPhone Number: "
    						+ root.data.getPhonenumber() + "\nEmail Address: " + root.data.getEmail()
    						+ "\nAddress: " + root.data.getAddress()+ "\nBirthday: " + root.data.getBirthday()
    						+ "\nNotes: " + root.data.getNotes());
                }

                // Traverse the right subtree
                searchByAddress(root.right,Address);
            }
        }
        public static<T> Contact searchByPhone(BSTNode<T> root,String phone) {
        	  // Base case: if the node is null, value not found
            if (root == null) {
                return null;
            }

            // Check if the current node's value is equal to x
            if (root.data.getPhonenumber().equalsIgnoreCase(phone)) {
                return root.data; // Value found, stop recursion
            }

            // Recursively search in the left subtree
            Contact leftResult = searchByPhone(root.left, phone);
            if (leftResult!=null) {
                return leftResult; // Value found in the left subtree, stop recursion
            }

            // Recursively search in the right subtree
            return searchByPhone(root.right, phone);
        }
        public static<T> Boolean searchByPhoneBoolean(BSTNode<T> root,String phone) {
        	if (root == null) {
                return false;
            }

            // Check if the current node's value is equal to x
            if (root.data.getPhonenumber().equalsIgnoreCase(phone) ) {
                return true; // Value found, stop recursion
            }

            // Recursively search in the left subtree
            if (searchByPhoneBoolean(root.left, phone)) {
                return true; // Value found in the left subtree, stop recursion
            }

            // Recursively search in the right subtree
            return searchByPhoneBoolean(root.right, phone); // Value found or not, return the result
        }
    	}
