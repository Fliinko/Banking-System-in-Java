import java.util.*;
import java.io.*;

abstract class BankHolidays implements Serializable{

    Calendar [] Holidays = {fromString("01/01"),
                        fromString("02/04"),
                        fromString("05/04"),
                        fromString("03/05"),
                        fromString("31/05"),
                        fromString("27/12"),
                        fromString("28/12")}; //Official dates of Bank Holidays in the UK for 2021
    BankHolidays(){}

    BankHolidays(Calendar [] Holidays){
        this.Holidays = Holidays;
    }

    public Calendar getHolidays(Calendar Holidays){
        for(int i=0; i<Holidays.length(); i++){
            return Holidays[i];
        }
    }

}