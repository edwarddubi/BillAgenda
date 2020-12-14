package views;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class InfoPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel numberOfFriends;

    public InfoPanel(){
        this.setLayout(new BorderLayout());
        numberOfFriends = new JLabel("Friends: ");
        this.add(numberOfFriends, BorderLayout.CENTER);

        TitledBorder title = new TitledBorder("Information");
        this.setBorder(title);
    }

    public void updateFriendSize(int friends){
        numberOfFriends.setText("Friends: " + friends);
        this.validate();
    }
    
}
