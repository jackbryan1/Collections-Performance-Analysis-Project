import java.io.*;
import java.util.Scanner;

public class output {
    public static void main(String args[]) throws FileNotFoundException, IOException{
        System.out.format("+-------------+--------------+---------------+" + System.lineSeparator());
        System.out.format("|   Surname   |   Initials   |   Extension   |" + System.lineSeparator());
        System.out.format("+-------------+--------------+---------------+" + System.lineSeparator());
        FileReader fr = new FileReader("test_data.csv");
        Scanner s = new Scanner(fr).useDelimiter(",");
        while(s.hasNext()){
            System.out.format("%1s%13s%1s%14s%1s%15s%1s%n", "|", s.next(), "|", s.next(), "|", s.nextLine(), "|");
        }
        System.out.format("+-------------+--------------+---------------+");
        makeCsv();
    }
    public static void makeCsv() throws IOException {
        ArrayDirectory ad = new ArrayDirectory();
        FileReader fr = new FileReader("test_data.csv");
        Scanner s = new Scanner(fr).useDelimiter(",");
        while(s.hasNext()){
            ad.insertEntry(new Entry(s.next(), s.next(), s.nextLine()));
        }
        FileWriter fw = new FileWriter("test.csv");
        for(int i = 0; i < ad.entries.length; i++) {
            fw.write(ad.entries[i].getSurname()+","+ad.entries[i].getInitials()+ad.entries[i].getExtension() + System.lineSeparator());
        }
        fw.close();
    }
}
