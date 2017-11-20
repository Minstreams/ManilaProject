package Test;

import Components.ExampleComponent;
import Components.RenderComponent;
import Main.GameObject;
import Main.GameView;
import Systems.ExampleSystem;
import Systems.InputSystem;
import Systems.RenderSystem;

public class Test {
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
        g2.GetComponent(RenderComponent.class).ChangePos(g2.x, g2.y);
    }
}
