package Scenes;

import Components.RenderComponent;
import Main.GameObject;
import Main.Scene;

public class Scene01 extends Scene {
    @Override
    protected void LoadScene() {
        AddGameObject(new GameObject(10,10));
        Find(0).AddComponent(new RenderComponent("g1.jpg"));
        AddGameObject(new GameObject(100,100));
        Find(1).AddComponent(new RenderComponent("g2.jpg"));
    }
}
