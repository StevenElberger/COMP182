/* Steven Elberger
 * Assignment 5
 * March 26 - April 23
 * Description: StringNode represents the nodes with String values in the BSTStrings
 * class. BSTStrings objects represent binary search trees with StringNodes.
 */
class StringNode {
        private String word;
        private StringNode left, right;
        public StringNode(String w, StringNode lf, StringNode rt) {
                word = w;
                left = lf;
                right = rt;
        }
        
        // Note: there is no setString
        public String getString() {
                return word;
        }
        
        public void setLeft(StringNode pt) {
                left = pt;
        }
        
        public void setRight(StringNode pt) {
                right = pt;
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
        
        private static StringNode copyTree(StringNode treeRoot) {
        		StringNode result;
        		if (treeRoot == null) {
        			result = null;
        		} else {
        			// Copy the String, then recursively set the left and right
        			result = new StringNode(treeRoot.getString(),
        					copyTree(treeRoot.getLeft()),
        					copyTree(treeRoot.getRight()));
        		}
                return result;
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
        
        // Search for a String
        public boolean search(String s) {
                return search(root,s);
        }
        
        public static boolean search(StringNode treeRoot, String str) {
        	boolean result;
        	if (treeRoot == null) {
        		result = false;
        	} else if (treeRoot.getString().equals(str)) {
        		// Found the String
        		result = true;
        	} else if (str.compareTo(treeRoot.getString()) > 0) {
        		// If the String is greater than treeRoot's String, search the right
        		result = search(treeRoot.getRight(),str);
        	} else {
        		// String is less than treeRoot's String, search left
        		result = search(treeRoot.getLeft(),str);
        	}
        	return result;
        }
        
        // Insert a String - no duplicates allowed
        public void insert(String s) {
                root = insert(s,root);
        }
        
        public static StringNode insert(String str, StringNode treeRoot) {
                if (treeRoot == null) {
                		// Empty node, add a new one
                        treeRoot = new StringNode(str,null,null);
                } else if(str.compareTo(treeRoot.getString()) > 0) {
                        // String is greater than treeRoot's String, go right
                        treeRoot.setRight(insert(str,treeRoot.getRight()));
                } else if(str.compareTo(treeRoot.getString()) < 0) {
                        // String is less than treeRoot's String, go left
                        treeRoot.setLeft(insert(str,treeRoot.getLeft()));
                } else {
                        // Duplicate Strings, do nothing
                }
                return treeRoot;
        }
        
        // Delete a String
        public void delete(String s) {
        	root = delete(root,s);
        }
        
        private static StringNode delete(StringNode treeRoot, String str) {
        	if (treeRoot == null) {
        	} else if (treeRoot.getString().equals(str)) {
        		// Found the String
        		if (treeRoot.getLeft() == null && treeRoot.getRight() != null) {
        			// Only has one child
        			treeRoot = treeRoot.getRight();
        		} else if (treeRoot.getRight() == null && treeRoot.getLeft() != null) {
        			// Only has one child
        			treeRoot = treeRoot.getLeft();
        		} else if (treeRoot.getRight() == null && treeRoot.getLeft() == null) {
        			// TreeRoot is a leaf, just set it to null
        			treeRoot = null;
        		} else {
        			// Node has two children
        			// Save predecessor node's String
        			// Delete predecessor node
        			// Create replacement node and point treeRoot to it
        			String predString = findLargest(treeRoot.getLeft()).getString();
        			delete(treeRoot, findLargest(treeRoot.getLeft()).getString());
        			StringNode replacement = new StringNode(predString, 
        					treeRoot.getLeft(), 
        					treeRoot.getRight());
        			treeRoot = replacement; 			
        		}
        	} else if (str.compareTo(treeRoot.getString()) > 0) {
        		// String is greater than this node's String, go right
        		treeRoot.setRight(delete(treeRoot.getRight(),str));
        	} else {
        		// String is less than this node's String, go left
        		treeRoot.setLeft(delete(treeRoot.getLeft(),str));
        	}
        	return treeRoot;
        }
        
        // Find height of the tree
        public int height() {
        	return height(root);
        }
        
        public static int height(StringNode treeRoot) {
        	int result;
        	if (treeRoot == null) {
        		result = 0;
        	} else if (treeRoot.getLeft() == null && treeRoot.getRight() == null) {
        		// Reached a leaf
        		result = 1;
        	} else {
        		// Search left and right recursively
        		int lf = height(treeRoot.getLeft());
        		int rt = height(treeRoot.getRight());
        		// Return the largest
        		// + 1 because we're counting this node
        		if (lf > rt) {
        			result = lf + 1;
        		} else {
        			result = rt + 1;
        		}
        	}
        	return result;
        }
        
        // Count number of leaves in tree
        public int leafCt() {
        	return leafCt(root);
        }
        
        private static int leafCt(StringNode treeRoot) {
        	int result;
        	if (treeRoot == null) {
        		result = 0;
        	} else if (treeRoot.getLeft() == null && treeRoot.getRight() == null) {
        		// Found a leaf
        		result = 1;
        	} else {
        		// Count the left's number of leaves
        		// Add the right's number of leaves
        		result = leafCt(treeRoot.getLeft());
        		result += leafCt(treeRoot.getRight());
        	}
        	return result;
        }
        
        // Number of nodes to closest leaf from root
        public int closeLeaf() {
        	return closeLeaf(root);
        }
         
        private static int closeLeaf(StringNode treeRoot) {
        	int result;
        	if (treeRoot == null) {
        		result = 0;
        	} else if (treeRoot.getLeft() == null && treeRoot.getRight() == null) {
        		// Found a leaf
        		result = 1;
        	} else {
        		// Search left and right
        		int lf = closeLeaf(treeRoot.getLeft());
        		int rt = closeLeaf(treeRoot.getRight());
        		// If both sides have values,
        		// Return the smallest value
        		if (lf > 0 && rt > 0) {
        			if (lf < rt) {
        				result = lf + 1;
        			} else {
        				result = rt + 1;
        			}
        		 // If one side is 0, it's null and shan't
        		 // be counted.
        		 } else if (lf > 0 && rt == 0) {
        			result = lf + 1;
        		 } else if (rt > 0 && lf == 0) {
        			result = rt + 1;
        		 } else {
        		 // Both are 0
        			result = 0;
        		 }
        	 }
        	 return result;
         }
         
        // Rotate the node containing str to the left – do nothing if not
        // possible, e.g., str is not in the tree or there is no right child
        // of str.
        public void rotateLeft(String s) {
        	root = rotateLeft(root, s);
        }
        
        private static StringNode rotateLeft(StringNode treeRoot, String str) {
        	if (treeRoot == null) {
        	} else if (treeRoot.getString().equals(str)) {
        		// If we can rotate, create a pivot node
        		// Set treeroot's right to pivot's left
        		// Set pivot's left to treeRoot and rotate
        		if (treeRoot.getRight() != null) {
        			StringNode pivot = treeRoot.getRight();
            		treeRoot.setRight(pivot.getLeft());
            		pivot.setLeft(treeRoot);
            		treeRoot = pivot;
        		}
        	} else if (str.compareTo(treeRoot.getString()) > 0) {
        		// If String is greater than this node's String, go right
        		treeRoot.setRight(rotateLeft(treeRoot.getRight(),str));	
        	} else {
        		// Otherwise, go left
        		treeRoot.setLeft(rotateLeft(treeRoot.getLeft(),str));
        	}
        	return treeRoot;
        }
        
        // Rotate the node containing str to the right – do nothing if not
        // possible.
        public void rotateRight(String s) {
        	root = rotateRight(root,s);
        }
        
        private static StringNode rotateRight(StringNode treeRoot, String str) {
        	if (treeRoot == null) {
        	} else if (treeRoot.getString().equals(str)) {
        		// If we can rotate, create a pivot node
        		// Set treeRoot's left to pivot's right
        		// Set pivot's right to treeRoot and rotate
        		if (treeRoot.getLeft() != null) {
        			StringNode pivot = treeRoot.getLeft();
            		treeRoot.setLeft(pivot.getRight());
            		pivot.setRight(treeRoot);
            		treeRoot = pivot;
        		}
        	} else if (str.compareTo(treeRoot.getString()) > 0) {
        		// If String is greater than this node's String, go right
        		treeRoot.setRight(rotateRight(treeRoot.getRight(),str));	
        	} else {
        		// Otherwise, go left
        		treeRoot.setLeft(rotateRight(treeRoot.getLeft(),str));
        	}
        	return treeRoot;
        }

        // Find the largest child
        private static StringNode findLargest(StringNode treeRoot) {
        	StringNode result;
        	if (treeRoot == null) {
        		result = null;
        	} else if (treeRoot.getRight() == null) {
        		// Found the largest
        		result = treeRoot;
        	} else {
        		// Keep searching
        		result = findLargest(treeRoot.getRight());
        	}
        	return result;
        }
        
        // Remove all leaves from the tree
        public void remLfs() {
        	root = remLfs(root);
        }
        
        private static StringNode remLfs(StringNode treeRoot) {
        	if (treeRoot == null) {
        	} else if (treeRoot.getLeft() == null && treeRoot.getRight() == null) {
        		treeRoot = null;
        	} else {
        		treeRoot.setLeft(remLfs(treeRoot.getLeft()));
        		treeRoot.setRight(remLfs(treeRoot.getRight()));
        	}
        	return treeRoot;
        }
        
        // Return the smallest String whose
        // reverse is also in the tree.
        // Return the empty String if there
        // is no such String
        public String smallRev() {
            return smallRev(root, root); // Better way to do this?
        }

        private static String smallRev(StringNode temproot, StringNode root) { 
            String result;
            if (temproot == null) {
                result = "";
            } else if (search(root, revString(temproot.getString()))) {
                String left = smallRev(temproot.getLeft(),root);
                if (!left.equals("")) {
                	result = left;
                } else {
                	result = temproot.getString();
                }
            } else {
                String left = smallRev(temproot.getLeft(),root);
                String right = smallRev(temproot.getRight(),root);
                if (!left.equals("")) {
                    result = left;
                } else {
                    result = right;
                }
            }
            return result;
        }
        
        // Returns the reverse of a String
        private static String revString(String s) {
        	String rtn = "";
        	for (int i = 0; i < s.length(); i++) {
        		rtn = s.charAt(i) + rtn;
        	}
        	return rtn;
        }
        
        public static String myName() {
                return "Steven Elberger";
        }
}