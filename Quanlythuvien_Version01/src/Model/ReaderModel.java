package Model;

import java.util.Date;

public class ReaderModel {
    private String readerid;
    private String empid;
    private String readername;
    private Date birth;
    private String gender;
    private String address;
    private int phone;
    private Date registrationdate;
    private Date deadlinedate;
    private String barcode;
    private String image;

    // contructor


    public ReaderModel() {

    }

    public ReaderModel(String readerid, String empid, String readername, Date birth, String gender,
                       String address, int phone, Date registrationdate, Date deadlinedate, String barcode,
                       String image) {
        this.readerid = readerid;
        this.empid = empid;
        this.readername = readername;
        this.birth = birth;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.registrationdate = registrationdate;
        this.deadlinedate = deadlinedate;
        this.barcode = barcode;
        this.image= image;

    }


    //getter


    public String getReaderid() {
        return readerid;
    }

    public String getEmpid() {
        return empid;
    }

    public String getReadername() {
        return readername;
    }

    public Date getBirth() {
        return birth;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public Date getDeadlinedate() {
        return deadlinedate;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getImage() {
        return image;
    }



    // settter

    public void setReaderid(String readerid) {
        this.readerid = readerid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public void setReadername(String readername) {
        this.readername = readername;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
    }

    public void setDeadlinedate(Date deadlinedate) {
        this.deadlinedate = deadlinedate;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
