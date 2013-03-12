class CharacterNode {
	private char letter;
	private CharacterNode next;
	
	public CharacterNode(char ch, CharacterNode link) {
	}
	
	public void setCharacter(char ch) {
	}
	
	public char getCharacter() {
		return letter;
	}
	
	public void setNext(CharacterNode next) {
	}
	
	public CharacterNode getNext() {
		return next;
	}
}

class MyString {
	// member variable pointing to the head of the linked list
	private CharacterNode head;
	
	// default constructor
	public MyString() {
	}
	
	// copy constructor
	public MyString(MyString l) {
	}
	
	// constructor from a String
	public MyString(String s) {
	}
	
	// for output purposes -- override Object version
	// no spaces between the characters, no linefeeds/returns
	//public String toString() {
	//}
	
	// create a new node and add it to the head of the list
	public void addHead(char ch) {
	}
	
	// create a new node and add it to the tail of the list
	public void addTail(char ch) {
	}
	
	// modify the list so it is reversed
	public void reverse() {
	}
	
	// remove all occurrences of the character from the list
	public void removeChar(char ch) {
	}
	
	// how many nodes in the list
	//public int length() {
	//}
	
	// concatenate a copy of list1 to the end of the list
	public void concat(MyString list1) {
	}
	
	// who are you?
	public static String myName() {
		return "Steven Elberger";
	}
}