import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayDirectory implements Directory {

    Entry[] entries = new Entry[0];
    private int free = 0;

    public static void main(String[] args) throws FileNotFoundException {
        ArrayDirectory ad = new ArrayDirectory();
        FileReader fr = new FileReader("test_data.csv");
        Scanner s = new Scanner(fr).useDelimiter(",");
        while(s.hasNext()){
            ad.insertEntry(new Entry(s.next(), s.next(), s.nextLine()));
        }
        s.close();
        //System.out.println(ad.lookupExtension("Prott"));
        //ad.deleteEntryUsingName("Amner");
        //ad.deleteEntryUsingExtension("49521");
        //ad.updateExtensionUsingName("Relph", "00000");
        //for(int k = 0; k < ad.entries.length ; k++){
        //   System.out.println(ad.entries[k].getSurname() + ad.entries[k].getInitials() + ad.entries[k].getExtension());
        //}
    }
    /**
     * Insert a new entry into the directory.
     *
     * @param entry the new entry to add
     */
    public void insertEntry(Entry entry) {
        if (free == entries.length) {
            entries = Arrays.copyOf(entries, entries.length + 1);
        }
        entries[free] = entry;
        free++;
    }

    /**
     * Remove an entry from the directory using their surname.
     *
     * @param surname the surname of the entry to remove
     */
    public void deleteEntryUsingName(String surname){
        int i = 0;
        boolean found = false;
        while(!found && i < entries.length){
            if(entries[i].getSurname().contains(surname)) {
                found = true;
                for(int j = i; j < entries.length - 1; j++){
                    entries[j] = entries[j+1];
                }
                entries = Arrays.copyOf(entries, entries.length - 1) ;
                free--;
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
        while(!found && i < entries.length){
            if(entries[i].getExtension().contains(number)) {
                found = true;
                for(int j = i; j < entries.length - 1; j++){
                    entries[j] = entries[j+1];
                }
                entries = Arrays.copyOf(entries, entries.length - 1) ;
                free--;
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
        while(!found && i < entries.length){
            if(entries[i].getSurname().equals(surname)) {
                found = true;
                entries[i].setExtension(newNumber);
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
        while(i < entries.length){
            if(entries[i].getSurname().contains(surname)) {
                return entries[i].getExtension();
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
    public List<Entry> toArrayList(){
        return Arrays.asList(entries);
    }
}