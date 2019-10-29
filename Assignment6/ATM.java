package Assignemnt6;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random; 
public class ATM {
	private int avaliableAmountInMachine = 0;
	private int transactionFee;
	public ArrayList<User> userData  = new ArrayList<User>();
	private ArrayList<String> TransactionDetail = new ArrayList<String>();
	
	public int getAvaliableAmountInMachine() {
		return avaliableAmountInMachine;
	}
	
	public void setAvaliableAmountInMachine(int avaliableAmountInMachine) {
		this.avaliableAmountInMachine = avaliableAmountInMachine;
	}
	
	public int getTransactionFee() {
		return transactionFee;
	}
	
	public void setTransactionFee(int transactionFee) {
		this.transactionFee = transactionFee;
	}

	public ArrayList<User> getUserData() {
		return userData;
	}

	public void setUserData(ArrayList<User> userData) {
		this.userData = userData;
	}
	
	public void Start() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter OLDUSER or NEWUSER for next step");
		String line = scanner.nextLine();
		if(line.equals("OLDUSER"))
			Login();
		if(line.equals("NEWUSER"))
			CreateNewUser();
	}

	private void CreateNewUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What's your name?");
		String name = scanner.nextLine();
		System.out.println("What's your age?");
		String age = scanner.nextLine();
		System.out.println("What's your address?");
		String address = scanner.nextLine();
		System.out.println("What's your phone number?");
		String phoneNumber = scanner.nextLine();
		System.out.println("Please create a preferred password for your account?");
		String password = scanner.nextLine();
		
		Random rand = new Random();
		boolean unique = false;
		String bankAccountNumber = "111101";
		if(userData.isEmpty()) {
			User NewUser = new User(name, age,address,phoneNumber,bankAccountNumber, password);
			userData.add(NewUser);
		}
		else {
			for(User i:userData) {
				int randNumber = rand.nextInt(100);
				bankAccountNumber = "1111"+ String.valueOf(randNumber);
				if(!bankAccountNumber.equals( i.getBankAccountNumber()))
					unique = true;
					break;
				}
			if(unique) {
				User NewUser = new User(name, age,address,phoneNumber,bankAccountNumber, password);
				userData.add(NewUser);
			}
		}
		
		for(User i:userData) {
			System.out.println(i.getName()+" "+i.getAge()+" "+i.getAddress()+" "+i.getBankAccountNumber()+" "+i.getPhoneNumber());
		}
		
		Start();
	}

	private void Login() {
		Scanner scanner = new Scanner(System.in);
		int index = 0;
		System.out.println("Please enter your bank account number");
		String bankAccountNumber = scanner.nextLine();
		for(User i: userData) {
			if(!bankAccountNumber.equals(i.getBankAccountNumber())) {
				System.out.println("Account number not found, Please Try again");
				Login();
			}
			else index = userData.indexOf(i);
		}
		System.out.println("Please enter your password");
		String password = scanner.nextLine();
		if(!password.equals(userData.get(index).getPassword()) ) {
			System.out.println("Wrong password please enter TryAgain|ForgetPassword ");
			String answer = scanner.nextLine();
			if(answer.equals("TryAgain")) Login();
			if(answer.equals("ForgetPassword")) changePassword(index);
		}
		else {
			System.out.println("What can I help you, Please enter withDrawal|deposit|recentTransactions|changePassword|exit");
			String line = scanner.nextLine();
			if(line.equals("withDrawal")) withDrawal(index);
			if(line.equals("deposit")) deposit(index);
			if(line.equals("recentTransactions")) recentTransactions();
			if(line.equals("changePassword")) changePassword(index);
			if(line.equals("exit")) Start();
		}
	}

	private void changePassword(int index) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter your name");
		String name = scanner.nextLine();
		if(!name.equals(userData.get(index).getName())) {
			System.out.println("wrong name please try again");
			changePassword(index);
		}
		
		System.out.println("Please enter your age");
		String age = scanner.nextLine();
		if(!age.equals(userData.get(index).getAge())) {
			System.out.println("wrong age please try again");
			changePassword(index);
		}
		
		System.out.println("Please enter your phone number");
		String phoneNumber = scanner.nextLine();
		if(!phoneNumber.equals(userData.get(index).getPhoneNumber())) {
			System.out.println("wrong phone number please try again");
			changePassword(index);
		}
		
		System.out.println("Please enter your new password");
		String NewPassword = scanner.nextLine();
		userData.get(index).setPassword(NewPassword);
		
		Login();
	}

	private void recentTransactions() {
		for(int i = TransactionDetail.size(); i < 10; i--) {
			System.out.println(TransactionDetail.get(i));
		}
		
		Start();
	}

	private void deposit( int index) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the amount you want to deposit");
		int amount = scanner.nextInt();
		avaliableAmountInMachine = avaliableAmountInMachine + amount - transactionFee;
		String Transaction = "Deposite in Account "+ userData.get(index).getBankAccountNumber() + " +"+amount;
		TransactionDetail.add(Transaction);
		Start();
	}

	private void withDrawal( int index) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the amount you want to withDrawal");
		int amount = scanner.nextInt();
		if(amount > avaliableAmountInMachine) {
			System.out.println("Sorry, this machine does not have enough money for now");
		}
		else avaliableAmountInMachine = avaliableAmountInMachine - amount - transactionFee;
		String Transaction = "WithDrawal from Account "+ userData.get(index).getBankAccountNumber() + " -"+amount;
		TransactionDetail.add(Transaction);
		
		Start();
	}
}
