
public class Test {
	public static void main(String[] args) {
		MyString list = new MyString("hello");
		System.out.println(list);
		list.addHead('t');
		list.addHead('O');
		System.out.println(list);
		list.addTail(' ');
		list.addTail('i');
		list.addTail('s');
		System.out.println(list);
		System.out.println(list.length());
	}
}