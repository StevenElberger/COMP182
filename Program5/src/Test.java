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
		System.out.println(bstree.leafCt());
		bstree.insert("Abc");
		bstree.insert("zebra");
		System.out.println(bstree);
		System.out.println(bstree.leafCt());
		BSTStrings bstree2 = new BSTStrings(bstree);
		System.out.println(bstree2);
		System.out.println(bstree.closeLeaf());
		bstree.delete("zebra");
		System.out.println(bstree);
		bstree.delete("Abc");
		System.out.println(bstree);
	}
}
