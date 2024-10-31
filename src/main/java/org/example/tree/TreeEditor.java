package org.example.tree;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class TreeEditor extends DefaultTreeCellEditor {
    private final JTextField textField = new JTextField(20);

    public TreeEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
        textField.addActionListener(event -> {
            System.out.printf("stopping editing");
            stopCellEditing();
        });
    }

    @Override
    public boolean isCellEditable(EventObject event) {
        if (super.isCellEditable(event) && event instanceof MouseEvent mouseEvent) {
            var path = tree.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
            if (path != null && path.getLastPathComponent() instanceof TreeNode node) {
                return node.getParent() == null; //only allow editing of tree node
            }
        }
        return false;
    }

    @Override
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }

    @Override
    public Object getCellEditorValue() {
        var trimmed = textField.getText().trim();
        return trimmed.substring(0, Math.min(trimmed.length(), 20));
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
        textField.setText(value.toString());
        return textField;
    }

}
