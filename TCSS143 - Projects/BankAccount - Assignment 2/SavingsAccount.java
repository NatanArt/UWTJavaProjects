/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 2
* 
* File Name:   SavingsAccount.java
*/

/**
* This program is a class that represents a Savings account.
* Since it is still a BankAccount it inherits all aspects of a
* nomral bank account plus some slightly different behaivior.
* This class is intended to be used with the AccountTester.java 
* driver program and with the BankAccount class.
* 
*
* @author Natan Artemiev
* @version 8 April 2023
*/
public class SavingsAccount extends BankAccount {
   /**
   * This boolean stores the active status of the current SavingsAccount.
   */   
   private boolean myStatusIsActive;
   
   /**
   * This is the constructor method for SavingsAccount. It takes the same
   * input as the super class and calls the super's constructor. Sets
   * the active status of the account to false by default (since we start
   * with a balance of $0.00).
   *
   * @param theNameofOwner holds the String that represents the 
   *        account owner's name.
   * @param theInterestRate holds the interest rate associated with 
   *        this account.
   */
   public SavingsAccount(final String theNameOfOwner, 
                         final double theInterestRate) {
      super(theNameOfOwner, theInterestRate);
      myStatusIsActive = false;
   }
   
   /**
   * This method calls the processDeposit method in the 
   * super class using the deposit amount passed in. If the deposit is
   * successful, and the balance is over $25, then we set the active
   * status of the account to be true. We will also return the boolean
   * that the superclass returns to us.
   * 
   * @param theAmount holds the amount that the person wants to deposit.
   * @return true if theAmount is greater than zero (successful deposit).  
   *         False if it the amount is an invalid number (unsuccessful).
   */
   public boolean processDeposit(final double theAmount) {
      boolean returnSuper = super.processDeposit(theAmount);
      if (super.getBalance() >= 25.0 && returnSuper) {
         myStatusIsActive = true;
      } 
      return returnSuper;
   }
   
   /**
   * This method first check if the account's status is active. If so,
   * we proceed. Otherwise we return false immediately. Once this is 
   * Checked we call the superclass's method. If it is successful and our
   * balance is less than $25 then we update myStatusIsActive to false.
   * It also adds $1.00 to the monthly service charges for every 
   * withdrawl performed after 4 withdrawals.
   * 
   * @param theAmount holds the amount that the person wants to withdraw.
   * @return true if theAmount is valid, false otherwise. False if balance
   *              is less than $25.00.
   */
   public boolean processWithdrawal(final double theAmount) {      
      boolean returnSuper  = false;
      if (myStatusIsActive) {
         returnSuper = super.processWithdrawal(theAmount);
         if (super.getBalance() < 25.0 && returnSuper) {
            myStatusIsActive = false;
         }
         if (myMonthlyWithdrawCount >= 5 && returnSuper) {
            myMonthlyServiceCharges += 1; 
         }
      }
      else {
         returnSuper = false; 
      }
      return returnSuper;
   }

   /**
   * This method calls the superclass's method and overrides it slightly
   * by updating myStatusIsActive to the proper boolean.
   */
   public void performMonthlyProcess() {
      super.performMonthlyProcess();
      if (super.getBalance() < 25.0) {
         myStatusIsActive = false;
      }
      else if (super.getBalance() > 25.0) {
         myStatusIsActive = true;
      }
   }
   
   /**
   * This is a method that prints out information about the account in a
   * format that is specified by the Assignment.
   * 
   * @return a String that contains the account info and required format.
   */
   public String toString() {
      return "SavingsAccount" + super.toStringForm() + 
             ", myStatusIsActive: " + myStatusIsActive +"]";
   }
}