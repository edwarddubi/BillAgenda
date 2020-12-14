package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import model.Agenda;
import model.Friend;

public class IOFileReader {

    private Agenda agenda;

    public IOFileReader(Agenda agenda){
        this.agenda = agenda;

    }

    public void readFile() throws Exception{
        BufferedReader buffer = new BufferedReader(new FileReader(new File("./data/friends.txt")));
        String line = buffer.readLine();
        int c = 0;
        while(line != null){
            if(c == 1){
                String[] info = line.split(",");
                String name = info[0];
                String phoneNumber = info[1];
                agenda.addFriend(name, phoneNumber);
            }
            line = buffer.readLine();
            if(c == 0){
                c++;
            }
        }
        buffer.close();

    }

    public void writeFile() throws Exception{
        PrintWriter printWriter = new PrintWriter(new File("./data/friends.txt"));
        int num_of_friends = agenda.getNumberOfFriends();
        String line = "Number of Friends: " + num_of_friends;
        printWriter.println(line);
        
        for(int i = 0; i < num_of_friends; i++){
            Friend friend = agenda.getFriends().get(i);
            line = friend.getName() + ", " + friend.getPhoneNumber();
            printWriter.println(line);
        }
        printWriter.close();

    }
    
}
