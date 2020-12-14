package views;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Controller.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionsPanel extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JButton mAddFriend, mRemoveFriend, mSearchFriend, mUpdatePhoneNumber;
    private static final String ADD = "add";
    private static final String REMOVE = "remove";
    private static final String SEARCH = "search";
    private static final String UPDATE = "update";
    private Controller controller;

    public ActionsPanel(Controller controller) {
        this.controller = controller;
        this.setLayout(new GridLayout(4, 1));

        mAddFriend = new JButton("Add Friend");
        mAddFriend.setActionCommand(ADD);
        mAddFriend.addActionListener(this);

        mRemoveFriend = new JButton("Remove Friend");
        mRemoveFriend.setActionCommand(REMOVE);
        mRemoveFriend.addActionListener(this);

        mSearchFriend = new JButton("Search Friend");
        mSearchFriend.setActionCommand(SEARCH);
        mSearchFriend.addActionListener(this);

        mUpdatePhoneNumber = new JButton("Update #");
        mUpdatePhoneNumber.setActionCommand(UPDATE);
        mUpdatePhoneNumber.addActionListener(this);

        this.add(mAddFriend);
        this.add(mRemoveFriend);
        this.add(mSearchFriend);
        this.add(mUpdatePhoneNumber);

        TitledBorder title = new TitledBorder("Actions");
        this.setBorder(title);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String cmd = e.getActionCommand().toLowerCase();
        switch(cmd){
            case ADD:
                controller.addNewFriend();
                break;
            case REMOVE:
                controller.removeFriend();
                break;
            case SEARCH:
                controller.searchForFriend();
                break;
            case UPDATE:
                controller.updateFriendNumber();
                break;
            default:
                break;
        }

    }
    
}
