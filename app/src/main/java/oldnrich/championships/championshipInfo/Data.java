package oldnrich.championships.championshipInfo;

import java.io.Serializable;

public class Data implements Serializable {
    private String manager;
    private String name;
    private String type;
    private String locationX;
    private String locationY;
    private String st_contest;
    private String end_contest;
    private int participants;
    private String explaination;
    //private int resId;
    //private static final long serialVersionUID = 1L;


    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public String getSt_contest() {
        return st_contest;
    }

    public void setSt_contest(String st_contest) {
        this.st_contest = st_contest;
    }

    public String getEnd_contest() {
        return end_contest;
    }

    public void setEnd_contest(String end_contest) {
        this.end_contest = end_contest;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public String getExplaination() {
        return explaination;
    }

    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }
}

