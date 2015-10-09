package chkv;

import chkv.Survival.*;
import chkv.firing.*;
import chkv.movement.*;
import robocode.*;
import java.awt.Color;

/**
 * Created by HirSlk on 10/9/2015
 * API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html
 */

public class BotMain extends Robot
{
	public void run() {
		setColors(Color.red,Color.blue,Color.green); // body,gun,radar

        Move move = new Move();
        Fire fire = new Fire();
        Survive survive = new Survive();

		while(true) {
            try {
                move.move(this);
                fire.fire(this);
                survive.survive(this);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}
}
