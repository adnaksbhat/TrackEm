package com.example.trackem;

public class Member2 {
    private String Content2;
    private String Category2;
    private String Account2;
    private String Date2;
    private String Amount2;

    public Member2() {

    }

    public Member2(String Content2, String Category2, String Account2, String Date2, String Amount2){
        this.Content2=Content2;
        this.Category2=Category2;
        this.Account2=Account2;
        this.Date2=Date2;
        this.Amount2=Amount2;
    }


    public String getContent2() {
        return Content2;
    }

    public void setContent2(String content2) {
        this.Content2=content2;
    }

    public String getCategory2() {
        return Category2;
    }

    public void setCategory2(String category2) {
        this.Category2=category2;
    }

    public String getAccount2() {
        return Account2;
    }

    public void setAccount2(String account2) {
        this.Account2 = account2;
    }

    public String getDate2() {
        return Date2;
    }

    public void setDate2(String date2) {
        this.Date2 = date2;
    }

    public String getAmount2() {
        return Amount2;
    }

    public void setAmount2(String amount2) {
        this.Amount2 = amount2;
    }

}
