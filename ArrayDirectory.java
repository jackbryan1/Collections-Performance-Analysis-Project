import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

abstract class ArrayDirectory implements Directory {
    Entry[] entries = new Entry[0];
    int free = 0;

    public void main(String args[]) throws FileNotFoundException {
        FileReader fr = new FileReader("test_data.csv");
        Scanner s = new Scanner(fr).useDelimiter(",");
        while(s.hasNext()){

        }
    }
    /**
     * Insert a new entry into the directory.
     *
     * @param entry the new entry to add
     */
    public void insertEntry(Entry entry) {
        if (free > entries.length) {
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
            if(entries[i].getSurname() == surname) {
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
            if(entries[i].getExtension() == number) {
                found = true;
                Entry[] temp = new Entry[entries.length - 1];
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
            if(entries[i].getSurname() == surname) {
                found = true;
                entries[i].Extension = newNumber;
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
            if(entries[i].getSurname() == surname) {
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
