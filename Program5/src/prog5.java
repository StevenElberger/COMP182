/* Steven Elberger
 * Assignment 5
 * March 26 - April 23
 * Description: StringNode represents the nodes in the BSTStrings class. BSTStrings objects represent binary search trees with String values.
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
        
        private static StringNode copyTree(StringNode l) {
        		StringNode result;
        		if (l == null) {
        			result = null;
        		} else {
        			// Copy the String, then recursively set the left and right
        			result = new StringNode(l.getString(),copyTree(l.getLeft()),copyTree(l.getRight()));
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
        
        public static boolean search(StringNode troot, String str) {
        	boolean result;
        	if (troot == null) {
        		result = false;
        	} else if (troot.getString().equals(str)) {
        		// Found the String
        		result = true;
        	} else if (str.compareTo(troot.getString()) > 0) {
        		// If the String is greater than troot's String, search the right
        		result = search(troot.getRight(),str);
        	} else {
        		// String is less than troot's String, search left
        		result = search(troot.getLeft(),str);
        	}
        	return result;
        }
        
        // Insert a String - no duplicates allowed
        public void insert(String s) {
                root = insert(s,root);
        }
        
        public static StringNode insert(String str, StringNode troot) {
                if (troot == null) {
                		// Empty node, add a new one
                        troot = new StringNode(str,null,null);
                } else if(str.compareTo(troot.getString()) > 0) {
                        // String is greater than troot's String, go right
                        troot.setRight(insert(str,troot.getRight()));
                } else if(str.compareTo(troot.getString()) < 0) {
                        // String is less than troot's String, go left
                        troot.setLeft(insert(str,troot.getLeft()));
                } else {
                        // Duplicate Strings, do nothing
                }
                return troot;
        }
        
        // Delete a String
        public void delete(String s) {
        	root = delete(root,s);
        }
        
        private static StringNode delete(StringNode troot, String str) {
        	if (troot == null) {
        	} else if (troot.getString().equals(str)) {
        		// Found the String
        		if (troot.getLeft() == null && troot.getRight() != null) {
        			// Only has one child
        			troot = troot.getRight();
        		} else if (troot.getRight() == null && troot.getLeft() != null) {
        			// Only has one child
        			troot = troot.getLeft();
        		} else if (troot.getRight() == null && troot.getLeft() == null) {
        			// Troot is a leaf, just set it to null
        			troot = null;
        		} else {
        			// Node has two children
        			// Its replacement will be the largest child
        			StringNode replacement = findReplacement(troot);
        			// Set the replacement's left to troot's left
        			replacement.setLeft(troot.getLeft());
        			// Same with right
        			replacement.setRight(troot.getRight());
        			// Replace troot with the replacement node
        			troot = replacement;
        		}
        	} else if (str.compareTo(troot.getString()) > 0) {
        		// String is greater than this node's String, go right
        		troot.setRight(delete(troot.getRight(),str));
        	} else {
        		// String is less than this node's String, go left
        		troot.setLeft(delete(troot.getLeft(),str));
        	}
        	return troot;
        }
        
        // Find's replacement node, set's troot's right child to appropriate node
        private static StringNode findReplacement(StringNode troot) {
        	StringNode result = null;
        	if (troot.getRight().getLeft() == null && troot.getRight().getRight() == null) {
        		// Found the largest and it is a leaf
        		// Set troot's right to null
        		result = troot.getRight();
        		troot.setRight(null);
        	} else if (troot.getRight().getLeft() != null && troot.getRight().getRight() == null) {
        		// Found the largest, but it has a left child
        		// Set this node's right to the largest node's
        		// left child
        		result = troot.getRight();
        		troot.setRight(troot.getRight().getLeft());
        	} else {
        		// Keep searching
        		findReplacement(troot.getRight());
        	}
        	return result;
        }
        
        // Find height of the tree
        public int height() {
        	return height(root);
        }
        
        public static int height(StringNode troot) {
        	int result;
        	if (troot == null) {
        		result = 0;
        	} else if (troot.getLeft() == null && troot.getRight() == null) {
        		// Reached a leaf
        		result = 1;
        	} else {
        		// Search left and right recursively
        		int lf = height(troot.getLeft());
        		int rt = height(troot.getRight());
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
        
        private static int leafCt(StringNode troot) {
        	int result;
        	if (troot == null) {
        		result = 0;
        	} else if (troot.getLeft() == null && troot.getRight() == null) {
        		// Found a leaf
        		result = 1;
        	} else {
        		// Count the left's number of leaves
        		// Add the right's number of leaves
        		result = leafCt(troot.getLeft());
        		result += leafCt(troot.getRight());
        	}
        	return result;
        }
        
        // Number of nodes to closest leaf from root
        public int closeLeaf() {
        	return closeLeaf(root);
        }
         
        private static int closeLeaf(StringNode troot) {
        	int result;
        	if (troot == null) {
        		result = 0;
        	} else if (troot.getLeft() == null && troot.getRight() == null) {
        		// Found a leaf
        		result = 1;
        	} else {
        		// Search left and right
        		int lf = closeLeaf(troot.getLeft());
        		int rt = closeLeaf(troot.getRight());
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
         
        // Rotate the node containing val to the left – do nothing if not
        // possible, e.g., val is not in the tree or there is no right child
        // of val.
        public void rotateLeft(String s) {
        	root = rotateLeft(root, s);
        }
        
        private static StringNode rotateLeft(StringNode troot, String str) {
        	if (troot == null) {
        	} else if (troot.getString().equals(str)) {
        		// Found the node we need to rotate
        		// Make a copy of troot
        		// Find the smallest node of the right child
        		StringNode copyTroot = new StringNode(troot.getString(),troot.getLeft(),null);
        		StringNode smallestNode = findSmallest(troot.getRight());
        		// If smallest node isn't null, set troot to its right child
        		// Then set the smallest node's left to troot
        		if (smallestNode != null) {
        			troot = troot.getRight();
        			smallestNode.setLeft(copyTroot);
        		}
        	} else if (str.compareTo(troot.getString()) > 0) {
        		// If String is greater than this node's String, go right
        		troot.setRight(rotateLeft(troot.getRight(),str));	
        	} else {
        		// Otherwise, go left
        		troot.setLeft(rotateLeft(troot.getLeft(),str));
        	}
        	return troot;
        }
        
        // Rotate the node containing val to the right – do nothing if not
        // possible.
        public void rotateRight(String s) {
        	root = rotateRight(root,s);
        }
        
        private static StringNode rotateRight(StringNode troot, String str) {
        	if (troot == null) {
        	} else if (troot.getString().equals(str)) {
        		// Found the node we need to rotate
        		// Make a copy of troot
        		// Find the largest node of the left child
        		StringNode copyTroot = new StringNode(troot.getString(),null,troot.getRight());
        		StringNode largestNode = findLargest(troot.getLeft());
        		// If largest node isn't null, set troot to its left child
        		// Then set the largest node's right to troot
        		if (largestNode != null) {
        			troot = troot.getLeft();
        			largestNode.setRight(copyTroot);
        		}
        	} else if (str.compareTo(troot.getString()) > 0) {
        		// If String is greater than this node's String, go right
        		troot.setRight(rotateRight(troot.getRight(),str));	
        	} else {
        		// Otherwise, go left
        		troot.setLeft(rotateRight(troot.getLeft(),str));
        	}
        	return troot;
        }
        
        // Find the smallest child
        private static StringNode findSmallest(StringNode troot) {
        	StringNode result;
        	if (troot == null) {
        		result = null;
        	} else if (troot.getLeft() == null) {
        		// Found the smallest
        		result = troot;
        	} else {
        		// Keep searching
        		result = findSmallest(troot.getLeft());
        	}
        	return result;
        }
        
        // Find the largest child
        private static StringNode findLargest(StringNode troot) {
        	StringNode result;
        	if (troot == null) {
        		result = null;
        	} else if (troot.getRight() == null) {
        		// Found the largest
        		result = troot;
        	} else {
        		// Keep searching
        		result = findLargest(troot.getRight());
        	}
        	return result;
        }
        
        // Remove all leaves from the tree
        public void remLfs() {
        	root = remLfs(root);
        }
        
        private static StringNode remLfs(StringNode troot) {
        	if (troot == null) {
        	} else if (troot.getLeft() == null && troot.getRight() == null) {
        		troot = null;
        	} else {
        		troot.setLeft(remLfs(troot.getLeft()));
        		troot.setRight(remLfs(troot.getRight()));
        	}
        	return troot;
        }
        
        // Return the smallest String whose
        // reverse is also in the tree.
        // Return the empty String if there
        // is no such String
        public String smallRev() {
            return smallRev(root, root); // <--- Bad practice?
        }

        private static String smallRev(StringNode temproot, StringNode root) { 
            String result;
            if (temproot == null) {
                result = "";
            } else if (search(root, revString(temproot.getString()))) {
                result = temproot.getString();
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