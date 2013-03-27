public class ProfTest {

   public static void main(String[] args) {
      int i;
      System.out.println("Testing constructors and addHead.");
      MyString str1 = new MyString("comp");
      MyString str3 = new MyString(str1);
      str1 = new MyString("182");
      out2ListInfo(str3, str1);
      MyString str2 = new MyString("");
      out2ListInfo(str1, str2);
      str1.addHead('2');
      str2.addHead('2');
      out2ListInfo(str1, str2);
      str1.addHead('3');
      str2.addHead('3');
      out2ListInfo(str1, str2);
      str2 = new MyString("");
      System.out.println("Testing addTail.");
      str1.addTail('4');
      str2.addTail('4');
      out2ListInfo(str1, str2);
      str1.addTail('5');
      str2.addTail('5');
      out2ListInfo(str1, str2);
      System.out.println("Testing reverse.");
      str1 = new MyString("ab");
      str1 = new MyString("smart");
      str2 = new MyString("");
      out2ListInfo(str1, str2);
      str1.reverse();
      str2.reverse();
      out2ListInfo(str1, str2);
      str1.addHead('b');
      str2.addTail('b');
      str1.reverse();
      str2.reverse();
      out2ListInfo(str1, str2);
      str1.addHead('c');
      str2.addTail('c');
      str1.reverse();
      str2.reverse();
      out2ListInfo(str1, str2);
      str1.addHead('d');
      str2.addTail('d');
      str1.reverse();
      str2.reverse();
      out2ListInfo(str1, str2);
      System.out.println("Testing removeChar.");
      str1 = new MyString("aabbacbaacbcbaaccbbadbacabaa");
      str2 = new MyString("dddaabbccbbccaaddbbaaddaaaabbb");
      str1.removeChar('d');
      str2.removeChar('d');
      out2ListInfo(str1, str2);
      str1.removeChar('e');
      str2.removeChar('e');
      out2ListInfo(str1, str2);
      str1.removeChar('a');
      str2.removeChar('a');
      out2ListInfo(str1, str2);
      str1.removeChar('c');
      str2.removeChar('c');
      out2ListInfo(str1, str2);
      str1.removeChar('b');
      str2.removeChar('b');
      out2ListInfo(str1, str2);
      str1.removeChar('b');
      str2.removeChar('b');
      out2ListInfo(str1, str2);
      System.out.println("Testing concatenate.");
      str1 = new MyString();
      str2 = new MyString();
      str1.concat(str2);
      str2.concat(str2);
      out2ListInfo(str1, str2);
      str1.concat(new MyString("a"));
      str1.concat(str2);
      str2.concat(new MyString("bb"));
      out2ListInfo(str1, str2);
      for (i = 1; i <= 3; i++) {
         str1.concat(str2);
         str2.concat(str1);
      }
      out2ListInfo(str1, str2);
      str1 = new MyString("a");
      str2 = new MyString("b");
      str3 = new MyString("c");
      for (i = 1; i <= 6; i++) {
         str1.concat(str2);
         str2.concat(str3);
         str3.concat(str1);
         str1.removeChar('a');
         str2.removeChar('b');
         str3.removeChar('c');
         str1.addTail('a');
         str2.addTail('b');
         str3.addTail('c');
      }
      System.out.println();
      System.out.println("str1: " + str1 + ", len = " + str1.length());
      System.out.println("str2: " + str2 + ", len = " + str2.length());
      System.out.println("str3: " + str3 + ", len = " + str3.length());
      // Might add a bit more soon
 }
   
   private static void out2ListInfo(MyString str1, MyString str2) {
      System.out.print("str1: " + str1 + ", len = " + str1.length());
      System.out.println("  str2: " + str2 + ", len = " + str2.length());
   }
}

/*  This is the output my program generates for this program
 
Testing constructors and addHead.
str1: comp, len = 4  str2: 182, len = 3
str1: 182, len = 3  str2: , len = 0
str1: 2182, len = 4  str2: 2, len = 1
str1: 32182, len = 5  str2: 32, len = 2
Testing addTail.
str1: 321824, len = 6  str2: 4, len = 1
str1: 3218245, len = 7  str2: 45, len = 2
Testing reverse.
str1: smart, len = 5  str2: , len = 0
str1: trams, len = 5  str2: , len = 0
str1: smartb, len = 6  str2: b, len = 1
str1: btramsc, len = 7  str2: cb, len = 2
str1: csmartbd, len = 8  str2: dbc, len = 3
Testing removeChar.
str1: aabbacbaacbcbaaccbbabacabaa, len = 27  str2: aabbccbbccaabbaaaaaabbb, len = 23
str1: aabbacbaacbcbaaccbbabacabaa, len = 27  str2: aabbccbbccaabbaaaaaabbb, len = 23
str1: bbcbcbcbccbbbcb, len = 15  str2: bbccbbccbbbbb, len = 13
str1: bbbbbbbbb, len = 9  str2: bbbbbbbbb, len = 9
str1: , len = 0  str2: , len = 0
str1: , len = 0  str2: , len = 0
Testing concatenate.
str1: , len = 0  str2: , len = 0
str1: a, len = 1  str2: bb, len = 2
str1: abbbbabbbbabbabbbbabb, len = 21  str2: bbabbabbbbabbabbbbabbbbabbabbbbabb, len = 34

str1: bcbccbcccbccccbcccccba, len = 22
str2: cacaacaaaacaaaaaaaacaaaaaaaaaaaaaaaacb, len = 38
str3: abbabbbaabbbbaaaabbbbbaaaaaaaabbbbbbaaaaaaaaaaaaaaaabc, len = 54

*/