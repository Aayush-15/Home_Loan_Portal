package Package;
import java.util.Scanner;
import java.io.*;
public class Person {
	    Scanner sc = new Scanner(System.in);
    //Initializing variables required for storing Account Holder Details
        String userid;  
        String name;   
        String password;
        
        double total_loan;   
        double remaining_loan; 
        int n=0;//Keeping The Track Of Number Of Records
    	int n1=0;//Keeping The Record Of Payment
        //CONSTRUCTOR TO INITIALIZE ALL THE VALUE TO ZERO
        Person()
        {
        	this.userid="";
        	this.name="";
        	this.password="";
        	this.total_loan=0;
        	this.remaining_loan=0;
        }
        // SCANNING ALL THE DETAILS FROM THE USER
        void scan()
        {
        	System.out.println("Enter The Name ");
        	this.name=sc.nextLine();
        	
        	System.out.println("Enter Your Userid:");
        	this.userid=sc.nextLine();
        	
        	System.out.println("Enter The Password You Want To Keep:");
        	this.password=sc.nextLine();
        	
        	System.out.println("Enter The Total Amount Of Loan To Be Taken:");
        	this.total_loan=sc.nextInt();
        		
        	System.out.println("Enter The Remaining Amount To Be Paid:");
        	this.remaining_loan=sc.nextInt();
        }
        void display(int n) 
        {
        	System.out.println("The Account Details Of User"+n+1);
        	System.out.println("The Name Of The Account Holder"+this.name);
        	System.out.println("The User ID :"+this.userid);
        	System.out.println("Home Loan Amount"+this.total_loan);
        	System.out.println("Remaining Loan "+this.remaining_loan);        	
        }
        void write() 
        { String name_1=this.name;
        String userid_1=this.userid;
        String password_1=this.password;
        double total_loan_1=this.total_loan;
        double remaining_loan_1=this.remaining_loan;
        String d=userid_1+'|'+name_1+'|'+password_1+'|'+total_loan_1+'|'+remaining_loan_1+"\n";
      
        try{
            BufferedWriter f= new BufferedWriter(new FileWriter("A:\\Comprehensive Assignment\\OOP\\UserDetails.txt",true));
            f.write(d);
            f.close();
        }
        catch(Exception e) //Exception if file is not found 
         {     
                    System.out.println("Error!!  File not found");
         } 

      }

        
}
