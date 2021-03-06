/* Steven Elberger
 * Assignment 4
 * March 11 - March 21
 * Description: CharacterNode is a node class which holds a char and another node.
 * MyString is a list class which holds a CharacterNode named head. Populate MyString with CharacterNodes 
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
		this.letter = ch;
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
		head = copylist(head,l.head);
	}

	// constructor from a String
	public MyString(String s) {
		head = copystring(s,head);
	}
	
	public String toString() {
		return toString(head);
	}
	
	// Take String value of head's character
	// Add it to the rest of the list's values
	private static String toString(CharacterNode lhead) {
		String result = "";
		if (lhead == null) {
		} else {
			result = String.valueOf(lhead.getCharacter()) + toString(lhead.getNext());
		}
		return result;
	}
	
	// If the string has only one character left, stop recursive calls
	// Otherwise, set head's character equal to the first char in s
	// Then, set its next equal to the rest of the list
	private CharacterNode copystring(String s, CharacterNode lhead) {
		if (s.length() < 1) {
		} else if (s.length() == 1) {
			lhead = new CharacterNode(s.charAt(0),null);
		} else {
			lhead = new CharacterNode(s.charAt(0),null);
			lhead.setNext(copystring(s.substring(1,s.length()),lhead.getNext()));
		}
		return lhead;
	}
	
	// Take the character from the parameter head and add it to this list's head
	// Link head up to the rest of this list
	private CharacterNode copylist(CharacterNode lhead, CharacterNode paramlhead) {
		if (paramlhead == null) {
		} else {
			lhead = new CharacterNode(paramlhead.getCharacter(),null);
			lhead.setNext(copylist(lhead.getNext(),paramlhead.getNext()));
		}
		return lhead;
	}
	
	// create a new node and add it to the head of the list
	public void addHead(char ch) {
		// Head is now a new node with its old value as its next
		head = new CharacterNode(ch,head);
	}

	// create a new node and add it to the tail of the list
	public void addTail(char ch) {
		head = addTail(head,ch);
	}

	private static CharacterNode addTail(CharacterNode L, char letter) {
		// Once we reach the end of the list, add the new node
		if (L == null) {
			L = new CharacterNode(letter,null);
		} else {
			L.setNext(addTail(L.getNext(),letter));
		}
		return L;
	}

	// modify the list so it is reversed
	public void reverse() {
		// Figure this out! Make this recursive!
		head = reverse(head);
	}
	
	private static CharacterNode reverse(CharacterNode listhead) {
		if (listhead == null || listhead.getNext() == null) {
		} else {
			// Store the next node
			CharacterNode nextnode = listhead.getNext();
			// Disconnect head from the next node
			listhead.setNext(null);
			// Reverse the rest of the list
			CharacterNode restoflist = reverse(nextnode);
			// Link the next node up to head
			nextnode.setNext(listhead);
			// Set head equal to the rest of the reversed list
			listhead = restoflist;
		}
		return listhead;
	}

	// remove all occurrences of the character from the list
	public void removeChar(char ch) {
		head = removeChar(head,ch);
	}
	
	private static CharacterNode removeChar(CharacterNode n, char letter) {
		// If the node contains the character, search the rest of the list
		// Then set the node equal to the next node, effectively removing it
		// Otherwise, search the rest of the list
		if (n == null) {
		} else if (n.getCharacter() == letter) {
			n.setNext(removeChar(n.getNext(),letter));
			n = n.getNext();
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
		// Add one for every node
		int result = 0;
		if (L == null) {
		} else {
			result = length(L.getNext()) + 1;
		}
		return result;
	}

	// concatenate a copy of list1 to the end of the list
	public void concat(MyString list1) {
		// Pass in a copy instead of the real deal
		MyString newlist = new MyString(list1);
		head = concat(head,newlist.head);
	}
	
	private static CharacterNode concat(CharacterNode lhead, CharacterNode headtail) {
		// If the first list is empty, point it towards the new list
		if (lhead == null) {
			lhead = headtail;
		// If the list is one element, set its next to the new list's head
		} else if (lhead.getNext() == null) {
			lhead.setNext(headtail);
		// Otherwise, set the tail's next to the new list's head
		} else {
			lhead.setNext(concat(lhead.getNext(),headtail));
		}
		return lhead;
	}

	// who are you?
	public static String myName() {
		return "Steven Elberger";
	}
}