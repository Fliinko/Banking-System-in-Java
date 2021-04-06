import java.util.*;
import java.io.*;

class CreditCard extends Card implements Serializable{

    protected int CARD_NUMBER;
    protected int CVV, ACC_NO;
    protected float money; //Money is preset and decreases when a transaction goes through
    protected Calendar EXPIRATION_DATE;
    protected String USER_NAME, USER_SURNAME;

    public CreditCard(){}

    public CreditCard(int CARD_NUMBER, Calendar EXPIRATION_DATE, int CVV, float money, String USER_NAME, String USER_SURNAME, int ACC_NO){
        super(CARD_NUMBER, EXPIRATION_DATE, CVV, USER_NAME, USER_SURNAME, ACC_NO);
        this.money = money;
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

    public float getMoney(){
        return money;
    }

    public int getAccNo(){
        return ACC_NO;
    }


    //--------------------------------
    public void generatePrefix(String input, int prefix){
        if(input == "Mastercard")
            prefix = 5;
        if(input == "Visa")
            prefix = 4;
    }
    
    public void newCredit(ArrayList<CreditCard> applicationList, ArrayList<Account> accountList){
        
        int tempCardNo, suffix, prefix, tempCVV, tempAccNo= 0;
        Calendar tempExpDate = null;
        String tempName, tempSurname, input = null;
        float balance;

        //------------------------------------------------------------------------------------------------
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        //------------------------------------------------------------------------------------------------

        System.out.println("Weclome User\n");
        System.out.println("Would you like to create a Mastercard or a Visa?\n");
        input = sc.next();

        System.out.println("Processing...");

        //Setting Card Number
        
        generatePrefix(input, prefix);
        suffix = 1000000 + rnd.nextInt(9999999); //Generates Random Suffix for Card
        tempCardNo = Integer.valueOf(String.valueOf(prefix) + String.valueOf(suffix));
        
        //Setting Expiration Date
        //Setting to 2 Years from current Month
        tempExpDate = cal.getInstance().get(Calendar.MONTH).get(Calendar.YEAR, 2);

        //Setting CVV

        tempCVV = 100 + rnd.nextInt(999);

        System.out.println("Kindly Enter your Account Number\n");
        tempAccNo = sc.nextInt();

        //Setting Balannce

        try{
        System.out.println("Kindly Enter the Amount of Money you want on your Credit Card\n");
        balance = sc.nextFloat();
        }
        catch(InputMismatchException e){
            System.out.println("Kindly Enter a Numerical Value\n");
            sc.nextFloat();
        }

        
        for(int i = 0; i < accountList.length(); i++){
            if(accountList[i].getAccNo == tempAccNo){
                tempName = accountList[i].getName();
                tempSurname = accountList[i].getSurname();
            }
        }

        applicationList.add(new CreditCard(tempCardNo, tempExpDate, tempCVV, balance, tempName, tempSurname));
        System.out.println("Application placed, you will be contacted when Accepted or Rejected\n");

    }
}
