import java.util.*;
import java.io.*;

class Administrator extends Person implements Serializable{

    protected String name, surname, ID, password;
    protected int STAFF_NO, TEL_NO, pin;

    public Administrator(String n, String s, int age, String id, String p, int SN, int TN, int pin){
        super(n,s,id,TN, age);
        password = p;
        STAFF_NO = SN;
        this.pin = pin;

    }

    // ----- Getters -----

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getID(){
        return ID;
    }

    public String getPassword(){
        return password;
    }

    public int getSTAFF_NO(){
        return STAFF_NO;
    }

    public int getTEL_NO(){
        return TEL_NO;
    }

    public int getPin(){
        return pin;
    }

    public String toString(){
        return super.name + " " + super.surname + " " + super.id + " " + password + " " + STAFF_NO + " " + super.TEL_NO + " ";
    }

    // ----- For Login System -----

    public boolean equalsStaffNumber(Object obj){
        return getSTAFF_NO()==(((Administrator)obj).getSTAFF_NO());
    }

    public boolean equalsPassword(Object obj){
        return getPassword()==(((Administrator)obj).getPassword());
    }

    public boolean equalsPin(Object obj){
        return getPin()==(((Administrator)obj).getPin());
    }
}
