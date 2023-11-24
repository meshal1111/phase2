
public class BSTNode<T> {
	public String key;
	public Contact data;
	public BSTNode<T> left, right;

	public BSTNode(String k, Contact val) {
		key = k;
		data = val;
		left = right = null;
	}

	public BSTNode(String k, Contact val, BSTNode<T> l, BSTNode<T> r) {
		key = k;
		data = val;
		left = l;
		right = r;
	}

}
