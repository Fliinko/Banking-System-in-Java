import java.util.*;
import java.io.*;

class Card{

    protected int CARD_NUMBER;
    protected int CVV, ACC_NO;
    protected Calendar EXPIRATION_DATE;
    protected String USER_NAME, USER_SURNAME;

    public Card(){}
    
    public Card(int CARD_NUMBER, Calendar EXPIRATION_DATE, int CVV, String USER_NAME, String USER_SURNAME, int ACC_NO){
        this.CARD_NUMBER = CARD_NUMBER;
        this.EXPIRATION_DATE = EXPIRATION_DATE;
        this.CVV = CVV;
        this.USER_NAME = USER_NAME;
        this.USER_SURNAME = USER_SURNAME;
    }

    // ----- Getters -----
    public int getCardNo(){
        return CARD_NUMBER;
    }

    public Calendar getExpDate(){
        return EXPIRATION_DATE;
    }

    public int getCVV(){
        return CVV;
    }

    public String getName(){
        return USER_NAME;
    }

    public String getSurname(){
        return USER_SURNAME;
    }

    public int getAccNo(){
        return ACC_NO;
    }

    // ----- Setters -----
    public void setCardNo(int CARD_NUMBER){
        this.CARD_NUMBER = CARD_NUMBER;
    }

    public void setExpDate(Calendar EXPIRATION_DATE){
        this.EXPIRATION_DATE = EXPIRATION_DATE;
    }

    public void setCVV(int CVV){
        this.CVV = CVV;
    }

    public void setName(String USER_NAME){
        this.USER_NAME = USER_NAME;
    }

    public void setSurname(String USER_SURNAME){
        this.USER_SURNAME = USER_SURNAME;
    }
}