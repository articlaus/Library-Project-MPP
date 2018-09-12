package dataaccess;

public class Author extends Person {

    private String credentials;
    private String shortBio;

    public Author() {

    }

    public Author(String credentials, String shortBio) {
        this.credentials = credentials;
        this.shortBio = shortBio;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
