import java.io.*;
import java.util.Scanner;

public class output {
    public static void main(String args[]) throws FileNotFoundException, IOException{
        Scanner s = new Scanner(System.in);
        System.out.println("What do you want to do? (1: Table, 2: CSV, 3:Performance");
        String op = s.nextLine();
        s.close();
        if (op=="1"){
            System.out.format("+-------------+--------------+---------------+" + System.lineSeparator());
            System.out.format("|   Surname   |   Initials   |   Extension   |" + System.lineSeparator());
            System.out.format("+-------------+--------------+---------------+" + System.lineSeparator());
            FileReader fr = new FileReader("test_data.csv");
            Scanner s2 = new Scanner(fr).useDelimiter(",");
            while(s2.hasNext()){
                System.out.format("%1s%13s%1s%14s%1s%15s%1s%n", "|", s2.next(), "|", s2.next(), "|", s2.nextLine(), "|");
            }
            System.out.format("+-------------+--------------+---------------+");
        }
        if (op=="2") {
            makeCsv();
        }
        if (op=="3") {
            PerformanceAnalysis.run(true);
        }
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
    public static void performanceTxt(long[] slowest,long[] average,long[] quickest) throws IOException{
        Scanner s = new Scanner(System.in);
        System.out.println("Enter file name");
        String fn = s.nextLine();
        s.close();
        FileWriter fw = new FileWriter(fn);
        String[][] temp;
        for(int i =0;i<12;i++){
            if(i == 0){
                fw.write("Array" + System.lineSeparator());
                fw.write("------------" + System.lineSeparator());
                fw.write("Insert Entry" + System.lineSeparator());
            }
            if(i == 4){
                fw.write("ArrayList" + System.lineSeparator());
                fw.write("------------" + System.lineSeparator());
                fw.write("Insert Entry" + System.lineSeparator());
            }
            if(i == 8){
                fw.write("HashMap" + System.lineSeparator());
                fw.write("------------" + System.lineSeparator());
                fw.write("Insert Entry" + System.lineSeparator());
            }
            if(i == 1 | i ==5 | i==9){
                fw.write("Extension Delete" + System.lineSeparator());
            }
            if(i == 2 | i ==6 | i==10){
                fw.write("Name Delete" + System.lineSeparator());
            }
            if(i == 3 | i ==7 | i==11){
                fw.write("Extension Update" + System.lineSeparator());
            }
            fw.write("Slowest: " + slowest[i] + System.lineSeparator());
            fw.write("Average: " + average[i] + System.lineSeparator());
            fw.write("Fastest: " + quickest[i] + System.lineSeparator());
            fw.write(System.lineSeparator());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }
}
