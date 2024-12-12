package InventoryPackage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;

public class CustomSwingComponents {

    // Custom RoundedTextField class
	public static class RoundedTextField extends JTextField {
	    private static final long serialVersionUID = 4928136926295862156L;
	    private int arcWidth;
	    private int arcHeight;
	    private Insets customInsets; // Custom insets for padding

	    public RoundedTextField(int arcWidth, int arcHeight) {
	        super();
	        this.arcWidth = arcWidth;
	        this.arcHeight = arcHeight;
	        this.customInsets = new Insets(5, 10, 5, 5); // Top, Left, Bottom, Right padding
	        setOpaque(false); // Make the background transparent
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        RoundedComponentUtils.paintRoundedComponent(
	                g, getWidth(), getHeight(), arcWidth, arcHeight, getBackground(), getForeground(), false);
	        super.paintComponent(g);
	    }

	    @Override
	    public Insets getInsets() {
	        return customInsets; // Return the custom insets
	    }

	    @Override
	    public void setBorder(Border border) {
	        // Prevent the default border from being painted
	    }
	}
    
    public static class RoundedPasswordField extends JPasswordField {
        /**
		 * 
		 */
		private static final long serialVersionUID = 6647935545931251707L;
		private int arcWidth;
        private int arcHeight;
        private Insets customInsets; // Custom insets for padding

        public RoundedPasswordField(int arcWidth, int arcHeight) {
            super();
            this.arcWidth = arcWidth;
            this.arcHeight = arcHeight;
            setOpaque(false); // Make the background transparent
            
            this.customInsets = new Insets(5, 10, 5, 5);
        }

        @Override
        protected void paintComponent(Graphics g) {
        	RoundedComponentUtils.paintRoundedComponent(
                    g, getWidth(), getHeight(), arcWidth, arcHeight, getBackground(), getForeground(), false);
            super.paintComponent(g);
        }
        
        @Override
	    public Insets getInsets() {
	        return customInsets; // Return the custom insets
	    }

        @Override
        public void setBorder(Border border) {
            // Prevent the default border from being painted
        }
    }
    
    public static class RoundedButton extends JButton {
        /**
		 * 
		 */
		private static final long serialVersionUID = -7109684015067773105L;
		private int arcWidth;
        private int arcHeight;

        public RoundedButton(String text, int arcWidth, int arcHeight) {
            super(text);
            this.arcWidth = arcWidth;
            this.arcHeight = arcHeight;
            setContentAreaFilled(false); // Disable default background painting
        }

        @Override
        protected void paintComponent(Graphics g) {
            RoundedComponentUtils.paintRoundedComponent(
                    g, getWidth(), getHeight(), arcWidth, arcHeight, getBackground(), getForeground(), getModel().isPressed());
            super.paintComponent(g);
        }

        @Override
        public void paintBorder(Graphics g) {
            // Prevent default border painting
        }
    }
    
    public static class RoundedPanel extends JPanel {

        private static final long serialVersionUID = -2135189083898044417L;

        private int arcWidth;
        private int arcHeight;
        private Image backgroundImage;
        
        private boolean setBorder = false;

        public RoundedPanel(int arcWidth, int arcHeight) {
            super();
            this.arcWidth = arcWidth;
            this.arcHeight = arcHeight;
            this.setBorder(null);
            this.setForeground(null);
        }

        public void setBackgroundImage(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
            repaint(); // Repaint the panel to show the new image
        }
        
        public void setBorder() {
        	this.setBorder = true;
        	repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Clip the painting area to a rounded rectangle
            Shape clip = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
            g2d.setClip(clip);

            // Paint background image if available
            if (backgroundImage != null) {
                g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            } else {
                // Paint rounded background
                g2d.setColor(getBackground());
                g2d.fill(clip);
            }

            // Draw border explicitly
            
            if (setBorder) {
            	g2d.setColor(getForeground());
                g2d.draw(new RoundRectangle2D.Float(0.5f, 0.5f, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight));
			}

            g2d.dispose();

            // Remove default background painting entirely
        }
    }
}
