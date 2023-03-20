package Model;

import java.util.Date;

public class ReaderModel {
    private String ReaderID;
    private String ReaderName;
    private  char ReaderGender;
    private Date DateOfBirth;
    private String ReaderAddress;
    private int ReaderPhone;
    private Date ReadRegistrationDate;
    private Date  ReadExpirationDate;
    private String Barcode;


    // contructor


    public ReaderModel(String readerID, String readerName, char readerGender, Date dateOfBirth,
                       String readerAddress, int readerPhone, Date readRegistrationDate,
                       Date readExpirationDate, String barcode) {
        ReaderID = readerID;
        ReaderName = readerName;
        ReaderGender = readerGender;
        DateOfBirth = dateOfBirth;
        ReaderAddress = readerAddress;
        ReaderPhone = readerPhone;
        ReadRegistrationDate = readRegistrationDate;
        ReadExpirationDate = readExpirationDate;
        Barcode = barcode;
    }


    // getter and setter

    public String getReaderID() {
        return ReaderID;
    }

    public void setReaderID(String readerID) {
        ReaderID = readerID;
    }

    public String getReaderName() {
        return ReaderName;
    }

    public void setReaderName(String readerName) {
        ReaderName = readerName;
    }

    public char getReaderGender() {
        return ReaderGender;
    }

    public void setReaderGender(char readerGender) {
        ReaderGender = readerGender;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getReaderAddress() {
        return ReaderAddress;
    }

    public void setReaderAddress(String readerAddress) {
        ReaderAddress = readerAddress;
    }

    public int getReaderPhone() {
        return ReaderPhone;
    }

    public void setReaderPhone(int readerPhone) {
        ReaderPhone = readerPhone;
    }

    public Date getReadRegistrationDate() {
        return ReadRegistrationDate;
    }

    public void setReadRegistrationDate(Date readRegistrationDate) {
        ReadRegistrationDate = readRegistrationDate;
    }

    public Date getReadExpirationDate() {
        return ReadExpirationDate;
    }

    public void setReadExpirationDate(Date readExpirationDate) {
        ReadExpirationDate = readExpirationDate;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }
}
