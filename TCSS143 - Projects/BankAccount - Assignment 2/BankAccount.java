/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 2
* 
* File Name:   BankAccount.java
*/

/**
* This program is a class that represents a basic bank account. 
* It holds a balance, it's owner's name, an interest rate. Like a
* regular bank account, you can process deposits and withdrawals, 
* and check your balance.
* This class is intended to be used with the AccountTester.java 
* driver program.
* 
*
* @author Natan Artemiev
* @version 8 April 2023
*/
public class BankAccount implements NamedAccount {

   /**
   * This stores the customer's (Account Owners) name.
   */
   private String myCustomersName;
   
   /**
   * This stores the account's balance.
   */
   private double myAccountBalance;
   
   /**
   * This stores the interest rate on this account.
   */
   private double myInterestRate;
   
   /**
   * This stores Waldo's the number of withdrawals from this account
   * for each month.
   */
   protected int myMonthlyWithdrawCount;
   
   /**
   * This keeps track of the monthly service charges that this 
   * account accrues.
   */
   protected double myMonthlyServiceCharges; 
   
   /**
   * This method constucts a BankAccount object. It sets our constants
   * to the appropirate values.
   * 
   * @param theNameOfTheOwner holds the String that represents the 
   *        account owner's name.
   * @param theInterestRate holds the interest rate associated with 
   *        this account.
   */
   public BankAccount(final String theNameOfTheOwner, 
                      final double theInterestRate) {
      myCustomersName = theNameOfTheOwner;
      if (theInterestRate <= 1.0 && theInterestRate >= 0.0) {
         myInterestRate = theInterestRate;
      }
      myAccountBalance = 0.0;
      myMonthlyWithdrawCount = 0;
      myMonthlyServiceCharges = 0.0;
   }
   
   /**
   * This is a getter method that allows a user to access the account's
   * balance.
   * 
   * @return the account's balance. 
   */
   public double getBalance() {
      return myAccountBalance;
   }
   
   /**
   * This processes deposits by taking the depsoit amount that is passed
   * in and adding it to the current balance. Checks if the amount passed
   * in is valid.
   * 
   * @param theAmount holds the amount that the person wants to deposit.
   * @return true if theAmount is greater than zero (successful deposit).  
   *         False if it the amount is an invalid number (unsuccessful).
   */
   public boolean processDeposit(final double theAmount) {
      boolean returnBool  = false;
      if (theAmount <= 0.0) {
         returnBool = false;
      }
      else {
         myAccountBalance += theAmount;
         returnBool = true;
      }
      return returnBool;
   }
   
   /**
   * This processes withdrawals from the account by taking the amount
   * that is passed in and subtracting it from the current balance. 
   * Checks if the amount passed in is valid by making sure that it is
   * positive and is not greater than the account balance. Will increment
   * the monthly withdrawal count everytime a successful withdrawal is 
   * performed.
   * 
   * @param theAmount holds the amount that the person wants to withdraw.
   * @return true if theAmount is valid, false otherwise.
   */
   public boolean processWithdrawal(final double theAmount) {
      boolean returnBool  = false;
      if (theAmount < 0.0 || theAmount > myAccountBalance) {
         returnBool = false;
      }
      else {
         myAccountBalance -= theAmount;
         myMonthlyWithdrawCount++;
         returnBool = true;
      }
      return returnBool;
   }
   
   /**
   * This method calculates the interest that the account accrues for the
   * month. 
   *
   * @return the calculated monthly interest.
   */
   public double calculateInterest() {
      return myAccountBalance * myInterestRate / 12.0;
   }
   
   /**
   * This method represents a process that could happen to a bank account
   * at the end of each month. It deducts the monthly fees from the 
   * account and adds the accrued interest. It also resets some of the 
   * fields to zero where appropriate to start the "new month."
   */
   public void performMonthlyProcess() {
      myAccountBalance -= myMonthlyServiceCharges;
      myAccountBalance += calculateInterest();
      myMonthlyWithdrawCount = 0;
      myMonthlyServiceCharges = 0.0;
      if (myAccountBalance < 0.0) {
         myAccountBalance = 0.0;
      }
   }
   
   /**
   * This is a method that is requried by the NamedAccount Interface,
   * to get the account holder's name.
   * 
   * @return the cutomer's name.
   */
   public String getAccountHolderName() {
      return myCustomersName;
   }
   
   /**
   * This is a method that is requried by the NamedAccount Interface,
   * to set a new account holder's name to the current account. 
   */
   public void setAccountHolderName(final String theNewName) {
      myCustomersName = theNewName;
   }
   
   /**
   * This is a method that prints out information about the account in a
   * format that is specified by the Assignment.
   * 
   * @return a String that contains the account info and required format.
   */
   public String toString() {
         return "BankAccount" + toStringForm()  + "]";
   }
   
   /**
   * This method stores a String that is "common ground" between
   * BankAccount and SavingsAccount so that it can be used by both.
   * This allows SavingAccount to have the same required format while
   * overriding a few samll details.
   * 
   * @return a String that contains the account info and required format.
   */   
   public String toStringForm() {
      return "[owner: " + myCustomersName +
             ", balance: " +
             String.format("%.2f", myAccountBalance) +
             ", interest rate: " + 
             String.format("%.2f", myInterestRate) +
             ", \n \t\t  number of withdrawals this month: " +
             myMonthlyWithdrawCount +
             ", service charges for this month: " + 
             String.format("%.2f", myMonthlyServiceCharges);
             
   }
}