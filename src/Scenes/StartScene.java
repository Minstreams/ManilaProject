package Scenes;

import Components.RenderComponent;
import Main.GameObject;
import Main.Scene;

public class StartScene extends Scene {

    @Override
    protected void LoadScene() {
        AddGameObject(new GameObject(10,10,0));
        Find(0).AddComponent(new RenderComponent("boat.jpg"));
    }
}
