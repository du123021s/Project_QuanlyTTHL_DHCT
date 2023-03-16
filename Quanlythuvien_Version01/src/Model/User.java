package Model;

import java.util.Date;

public class User {
    private String adminID;
    private String passWord;
    private String gmail;
    private String sex;
    private Date cardMakingDate;

    public User(String adminID, String passWord, String gmail, String sex, Date cardMakingDate) {
        this.adminID = adminID;
        this.passWord = passWord;
        this.gmail = gmail;
        this.sex = sex;
        this.cardMakingDate = cardMakingDate;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCardMakingDate() {
        return cardMakingDate;
    }

    public void setCardMakingDate(Date cardMakingDate) {
        this.cardMakingDate = cardMakingDate;
    }

    @Override
    public String toString()
    {
        return "ClassInfo [id = "+adminID+", PassWord = "+passWord + "]";
    }
}
