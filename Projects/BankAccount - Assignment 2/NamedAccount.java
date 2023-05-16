/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 1
* 
* File Name:   NamedAccount.java
*/

/**
* This program is an interface that represents a named account.
* All classes that implement this interface must implement the
* abstract methods that it specifies. 
*
* @author Natan Artemiev
* @version 8 April 2023
*/
public interface NamedAccount {
   /**
   * This abastract method is something that NamedAccount requires
   * other classes to override. It gets the account holder's name.
   */   
   String getAccountHolderName();
   
   /**
   * This abastract method is something that NamedAccount requires
   * other classes to override. It will set the account holder's name
   * theNewName that is passed into the method.
   */
   void setAccountHolderName(final String theNewName);
}