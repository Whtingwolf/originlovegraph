package entiy;

public class User {
    private String username;
    private String password;
    private String numberphone;
    public User ( ) {
    }

    public String getUsername ( ) {
        return username;
    }

    public String getPassword ( ) {
        return password;
    }

    public String getNumberphone ( ) {
        return numberphone;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public void setNumberphone (String numberphone) {
        this.numberphone = numberphone;
    }
}
