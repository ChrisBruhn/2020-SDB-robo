package Borg;

import robocode.*;
import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;

import java.awt.*;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * BorgRobotPredictive - a robot by (your name here)
 */
public class BorgRobotPredictive extends AdvancedRobot
{
	/**
	 * run: BorgRobotPredictive's default behavior
	 */
	
	boolean foundTarget = false;

	public void run() {
		// Initialization of the robot should be put here
		setAdjustGunForRobotTurn(true);
		setAdjustRadarForGunTurn(true);
		setAdjustRadarForRobotTurn(true);
		
		setColors(Color.black, Color.green, Color.blue, Color.yellow, Color.green); // body,gun,radar
		
		// Initial move to align
		turnLeft(getHeading());

		// Robot main loop
		while(true) {
			execute();

			setAhead(50);

			
			if(foundTarget == false){
				setTurnRadarRight(20);
			}
			
			foundTarget = false;
		}
	}

	// onScannedRobot: What to do when you see another robot
	public void onScannedRobot(ScannedRobotEvent e) {
		foundTarget = true;

		// Calculate bullet power
		double bulletPower = 1.5;
		double bulletVelocity = 20 - (3 * bulletPower);
		// Calculate radar
		double absAngleToTarget = getHeading() + e.getBearing();
		double bearingFromRadarToTarget = normalRelativeAngleDegrees(absAngleToTarget - getRadarHeading());
		// Calculate predicted target position
		// Calculate angles
		double angleToMeFromTarget = 180 + absAngleToTarget;
		double angleToPredictedFromMe = Math.abs(angleToMeFromTarget - e.getHeading());
		double absAngleToPredicted = getHeading() + (e.getBearing() + targetAimPredictionSin(angleToPredictedFromMe, e.getVelocity(), bulletVelocity));
		
		double bearingFromGunToPredict = normalRelativeAngleDegrees(absAngleToPredicted - getGunHeading());
		
		// Move gun
		if(Math.abs(bearingFromGunToPredict) <= 3){
			setTurnGunRight(bearingFromGunToPredict);
			if(getGunHeat() == 0){
				fire(bulletPower);
			}
		} else {
			setTurnGunRight(bearingFromGunToPredict);
		}
		// Move radar
		setTurnRadarRight(bearingFromRadarToTarget);
		if(bearingFromRadarToTarget == 0){
			scan();
		}
	}

	// onHitByBullet: What to do when you're hit by a bullet
	public void onHitByBullet(HitByBulletEvent e) {
		back(50);
		turnRight(90);
		ahead(50);
	}

	// onHitWall: What to do when you hit a wall
	public void onHitWall(HitWallEvent e) {
		turnRight(90);
		setTurnRadarRight(360);
	}
	
	// onHitRobot: What to do when you hit a robot
	public void onHitRobot(HitRobotEvent e){
		back(60);
		turnRight(90);
		ahead(50);
	}
	
	// Predictive calculation
	public double targetAimPredictionSin(double theta, double v_T, double v_B){
		double thetaR = Math.toRadians(theta);
		double angleR = Math.asin(Math.sin(thetaR) * v_T / v_B);
		double angle = Math.toDegrees(angleR);
		
		return angle;
	}
}
