package org.example.tree;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;
import java.awt.*;

public class TreeRenderer extends DefaultTreeCellRenderer {
    private final JPanel treePanel;
    private final JLabel treeLabel, categoryLabel, itemLabel;
    public TreeRenderer() {
        treePanel = new JPanel();
        treePanel.add(new JLabel("12345: "));
        treeLabel = new JLabel();
        treeLabel.setForeground(Color.RED);
        treePanel.add(treeLabel);
        treePanel.add(new JLabel("Status"));
        categoryLabel = new JLabel();
        categoryLabel.setForeground(Color.BLUE);
        itemLabel = new JLabel();
        itemLabel.setForeground(Color.GREEN);
        setBackgroundSelectionColor(Color.LIGHT_GRAY);
    }

    public JPanel getTreePanel() {
        return treePanel;
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        if (leaf) {
            itemLabel.setText(value.toString());
            return itemLabel;
        } else if (value instanceof TreeNode node && node.getParent() == null) {
            treeLabel.setText(value.toString());
            return treePanel;
        } else {
            categoryLabel.setText(value.toString());
            return categoryLabel;
        }
    }
}
