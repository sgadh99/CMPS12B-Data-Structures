class DictionaryTest {
	public static void main(String[] args) {
		Dictionary A = new Dictionary();
		System.out.println(A.isEmpty());
		A.insert("1", "a");
		System.out.println(A.isEmpty());
		System.out.println("Size of list: " + A.size());
		A.insert("2", "b");
		A.insert("3", "c");
		A.insert("4", "d");
		A.insert("5", "e");
		A.insert("6", "f");
		System.out.println(A.toString());
		System.out.println("Size of list: " + A.size());
		A.delete("4");
		System.out.println(A.toString());
		System.out.println("Size of list: " + A.size() + "\n");
		System.out.println("********************************\n");
		try {
			A.insert("6", "Duplicate"); 
		} catch(DuplicateKeyException e) {
			System.out.println("Caught Exception " + e);
        	System.out.println("Continuing without interuption \n");
		}
		A.insert("4", "Reinserted");
		System.out.println(A);
		A.makeEmpty();
		System.out.println("Size of list: " + A.size() + "\n");
		try {
			A.delete("4");
		} catch(KeyNotFoundException e) {
			System.out.println("Caught Exception " + e);
        	System.out.println("Continuing without interuption");
		}

	}
}
