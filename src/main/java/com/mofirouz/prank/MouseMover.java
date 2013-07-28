package com.mofirouz.prank;

import java.awt.*;
import java.util.Random;

/**
 * 26/07/2013 16:51
 */
public class MouseMover {
    private static final Random random = new Random();
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final Robot robot;

    public MouseMover() throws AWTException {
        robot = new Robot();
    }

    public void move(int distance, int speed, boolean jiggle) throws InterruptedException {
        double screenSizeWidth = screenSize.getWidth();
        double screenSizeHeight = screenSize.getHeight();

        boolean xNegative = random.nextBoolean();
        boolean yNegative = random.nextBoolean();

        while (distance > 0) {
            if (jiggle) {
                xNegative = random.nextBoolean();
                yNegative = random.nextBoolean();
            }

            PointerInfo mouseInfo = MouseInfo.getPointerInfo();
            Point currentPos = mouseInfo.getLocation();
            int mouseX = currentPos.x;
            int mouseY = currentPos.y;

            if (mouseX == 0 || mouseX == screenSizeWidth)
                xNegative = !xNegative;
            else if (mouseY == 0 || mouseY == screenSizeHeight)
                yNegative = !yNegative;

            if (xNegative)
                mouseX--;
            else
                mouseX++;

            if (yNegative)
                mouseY--;
            else
                mouseY++;

            robot.mouseMove(mouseX, mouseY);
            Thread.sleep(speed);
            distance--;
        }
    }
}
