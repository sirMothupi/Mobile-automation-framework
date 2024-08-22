package org.greyytechnologies.enablers;

public class TestEnablers
{
    /*public void android_scroll_down(int numOfSwipes) throws InterruptedException {
        for (int i = 1; i <= numOfSwipes; i++) {
            try {
                Dimension dimension = androidDriver.manage().window().getSize();

                int height = (int) dimension.getHeight();
                int width = dimension.getWidth();
                int x = width / 2;
                int starty = (int) (height * 0.7);
                int endy = (int) (height * 0.20);
                swipe(x, starty, x, endy, 800);
            } catch (Exception e) {
            }
        }
    }*/

    /*public static void swipe(int startx, int starty, int endx, int endy, int duration) {
        new TouchAction(androidDriver).press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).
                moveTo(PointOption.point(endx, endy)).release().perform();
    }*/
}
