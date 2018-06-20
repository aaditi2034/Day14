/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksys;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Arpit GUPTA
 */
public class BankSys {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Account a=new Account();
        Bank b=new Bank();
        int AccNo;
        String accno;
        boolean quit=false;
        do
        {
            System.out.println("1: Create a new account");
            System.out.println("2: Credit");
            System.out.println("3: Debit");
            System.out.println("4: MiniStatement");
            System.out.println("5: Print the Passbook(Account summary)");
            System.out.println("6: Quit");//quiting will delete all the existing files
            System.out.println("7: Delete an account");// will delete only the file of current account number
            int n=a.s.nextInt();
            switch(n)
            {
                case 1:
                a.create(); 
                break;
                case 2:
                System.out.println("Enter the Account no to credited from");
                AccNo=a.s.nextInt();
                b.credit(AccNo);
                break;
                case 3:
                System.out.println("Enter the Account no to be debited  from");
                AccNo=a.s.nextInt();
                b.debit(AccNo);
                break;
                case 4:
                System.out.println("Enter the Account no you want the mini statement of");
                accno=a.s.next();
                a.ministatement(accno);
                break;
                case 5:
                System.out.println("Enter the Account no you want the Account Summary of");
                accno=a.s.next();
                a.AccountSummary(accno);
                break;
                case 6:
                File files =new File("D:\\ADITI\\languages\\internship_internity\\BankSys\\src\\files\\");
                File[] file=files.listFiles();
                for(File i:file)
                    i.delete();
                quit=true;
                break;
                case 7:
                System.out.println("Enter the Account no you want to delete");
                AccNo=a.s.nextInt();
                if(Bank.hm.containsKey(AccNo))
                {
                    Object v=Bank.hm.get(AccNo);
                    a=(Account)v;
                    String AccHolderName=a.AccHolderName;
                    File file1 = new File("D:\\ADITI\\languages\\internship_internity\\BankSys\\src\\files\\"+AccNo+"_"+AccHolderName+".txt");
                    if(file1.delete())
                        System.out.println("Account Deleted");
                    else
                    System.err.println("Error while Deleting an account");
                }
                break;
                default:
                    System.out.print("invalid option");
            }
        }while(!quit);
        
        System.out.println("\nThanks");
    }
    
    
}
