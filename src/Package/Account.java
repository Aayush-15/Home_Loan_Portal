package Package;

public class Account
{
	Loan_Payment[] account = new Loan_Payment[50];
	Loan_Payment[] account_1 =new Loan_Payment[50];
	int n=0;//Keeping The Track Of Number Of Records
	int n1=0;//Keeping The Record Of Payment
	/*
	METHOD TO ADD USER DETAILS IN TXT FILE
	 */
	void add()
	{
		account[n]=new Loan_Payment();
		System.out.println("Enter Detalis for Account "+(n+1));
		account[n++].scan();  //calling scan() function to scan details from user
		System.out.println();
		
	}
	//METHOD TO ADD
	void add_Payment()
	{
		account_1[n1]=new Loan_Payment();
		System.out.println("Enter Payment Details for Account ");
		account_1[n1++].scan_Payment_Details();  //calling scan() function to scan details from user
		System.out.println();	
	}
	void write_Payment_Details()
	{
		for(int i=0;i<n1;i++)
		{
			account_1[i].write_Payment_Details();
		}
	}
	
	void display()
	{
		if(this.n == 0)
		{
			System.out.println("No Accounts Available !\n");
			return;
		}
		//loop to call display function in Person class through Atm_Bank_Interface2 object 
		for(int i=0;i<n;i++)
		{
			System.out.println("|| Account "+(i+1)+" Details ||");
			account[i].display(i+1);
			System.out.println();
			System.out.println("************************");
		}
		System.out.println();     
	}
	
	
	void write_txt()
	{
		for(int i=0;i<n;i++)
		{
			account[i].write();
		}
	}
	
}
