package Model;

import java.util.Date;

public class Sach {
    private String bookID;
    private String typeID;
    private String bookSheltID;
    private String bookName;
    private String auThor;
    private Date pubYear;
    private  int numbetOf;
    private float price;
    private String status;

    // contructor


    public Sach(String bookID, String typeID, String bookSheltID, String bookName, String auThor, Date pubYear, int numbetOf, float price, String status) {
        this.bookID = bookID;
        this.typeID = typeID;
        this.bookSheltID = bookSheltID;
        this.bookName = bookName;
        this.auThor = auThor;
        this.pubYear = pubYear;
        this.numbetOf = numbetOf;
        this.price = price;
        this.status = status;
    }


    // get and set

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getBookSheltID() {
        return bookSheltID;
    }

    public void setBookSheltID(String bookSheltID) {
        this.bookSheltID = bookSheltID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuThor() {
        return auThor;
    }

    public void setAuThor(String auThor) {
        this.auThor = auThor;
    }

    public Date getPubYear() {
        return pubYear;
    }

    public void setPubYear(Date pubYear) {
        this.pubYear = pubYear;
    }

    public int getNumbetOf() {
        return numbetOf;
    }

    public void setNumbetOf(int numbetOf) {
        this.numbetOf = numbetOf;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
