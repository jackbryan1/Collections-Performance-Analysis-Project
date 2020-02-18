public class Entry {
    private String Surname;
    private String Initials;
    private String Extension;

    public Entry(String Surname, String Initials, String Extension){
        this.Surname = Surname;
        this.Initials = Initials;
        this.Extension = Extension;
    }

    public String getSurname() {
        return this.Surname;
    }

    public void setSurname(String surname) {
        this.Surname = surname;
    }

    public String getInitials() {
        return this.Initials;
    }

    public void setInitials(String initials) {
        this.Initials = initials;
    }

    public String getExtension() {
        return this.Extension;
    }

    public void setExtension(String extension) {
        this.Extension = extension;
    }
}
