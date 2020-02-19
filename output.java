import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class output {
    public static void main(String args[]) throws FileNotFoundException {
        System.out.format("+-------------+--------------+---------------+" + System.lineSeparator());
        System.out.format("|   Surname   |   Initials   |   Extension   |" + System.lineSeparator());
        System.out.format("+-------------+--------------+---------------+" + System.lineSeparator());
        FileReader fr = new FileReader("test_data.csv");
        Scanner s = new Scanner(fr).useDelimiter(",");
        while(s.hasNext()){
            System.out.format("%1s%13s%1s%14s%1s%15s%1s%n", "|", s.next(), "|", s.next(), "|", s.nextLine(), "|");
        }
        System.out.format("+-------------+--------------+---------------+");
    }
}
