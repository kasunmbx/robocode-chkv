package chkv.movement;

import chkv.*;

/**
 * Created by HirSlk on 10/9/2015
 */

public class Move {

    double bFHeight;
    double bFWidth;

    public Move (BotMain bot) {
        bFHeight = bot.getBattleFieldHeight();
        bFWidth = bot.getBattleFieldWidth();
    }

    public void move (BotMain bot) {
        double myX = bot.getX();
        double myY = bot.getY();
        double myHeading = bot.getHeading();

        boolean turnRight = false;
        boolean turnLeft = false;

        if (myHeading < 90) {
            if ((150 * Math.cos(Math.toRadians(myHeading%90))) > (bFHeight - myY)) {
                turnRight = true;
            }
            if ((150 * Math.sin(Math.toRadians(myHeading%90))) > (bFWidth - myX)) {
                turnLeft = true;
            }
        } else if (90 <= myHeading && myHeading < 180) {
            if ((150 * Math.sin(Math.toRadians(myHeading % 90))) > (myY)) {
                turnLeft = true;
            }
            if ((150 * Math.cos(Math.toRadians(myHeading % 90))) > (bFWidth - myX)) {
                turnRight = true;
            }
        } else if (180 <= myHeading && myHeading < 270) {
            if ((150 * Math.cos(Math.toRadians(myHeading%90))) > (myY)) {
                turnRight = true;
            }
            if ((150 * Math.sin(Math.toRadians(myHeading%90))) > (myX)) {
                turnLeft = true;
            }
        } else if (270 <= myHeading) {
            if ((150 * Math.sin(Math.toRadians(myHeading % 90))) > (bFHeight - myY)) {
                turnLeft = true;
            }
            if ((150 * Math.cos(Math.toRadians(myHeading % 90))) > (myX)) {
                turnRight = true;
            }
        }

        if ((turnLeft == true) && (turnRight == true)) {
            bot.setTurnRight(180);
        } else if (turnLeft == true) {
            bot.setTurnLeft(90);
        } else if (turnRight == true) {
            bot.setTurnRight(90);
        }

        bot.setAhead(1000);
    }

}
