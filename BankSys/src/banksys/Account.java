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
public class Account {
    
    Scanner s=new Scanner(System.in);
    String AccHolderName;
    int AccNo;
    double AccountBalance;
    int i=0;
    Account[] a=new Account[5];
    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
       Date dateobj=new Date();
    
    public Account()
    {
        AccHolderName="";
        AccNo=0;
        AccountBalance=0;
    }
    
    public Account(String Name,int AcNo,double AccBalance)
    {
        AccHolderName=Name;
        AccNo=AcNo;
        AccountBalance=AccBalance;    
    }
    
    public void create() throws IOException
    {
        if(i<5)
        {
            System.out.println("Enter you name");
            AccHolderName=s.next();

            System.out.println("Your account number is:"+AccNo);
            System.out.println("Enter an opening balance:");
             AccountBalance=s.nextDouble();

            a[i]=new Account(AccHolderName,AccNo,AccountBalance);
            Bank.hm.put(AccNo,a[i]);
            File file=new File("D:\\ADITI\\languages\\internship_internity\\BankSys\\src\\files\\"+AccNo+"_"+AccHolderName+".txt");

            try{
                if(file.createNewFile())
                { 
                    System.out.print("Account is created\n");
                    System.out.println("Account Number: "+AccNo+"\nAccount holder name:  "+a[i].AccHolderName+"\nAccount Balance :"  +a[i].AccountBalance+"\nAccount creation date :" +df.format(dateobj));   
                }   
            }catch(IOException e){System.out.print(e);}
            AccNo++;
            i++;
        }
        else
            System.out.print("user limit exceeded");
    }
    
    public static ArrayList<String> miniS=new ArrayList<>();
    
    void  ministatement(String AccNo)
    {
        int size=miniS.size();
        int count=0;
        for(int k=size-1;k>=0;k--)
        {
           String s1=miniS.get(k);
           if(s1.startsWith(AccNo) && count<5)
           {
                String[] arrSplit = s1.split("#"); 
                for(int j=0;j<arrSplit.length;j++)
                {
                    System.out.print(arrSplit[j]+" ");
                }
                System.out.print("\n");
                count++;
            }
        }
    }
    
    void AccountSummary(String AccNo)
    {
        int size=miniS.size();
        for(int k=0;k<size;k++)
        {
           String s1=miniS.get(k);
           if(s1.startsWith(AccNo))
           {
                String[] arrSplit = s1.split("#");
                for (String arrSplit1 : arrSplit) 
                   System.out.print(arrSplit1 + " ");
                System.out.print("\n");
            } 
        }
    }
}

