public class Test {
	public static void main(String[] args) {
		MyString list = new MyString("hello");
		System.out.println("List: " + list);
		list.addHead('t');
		list.addHead('O');
		System.out.println("List: " + list);
		list.addTail(' ');
		list.addTail('i');
		list.addTail('s');
		System.out.println("List: " + list);
		System.out.println("List length: " + list.length());
		MyString list2 = new MyString(list);
		System.out.println("List2: " + list2);
		list.removeChar('l');
		System.out.println("List: " + list);
		System.out.println("List2: " + list2);
	}
}