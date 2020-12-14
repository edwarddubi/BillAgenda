package Controller;

import model.Agenda;
import model.Friend;
import views.Frame;

public class Controller{
    private Agenda agenda;
    private Frame frame;
    private IOFileReader ioFileReader;
    public Controller(){
        agenda = new Agenda();
        frame = new Frame(this);
        ioFileReader = new IOFileReader(agenda);
        try{
            ioFileReader.readFile();
        }catch(Exception e){
            frame.displayMessage(e.getMessage());
        }
        
        frame.UpdateInfoView(agenda.getNumberOfFriends());
        frame.setVisible(true);
    }

    public int getAllFriends(){
        return agenda.getNumberOfFriends();
    }

    public void writeFileOnExit(){
        try{
            ioFileReader.writeFile();
        }catch(Exception e){
            frame.displayMessage(e.getMessage());
        } 
    }

    public void addNewFriend(){
        String name = frame.getInput("Please input friend's name:");
        String phoneNumber = frame.getInput("Please input friend's phone number:");
        try{
            boolean added = agenda.addFriend(name, phoneNumber);
            if(added){
                String msg = "Your friend has been successfully added.";
                frame.UpdateInfoView(getAllFriends());
                frame.displayMessage(msg);
                
            }
        }catch(Exception e){
            frame.displayMessage(e.getMessage());
        }
        
    }

    public void removeFriend(){
        String name = frame.getInput("Please input friend's name:");
        try{
            boolean removed = agenda.removeFriend(name);
            if(removed){
                String msg = "Your friend was successfully removed.";
                frame.UpdateInfoView(getAllFriends());
                frame.displayMessage(msg);
                
            }
        }catch(Exception e){
            frame.displayMessage(e.getMessage());
        }
        
    }

    public void searchForFriend(){
        String name = frame.getInput("Please input friend's name:");
        try{
            Friend friend = agenda.searchFriend(name);
            String msg = "Found: Name is " + friend.getName() + " and Number is " + friend.getPhoneNumber() + ".";
            frame.displayMessage(msg);
        }catch(Exception e){
            frame.displayMessage(e.getMessage());
        }
        
    }

    public void updateFriendNumber(){
        String name = frame.getInput("Please input friend's name:");
        String phoneNumber = frame.getInput("Please input friend's phone number:");
        try{
            agenda.updatePhoneNumber(name, phoneNumber);
            String msg = "Your friend's number was updated.";
            frame.displayMessage(msg);
        }catch(Exception e){
            frame.displayMessage(e.getMessage());
        }
        
    }



}
