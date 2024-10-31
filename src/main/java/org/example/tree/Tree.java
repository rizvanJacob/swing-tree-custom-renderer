package org.example.tree;

import javax.swing.*;
import java.awt.*;

public class Tree extends JTree {
    public Tree() {
        super();
        var renderer = new TreeRenderer();
        setCellRenderer(renderer);
        setEditable(true);
        var editor = new TreeEditor(this, renderer);
        setCellEditor(editor);
        setMinimumSize(new Dimension(50, 0));
    }
}
