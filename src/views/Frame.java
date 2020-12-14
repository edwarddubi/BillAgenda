package views;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.Controller;

import java.awt.*;

public class Frame extends JFrame {
    private static final long serialVersionUID = 1L;
    private InfoPanel infoPanel;
    private ActionsPanel actionsPanel;
    private Controller controller;

    public Frame(Controller controller){
        this.controller = controller;
        this.setLayout(new BorderLayout());
        infoPanel = new InfoPanel();
        actionsPanel = new ActionsPanel(controller);
        
        this.add(actionsPanel, BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.SOUTH);
        this.setSize(new Dimension(350, 270));
        this.setResizable(false);
        

        this.setTitle("Luke's Agenda");

        

    }

    public void displayMessage(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }

    public String getInput(String msg){
        return JOptionPane.showInputDialog(this, msg);
    }

    public void UpdateInfoView(int num_friends){
        infoPanel.updateFriendSize(num_friends);
    }
    
}
