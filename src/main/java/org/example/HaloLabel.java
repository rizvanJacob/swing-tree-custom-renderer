package org.example;

import javax.swing.*;
import java.awt.*;

public class HaloLabel extends JLabel {

    public HaloLabel(String text) {
        super(text);
        setFont(getFont().deriveFont(Font.BOLD).deriveFont(24f));
        setForeground(Color.RED);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Enable anti-aliasing for smoother edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the font color (halo color) and position offsets for halo
        g2d.setColor(Color.BLACK);
        int offset = 2;
        for (int x = -offset; x <= offset; x++) {
            for (int y = -offset; y <= offset; y++) {
                if (x != 0 || y != 0) { // Skip the center (original text)
                    g2d.drawString(getText(), getInsets().left + x, getInsets().top + getFontMetrics(getFont()).getAscent() + y);
                }
            }
        }

        // Draw the main text in the desired foreground color
        g2d.setColor(getForeground());
        g2d.drawString(getText(), getInsets().left, getInsets().top + getFontMetrics(getFont()).getAscent());

        g2d.dispose();
    }
}
