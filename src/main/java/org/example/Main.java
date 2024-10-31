package org.example;

import org.example.tree.Tree;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        var frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400,300);

        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Normal Label"));
        panel.add(new HaloLabel("Halo Text"));
        panel.add(new Tree());

        frame.add(panel);
        frame.setVisible(true);
    }
}
