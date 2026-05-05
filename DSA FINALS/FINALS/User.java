
public class User {
    private String username;
    private int passcode;
    private int score;

    
    public User(String username, int passcode) {
        this.username = username;
        this.passcode = passcode;
    }
    
    
    public User() {
    }
    


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getPasscode() {
        return passcode;
    }
    public void setPasscode(int passcode) {
        this.passcode = passcode;
    }


    public int getScore() {
        return score;
    }


    public void setScore(int score) {
        this.score = score;
    }
}