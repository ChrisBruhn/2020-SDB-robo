package prog2;
import robocode.*;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/JuniorRobot.html

/**
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
