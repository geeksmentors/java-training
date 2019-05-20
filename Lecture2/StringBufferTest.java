import java.io.*;
class StringBufferTest {
    public static void main(String[] args)
    {
        StringBuffer s = new StringBuffer("GeeksforGeeks");
        int p = s.length();
        int q = s.capacity();
        System.out.println("Length of string GeeksforGeeks=" + p);
        System.out.println("Capacity of string GeeksforGeeks=" + q);


        StringBuffer s2 = new StringBuffer("Geeksfor");
        s2.append("Geeks");
        System.out.println(s2); // returns GeeksforGeeks
        s2.append(1);
        System.out.println(s2); // returns GeeksforGeeks1
    }
}
