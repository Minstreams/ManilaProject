package Main;

import Components.*;
import Systems.*;

public class GameWorld {
	public static int SystemNum = 0;
	private void GameLoop() {
		
	}
	public static void main(String[] args) {
		GameObject g = new GameObject();
		g.AddComponent(new RenderComponent());
		g.AddComponent(new ExampleComponent());
		GameObject g2 = new GameObject(g);
		g2.AddComponent(new RenderComponent());
		RenderSystem.Function();
		ExampleSystem.Function();
		InputSystem.Function();
	}

}
