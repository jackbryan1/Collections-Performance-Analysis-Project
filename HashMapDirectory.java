import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class HashMapDirectory implements Directory{

    HashMap<String, Entry> entriesNum = new HashMap<>();
    HashMap<String, Entry> entriesStr = new HashMap<>();

    public static void main(String args[]) throws FileNotFoundException {
        HashMapDirectory hmd = new HashMapDirectory();
        FileReader fr = new FileReader("test_data.csv");
        Scanner s = new Scanner(fr).useDelimiter(",");
        while(s.hasNext()){
            String[] temp = new String[3];
            temp = s.nextLine().split(",");
            hmd.insertEntry(new Entry(temp[0], temp[1], temp[2]));
        }
        s.close();
        //System.out.println(hmd.lookupExtension("Prott"));
        //hmd.deleteEntryUsingName("Rotlauf");
        //hmd.deleteEntryUsingExtension("49521");
        //hmd.updateExtensionUsingName("Relph", "00000");
        //for(String k : hmd.entriesNum.keySet()){
        //    System.out.println(hmd.entriesNum.get(k).getSurname() + hmd.entriesNum.get(k).getInitials() + hmd.entriesNum.get(k).getExtension());
        //}
    }
    /**
     * Insert a new entry into the directory.
     *
     * @param entry the new entry to add
     */
    public void insertEntry(Entry entry) {
        entriesNum.put(entry.getExtension(), entry);
        entriesStr.put(entry.getSurname(), entry);
    }

    /**
     * Remove an entry from the directory using their surname.
     *
     * @param surname the surname of the entry to remove
     */
    public void deleteEntryUsingName(String surname){
        entriesNum.remove(entriesStr.get(surname).getExtension());
        entriesStr.remove(surname);
    }

    /**
     * Remove an entry from the directory using their extension number.
     *
     * @param number the extension number of the entry to remove
     */
    public void deleteEntryUsingExtension(String number){
        entriesStr.remove(entriesNum.get(number).getSurname());
        entriesNum.remove(number);
    }

    /**
     * Update an entry's extension number using their surname.
     *
     * @param surname   surname of the entry to be updated
     * @param newNumber the new number
     */
    public void updateExtensionUsingName(String surname, String newNumber){
        entriesNum.get(entriesStr.get(surname).getExtension()).setExtension(newNumber);
        entriesStr.get(surname).setExtension(newNumber);
    }

    /**
     * Get the extension number of an entry using their surname.
     *
     * @param surname the surname of the entry
     * @return the extension number of the entry
     */
    public String lookupExtension(String surname){
        return entriesStr.get(surname).getExtension();
    }

    /**
     * Return an array list of all entries in the directory.
     *
     * @return an array list of all entries
     */
    public List<Entry> toArrayList() {
        Collection<Entry> c = entriesNum.values();
        ArrayList<Entry> arrayList = new ArrayList<>(c);
        return arrayList;
    }
}
