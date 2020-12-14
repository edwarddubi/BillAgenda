package model;

import java.util.ArrayList;

/**
 * Class that models an Agenda 
 * @author Pedro Guillermo Feij�o-Garc�a
 */
public class Agenda 
{	
	/*
	 * These are the relationships with the Friend class
	 */
	
	/**
	 * List of all Luke's friends in the Agenda App
	 */
	private ArrayList<Friend> friendList;
	
	/**
	 * Constructor method that creates an instance of an Agenda
	 */
	public Agenda()
	{
		friendList = new ArrayList<>();
	}
	
	/*
	 * These methods are called "Getters"
	 * They are in charge of retrieving particular values of the object
	 */

	/**
	 * Method that returns the number of friends in the Agenda
	 * @return the number of friends
	 */
	public int getNumberOfFriends() 
	{
		return friendList.size();
	}

	/**
	 * Method that returns the first Friend of the Agenda
	 * @return the first Friend
	 */
	public ArrayList<Friend> getFriends() 
	{
		return friendList;
	}
	/*
	 * These methods correspond to the Functional Requirements
	 * They directly address the actions/operations/services the user wants to be able to do with the Software
	 */
	
	/**
	 * Method that adds a new Friend to the Agenda
	 * @param friend Friend to be added to the Agenda
	 * @return true if the Friend is added to the Agenda. False otherwise.
	 */
	public boolean addFriend(String name, String phoneNumber) throws Exception
	{
		if(isNullEmpty(name)){
			throw new Exception("You have to input a name."); 
		}
		if(isNullEmpty(phoneNumber)){
			throw new Exception("You have to input a phone number."); 
		}
		if(phoneNumberExists(phoneNumber)){
			throw new Exception("Your friend already exists!");
		}
		friendList.add(new Friend(name, phoneNumber));
		return true;
	}

	private boolean isNullEmpty(String item){
		if(item == null || item.isEmpty()){
			return true;
		}
		return false;
	}
	
	/**
	 * Method that searches for a Friend by an input name
	 * @param name name of the Friend looked for
	 * @return the Friend corresponding to the input name. Null if he/she does not exist.
	 */
	public Friend searchFriend(String name) throws Exception
	{
		int index = -1;
		if(getNumberOfFriends() == 0){
			throw new Exception("You still have no friends in the agenda.");
		}else{
			for (int i = 0; i < getNumberOfFriends(); i++){
				String friend_name = friendList.get(i).getName();
				if(friend_name != null && friend_name.toLowerCase().equals(name.toLowerCase())){
					index = i;
					break;
				}
	
			}
		}
		
		
		if(index == -1){
			throw new Exception("You don't have a friend with that name.");
		}else{
			return friendList.get(index);
		}
	}
	
	
	public boolean removeFriend(String name) throws Exception
	{
		if(getNumberOfFriends() == 0){
			throw new Exception("You still have no friends in the agenda.");
		}else{
			try{
				Friend friend = searchFriend(name);
				friendList.remove(friend);
			}catch(Exception e){
				throw new Exception(e.getMessage());
			}

		}
		return true;
	}

	public void updatePhoneNumber(String name, String phoneNumber) throws Exception
	{
		//int i = 0, index  = -1;
		if(getNumberOfFriends() == 0){
			throw new Exception("You still have no friends in the agenda.");
		}else{
			try{
				Friend friend = searchFriend(name);
				friend.setPhoneNumber(phoneNumber);
			}catch(Exception e){
				throw new Exception(e.getMessage());
			}
		}
		
	}

	public boolean phoneNumberExists(String phoneNumber){
		int i = 0;
		while(i < getNumberOfFriends()){

			String friend_phone_number = friendList.get(i).getPhoneNumber();

			if(friend_phone_number != null && friend_phone_number.toLowerCase().equals(phoneNumber.toLowerCase())){
				return true;
			}
			i++;
		}	
		return false;
	}
	
	
}
