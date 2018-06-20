/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksys;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Arpit GUPTA
 */
public class Bank {

    Scanner s=new Scanner(System.in);
    int i=0;
    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    Date dateobj=new Date();
    public static HashMap<Integer,Object> hm =new HashMap<>();
    Account a=new Account();
    void credit(int AccNo) throws IOException
    {    
        if(hm.containsKey(AccNo))
        {
            Object v=hm.get(AccNo);
            a=(Account)v;
            System.out.print("Enter the amount you want credit :");
            double amount=s.nextDouble();
            if(amount>0)
            {
                a.AccountBalance=a.AccountBalance+amount;
                Account.miniS.add(AccNo+"#"+df.format(dateobj)+"#"+amount+"#Credited#"+a.AccountBalance);
                try{
                    FileWriter file = new FileWriter("D:\\ADITI\\languages\\internship_internity\\BankSys\\src\\files\\"+AccNo+"_"+a.AccHolderName+".txt",true);
                    file.append(df.format(dateobj)+"  "+amount+"  credited   " +a.AccountBalance);
                    file.append(System.getProperty( "line.separator" ));
                    file.close();
                }catch(Exception e){
                System.out.print(e);
            }
           
            System.out.println("Do you want the receipt\n1:Yes\n2:No");
            int n=s.nextInt();
            if(n==1)
                System.out.println("Account Number: "+AccNo+"\nAccount holder name:  "+a.AccHolderName+"\nAmount credited :"+amount+"\nAccount Balance :"  +a.AccountBalance);
            System.out.println("Have a GOOD DAY..!!");
        }
        else
           System.out.println("please enter the valid ammount");
    }
    else 
        System.out.println("please enter the valid account number");
}
    
    void debit(int AccNo)
    {   
        if(hm.containsKey(AccNo))
        {  
            Object v=hm.get(AccNo);
            a=(Account)v;
            System.out.print("Enter the amount you want debited :");
            double amount=s.nextDouble();
        
            if(amount<a.AccountBalance && amount<30000)
            {   
                a.AccountBalance=a.AccountBalance-amount;
          
                Account.miniS.add(AccNo+"#"+df.format(dateobj)+"#"+amount+"#Debited#"+a.AccountBalance);
                try{
                    FileWriter file = new FileWriter("D:\\ADITI\\languages\\internship_internity\\BankSys\\src\\files\\"+AccNo+"_"+a.AccHolderName+".txt",true);
                    file.append(df.format(dateobj)+"  "+amount+"  debited   " +a.AccountBalance);
                    file.append(System.getProperty( "line.separator" ));
                    file.close();
                }catch(Exception e){
                System.out.print(e);
                }
                System.out.println("Do you want the receipt\n1:Yes\n2:No");
                int n=s.nextInt();
                if(n==1)
                    System.out.println("Account Number: "+AccNo+"\nAccount holder name:  "+a.AccHolderName+"\nAmount Debited :"+amount+"\nAccount Balance :"  +a.AccountBalance);
                System.out.println("Have a GOOD DAY..!!");
            }
            else
                System.out.println("please enter the valid ammount");
        }
        else
            System.out.println("please enter the valid account number");
    }

}
