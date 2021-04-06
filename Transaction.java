import java.util.*;
import java.io.*;
import java.time.*;

class Transaction implements Serializable{

    private int ACC_NO_SENDER, ACC_NO_RECEIVER;
    private String type;
    private Calendar [] TRANSACTION_DATE = new Calendar[2];
    private float money;
    private int TRANSACTION_ID;

    ArrayList<Account> accountList = new ArrayList<Account>();

    Transaction(){}

    Transaction(int TRANSACTION_ID, int ACC_NO_SENDER, int ACC_NO_RECEIVER, String type, float money, Calendar [] TRANSACTION_DATE){
        this.TRANSACTION_ID = TRANSACTION_ID;
        this.ACC_NO_SENDER = ACC_NO_SENDER;
        this.ACC_NO_RECEIVER = ACC_NO_RECEIVER;
        this.type = type;
        this.money = money;
        this.TRANSACTION_DATE = TRANSACTION_DATE;
    }

    // ---- Getters ----
    public int getID(){
        return TRANSACTION_ID;
    }

    public int getSender(){
        return ACC_NO_SENDER;
    }

    public int getReceiver(){
        return ACC_NO_RECEIVER;
    }

    public String getType(){
        return type;
    }

    public float getMoney(){
        return money;
    }

    public Calendar getDate(){
        for(int i = 0; i < TRANSACTION_DATE.length(); i++){
            return TRANSACTION_DATE[i];
        }
    }

    // ---- Setters ----
    public void setID(int TRANSACTION_ID){
        this.TRANSACTION_ID = TRANSACTION_ID;
    }

    public void setSender(int ACC_NO_SENDER){
        this.ACC_NO_SENDER = ACC_NO_SENDER;
    }

    public void setReceiver(int ACC_NO_RECEIVER){
        this.ACC_NO_RECEIVER = ACC_NO_RECEIVER;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setMoney(float money){
        this.money = money;
    }

    public void setDate(Calendar [] TRANSACTION_DATE){
        this.TRANSACTION_DATE = TRANSACTION_DATE;
    }

    //-----------------------------------------------
}



