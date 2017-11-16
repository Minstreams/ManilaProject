package Main;

import java.util.Calendar;

import Components.*;
import Systems.*;

public class GameWorld {
	public static int SystemNum = 0;
	private void GameLoop() {
		
	}
	public static void main(String[] args) {
		GameView gameView = new GameView();
		gameView.CreatView();
		GameObject g = new GameObject(10,10);
		g.AddComponent(new RenderComponent("g1.jpg"));
		g.AddComponent(new ExampleComponent());
		GameObject g2 = new GameObject(100,100);
		g2.AddComponent(new RenderComponent("g2.jpg"));
		RenderSystem.Function();
		ExampleSystem.Function();
		InputSystem.Function();
		gameView.PaintGameObject(g);
		gameView.PaintGameObject(g2);
		delaySeconds(1);
		g2.GetComponent(RenderComponent.class).ChangePos(g2.x, g2.y);
	}

	public static void delaySeconds(int s) {
		int o = nowSecond();
		while(nowSecond()-o <= s) {
			
		}
		
	}
	
	private static int nowSecond() {
		int second = 0;
		Calendar c = Calendar.getInstance();
		second = c.get(Calendar.SECOND) + c.get(Calendar.MINUTE)*60;
		return second;
	}
}
