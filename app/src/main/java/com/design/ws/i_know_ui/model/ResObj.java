package com.design.ws.i_know_ui.model;

public class ResObj {
    private String message;
    private String MobileNumber;
    public String getMobileNumber(){return  MobileNumber; }
//    {"error":false,"memberID":3,"FirstName":"kiran","LastName":"ingle","MobileNumber":"86597542","email":"k@gmail.com"}
    public Boolean error;

    public Boolean getError() {
        return error;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getemail() {
        return email;
    }

    public Integer memberID;

    public String FirstName;

    public String LastName;

    public String email;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
