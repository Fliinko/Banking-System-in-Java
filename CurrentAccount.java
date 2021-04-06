import java.util.*;
import java.io.*;

class CurrentAccount extends Account implements Serializable{

    private String currency;
    private float money;
    private int CARD_COUNTER, ACCOUNT_NUMBER, USER_NO, USER_NO2;
    
    public CurrentAccount(){}

    public CurrentAccount(String currency, float money, int USER_NO, int ACCOUNT_NUMBER, int CARD_COUNTER){
        super(currency, money, USER_NO, ACCOUNT_NUMBER, CARD_COUNTER);
    }

    // For Joint Account
    public CurrentAccount(String currency, float money, int USER_NO, int USER_NO2, int ACCOUNT_NUMBER, int CARD_COUNTER){
        super(currency, money, USER_NO, USER_NO2, ACCOUNT_NUMBER, CARD_COUNTER);
    }

    // ----- Getters -----

    public String getCurrency(){
        return currency;
    }

    public float getMoney(){
        return money;
    }

    public int getUserNo(){
        return USER_NO;
    }

    public int getUser2(){
        return USER_NO2;
    }

    public int getAccNo(){
        return ACCOUNT_NUMBER;
    }

    public int getCardCt(){
        return CARD_COUNTER;
    }

    // -----------------------------
    public void printCurrencies(){
        System.out.println("EU");
        System.out.println("PND");
        System.out.println("USD");
        System.out.println("YEN");
        System.out.println("BTC");
    }

    public void newCurrent(ArrayList<CurrentAccount> applicationList, ArrayList<CurrentAccount> currentList){

        String tempCurrency = null;
        float tempMoney;
        int tempUserNo, tempUserNo2, tempCardCt;
        int tempAccNo = currentList.length();
        char choice;

        Scanner sc = new Scanner(System.in);

        System.out.println("Creating a (Current) Account");

        System.out.println("Are you creating a Joint(J) or a Regular (R) account?\n");
        choice = sc.next().charAt(0);

        switch(choice){
            case 'R':
                //Setting Currency
                printCurrencies();
                System.out.println("From the above currencies, please choose one by typing it in\n");
                tempCurrency = sc.next();
                //Setting Money - Can fund through transactions
                tempMoney = 0;
                //Setting User Number
                System.out.println("Please enter your User Number\n");
                tempUserNo = sc.nextInt();
                //Setting Account Number
                tempAccNo++;
                //Clarifying Situation with Card
                System.out.println("To apply for a card, please apply through the portal after account acceptance\n");
                tempCardCt = 0;

                applicationList.add(new CurrentAccount(tempCurrency, tempMoney, tempUserNo, tempAccNo, tempCardCt));
                System.out.println("Application Successful, Kindly wait for acceptance\n");

            case 'J':
                //Setting Currency
                printCurrencies();
                System.out.println("From the above currencies, please choose one by typing it in\n");
                tempCurrency = sc.next();
                //Setting Money - Can fund through transactions
                tempMoney = 0;
                //Setting User Number
                System.out.println("Please enter your User Number\n");
                tempUserNo = sc.nextInt();
                System.out.println("Please enter the second User Number\n");
                tempUserNo2 = sc.nextInt();
                //Setting Account Number
                tempAccNo++;
                //Clarifying Situation with Card
                System.out.println("To apply for a card, please apply through the portal after account acceptance\n");
                tempCardCt = 0;

                applicationList.add(new CurrentAccount(tempCurrency, tempMoney, tempUserNo, tempUserNo2, tempAccNo, tempCardCt));
                System.out.println("Application Successful, Kindly wait for acceptance\n");
        } 
    }

    public void listAllCurrent(ArrayList<CurrentAccount> applicationList){
        for(CurrentAccount item: applicationList){
            System.out.println(item);
        }
    }
}
