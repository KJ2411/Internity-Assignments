	import java.util.ArrayList;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	import java.util.Date;
	import java.util.HashMap;
	import java.text.SimpleDateFormat;

	 class Bank
	{
		static HashMap<Integer,Account> Account1 = new HashMap<>();       //Accno, Account
		
		Date d = new Date();
		String date = new SimpleDateFormat("dd/MMM/yyyy").format(d);
		String time = new SimpleDateFormat("HH:mm:ss").format(d);
		
		public void credit(int accountNo)
		{
			
			try 
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				Account acc = Account1.get(accountNo);
				
				System.out.println("Enter the amount to be credited");
				int camount = Integer.parseInt(br.readLine());
				
				if(camount>0)
				{
					int b = camount + acc.accountBal;						//crediting amount
					acc.accountBal = b;
					Account1.put(accountNo, acc);							//updating the account with new balance 
					System.out.println("Amount Credited");
					System.out.println("New amount " + acc.accountBal);
					
					Account.miniState.add("Account "+accountNo+" is credited with Rs"+camount+" on date "+date+" at "+time);
				}
				else
					System.out.println("Amount can't be negative");
				
			} 
			catch (NumberFormatException | IOException e) 
			{
				e.printStackTrace();
			} 
			
			
		}
		
		public void debit(int accountNo)
		{
								
			
				try 
				{
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					Account acc = Account1.get(accountNo);

				
					System.out.println("Enter the amount to be debited");
					int damount = Integer.parseInt(br.readLine());
				
				
					if(damount>0)
					{
						if(acc.accountBal<damount)
							System.out.println("Not enough balance");
						else 
						{
							int b = acc.accountBal - damount;
							acc.accountBal = b; 
							Account1.put(accountNo, acc);
							System.out.println("Amount Debited");
							System.out.println("New amount " + acc.accountBal);
						
						
							Account.miniState.add("Account "+accountNo+" is debited with Rs"+damount+" on date "+date+" at "+time);
						
						}
					}
					else
						System.out.println("Amount can't be negative");
				
				} 
				catch (NumberFormatException | IOException e) 
				{
					e.printStackTrace();
				}
		}
		
		
		
	}


	public class Account extends Bank
	{
		String accHolderName;										 //account holder name
		int accountNo;												 //account no
		int accountBal;												 //current bal
		static ArrayList<String> miniState;							 //mini statement
		
		
		Account(String name,int no,int bal)
		{
			accHolderName = name;
			accountNo = no;
			accountBal = bal;
			
			Account1.put(accountNo, this);
		}
		
		public void call()
		{
			
			while(true)				    //this allows user to perform operation(credit, debit and generate ministatement)
			{							//again and again
				try 
				{	
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					Bank bank = new Bank();
				
					System.out.println("\nYour Current Balance is Rs"+this.accountBal+"\n");
					System.out.println("Enter 1 to credit");
					System.out.println("Enter 2 to debit");
					System.out.println("Enter 3 to generate mini statement");
					System.out.println("Enter 4 to exit");
					int ch = Integer.parseInt(br.readLine());
					
					switch(ch)
					{
						case 1:
								bank.credit(accountNo);
								break;
								
						case 2: 
								bank.debit(accountNo);
								break;
								
						case 3: for(int i=0;i<Account.miniState.size();i++)
									System.out.println(Account.miniState.get(i));
						
								System.out.println("--------------------------------------");
								break;
						
						case 4: System.exit(0);
								break;
								
						default: System.out.println("Please Enter the valid number");		
						
					}
				} 				//end of try
				catch (NumberFormatException |IOException e) 
				{
					System.out.println("Inavlid inputs");
				}
			}					
		}
		
		public static void main(String... args) 
		{
			BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
			
			miniState = new ArrayList<String>();
			
			char y='y';
			while(y=='y')                   //this loop ensures that if user enters any wrong input, he 
			{								//can again perform the input (the program doesn't terminate)
				try 
				{
					System.out.println("Enter the Account Holder Name");
					String name = br.readLine();
					
					System.out.println("Enter the Account no");
					int num = Integer.parseInt(br.readLine());
					
					System.out.println("Enter the Current Balance");
					int bal = Integer.parseInt(br.readLine());
					
					if(bal<0)
						System.out.println("Amount can't be negative");
					
					else
					{
						y='n';				//if all inputs are valid the loop does not work again
						
						Account accob = new Account(name,num,bal);
						accob.call();
					}
				} 
				catch (NumberFormatException | IOException e) 
				{
					System.out.println("Please give valid inputs");
				}
				
			}
		}
	}

