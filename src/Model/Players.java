package Model;

public class Players {

    private int playerID;
    private int schoolID;
    private String firstName;
    private String lastName;

    public Players(int playerID, int schoolID, String firstName, String lastName) {
        this.playerID = playerID;
        this.schoolID = schoolID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
