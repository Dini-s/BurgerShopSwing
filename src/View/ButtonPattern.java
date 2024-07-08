package View;

import javax.swing.*;
import java.awt.*;

public class ButtonPattern extends JButton {
    private int borderRadius;

    public ButtonPattern(String text, int borderRadius) {
        super(text);
        this.borderRadius = borderRadius;
        setContentAreaFilled(false);
        setFocusPainted(false); // Remove the focus border
        setBackground(Color.RED);
        setForeground(Color.WHITE);
        setFont(new Font("",Font.PLAIN,15));

    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, borderRadius, borderRadius); // Use the borderRadius variable
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, borderRadius, borderRadius); // Use the borderRadius variable
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
        repaint(); // Repaint the button to reflect the change
    }
}
