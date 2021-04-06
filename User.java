import java.io.*;
class User extends Person implements Serializable{

    protected String name, surname, ID, password, email;
    protected int TEL_NO, USER_NO, CARD_COUNTER;
    protected int CARD_NUMBER;

    public User(String n, String s, int age, String id, int UN, String p, int TN, String e, int CARD_COUNTER){
        super(n,s,id,TN, age);
        USER_NO = UN;
        password = p;
        email = e;
        this.CARD_COUNTER = CARD_COUNTER;

    }

    public User(String n, String s, int age, String id, int UN, String p, int TN, String e, int CARD_COUNTER, int CARD_NUMBER){
        super(n,s,id,TN, age);
        USER_NO = UN;
        password = p;
        email = e;
        this.CARD_COUNTER = CARD_COUNTER;
        this.CARD_NUMBER = CARD_NUMBER;

    }

    // ----- Getters ------

    public String getID() {
        return ID;
    }

    public int getTEL_NO() {
        return TEL_NO;
    }

    public String getName() {
        return name;
    }

    public int getUSER_NO() {
        return USER_NO;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail(){
        return email;
    }

    public int getCardCt(){
        return CARD_COUNTER;
    }

    public int getCardNo(){
        return CARD_NUMBER;
    }

    // ----- For Login System -----

    public boolean equalsUserNumber(Object obj){
        return getUSER_NO()==(((User)obj).getUSER_NO());
    }

    public boolean equalsPassword(Object obj){
        return getPassword()==(((User)obj).getPassword());
    }

    public String toString(){
        return (super.name + "" + super.surname + "" + super.id + "" + password + " " + super.TEL_NO + "" + email + " ");
    }
}