package Main;

import java.util.Calendar;
import java.util.TimerTask;

public class GameWorld extends TimerTask{
	public static int SystemNum = 0;
	private void GameLoop() {
		
	}

	public static void delaySeconds(float s) {
		long o = System.currentTimeMillis();
		long delta = (long)s*1000;
		while(System.currentTimeMillis()-o <= delta) {
			
		}
	}

	@Override
	public void run() {
		GameLoop();
	}
}
