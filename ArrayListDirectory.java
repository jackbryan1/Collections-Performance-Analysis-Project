import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListDirectory implements Directory{

    private ArrayList<Entry> entries = new ArrayList<>();

    public static void main(String args[]) throws FileNotFoundException {
        ArrayListDirectory ald = new ArrayListDirectory();
        FileReader fr = new FileReader("test_data.csv");
        Scanner s = new Scanner(fr).useDelimiter(",");
        while(s.hasNext()){
            ald.insertEntry(new Entry(s.next(), s.next(), s.nextLine()));
        }
        s.close();
        //System.out.println(ald.lookupExtension("Prott"));
        //ald.deleteEntryUsingName("Amner");
        //ald.deleteEntryUsingExtension("49521");
        //ald.updateExtensionUsingName("Relph", "00000");
        //for(int k = 0; k < ald.entries.size() ; k++){
        //   System.out.println(ald.entries.get(k).getSurname() + ald.entries.get(k).getInitials() + ald.entries.get(k).getExtension());
        //}
    }
    /**
     * Insert a new entry into the directory.
     *
     * @param entry the new entry to add
     */
    public void insertEntry(Entry entry) {
        entries.add(entry);
    }

    /**
     * Remove an entry from the directory using their surname.
     *
     * @param surname the surname of the entry to remove
     */
    public void deleteEntryUsingName(String surname){
        int i = 0;
        boolean found = false;
        while(!found && i < entries.size()){
            if(entries.get(i).getSurname().contains(surname)) {
                found = true;
                entries.remove(entries.get(i));
            }
            i++;
        }
    }

    /**
     * Remove an entry from the directory using their extension number.
     *
     * @param number the extension number of the entry to remove
     */
    public void deleteEntryUsingExtension(String number){
        int i = 0;
        boolean found = false;
        while(!found && i < entries.size()){
            if(entries.get(i).getExtension().contains(number)) {
                found = true;
                entries.remove(entries.get(i));
            }
            i++;
        }
    }

    /**
     * Update an entry's extension number using their surname.
     *
     * @param surname   surname of the entry to be updated
     * @param newNumber the new number
     */
    public void updateExtensionUsingName(String surname, String newNumber){
        int i = 0;
        boolean found = false;
        while(!found && i < entries.size()){
            if(entries.get(i).getSurname().equals(surname)) {
                found = true;
                entries.get(i).setExtension(newNumber);
            }
            i++;
        }
    }

    /**
     * Get the extension number of an entry using their surname.
     *
     * @param surname the surname of the entry
     * @return the extension number of the entry
     */
    public String lookupExtension(String surname){
        int i = 0;
        while(i < entries.size()){
            if(entries.get(i).getSurname().contains(surname)) {
                return entries.get(i).getExtension();
            }
            i++;
        }
        return "Couldn't find extension";
    }

    /**
     * Return an array list of all entries in the directory.
     *
     * @return an array list of all entries
     */
    public List<Entry> toArrayList() {
        return entries;
    }
}
