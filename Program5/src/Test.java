class Test {
    public static void main(String[] args) {
        String s;
        int i, ran_num;
        System.out.println("Author: " + BSTStrings.myName());
        System.out.println();
        System.out.println("Testing insert.");
        BSTStrings tree = new BSTStrings();
        System.out.print(tree + " || ");
        tree.insert("fred");
        System.out.print(tree + " || ");
        tree.insert("alice");
        System.out.print(tree + " || ");
        tree.insert("brad");
        System.out.println(tree);
        tree.insert("laura");
        System.out.println(tree);
        tree.insert("pete");
        System.out.println(tree);
        tree.insert("henry");
        System.out.println(tree);
        tree.insert("henry");
        System.out.println(tree);
        tree.insert("fred");
        System.out.println(tree);
        System.out.println();
        System.out.println("Testing search.");
        s = "fred";
        if (tree.search(s))
            System.out.print(s + " found. ");
        else
            System.out.println("*** ERROR " + s + " not found.");
        s = "laura";
        if (tree.search(s))
            System.out.print(s + " found. ");
        else
            System.out.println("*** ERROR " + s + " not found.");
        s = "henry";
        if (tree.search(s))
            System.out.print(s + " found. ");
        else
            System.out.println("*** ERROR " + s + " not found.");
        s = "brad";
        if (tree.search(s))
            System.out.println(s + " found. ");
        else
            System.out.println("*** ERROR " + s + " not found.");
        s = "abbot";
        if (!tree.search(s))
            System.out.print(s + " OK. ");
        else
            System.out.println("*** ERROR " + s + " found.");
        s = "carl";
        if (!tree.search(s))
            System.out.print(s + " OK. ");
        else
            System.out.println("*** ERROR " + s + " found.");
        s = "gary";
        if (!tree.search(s))
            System.out.print(s + " OK. ");
        else
            System.out.println("*** ERROR " + s + " found.");
        s = "sally";
        if (!tree.search(s))
            System.out.print(s + " OK. ");
        else
            System.out.println("*** ERROR " + s + " found.");
        System.out.println();
        System.out.println();
        System.out.println("Testing height, leaf count, and close leaf.");
        System.out.print(tree.height() + " - " + tree.leafCt() + " - "
                + tree.closeLeaf() + ". ");
        tree = new BSTStrings();
        System.out.print(tree.height() + " - " + tree.leafCt() + " - "
                + tree.closeLeaf() + ". ");
        tree.insert("cat");
        System.out.print(tree.height() + " - " + tree.leafCt() + " - "
                + tree.closeLeaf() + ". ");
        tree.insert("dog");
        System.out.print(tree.height() + " - " + tree.leafCt() + " - "
                + tree.closeLeaf() + ". ");
        tree.insert("fat");
        System.out.print(tree.height() + " - " + tree.leafCt() + " - "
                + tree.closeLeaf() + ". ");
        tree.insert("eat");
        System.out.print(tree.height() + " - " + tree.leafCt() + " - "
                + tree.closeLeaf() + ". ");
        tree.insert("bar");
        System.out.print(tree.height() + " - " + tree.leafCt() + " - "
                + tree.closeLeaf() + ". ");
        tree.insert("car");
        System.out.print(tree.height() + " - " + tree.leafCt() + " - "
                + tree.closeLeaf() + ". ");
        tree.insert("tar");
        System.out.print(tree.height() + " - " + tree.leafCt() + " - "
                + tree.closeLeaf() + ". ");
        tree.insert("rat");
        System.out.print(tree.height() + " - " + tree.leafCt() + " - "
                + tree.closeLeaf() + ". ");
        System.out.println();
        System.out.println();
        System.out.println("Testing copy constructor.");
        BSTStrings tree1 = new BSTStrings(tree);
        System.out.println(tree);
        System.out.println(tree1);
        tree.insert("pet");
        tree.insert("paw");
        tree.insert("pal");
        tree1.insert("ape");
        tree1.insert("alp");
        tree1.insert("art");
        System.out.println(tree);
        System.out.println(tree1);
        System.out.println();
        System.out.println("Testing rotates.");
        tree.rotateRight("dog");
        tree.rotateLeft("tar");
        System.out.println(tree);
        tree.rotateLeft("cat");
        tree.rotateRight("cat");
        tree.rotateLeft("bar");
        tree.rotateRight("dog");
        tree.rotateRight("rat");
        tree.rotateRight("paw");
        tree.rotateLeft("pal");
        tree.rotateLeft("pet");
        tree.rotateLeft("pea");
        System.out.println(tree);
        System.out.println("First smallRev test: " + tree.smallRev());
        System.out.print("First remLfs test: ");
        tree.remLfs();
        System.out.println(tree);
        tree = new BSTStrings();
        tree.insert("map");
        tree.insert("top");
        tree.insert("wry");
        tree.insert("tap");
        tree.insert("won");
        tree.insert("sit");
        tree.insert("urn");
        tree.insert("rut");
        tree.insert("sea");
        tree.insert("sot");
        tree.insert("zen");
        tree.insert("nut");
        tree.insert("mop");
        tree.insert("tux");
        tree.insert("ugh");
        tree.insert("pea");
        tree.insert("ran");
        tree.insert("run");
        System.out.println("2nd smallRev test: " + tree.smallRev());
        System.out.println();
        System.out.println("Testing delete.");
        tree.delete("ugh");
        System.out.println(tree);
        tree.delete("ugh");
        tree.delete("zen");
        System.out.println(tree);
        tree.delete("wry");
        tree.delete("won");
        System.out.println(tree);
        tree.delete("mop");
        tree.delete("nut");
        tree.delete("pea");
        System.out.println(tree);
        tree.delete("map");
        System.out.println(tree);
        tree.delete("sit");
        System.out.println(tree);
        tree.delete("sea");
        System.out.print(tree + "  ");
        System.out.println(tree.height() + " - " + tree.leafCt() + ". ");
        tree.remLfs();
        System.out.println("2nd refLfs test: " + tree);
        tree = new BSTStrings();
        tree.insert("mom");
        tree.insert("top");
        tree.insert("wry");
        tree.insert("pat");
        tree.insert("pot");
        tree.insert("tap");
        tree.insert("tap");
        tree.insert("won");
        tree.insert("sit");
        tree.insert("urn");
        tree.insert("rut");
        tree.insert("sea");
        tree.insert("sot");
        tree.insert("zen");
        tree.insert("nut");
        tree.insert("mop");
        tree.insert("tux");
        tree.insert("ugh");
        tree.insert("pea");
        tree.insert("ran");
        tree.insert("run");
        tree.insert("now");
        System.out.println("Small rev 3: " + tree.smallRev());
        System.out.println(tree);
        tree.delete("mom");
        System.out.println(tree);
        System.out.println("Small rev 4: " + tree.smallRev());
        tree.delete("won");
        System.out.println("Small rev 5: " + tree.smallRev());
        System.out.println(tree);
        tree.delete("tap");
        System.out.println("Small rev 6: " + tree.smallRev());
        System.out.println(tree);
        tree.delete("top");
        System.out.println("Small rev 7: " + tree.smallRev());
        System.out.print(tree + "  ");
        System.out.println(tree.height() + " - " + tree.leafCt() + ". ");
        tree.remLfs();
        System.out.print(tree + "  ");
        System.out.println(tree.height() + " - " + tree.leafCt() + ". ");
        tree = new BSTStrings();
        System.out.println();
        System.out.println("Testing with random big trees.");
        tree = new BSTStrings();
        ran_num = 113;
        for (i = 1; i <= 1000; i++) {
            ran_num = (ran_num * 101 + 103) % 1000003;
            tree.insert(String.valueOf(ran_num % 1000));
            ran_num = (ran_num * 101 + 103) % 1000003;
            tree.rotateRight(String.valueOf(ran_num % 1000));
            ran_num = (ran_num * 101 + 103) % 1000003;
            tree.rotateLeft(String.valueOf(ran_num % 1000));
        }
        tree.delete("0");
        tree.delete("101");
        System.out.println("a) " +tree.height() + " - " + tree.leafCt() + " - "
                + tree.closeLeaf() + " - " + tree.smallRev() + ". ");
        for (i = 1; i <= 6000; i++) {
            ran_num = (ran_num * 101 + 103) % 1000003;
            tree.delete(String.valueOf(ran_num % 1000));
        }
        System.out.print(tree + "  ");
        System.out.println(tree.height() + " - " + tree.leafCt() + " - "
                + tree.closeLeaf() + " - " + tree.smallRev() + ". ");

        tree1 = new BSTStrings(tree);
        for (i = 1; i <= 100000; i++) {
            ran_num = (ran_num * 101 + 103) % 1000003;
            tree1.insert(String.valueOf(ran_num % 10000));
            ran_num = (ran_num * 101 + 103) % 1000003;
            tree1.rotateRight(String.valueOf(ran_num % 1000));
            ran_num = (ran_num * 101 + 103) % 1000003;
            tree1.rotateLeft(String.valueOf(ran_num % 1000));
        }
        tree1.delete("464");
        tree1.delete("0");
        tree1.delete("1");
        tree1.delete("1001");
        System.out.println("c) " + tree1.height() + " - " + tree1.leafCt() + " - "
                + tree1.closeLeaf() + " - " + tree1.smallRev() + ". ");
        for (i = 1; i <= 67000; i++) {
            ran_num = (ran_num * 101 + 103) % 1000003;
            tree1.delete(String.valueOf(ran_num % 10000));
        }
        System.out.print(tree1 + "  ");
        System.out.println(tree1.height() + " - " + tree1.leafCt() + " - "
                + tree1.closeLeaf() + ". ");
        System.out.println("Author: " + BSTStrings.myName());
    }
}

/*
 * my output
 * 
Author: Ilie 'nasty' Nastase

Testing insert.
 || fred-1 || (alice-2)fred-1 || (alice-2(brad-3))fred-1
(alice-2(brad-3))fred-1(laura-2)
(alice-2(brad-3))fred-1(laura-2(pete-3))
(alice-2(brad-3))fred-1((henry-3)laura-2(pete-3))
(alice-2(brad-3))fred-1((henry-3)laura-2(pete-3))
(alice-2(brad-3))fred-1((henry-3)laura-2(pete-3))

Testing search.
fred found. laura found. henry found. brad found. 
abbot OK. carl OK. gary OK. sally OK. 

Testing height, leaf count, and close leaf.
3 - 3 - 3. 0 - 0 - 0. 1 - 1 - 1. 2 - 1 - 2. 3 - 1 - 3. 4 - 1 - 4. 4 - 2 - 2. 4 - 2 - 3. 4 - 3 - 3. 5 - 3 - 3. 

Testing copy constructor.
(bar-2(car-3))cat-1(dog-2((eat-4)fat-3((rat-5)tar-4)))
(bar-2(car-3))cat-1(dog-2((eat-4)fat-3((rat-5)tar-4)))
(bar-2(car-3))cat-1(dog-2((eat-4)fat-3(((((pal-8)paw-7)pet-6)rat-5)tar-4)))
(((alp-4)ape-3(art-4))bar-2(car-3))cat-1(dog-2((eat-4)fat-3((rat-5)tar-4)))

Testing rotates.
(bar-2(car-3))cat-1(dog-2((eat-4)fat-3(((((pal-8)paw-7)pet-6)rat-5)tar-4)))
(bar-2(car-3))cat-1(dog-2((eat-4)fat-3(((((pal-8)paw-7)pet-6)rat-5)tar-4)))
First smallRev test: rat
First remLfs test: (bar-2)cat-1(dog-2(fat-3((((paw-7)pet-6)rat-5)tar-4)))
2nd smallRev test: 

Testing delete.
map-1((((((mop-7)nut-6(pea-7(ran-8(run-9))))rut-5(sea-6))sit-4(sot-5))tap-3)top-2((((tux-6)urn-5)won-4)wry-3(zen-4)))
map-1((((((mop-7)nut-6(pea-7(ran-8(run-9))))rut-5(sea-6))sit-4(sot-5))tap-3)top-2((((tux-6)urn-5)won-4)wry-3))
map-1((((((mop-7)nut-6(pea-7(ran-8(run-9))))rut-5(sea-6))sit-4(sot-5))tap-3)top-2((tux-4)urn-3))
map-1(((((ran-6(run-7))rut-5(sea-6))sit-4(sot-5))tap-3)top-2((tux-4)urn-3))
((((ran-5(run-6))rut-4(sea-5))sit-3(sot-4))tap-2)top-1((tux-3)urn-2)
((((ran-5(run-6))rut-4)sea-3(sot-4))tap-2)top-1((tux-3)urn-2)
(((ran-4(run-5))rut-3(sot-4))tap-2)top-1((tux-3)urn-2)  5 - 3. 
2nd refLfs test: (((ran-4)rut-3)tap-2)top-1(urn-2)
Small rev 3: mom
mom-1((((mop-5(now-6))nut-4)pat-3((pea-5)pot-4((((ran-8(run-9))rut-7(sea-8))sit-6(sot-7))tap-5)))top-2((((tux-6(ugh-7))urn-5)won-4)wry-3(zen-4)))
(((mop-4(now-5))nut-3)pat-2((pea-4)pot-3((((ran-7(run-8))rut-6(sea-7))sit-5(sot-6))tap-4)))top-1((((tux-5(ugh-6))urn-4)won-3)wry-2(zen-3))
Small rev 4: now
Small rev 5: pat
(((mop-4(now-5))nut-3)pat-2((pea-4)pot-3((((ran-7(run-8))rut-6(sea-7))sit-5(sot-6))tap-4)))top-1(((tux-4(ugh-5))urn-3)wry-2(zen-3))
Small rev 6: pot
(((mop-4(now-5))nut-3)pat-2((pea-4)pot-3(((ran-6(run-7))rut-5(sea-6))sit-4(sot-5))))top-1(((tux-4(ugh-5))urn-3)wry-2(zen-3))
Small rev 7: 
(((mop-4(now-5))nut-3)pat-2((pea-4)pot-3(((ran-6(run-7))rut-5(sea-6))sit-4)))sot-1(((tux-4(ugh-5))urn-3)wry-2(zen-3))  7 - 6. 
(((mop-4)nut-3)pat-2(pot-3(((ran-6)rut-5)sit-4)))sot-1(((tux-4)urn-3)wry-2)  6 - 3. 

Testing with random big trees.
a) 26 - 193 - 5 - 104. 
((276-3)285-2(650-3(804-4)))902-1  4 - 2 - 3 - . 
c) 39 - 3269 - 6 - 1002. 
(1443-2((2900-4((5462-6)5730-5(6296-6)))7699-3))8887-1((9273-3)9289-2)  6 - 3 - 3. 
Author: Ilie 'nasty' Nastase

*/
/*
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
		bstree.delete("F");
		System.out.println(bstree);
		System.out.println(bstree.search("G"));
		bstree.insert("A");
		System.out.println(bstree);
		bstree.rotateRight("D");
		System.out.println(bstree);
		bstree.rotateLeft("A");
		System.out.println(bstree);
		bstree.insert("A");
		System.out.println(bstree);
		bstree.remLefs();
		System.out.println(bstree);
		bstree.delete("G");
		System.out.println(bstree);
		bstree.delete("D");
		System.out.println(bstree);
		bstree.delete("N");
		System.out.println(bstree);
		bstree.insert("DE");
		System.out.println(bstree);
		bstree.insert("BE");
		System.out.println(bstree);
		bstree.insert("AE");
		System.out.println(bstree);
		bstree.insert("CE");
		System.out.println(bstree);
		bstree.insert("EBB");
		System.out.println(bstree);
		bstree.insert("EA");
		System.out.println(bstree);
		bstree.insert("EC");
		System.out.println(bstree);
		System.out.println(bstree.smallRev());
	}
}
*/