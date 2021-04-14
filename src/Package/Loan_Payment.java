package Package;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class Loan_Payment extends Person
{
	Scanner sca = new Scanner(System.in);
	int date;
	int month;
	int year;
	int deposit;
	String Payment_Description;
	String userid_1;
	//CONSTRUCTOR METHOD TO INITIALIZE ALL THE VALUES TO EITHER ZERO OR NULL
	void Load_Payment()
	{
		this.userid_1="";
		this.deposit=0;
		this.Payment_Description="";
		this.date=0;
		this.month=0;
		this.year=0;
	}
	//SCAN THE LOAN REPAYMENT DETAILS FROM THE USER
	void scan_Payment_Details()
	{
		System.out.println("Enter The User ID ");
		this.userid_1=sca.nextLine();

		System.out.println("Enter The Payment Description:");
		this.Payment_Description=sca.nextLine();

		System.out.println("Enter The Amount You Will Deposit");
		this.deposit=sca.nextInt();

		System.out.println("Enter The Date:");
		this.date=sca.nextInt();

		System.out.println("Enter The Month:");
		this.month=sca.nextInt();

		System.out.println("Enter The Year:");
		this.year=sca.nextInt();
	}
	/*
	     This Method is used to Write The Loan Repayment Details In The FILE LOAN PAYMENT DETAILS
	 */
	void write_Payment_Details()
	{

		int date_1=this.date;
		int month_1=this.month;
		int year_1=this.year;
		int deposit_1=this.deposit;
		String Payment_Description_1=this.Payment_Description;
		String userid_2=this.userid_1;
		Boolean ok=false;
		String s7="";
		String[] words7;
		     /*
		         THIS CHECKS IF THE USER ID IS PRESENT OR NOT , IF THE USER ID AND PASSWORD IS MATCHED THEN ONLY THE DETAILS
		         WILL BE WRITTEN IN TXT FILE
		      */
		FileReader fr7= null;
		try {
			fr7 = new FileReader("A:\\Comprehensive Assignment\\OOP\\UserDetails.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br7 = new BufferedReader(fr7);
		while(true)
		{
			try {
				if ((s7 = br7.readLine()) == null) break;
			} catch (IOException e) {
				e.printStackTrace();
			}
			words7=s7.split("\\|");
			if(words7[0].equals(userid_2))
			{
				ok=true;
			}
		}
             /*
                IF THE PARTICULAR USER ID AND PASSSWORD DETAILS MATCHES THEN OK=TRUE AND THE DETAILS WILL BE WRITTEN IN
                THE TXT FILE else the details will not be written in transaction.txt file
              */
		if(ok==true)
		{
			//Adding All the details in the file
			String d=userid_2+'|'+deposit_1+'|'+Payment_Description_1+'|'+date_1+'|'+month_1+'|'+year_1+'\n';
			try{
				BufferedWriter f= new BufferedWriter(new FileWriter("A:\\Comprehensive Assignment\\OOP\\LoanPaymentDetails.txt",true));
				f.write(d);
				f.close();
			}
			catch(Exception e) //Exception if file is not found
			{
				System.out.println("Error!!  File not found");
			}
		}
		else
		{
			System.out.println("No Data Exists For Such Userid");
		}


	}
	/*
          THIS METHOD PRINTS ALL THE USERS DATA THAT HAVE DEPOSITED MONEY IN THAT PARTICULAR YEAR
    */
	public void Year_wise() throws IOException
	{
		Scanner sca = new Scanner(System.in);
		System.out.println("Enter The Year For Which You Want To See Transaction:");
		String year_r = sca.next();
		/*
		    FOR PRINTING ALL THE USER DATA ACCORDING TO THAT DATA STORE IN THE FILE USER.TXT
		 */
		/*
		   FOR FINDING ALL THE NUMBER OF USERS WE WILL ITERATE THROUGH USERDETAILS.TXT FILE AND
		   ITERATE OVER ALL THE USER AND FOR EVERY USER PRINT ALL THE DETAILS YEAR WISE
		   FOR THIS PURPOSE WE HAVE TO ITERATE THROUGH  TWO FILES OUTER FILE USERDETAILS AND INNER FILE FOR TRANSACTIONDETAILS
		   WE WILL USE SPLIT STRING METHOD TO GET USERID AND TRANSACTION DETAILS
		 */
		FileReader fr1=new FileReader("A:\\Comprehensive Assignment\\OOP\\UserDetails.txt");/*openingThe File User Details.txt*/
		String s1,s2,s3;
		String[] words1;//Array of strings to split the string
		String s;
		String[] words;
		BufferedReader br1 = new BufferedReader(fr1);

		while((s1=br1.readLine()) != null)
		{
			words1=s1.split("\\|");
			s2=words1[3];//total loan
			s3=words1[4];//remaining amount
			FileReader fr=new FileReader("A:\\Comprehensive Assignment\\OOP\\LoanPaymentDetails.txt");
			/* Opening the Loan Payment Details file to print all the transaction of a
			 current particular person from user details.txt*/
			BufferedReader br = new BufferedReader(fr);
			while ((s= br.readLine())!=null) {
				words = s.split("\\|");

				if (words[0].equals(words1[0])) {
					for (String word : words) {
						if (word.equals(year_r)) {
							System.out.println("Year: " + words[5]);
							System.out.println("Name: " + words1[1]);
							System.out.println("Amount Deposited: " + words[1]);
							System.out.println("TOTAL LOAN:"+s2);
							System.out.println("Previous Remaining Amount"+s3);
							int amount=Integer.parseInt(s3)-Integer.parseInt(words[1]);
							/* Integer.parseInt Converts the String Into Integers*/
							System.out.println("CURRENT REMAINING LOAN PAYMENT"+amount);
							System.out.println(Arrays.toString(words));
						}
					}
				}
			}
		}

	}
	/*
	    THIS METHOD PRINTS ALL THE AMOUNT COLLECTED IN THE PARTICULAR YEAR MONTH WISE
	 */
	public void month_wise() throws IOException
	{

		System.out.println("Enter The Year For Which You Want To See All The Months Transaction:");
		String year_r = sca.next();
		//TAKING THE INPUT FROM THE USER FOR WHICH YEAR'S DATA TO BE PRINTED ON CONSOLE
		FileReader fr=new FileReader("A:\\Comprehensive Assignment\\OOP\\LoanPaymentDetails.txt");
		String s;
		int[] arr=new int [13];
		for(int i=0;i<13;i++)
		{
			arr[i]=0;
		}//INITIALISING THE ARRAY AS ZERO
		String[] words;
		/*
		 ITERATE THROUGH TRANSACTIONDETAILS.TXT FILE AND KEEP THE TRACK OF PARTICULAR MONTH AND YEAR AND
		 ADD THEM TO GET ALL THE NECESSARY DETAILS
		 */
		BufferedReader br = new BufferedReader(fr);
		while ((s= br.readLine())!=null)
		{
			words=s.split("\\|");
			for (String word: words)
			{
				if (word.equals(year_r))
				{
					//System.out.println(Arrays.toString(words));
					int k=Integer.parseInt(words[1]);
					int index=Integer.parseInt(words[4]);
					System.out.println(index+" "+k);
					arr[index]+=k;
				}
			}
		}
		//PRINTING THE AMOUNT DEPOSITED YEAR WISE
		System.out.println("Now Priting The Amount Deposited Year :"+year_r);
		int sum=0;
		System.out.println("Collection For January Month:"+arr[1]);sum+=arr[1];
		System.out.println("Collection For February Month:"+arr[2]);sum+=arr[2];
		System.out.println("Collection For March Month:"+arr[3]);sum+=arr[3];
		System.out.println("Collection For April Month:"+arr[4]);sum+=arr[4];
		System.out.println("Collection For May Month:"+arr[5]);sum+=arr[5];
		System.out.println("Collection For June Month:"+arr[6]);sum+=arr[6];
		System.out.println("Collection For July Month:"+arr[7]);sum+=arr[7];
		System.out.println("Collection For August Month:"+arr[8]);sum+=arr[8];
		System.out.println("Collection For September Month:"+arr[9]);sum+=arr[9];
		System.out.println("Collection For October Month:"+arr[10]);sum+=arr[10];
		System.out.println("Collection For November Month:"+arr[11]);sum+=arr[11];
		System.out.println("Collection For December Month:"+arr[12]);sum+=arr[12];

		System.out.println("Total Deposition Of Money In The Year "+year_r+":"+sum);
	}


}

