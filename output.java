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
        performanceTxt();
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
    public static void performanceTxt() throws IOException{
        FileWriter fw = new FileWriter("Performance.txt");
        for(int i =0;i<12;i++){
            if(i == 0){
                fw.write("Array");
                fw.write("");
                fw.write("Insert Entry");
            }
            if(i == 4){
                fw.write("ArrayList");
                fw.write("");
                fw.write("Insert Entry");
            }
            if(i == 8){
                fw.write("HashMap");
                fw.write("");
                fw.write("Insert Entry");
            }
            if(i == 1 | i ==5 | i==9){
                fw.write("Extension Delete");
            }
            if(i == 2 | i ==6 | i==10){
                fw.write("Name Delete");
            }
            if(i == 3 | i ==7 | i==11){
                fw.write("Extension Update");
            }
            //fw.write("Slowest: " + slowest[i]);
            //fw.write("Average: " + average[i]);
            //fw.write("Fastest: " + quickest[i]);
            //fw.write(");
        }
        fw.close();
    }
}
