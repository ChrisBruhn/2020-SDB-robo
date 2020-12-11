package prog;
import robocode.*;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/JuniorRobot.html

/**
 * BorgJuniorRobot - a robot by (your name here)
 */
public class BorgJuniorRobot extends JuniorRobot
{
	/**
	 * run: BorgJuniorRobot's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// Some color codes: blue, yellow, black, white, red, pink, brown, grey, orange...
		// Sets these colors (robot parts): body, gun, radar, bullet, scan_arc
		setColors(black, green, blue, yellow, green);
		turnTo(0);

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			turnGunRight(360);
			ahead(100);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot() {
		// Replace the next line with any behavior you would like
		int dGunAngle = Math.abs(scannedAngle - gunHeading);
		
		turnGunTo(scannedAngle);
		if(gunReady == true && scannedDistance < 800 && dGunAngle <= 3){
			fire(1);
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet() {
		// Replace the next line with any behavior you would like
		turnRight(90);
		ahead(100);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall() {
		// Replace the next line with any behavior you would like
		turnRight(90);
		turnGunLeft(90);
	}	
}
