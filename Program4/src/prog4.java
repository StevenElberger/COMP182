/* Steven Elberger
 * Assignment 4
 * March 11 - March 21
 * Description: CharacterNode is a node class which holds a char and another node.
 * MyString is a list class which holds CharacterNodes. Populate MyString with CharacterNodes 
 * to create a linked list.
 */
class CharacterNode {
	private char letter;
	private CharacterNode next;

	public CharacterNode(char ch, CharacterNode link) {
		letter = ch;
		next = link;
	}

	public void setCharacter(char ch) {
		letter = ch;
	}

	public char getCharacter() {
		return letter;
	}

	public void setNext(CharacterNode next) {
		this.next = next;
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
		for (int i = s.length() - 1; i >= 0; i--) {
			if (i == s.length() - 1) {
				head = new CharacterNode(s.charAt(i),null);
			} else {
				head = new CharacterNode(s.charAt(i),head);
			}
		}
	}

	// for output purposes -- override Object version
	// no spaces between the characters, no linefeeds/returns
	public String toString() {
		String result = "";
		CharacterNode pt = head;
		while (pt != null) {
			result += String.valueOf(pt.getCharacter());
			pt = pt.getNext();
		}
		return result;
	}

	// create a new node and add it to the head of the list
	public void addHead(char ch) {
		head = new CharacterNode(ch,head);
	}

	// create a new node and add it to the tail of the list
	public void addTail(char ch) {
		head = addTail(head,ch);
	}

	private static CharacterNode addTail(CharacterNode L, char letter) {
		if (L == null) {
			L = new CharacterNode(letter,null);
		} else {
			L.setNext(addTail(L.getNext(),letter));
		}
		return L;
	}

	// modify the list so it is reversed
	public void reverse() {
	}

	// remove all occurrences of the character from the list
	public void removeChar(char ch) {
		head = removeChar(head,ch);
	}
	
	private static CharacterNode removeChar(CharacterNode n, char letter) {
		if (n == null) {
		} else if (n.getCharacter() == letter) {
			n = n.getNext();
			n.setNext(removeChar(n.getNext(),letter));
		} else {
			n.setNext(removeChar(n.getNext(),letter));
		}
		return n;
	}

	// how many nodes in the list
	public int length() {
		return length(head);
	}

	private static int length(CharacterNode L) {
		int result = 0;
		if (L == null) {
		} else {
			result = length(L.getNext()) + 1;
		}
		return result;
	}

	// concatenate a copy of list1 to the end of the list
	public void concat(MyString list1) {
	}

	// who are you?
	public static String myName() {
		return "Steven Elberger";
	}
}