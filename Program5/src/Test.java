public class Test {
	public static void main(String[] args) {
		BSTStrings bstree = new BSTStrings();
		bstree.insert("N");
		System.out.println(bstree);
		bstree.insert("D");
		System.out.println(bstree);
		bstree.insert("F");
		System.out.println(bstree);
		bstree.insert("E");
		System.out.println(bstree);
		bstree.insert("G");
		System.out.println(bstree);
		System.out.println(bstree.closeLeaf());
		System.out.println(bstree.leafCt());
		System.out.println(bstree.height());
	}
}
