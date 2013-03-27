public class Test {
	public static void main(String[] args) {
		BSTStrings bstree = new BSTStrings();
		bstree.insert("Hello");
		bstree.insert("world");
		System.out.println(bstree);
		System.out.println(bstree.height());
	}
}
