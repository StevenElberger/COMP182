public class Test {
	public static void main(String[] args) {
		BSTStrings bstree = new BSTStrings();
		bstree.insert("Hello");
		bstree.insert("world");
		System.out.println(bstree);
		System.out.println(bstree.height());
		System.out.println(bstree.search("world"));
		System.out.println(bstree.search("abba"));
		System.out.println(bstree.search("Hello"));
	}
}
