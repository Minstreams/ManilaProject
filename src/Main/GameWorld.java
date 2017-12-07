package Main;

import Systems.InputSystem;
import Systems.RenderSystem;

import java.util.Timer;
import java.util.TimerTask;

/*
游戏世界类，游戏循环，起始均从这里开始
 */
public class GameWorld extends TimerTask{

	private Timer timer = new Timer();

	private Scene currentScene = null;

	public GameWorld(Scene scene){
		LoadScene(scene);
		RenderSystem.Start();
		InputSystem.Start();
		//开始游戏循环
		this.timer.schedule(this,0,25);
	}

	/**
	 *
	 * @param toLoad
	 */
	public void LoadScene(Scene toLoad){
		currentScene = toLoad;
	}

	/**
	 * 延迟阻塞s秒
	 * @param s
	 */
	public static void delaySeconds(float s) {
		long o = System.currentTimeMillis();
		long delta = (long)s*1000;
		while(System.currentTimeMillis()-o <= delta) {

		}
	}
	/**
	 * 游戏循环，每25毫秒调用
	 */
	private void GameLoop() {
		RenderSystem.Function();
		InputSystem.Function();
	}
	@Override
	public void run() {
		GameLoop();
	}
}
