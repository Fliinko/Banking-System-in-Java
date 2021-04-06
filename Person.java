import java.util.*;
import java.io.*;
class Person implements Serializable{

    protected String name, surname, id, password;
    protected int TEL_NO, age;

    public Person(String n, String s, String ID, int t, int a){
        name = n;
        surname = s;
        id = ID;
        TEL_NO = t;
        age = a;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getID(){
        return id;
    }

    public int getTelNo(){
        return TEL_NO;
    }

    public int getAge(){
        return age;
    }

    public void setName(String n){
        name = n;
    }

    public void setSurname(String s){
        surname = s;
    }

    public void setID(String ID){
        id = ID;
    }

    public void setTelNo(int t){
        TEL_NO = t;
    }

    public void setAge(int a){
        age = a;
    }

    public String toString(){
        return(name + " " + surname + " " + id + " " + TEL_NO + " " + age + " ");
    }
}