import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class input {
    public static void main(String[] args) throws FileNotFoundException {
        String[] arguments = {};
        Scanner s = new Scanner(System.in);
        System.out.println("Enter file name");
        String fn = s.nextLine();
        System.out.println("Choose a directory type (Array, ArrayList, Hashmap)");
        String dt = s.nextLine();
        System.out.println("Enter the new entry");
        String temp = s.nextLine();
        s.close();
        if (dt.toLowerCase().equals("array")) {
            Array(fn ,temp);
        }
        if (dt.toLowerCase().equals("arraylist")) {
            ArrayList(fn, temp);
        }
        if (dt.toLowerCase().equals("hashmap")) {
            Hashmap(fn, temp);
        }
    }

    public static void Array(String fn, String temp) throws FileNotFoundException {
        ArrayDirectory ad = new ArrayDirectory();
        FileReader fr = new FileReader(fn);
        Scanner s = new Scanner(fr).useDelimiter(",");
        while(s.hasNext()){
            ad.insertEntry(new Entry(s.next(), s.next(), s.nextLine()));
        }
        Scanner s2 = new Scanner(temp).useDelimiter(",");
        if (temp.matches("\\w+,\\w+,\\w+")) {
            ad.insertEntry(new Entry(s2.next(), s2.next(), s2.next()));
        }
    }

    public static void ArrayList(String fn, String temp) throws FileNotFoundException {
        ArrayListDirectory ald = new ArrayListDirectory();
        FileReader fr = new FileReader(fn);
        Scanner s = new Scanner(fr).useDelimiter(",");
        while(s.hasNext()){
            ald.insertEntry(new Entry(s.next(), s.next(), s.nextLine()));
        }
        Scanner s2 = new Scanner(temp).useDelimiter(",");
        if (temp.matches("\\w+,\\w+,\\w+")) {
            ald.insertEntry(new Entry(s2.next(), s2.next(), s2.next()));
        }
    }

    public static void Hashmap(String fn, String temp) throws FileNotFoundException {
        HashMapDirectory hmd = new HashMapDirectory();
        FileReader fr = new FileReader(fn);
        Scanner s = new Scanner(fr).useDelimiter(",");
        while(s.hasNext()){
            hmd.insertEntry(new Entry(s.next(), s.next(), s.nextLine()));
        }
        Scanner s2 = new Scanner(temp).useDelimiter(",");
        if (temp.matches("\\w+,\\w+,\\w+")) {
            hmd.insertEntry(new Entry(s2.next(), s2.next(), s2.next()));
        }
    }

}
