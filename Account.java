import java.util.*;
import java.io.*;

class Account implements Serializable{

    private String currency;
    private float balance;
    private int CARD_COUNTER, ACCOUNT_NUMBER, USER_NO;

    Scanner sc = new Scanner(System.in);
    
    public Account(){}

    public Account(String currency, float balance, int USER_NO, int ACCOUNT_NUMBER, int CARD_COUNTER){
        this.currency = currency;
        this.balance = balance;
        this.USER_NO = USER_NO;
        this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
        this.CARD_COUNTER = CARD_COUNTER;
    }

    //For Joint Account
    public Account(String curreny, float balance, int USER_NO, int USER_NO2, int ACCOUNT_NUMBER, int CARD_COUNTER){
        this.currency = currency;
        this.balance = balance;
        this.USER_NO = USER_NO;
        this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
        this.CARD_COUNTER = CARD_COUNTER;
    }

    // ----- Getters -----

    public String getCurrency(){
        return currency;
    }

    public float getBalance(){
        return balance;
    }

    public int getUserNo(){
        return USER_NO;
    }

    public int getAccNo(){
        return ACCOUNT_NUMBER;
    }

    public int getCardCt(){
        return CARD_COUNTER;
    }

    // ----- Setters -----

    public void setCurrency(String currency){
        this.currency = currency;
    }

    public void setBalance(float balance){
        this.balance = balance;
    }

    public void setUserNo(int USER_NO){
        this.USER_NO = USER_NO;
    }

    public void setAccNo(int ACCOUNT_NUMBER){
        this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
    }

    public void setCardCt(int CARD_COUNTER){
        this.CARD_COUNTER = CARD_COUNTER;
    }

    // -----------------------------------

}