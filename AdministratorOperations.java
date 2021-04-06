import java.util.*;
import java.io.*;

public class AdministratorOperations implements Serializable{

    //Object Instances -- Important to call functions in other classes
    CurrentAccount c = new CurrentAccount();
    SavingsAccount s = new SavingsAccount();
    Card ca = new Card();
    Administrator a = new Administrator();
    Account acc = new Account();

    //------------------------------------------------------------------------------------------------
    public boolean adminLogin(ArrayList<Administrator> adminList){
        Scanner sc = new Scanner(System.in);
        int staffno, pin = null;

        System.out.println("Enter your Staff Number and PIN to login in\n");

        try{
        System.out.println("Staff Number...");
        staffno = sc.nextInt();

        }catch(InputMismatchException e){
        System.out.println("Incorrect Input\n");
        }

        try{
        System.out.println("PIN...");
        pin = sc.nextInt();

        }catch(InputMismatchException e){
        System.out.println("Incorrect Input\n");
        }

        int spot = adminList.indexOf(new Administrator(null, null, null, null, staffno, null, pin));
        if(spot == -1)
            return false;
        else
            return true;
        
    }

    //------------------------------------------------------------------------------------------------
    //Account Operations

    public void approveAccount(ArrayList<Administrator> adminList, ArrayList<Account> approvedAccount, ArrayList<CurrentAccount> applicationListC, ArrayList<SavingsAccount> applicationListS){
        Scanner sc = new Scanner(System.in);
        int choice1 = null;
        String choice, choice2 = null;

        boolean result = adminLogin(adminList);

        do{
            if(result == false)
            System.out.println("Incorrect Login... Try again\n");
            else{
            
            System.out.println("Would you like to approve Savings or Current applications?\n");
            choice = sc.next();

                switch(choice){
                    case "Savings":
                        //Viewing Savings Applications
                        viewPendingSavings(applicationListS);
                        System.out.println("Select the position of the Account to approve\n");
                        choice1 = sc.nextInt();
                        System.out.println(applicationListS[choice1]);

                        try{
                        System.out.println("Approved (A) or Denied (D)");
                        choice2 = sc.next();
                        }catch(InputMismatchException e){
                            System.out.println("Incorrect Input\n");
                            sc.next();
                        }

                        if(choice2 == 'A'){
                            approvedAccount.add(new Account(applicationListS[choice1]));
                            result1 = true;
                        }
                        else{
                            System.out.println("Account Approval Denied");
                            applicationListS.remove(choice1);
                            result1 = true;
                        }
                        break;

                    case "Current":

                        viewPendingCredit(applicationListC);
                        System.out.println("Select the position of the Account to approve\n");
                        choice1 = sc.nextInt();
                        System.out.println(applicationListC[choice1]);

                        try{
                        System.out.println("Approved (A) or Denied (D)");
                        choice2 = sc.next();
                        }catch(InputMismatchException e){
                            System.out.println("Incorrect Input\n");
                            sc.next();
                        }

                        if(choice2 == 'A'){
                            approvedAccount.add(new Account(applicationListC[choice1]));
                            result1 = true;
                        }
                        else{
                            System.out.println("Account Approval Denied");
                            applicationListC.remove(choice1);
                            result1 = true;
                        }
                        break;

                    default: System.out.println("Invalid input\n");
                            break;

                }   
            }
        }while(result || result1 == false); 
    }

    public void viewApprovedAccounts(ArrayList<Account> approvedAccount){
        for(AccountAccount item: approvedAccount){
            System.out.println(item);
        }
    }

    public void viewPendingCurrent(ArrayList<CurrentAccount> applicationList){
        for(CurrentAccount item: applicationList){
            System.out.println(item);
        }
    }

    public void viewPendingSavings(ArrayList<SavingsAccount> applicationList){
        for(SavingsAccount item: applicationList){
            System.out.println(item);
        }
    }

    public void closeAccount(ArrayList<Account> approvedAccount, ArrayList<Report> reportList){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        int findACCNO = null;
        String tempReport = null;

        System.out.println("Kindly enter the Account Number to be closed\n");
        findACCNO = sc.nextInt();

        int spot = approvedAccount.indexOf(new Account(null, null, null, findACCNO, null));
        if(spot == -1)
            System.out.println("Account ID not found\n");
        else{
            System.out.println("Enter the reason for Account Deletion\n");
            tempReport = sc.next();

            reportList.add(new Report(tempReport, "Account", findACCNO));
            approveAccount.remove(spot);
            System.out.println("Deleted");

        }
    }

    //------------------------------------------------------------------------------------------------
    //Card Operations

    public void acceptCard(ArrayList<Administrator> adminList, ArrayList<Card> cardList, ArrayList<CreditCard> creditList, ArrayList<DebitCard> debitList, ArrayList<Account> accountList){
        Scanner sc = new Scanner(System.in);
        int tempCardCt, tempAccNo, choice1 = null;
        String choice, choice2 = null;
        boolean result = adminLogin(adminList);
        boolean result1 = false;

        do{
            if(result == false)
            System.out.println("Incorrect Login... Try again\n");
            else{

                try{
                System.out.println("Would you like to view Credit or Debit applications?\n");
                choice = sc.next();
                }catch(InputMismatchException e){
                    System.out.println("Incorrect Input\n");
                    sc.next();
                }

                switch(choice){

                    case "Credit": 
                                    viewPendingCredit(creditList);
                                    try{
                                    System.out.println("Select the position of the Card to approve\n");
                                    choice1 = sc.nextInt();
                                    }catch(InputMismatchException e){
                                        System.out.println("Invalid Input\n");
                                        sc.nextInt();
                                    }
                                    System.out.println(creditList[choice1]);

                                    try{
                                    System.out.println("Approved (A) or Denied (D)");
                                    choice2 = sc.next();
                                    }catch(InputMismatchException e){
                                        System.out.println("Invalid Input\n");
                                        sc.next();
                                    }

                                    if(choice2 == 'A'){
                                        cardList.add(new Card(creditList[choice1]));
                                        int tempAccNo = creditList[choice1].getAccNo();
                                        Account a = Account(null, null, null, findACCNO, null);;
                                        if(!a){
                                            System.out.println("Linked Account Does Not Exist");
                                        }else{
                                            tempCardct = a.getCardCt();
                                            a.setCardCt(tempCardCt++);
                                        }
                                        result1 = true;
                                    }
                                    else if(choice2 == 'D'){
                                        System.out.println("Approval of Card Denied\n");
                                        result1 = true;
                                    }

                                    break;
                        
                        case "Debit": 
                                        viewPendingDebit(debitList);
                                        try{
                                            System.out.println("Select the position of the Card to approve\n");
                                            choice1 = sc.nextInt();
                                            }catch(InputMismatchException e){
                                                System.out.println("Invalid Input\n");
                                                sc.nextInt();
                                            }
                                            System.out.println(debitList[choice1]);

                                            try{
                                            System.out.println("Approved (A) or Denied (D)");
                                            choice2 = sc.next();
                                            }catch(InputMismatchException e){
                                                System.out.println("Invalid Input\n");
                                                sc.next();
                                            }

                                            if(choice2 == 'A'){
                                                cardList.add(new Card(debitList[choice1]));
                                                int tempAccNo = debitList[choice1].getAccNo();
                                                Account a = Account(null, null, null, findACCNO, null);;
                                                if(!a){
                                                    System.out.println("Linked Account Does Not Exist");
                                                }else{
                                                    tempCardct = a.getCardCt();
                                                    a.setCardCt(tempCardCt++);
                                                }
                                                result1 = true;
                                            }
                                            else if(choice2 == 'D'){
                                                System.out.println("Approval of Card Denied\n");
                                                result1 = true;
                                            }     
                                            
                                            break;

                        default:
                                System.out.println("Invalid input\n");
                                break;
                }
            }
        }while(result || result1 == false);
    }

    public void viewApprovedCards(Arraylist<Card> approvedCard){
        for(Card item: approvedCard){
            System.out.println(item);
        }
    }

    public void viewPendingCredit(ArrayList<CreditCard> applicationsCredit){
        for(CreditCard: applicationsCredit){
            System.out.println(item);
        }
    }

    public void viewPendingDebit(ArrayList<DebitCard> applicationsDebit){
        for(DebitCard: applicationsDebit){
            System.out.println(item);
        }
    }

    public void closeCard(ArrayList<Card> approvedCard, ArrayList<Report> reportList){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        int findCardNo = null;
        String tempReport = null;

        System.out.println("Kindly enter the Card Number to be closed\n");
        findCardNo = sc.nextInt();

        int spot = approvedCard.indexOf(new Card(findCardNo, null, null, null, null));
        if(spot == -1)
            System.out.println("Card Number not found\n");
        else{
            System.out.println("Kindly enter the reason for Card deletion\n");
            tempReport = sc.next();
            reportList.add(new Report(tempReport, "Card", findCardNo));

            approvedCard.remove(spot);
            System.out.println("Deleted");
        }
    }
}
