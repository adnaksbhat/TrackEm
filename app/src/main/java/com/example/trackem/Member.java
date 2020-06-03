package com.example.trackem;

public class Member {
private String Name;
    private String Content;
    private String Category;
    private String Account;
    private String Date;
    private String Amount;


    public Member() {

    }



    public Member( String Name, String Content, String Category, String Account, String Date, String Amount){
this.Name=Name;
         this.Content=Content;
         this.Category=Category;
         this.Account=Account;
         this.Date=Date;
         this.Amount=Amount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    //    public String getEmail() {
//        return Email;
//    }
//
//    public void setEmail(String email) {
//        Email = email;
//    }
    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content=content;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
       this.Category=category;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        this.Account = account;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        this.Amount = amount;
    }

}
