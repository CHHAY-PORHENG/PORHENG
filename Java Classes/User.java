/*
 * NAME: CHHAY PORHENG
 * CLASS: A
 * YEAR: 2 TERM: 3
 * ID: 6022010042
 * LECTURE: LAY VATHNA
 * PROJECT: ONLINE BUS TICKET BOOKING SYSTEM
 */

/* IMPORTANT CLASS */

// USER CLASS
public class User {
    private int userId;
    private String name;
    private String email;
    private String password;

    // CONSTRUCTOR
    public User(int userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // GETTERS AND SETTERS
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
