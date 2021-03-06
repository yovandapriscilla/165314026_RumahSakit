package pojos;
// Generated Nov 1, 2018 6:26:57 PM by Hibernate Tools 4.3.1

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable, Comparable<User> {

    private String email;
    private String password;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int compareTo(User user) {
//        if (this.email.equals(user.email)) {
//            return 0;
//        } else {
//            this.email.compareTo(user.email);
//        }
        return this.email.compareTo(user.email);
    }

}
