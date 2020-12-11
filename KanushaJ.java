package prog;
import robocode.*;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/JuniorRobot.html
//Contributors:
// *     Flemming N. Larsen
// *     - Initial implementation
/**
 * Neej - a robot by (your name here)
 */
public class KanushaJ extends JuniorRobot
{
	/**
	 * run: Neej's default behavior
	 */

	/**
	 * MyFirstJuniorRobot's run method - Seesaw as default
	 */
	public void run() {
		// Set robot colors
		setColors(black, black, black);

		// Seesaw forever
		while (true) {
			ahead(100); // Move ahead 100
			turnGunRight(360); // Spin gun around
			back(100); // Move back 100
			turnGunRight(360); // Spin gun around
		}
	}

	/**
	 * When we see a robot, turn the gun towards it and fire
	 */
	public void onScannedRobot() {
		// Turn gun to point at the scanned robot
		turnGunTo(scannedAngle);

		// Fire!
		fire(1);
	}

	/**
	 * We were hit!  Turn and move perpendicular to the bullet,
	 * so our seesaw might avoid a future shot.
	 */
	public void onHitByBullet() {
		// Move ahead 100 and in the same time turn left papendicular to the bullet
		turnAheadLeft(100, 90 - hitByBulletBearing);
	}
}
