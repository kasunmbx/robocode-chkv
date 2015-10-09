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

public class BotMain extends AdvancedRobot
{
	Move move;
	Fire fire;
	Survive survive;

	public void run() {
		setAdjustRadarForGunTurn(false);

		move = new Move(this);
		fire = new Fire();
		survive = new Survive();

		setColors(Color.red,Color.blue,Color.green); // body,gun,radar

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
		fire(2);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(30);
		move.move(this);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}
}
