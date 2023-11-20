
public class Node<T> {
	protected Event data;
	protected Contact Data;
	protected Node<T> next;

	public Node() {
		data = null;
		next = null;
	}

	public Node(Event val) {
		data = val;
		next = null;
	}
	public Node(Contact val) {
		Data = val;
		next = null;
	}
}
