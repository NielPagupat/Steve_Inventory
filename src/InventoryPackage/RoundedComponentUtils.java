package InventoryPackage;

import java.awt.*;

public class RoundedComponentUtils {

    /**
     * Paints a rounded rectangle with the specified parameters.
     *
     * @param g         the Graphics instance
     * @param width     the width of the component
     * @param height    the height of the component
     * @param arcWidth  the width of the corner arcs
     * @param arcHeight the height of the corner arcs
     * @param bgColor   the background color
     * @param borderColor the border color
     * @param isPressed whether the component is in a pressed state
     */
    public static void paintRoundedComponent(Graphics g, int width, int height, int arcWidth, int arcHeight,
                                             Color bgColor, Color borderColor, boolean isPressed) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set background color
        if (isPressed) {
            g2.setColor(bgColor.darker());
        } else {
            g2.setColor(bgColor);
        }
        g2.fillRoundRect(0, 0, width, height, arcWidth, arcHeight);

        // Set border color
        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, width - 1, height - 1, arcWidth, arcHeight);

        g2.dispose();
    }
}
