package projectTen;

import java.util.Scanner;	

import java.io.*;

import java.text.NumberFormat;

public class SavingsAccount {

	class DoProcessing {

		private double lastInterest;
		private double interestRateYearly;
		private double totalBalance;

		public DoProcessing(double balance, double interestRate) {	//constructor to build object

			totalBalance = balance;
			interestRateYearly = interestRate;
			lastInterest = 0.0;
			
		}

		public void withdraw(double withdrawl) {
			
			totalBalance = totalBalance - withdrawl;
		}

		public void deposit(double depositAmount) {
			
			totalBalance = totalBalance + depositAmount;
		}

		public void addInterest() {

			double monthlyInterestRate = (interestRateYearly / 12);

			lastInterest = (monthlyInterestRate * totalBalance);

			totalBalance = totalBalance + lastInterest;
		}

		
		public double getInterestRateYearly() {	//getter
			
			return interestRateYearly;
		}
		
		public double getLastInterest() {	//getter
			
			return lastInterest;
		}
		
		public double getTotalBalance() {	//getter 
			
			return totalBalance;
		}
	}

	public static void main(String args[]) {

		double montlyDeposit;
		double monthlyWithdrawl;
		double interestEarned = 0.0;
		double totalDeposits = 0;
		double totalWithdrawn = 0;
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();	//sets up the ability to use our classes
		Scanner scanner = new Scanner(System.in);

		System.out.print("Money on account >> ");
		
		double startBal = scanner.nextDouble();

		System.out.print("Annual interest >> ");
		
		double annualInterestRate = scanner.nextDouble();

		SavingsAccount newSavingObject = new SavingsAccount();
		
		DoProcessing savingsAccount = newSavingObject.new DoProcessing(startBal, annualInterestRate);

		System.out.print("Months >> ");
		
		double months = scanner.nextInt();


		for (int i = 0; i <= (months-1); i++) {

			System.out.print("Deposit total for " +(i+1) + " month >> ");
			
			montlyDeposit = scanner.nextDouble();
			
			totalDeposits += montlyDeposit;

			savingsAccount.deposit(montlyDeposit);

			System.out.print("Withdraw total for " + (i+1) + " month >> ");
			
			monthlyWithdrawl = scanner.nextDouble();
			
			totalWithdrawn =totalWithdrawn+ monthlyWithdrawl;

			savingsAccount.withdraw(monthlyWithdrawl);

			savingsAccount.addInterest();

			interestEarned = interestEarned + savingsAccount.getLastInterest();
		}

		System.out.println("Final Deposit >> " + formatter.format((totalDeposits)));
		
		System.out.println("Final Withdrawn >> " + formatter.format((totalWithdrawn)));
		
		System.out.println("Gained Interest >> " + formatter.format((interestEarned)));
		
		System.out.println("Final Balance >> "+ formatter.format((savingsAccount.getTotalBalance())));
	}

}
