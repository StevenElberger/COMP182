class StringNode {
        private String word;
        private StringNode left, right;
        public StringNode(String w, StringNode lf, StringNode rt) {
                this.word = w;
                this.left = lf;
                this.right = rt;
        }
        // Note: there is no setString
        public String getString() {
                return word;
        }
        public void setLeft(StringNode pt) {
                this.left = pt;
        }
        public void setRight(StringNode pt) {
                this.right = pt;
        }
        public StringNode getLeft() {
                return left;
        }
        public StringNode getRight() {
                return right;
        }
}
 
class BSTStrings {
        // member variable pointing to the root of the BST
        private StringNode root;
        // default constructor
        public BSTStrings() {
        }
        // copy constructor
        public BSTStrings(BSTStrings t) {
                root = copyTree(t.root);
        }
        private static StringNode copyTree(StringNode l) {
                return l;
        }
        // for output purposes -- override Object version
        public String toString() {
                return toString(root, 1);
        }
        private static String toString(StringNode l, int x) {
                String s = "";
                if (l == null) {
                        // nothing to output
                } else {
                        if (l.getLeft() != null) { // don't output empty subtrees
                                s = '(' + toString(l.getLeft(), x+1) + ')';
                        }
                        s = s + l.getString() + "-" + x;
                        if (l.getRight() != null) { // don't output empty subtrees
                                s = s + '(' + toString(l.getRight(), x+1) + ')';
                        }
                }
                return s;
        }
        public boolean search(String s) {
                return false;
        }
        public void insert(String s) {
                root = insert(s,root);
        }
        public static StringNode insert(String str, StringNode troot) {
                if (troot == null) {
                        troot = new StringNode(str,null,null);
                        //System.out.println(troot.getString());
                } else if(str.compareTo(troot.getString()) > 0) {
                        // string is greater than, go right!
                        troot.setRight(insert(str,troot.getRight()));
                } else if(str.compareTo(troot.getString()) < 0) {
                        // string is less than, go left!
                        troot.setLeft(insert(str,troot.getLeft()));
                } else {
                        // same strings, do nothing
                }
                return troot;
        }
        public void delete(String s) {
        }
        public int height() {
                return 0;
        }
        public int leafCt() {
                return 0;
        }
         public int closeLeaf() {
                 return 0;
         }
        // Rotate the node containing val to the left � do nothing if not
        // possible, e.g., val is not in the tree or there is no right child
        // of val.
        public void rotateLeft(String s) {
        }
        // Rotate the node containing val to the right � do nothing if not
        // possible.
        public void rotateRight(String s) {
        }
        public static String myName() {
                return "Steven Elberger";
        }
}