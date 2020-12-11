package prog2;
import robocode.*;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/JuniorRobot.html

/**
 * Goddag - a robot by (your name here)
 */
public class Goddag extends JuniorRobot
{
	/**
	 * run: Goddag's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here
		
		
		// Some color codes: blue, yellow, black, white, red, pink, brown, grey, orange...
		// Sets these colors (robot parts): body, gun, radar, bullet, scan_arc
		setColors(purple, purple, blue, black, black);

		// Robot main loop
		while (true) {
			turnGunRight(360);
			ahead(100);
			// Repeat.
			}
		
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot() {
		// Replace the next line with any behavior you would like
		turnGunTo(scannedAngle);
		if(scannedDistance<75){
			fire(3);
			  turnBackLeft(150,80);
			  gunHeading=gunHeading-40;
			  gunHeading=gunHeading+80;
		}
		else{
			heading=heading-90;
					turnBackLeft(100,30);
		}
	}
		


	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet() {
		// Replace the next line with any behavior you would like
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall() {
		// Replace the next line with any behavior you would like
		turnBackLeft(150,60);
		turnAheadLeft(100,60);
	}	
}
