package model;

/**
 * Class that models a Friend 
 * @author Edward Mensah
 */
public class Friend 
{
	/**
	 * Friend's name
	 * Friend's phone number
	 */
	private String name, phoneNumber;
	/**
	 * 
	 */

	public Friend(){
		this.name = "";
		this.phoneNumber = "";
	}
	
	/**
	 * Constructor method that creates an instance of a Friend
	 * @param name input name of the new Friend
	 * @param phoneNumber input phone number of the new Friend
	 */
	public Friend(String name, String phoneNumber)
	{
		
		this.name = name;
		this.phoneNumber = phoneNumber;

	}
	
	/*
	 * These methods are called "Getters"
	 * They are in charge of retrieving particular values of the object
	 */
	
	/**
	 * Method that returns the name of the Friend
	 * @return the name of the friend
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Method that returns the phone number of the Friend
	 * @return the phone number of the friend
	 */
	//COMPLETE Declare and complete the code of this method
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	
	/*
	 * These methods are called "Setters"
	 * They are in charge of updating particular values of the object
	 */
	
	/**
	 * Method that updates the name of the Friend
	 * @param name new value of the attribute "name"
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * Method that updates the phone number of the Friend
	 * @param phoneNumber new value of the attribute "phone number"
	 */
	//COMPLETE Declare and complete the code of this method
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
}
