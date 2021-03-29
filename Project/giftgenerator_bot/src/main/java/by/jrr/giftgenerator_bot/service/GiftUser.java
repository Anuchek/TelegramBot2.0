package by.jrr.giftgenerator_bot.service;

public class GiftUser {
    private char gender;
    private String relationship;

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }

    public char getGender() {
        return gender;
    }
}
