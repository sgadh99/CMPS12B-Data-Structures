public class Dictionary implements DictionaryInterface {
	private class Node {
		String key;
		String value;
		Node next;

		Node (String key, String value) {
			this.key = key;
			this.value = value;
			next = null;
		}
	}

	private Node head;
	private int numItems;

	public Dictionary() {
		head = null;
		numItems = 0;
	}


	
	private Node findKey(String key) {
		Node N = head;
		while(N != null) {
			if(N.key != key) {
				N = N.next;
			} else return N;
		}
		return null;
	}

	public boolean isEmpty() {
		return (numItems == 0);
	}


	public int size() {
		return numItems;
	}


	public String lookup(String key) {
		Node N = findKey(key);
	
		while (N != null) {
			if (N.key.equals(key))
				return N.value;
			N = N.next;
		}
		return null;
	}


	public void insert(String key, String value) throws DuplicateKeyException {
		if (lookup(key) != null) {
			throw new DuplicateKeyException("cannot insert duplicate keys");
		} else {
			if (head == null) {
				Node N = new Node(key, value);
				head = N;
			} else {
				Node N = head;
				while(N != null){
					if (N.next == null) break;
					N = N.next;
				}
				N.next = new Node(key, value);
			}
			numItems++;
		}
	}

	public void delete(String key) throws KeyNotFoundException {
		if (lookup(key) == null) {
			throw new KeyNotFoundException("cannot delete non-existent key");
		} else {
			if (numItems <= 1) {
				Node N = head;
				head = head.next;
				N.next = null;
			
			} else {
				Node N = head;
				if (N.key.equals(key)) {
					head = N.next;
					
				} else {
					while(!N.next.key.equals(key))
						N = N.next;
					N.next = N.next.next;
				
				}
			}
			numItems--;
		}
	}


	public void makeEmpty() {
		head = null;
		numItems = 0;
	}


	public String toString() {
	
		String s = "";
		Node N = head;
		while(N != null) {
			s += N.key + " " + N.value + "\n";
			N = N.next;
		}
		return s;
	}
}
