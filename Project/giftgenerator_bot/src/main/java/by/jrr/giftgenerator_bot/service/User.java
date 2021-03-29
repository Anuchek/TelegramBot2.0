package by.jrr.giftgenerator_bot.service;

public class User {
    private String gender;
    private String relationship;

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getGender() {
        return gender;
    }
}
