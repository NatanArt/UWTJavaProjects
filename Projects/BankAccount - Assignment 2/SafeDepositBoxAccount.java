/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 2
* 
* File Name:   SafeDepositBoxAccount.java
*/

/**
* This program is a class that represents a safe deposit box account. 
* It is separate from a normal bank account since the bank does not know
* what it contains. This class will only allow the AccountTester to know
* the owner's name.
*
* @author Natan Artemiev
* @version 8 April 2023
*/
public class SafeDepositBoxAccount implements NamedAccount {
   /**
   * This stores the customer's (Account Owners) name.
   */
   private String myAccountHolderName;
   
   /**
   * This method is the constructor method for SafeDepositBoxAccount.
   * It sets myAccountholderName to theAccountHolderName passed in.
   */
   public SafeDepositBoxAccount(final String theAccountHolderName) {
      myAccountHolderName = theAccountHolderName;
   }
   
   /**
   * This is a method that is requried by the NamedAccount Interface,
   * to get the account holder's name.
   * 
   * @return the cutomer's name.
   */
   public String getAccountHolderName() {
      return myAccountHolderName;
   }
   
   /**
   * This is a method that is requried by the NamedAccount Interface,
   * to set a new account holder's name to the current account. 
   */
   public void setAccountHolderName(final String theNewName) {
      myAccountHolderName = theNewName;
   }
   
   /**
   * This is a method that prints out information about the account in a
   * format that is specified by the Assignment.
   * 
   * @return a String that contains the account info and required format.
   */
   public String toString() {
      return  "SafeDepositBoxAccount[owner: " + myAccountHolderName + "]";
   }
}