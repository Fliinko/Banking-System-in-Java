import java.util.*;
import java.io.*;

public class RegularOperations implements Serializable{

    DebitCard d = new DebitCard();
    CreditCard c = new CreditCard();

    SavingsAccount s = new SavingsAccount();
    CurrentAccount ca = new CurrentAccount();


    //------------------------------------------------------------------------------------------------
    //Account Operations

    public void applyAccount(){

        System.out.println("Welcome\n");
        System.out.println("Kindly enter whether you would like a (Savings) or a (Current) Account\n");
        
        Scanner sc = new Scanner(System.in);
        
        String type = sc.next();

        if(type.equals("Savings")){
            s.newSavings();
        }
        else if(type.equals("Current")){
            ca.newCurrent();
        }
        else{
            System.out.println("Kindly enter a valid type\n");
            wait();
        }

        System.out.println("We will contact you via email when your application is Approved or Denied");

    }

    public void viewCurrentDetails(ArrayList<CurrentAccount> currentList, int USER_NO){
        for(CurrentAccount item: currentList){
            if(item.getUserNo() = USER_NO)
                System.out.println(item);
        }
    }

    public void viewSavingsDetails(ArrayList<SavingsAccount> savingsList, int USER_NO){
        for(CurrentAccount item: savingsList){
            if(item.getUserNo() = USER_NO)
                System.out.println(item);
        }
    }

    public void viewBalance(ArrayList<Account> approvedAccount, int USER_NO){
        for(Account item: approvedAccount){
            if(item.getUserNo() = USER_NO)
                System.out.println(item.getBalance());
        }
    }

    public void closeAccount(ArrayList<Account> approvedAccount){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        int findACCNO;

        System.out.println("Kindly enter the Account Number to be closed\n");
        findACCNO = sc.nextInt();

        int spot = approvedAccount.indexOf(new Account(null, 0, 0, findACCNO, 0));
        if(spot == -1)
            System.out.println("Account ID not found\n");
        else{
            System.out.println("Found in position" + spot);
            approvedAccount.remove(spot);
            System.out.println("Deleted");
        }
    }

    public void viewAccountDetails(ArrayList<Account> approvedAccount){
        Scanner sc = new Scanner(System.in);
        int findACCNO;

        System.out.println("Kindly enter the Account Number to be viewed\n");
        findACCNO = sc.nextInt();

        int spot = approvedAccount.indexOf(new Account(null, 0, 0, findACCNO, 0));
        if(spot == -1)
            System.out.println("Account ID not found\n");
        else{
            System.out.println(approvedAccount(spot));
        }
    }

    //------------------------------------------------------------------------------------------------
    //Transaction Operations

    public void viewTransactions(ArrayList<Transaction> transactionList, int USER_NO){
        for(Transaction item: transactionList){
            if(item.getSender().equals(USER_NO) || item.getReceiver.equals(USER_NO)){
                System.out.println(item);
            }else{
                System.out.println("User Number not found");
            }
        }
        
    }

    public void newTransaction(ArrayList<Transaction> transactionList, ArrayList<Account> accountList){

        int tempID = transactionList.length();
        int tempSender, spot;
        int tempReceiver;
        float tempMoney;
        Calendar [] tempDate = new Calendar[2];
        String tempType = null;

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        //Setting ID
        tempID++;

        //Setting Sender

        try{
            System.out.println("Please enter your Bank ID: \n");
            tempSender = sc.nextInt();
            spot = accountList.indexOf(new Account(null, 0, 0, 0, tempSender, 0));
            if(spot == -1){
                System.out.println("Account with Account Number" + tempSender + "does not exist");
                tempSender = 0;
            }
            else{
                tempSender = accountList(spot).getAccNo();
            }
        }catch(InputMismatchException e){
            System.out.println("Please enter a valid input\n");
            sc.nextInt();
        }

        //Setting Receiver

        try{
            System.out.println("Please enter receiver's Bank ID: \n");
            tempReceiver = sc.nextInt();
            spot = accountList.indexOf(new Account(null, 0, 0, 0, tempReceiver, 0));
            if(spot == -1){
                System.out.println("Account with Account Number" + tempReceiver + "does not exist");
                tempReceiver = 0;
            }
            else{
                tempReceiver = accountList(spot).getAccNo(); 
            }

        }
        catch(InputMismatchException e){
            System.out.println("Please enter a valid input\n");
            sc.nextInt();
        }

        //Setting Money

        try{
            System.out.println("Please enter the amount of money to be sent\n");
            tempMoney = sc.nextFloat();

            if(tempMoney > accountList(spot).getBalance()){
                System.out.println("Insufficient Balance\n");
                wait();
            }
        }
        catch(InputMismatchException e){
            System.out.println("Please enter a valid input\n");
            sc.nextFloat();
        }

        //Setting Type

        if(tempMoney > 0){
            tempType = "Credit";
        }
        //Shouldn't get to here
        else{
            tempType = "Cancelled Transaction";
        }

        //Setting Date
        tempDate[0] = Calendar.get(Calendar.DAY_OF_MONTH);
        tempDate[1] = Calendar.get(Calendar.MONTH);
        tempDate[2] = Calendar.get(Calendar.YEAR);

        //Adding in ArrayList
        transactionList.add(new Transaction(tempID, tempSender, tempReceiver, tempType, tempMoney, tempDate));

    }

    //------------------------------------------------------------------------------------------------
    //Card Operations

    public void newCard(ArrayList<Card> applicationList){
        System.out.println("Welcome\n");
        System.out.println("Kindly enter whether you would like a (Credit) or (Debit) Card\n");
        
        Scanner sc = new Scanner(System.in);
        String type = sc.next();

        if(type.equals("Credit")){
            s.newCredit();
        }
        else if(type.equals("Debit")){
            d.newDebit();
        }
        else{
            System.out.println("Kindly enter a valid type\n");
            wait();
        }
    }

    public void closeCard(ArrayList<Card> approvedCard){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        int findCardNo;

        System.out.println("Kindly enter the Card Number");
        findCardNo = sc.nextInt();

        int spot = approvedCard.indexOf(new Card(findCardNo, null, 0, null, null, 0));
        if(spot == -1)
            System.out.println("Card does not exist\n");
        else{
            System.out.println("Found in position" + spot);
            approvedCard.remove(spot);
            System.out.println("Deleted");
        }
    }

    public void viewCardDetails(ArrayList<Card> approvedCard){
        Scanner sc = new Scanner(System.in);
        int findCardNo ;

        System.out.println("Kindly enter the Card Number to be viewed\n");
        findCardNo = sc.nextInt();

        int spot = approvedCard.indexOf(new Card(findCardNo, null, 0, null, null,0));
        if(spot == -1)
            System.out.println("Card Number not found\n");
        else{
            System.out.println(approvedCard(spot));
        }
    }
    
}