package Model;

public class Schools {

 private int schoolID;
 private String name;
 private String county;

    public Schools(int schoolID, String name, String county) {
        this.schoolID = schoolID;
        this.name = name;
        this.county = county;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
