package Package;
import java.util.Scanner;
import java.io.*;
public class MainSystem {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Account acc = new Account();//Object for Reading and Writing User Details
		Account acc_1=new Account();//Object for Reading and Writing Transaction Details
		System.out.println("Welcome to Home Loan Portal!");
		int choice;
		while(true)
		{
			System.out.println("*************************");
			
			System.out.println("1. Create New Account");
			
			System.out.println("2.Add Transaction ");
			
			System.out.println("3.Exit This Portal");
			
			System.out.println("*************************");
			
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();
			if(choice==1) {
				acc.add();//Adds User Details to the file
			}
			else if(choice==2)
			{
				String tmp;
				System.out.println("Enter Your User Id:");
				tmp=sc.next();
				System.out.println("Enter Your Password:");
				String tmp1=sc.next();
				/*
				If the User id and password matches then only user can enter details in the file
				traverse the whole file userdetails.txt and by string split method if the data matches then user can enter details
				 */
				Boolean ok=false;
		        String s9="";
		        String[] words9;
		      FileReader fr9= null;
		try {
			fr9 = new FileReader("A:\\Comprehensive Assignment\\OOP\\UserDetails.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br9 = new BufferedReader(fr9);
             while(true)
			 {
				 try {
					 if ((s9 = br9.readLine()) == null) break;
				 } catch (IOException e) {
					 e.printStackTrace();
				 }
				 words9=s9.split("\\|");
				 if(words9[0].equals(tmp)&&words9[2].equals(tmp1))
				 {
				 	ok=true;
				 }
			 }

             if(ok==true)
			 {
			 	 System.out.println("User Validated Successfully");
			 	 System.out.println("Now You Can Deposit Your Money");
				 acc_1.add_Payment();
			 }
             else
			 {
			 	System.out.println("Wrong Userid Or Password");
			 }
			}
			else if(choice==3)
				break;
		}

		acc.write_txt();
		acc_1.write_Payment_Details();

		Loan_Payment lp = new Loan_Payment();
		int choice1;
		while(true)
		{
            System.out.println("*************************");
			
			System.out.println("1.Year Wise Transaction");
			
			System.out.println("2.Monthly Transaction");
			
			System.out.println("3.Exit");
			
			System.out.println("*************************");
			
			System.out.println("Enter Your Choice");
			choice1= sc.nextInt();
			if(choice1==1)
				lp.Year_wise();
			//Prints All the Transactions Yearwise
			else if(choice1==2)
			{
				lp.month_wise();
				//Prints All the Transactions Of The Year Month Wise
			}
			else
				break;
		}

	}

}
