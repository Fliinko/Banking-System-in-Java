import java.util.*;
import java.io.*;

public class Report implements Serializable{

    int number;
    String report, file;

    Report(){}

    Report(String report, String file, int number){
        this.report = report;
        this.file = file;
        this.number = number;
    }

    // ---- Getters ----
    public String getReport(){
        return report;
    }

    public String getFile(){
        return file;
    }

    public int getNumber(){
        return number;
    }

    // ---- Setters ----
    public void setReport(String report){
        this.report = report;
    }

    public void setFile(String file){
        this.file = file;
    }

    public void setNumber(int number){
        this.number = number;
    }
}