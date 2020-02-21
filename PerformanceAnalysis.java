import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PerformanceAnalysis{
    public static void main(String[] Args)throws IOException{
        run(false);
    }
    public static void run(Boolean r) throws IOException{
        long total = 0;
        long[] average = new long[12];
        long[] slowest = new long[12];
        long[] quickest = new long[12];
        Entry ne;
        ArrayDirectory ad = new ArrayDirectory();
        ArrayDirectory backupad ;
        ArrayListDirectory ald = new ArrayListDirectory();
        ArrayListDirectory backupald;
        HashMapDirectory hmd = new HashMapDirectory();
        HashMapDirectory backuphmd;
        FileReader fr = new FileReader("test_data.csv");
        Scanner s = new Scanner(fr).useDelimiter(",");
        while(s.hasNext()){
            String[] temp = new String[3];
            temp = s.nextLine().split(",");
            ad.insertEntry(new Entry(temp[0], temp[1], temp[2]));
            ald.insertEntry(new Entry(temp[0], temp[1], temp[2]));
            hmd.insertEntry(new Entry(temp[0], temp[1], temp[2]));
        }
        //hmd.entriesStr.remove("Rotlauf");
        //for(String k : hmd.entriesStr.keySet()){
        //    System.out.println(k);
        //}

        for(int i = 0; i <= 11; i++){
            average[i] = 0;
            slowest[i] = 0;
            quickest[i] = 2147483647;
        }
        backupad = ad;
        backupald = ald;
        backuphmd = hmd;
        StopWatch sw = new StopWatch();
        for(int i = 0; i < 1000; i++) {
            sw.start();
            ad.insertEntry(new Entry("test", "test", "11111"));
            sw.stop();
            total += sw.getElapsedTime();
            if(sw.getElapsedTime() > slowest[0]){
                slowest[0] = sw.getElapsedTime();
            }
            if(sw.getElapsedTime() < quickest[0]){
                quickest[0] = sw.getElapsedTime();
            }
            ad = backupad;
            sw.reset();
        }
        average[0] = total/1000;
        total = 0;
        for(int i = 0; i < 1000; i++) {
            sw.start();
            ad.deleteEntryUsingExtension("35024");
            sw.stop();
            total += sw.getElapsedTime();
            if(sw.getElapsedTime() > slowest[1]){
                slowest[1] = sw.getElapsedTime();
            }
            if(sw.getElapsedTime() < quickest[1]){
                quickest[1] = sw.getElapsedTime();
            }
            ad = backupad;
            sw.reset();
        }
        average[1] = total/1000;
        total = 0;
        for(int i = 0; i < 1000; i++) {
            sw.start();
            ad.deleteEntryUsingName("Rotlauf");
            sw.stop();
            total += sw.getElapsedTime();
            if(sw.getElapsedTime() > slowest[2]){
                slowest[2] = sw.getElapsedTime();
            }
            if(sw.getElapsedTime() < quickest[2]){
                quickest[2] = sw.getElapsedTime();
            }
            ad = backupad;
            sw.reset();
        }
        average[2] = total/1000;
        total = 0;
        for(int i = 0; i < 1000; i++) {
            sw.start();
            ad.lookupExtension("35024");
            sw.stop();
            total += sw.getElapsedTime();
            if(sw.getElapsedTime() > slowest[3]){
                slowest[3] = sw.getElapsedTime();
            }
            if(sw.getElapsedTime() < quickest[3]){
                quickest[3] = sw.getElapsedTime();
            }
            ad = backupad;
            sw.reset();
        }
        average[3] = total/1000;
        total = 0;
        for(int i = 0; i < 1000; i++) {
            sw.start();
            ald.insertEntry(new Entry("test", "test", "11111"));
            sw.stop();
            total += sw.getElapsedTime();
            if(sw.getElapsedTime() > slowest[4]){
                slowest[4] = sw.getElapsedTime();
            }
            if(sw.getElapsedTime() < quickest[4]){
                quickest[4] = sw.getElapsedTime();
            }
            ald = backupald;
            sw.reset();
        }
        average[4] = total/1000;
        total = 0;
        for(int i = 0; i < 1000; i++) {
            sw.start();
            ald.deleteEntryUsingExtension("35024");
            sw.stop();
            total += sw.getElapsedTime();
            if(sw.getElapsedTime() > slowest[5]){
                slowest[5] = sw.getElapsedTime();
            }
            if(sw.getElapsedTime() < quickest[5]){
                quickest[5] = sw.getElapsedTime();
            }
            ald = backupald;
            sw.reset();
        }
        average[5] = total/1000;
        total = 0;
        for(int i = 0; i < 1000; i++) {
            sw.start();
            ald.deleteEntryUsingName("Rotlauf");
            sw.stop();
            total += sw.getElapsedTime();
            if(sw.getElapsedTime() > slowest[6]){
                slowest[6] = sw.getElapsedTime();
            }
            if(sw.getElapsedTime() < quickest[6]){
                quickest[6] = sw.getElapsedTime();
            }
            ald = backupald;
            sw.reset();
        }
        average[6] = total/1000;
        total = 0;
        for(int i = 0; i < 1000; i++) {
            sw.start();
            ald.lookupExtension("35024");
            sw.stop();
            total += sw.getElapsedTime();
            if(sw.getElapsedTime() > slowest[7]){
                slowest[7] = sw.getElapsedTime();
            }
            if(sw.getElapsedTime() < quickest[7]){
                quickest[7] = sw.getElapsedTime();
            }
            total += sw.getElapsedTime();
            ald = backupald;
            sw.reset();
        }
        average[7] = total/1000;
        total = 0;
        for(int i = 0; i < 1000; i++) {
            hmd=hmdReset(hmd);
            sw.start();
            hmd.insertEntry(new Entry("test", "test", "11111"));
            sw.stop();
            total += sw.getElapsedTime();
            if(sw.getElapsedTime() > slowest[8]){
                slowest[8] = sw.getElapsedTime();
            }
            if(sw.getElapsedTime() < quickest[8]){
                quickest[8] = sw.getElapsedTime();
            }
            sw.reset();
        }
        average[8] = total/1000;
        total = 0;
        for(int i = 0; i < 1000; i++) {
            hmd = hmdReset(hmd);
            sw.start();
            hmd.deleteEntryUsingExtension("35024");
            sw.stop();
            total += sw.getElapsedTime();
            if(sw.getElapsedTime() > slowest[9]){
                slowest[9] = sw.getElapsedTime();
            }
            if(sw.getElapsedTime() < quickest[9]){
                quickest[9] = sw.getElapsedTime();
            }
            sw.reset();
        }
        average[9] = total/1000;
        total = 0;
        for(int i = 0; i < 1000; i++) {
            hmd = hmdReset(hmd);
            sw.start();
            hmd.deleteEntryUsingName("Rotlauf");
            sw.stop();
            total += sw.getElapsedTime();
            if(sw.getElapsedTime() > slowest[10]){
                slowest[10] = sw.getElapsedTime();
            }
            if(sw.getElapsedTime() < quickest[10]){
                quickest[10] = sw.getElapsedTime();
            }
            sw.reset();
        }
        average[10] = total/1000;
        total = 0;
        for(int i = 0; i < 1000; i++) {
            hmd = hmdReset(hmd);
            sw.start();
            hmd.lookupExtension("Rotlauf");
            sw.stop();
            total += sw.getElapsedTime();
            if(sw.getElapsedTime() > slowest[11]){
                slowest[11] = sw.getElapsedTime();
            }
            if(sw.getElapsedTime() < quickest[11]){
                quickest[11] = sw.getElapsedTime();
            }
            sw.reset();
        }
        average[11] = total/1000;
//        for(int i =0;i<12;i++){
//            if(i == 0){
//                System.out.println("Array");
//                System.out.println();
//                System.out.println("Insert Entry");
//            }
//            if(i == 4){
//                System.out.println("ArrayList");
//                System.out.println();
//                System.out.println("Insert Entry");
//            }
//            if(i == 8){
//                System.out.println("HashMap");
//                System.out.println();
//                System.out.println("Insert Entry");
//            }
//            if(i == 1 | i ==5 | i==9){
//                System.out.println("Extension Delete");
//            }
//            if(i == 2 | i ==6 | i==10){
//                System.out.println("Name Delete");
//            }
//            if(i == 3 | i ==7 | i==11){
//                System.out.println("Extension Update");
//            }
//            System.out.println("Slowest: " + slowest[i]);
//            System.out.println("Average: " + average[i]);
//            System.out.println("Fastest: " + quickest[i]);
//            System.out.println();
//        }
        output o = new output();
        if(r = true){
            o.performanceTxt(slowest,average,quickest);
        }
    }
    public static HashMapDirectory hmdReset(HashMapDirectory hmd) throws FileNotFoundException{
        FileReader fr = new FileReader("test_data.csv");
        Scanner s = new Scanner(fr).useDelimiter(",");
        while(s.hasNext()){
            String[] temp = new String[3];
            temp = s.nextLine().split(",");
            hmd.insertEntry(new Entry(temp[0], temp[1], temp[2]));
        }
        return hmd;
    }
}
