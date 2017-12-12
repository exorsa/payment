package com.example.pike.payment001.model;

import java.io.Serializable;

public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    private int seq;
    private String name;
    private String email;
    private String menu;    //메뉴이름
    private int  price; // 가격
    private int  piece; // 주문 갯수
    private String address;
    private String phoneNum;
    private String memo; // 배송시 요청사항
    private int total;  // 총 가격(price x piece = total)
    private int cn1,cn2,cn3,cn4;
    private int cy,cm;
    private int pn1,pn2;
    private int cvc;
    private int pw;

    public Payment(int seq, String  name, String menu, int price, int piece, String address,
                   String phoneNum, String memo,  int total, int cn1, int cn2, int cn3, int cn4,
                   int cy, int cm, int pn1, int pn2, int cvc, int pw){
        this.seq = seq;
        this.name = name;
        this.menu = menu;
        this.price = price;
        this.piece = piece;
        this.address = address;
        this.phoneNum = phoneNum;
        this.memo = memo;
        this.total=total;
        this.cn1 = cn1;
        this.cn2 = cn2;
        this.cn3 = cn3;
        this.cn4  = cn4;
        this.cy = cy;
        this.cm = cm;
        this.pn1 = pn1;
        this.pn2 = pn2;
        this.cvc = cvc;
        this.pw = pw;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getUser_name() {
        return name;
    }

    public void setUser_name(String user_name) {
        this.name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getRequest() {
        return memo;
    }

    public void setRequest(String request) {
        this.memo = request;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCn1() {
        return cn1;
    }

    public void setCn1(int cn1) {
        this.cn1 = cn1;
    }

    public int getCn2() {
        return cn2;
    }

    public void setCn2(int cn2) {
        this.cn2 = cn2;
    }

    public int getCn3() {
        return cn3;
    }

    public void setCn3(int cn3) {
        this.cn3 = cn3;
    }

    public int getCn4() {
        return cn4;
    }

    public void setCn4(int cn4) {
        this.cn4 = cn4;
    }

    public int getCy() {
        return cy;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public int getCm() {
        return cm;
    }

    public void setCm(int cm) {
        this.cm = cm;
    }

    public int getPn1() {
        return pn1;
    }

    public void setPn1(int pn1) {
        this.pn1 = pn1;
    }

    public int getPn2() {
        return pn2;
    }

    public void setPn2(int pn2) {
        this.pn2 = pn2;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public int getPw() {
        return pw;
    }

    public void setPw(int pw) {
        this.pw = pw;
    }
}
