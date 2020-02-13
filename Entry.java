public class Entry {
    String Surname;
    String Initials;
    String Extension;

    public Entry(String Surname, String Initials, String Extension){
        this.Surname = Surname;
        this.Initials = Initials;
        this.Extension = Extension;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getInitials() {
        return Initials;
    }

    public void setInitials(String initials) {
        Initials = initials;
    }

    public String getExtension() {
        return Extension;
    }

    public void setExtension(String extension) {
        Extension = extension;
    }
}
