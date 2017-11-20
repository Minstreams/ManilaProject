package Scenes;

import Components.RenderComponent;
import Main.GameObject;
import Main.Scene;

public class Scene01 extends Scene {
    @Override
    protected void LoadScene() {
        GameObject g = new GameObject(10,10);
        g.AddComponent(new RenderComponent("g1.jpg"));
        GameObject g2 = new GameObject(100,100);
        g2.AddComponent(new RenderComponent("g2.jpg"));
    }
}
