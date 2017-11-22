package Scenes;

import Components.RenderComponent;
import Main.GameObject;
import Main.Scene;

/**
 * 示例场景
 */
public class Scene01 extends Scene {
    @Override
    protected void LoadScene() {
        AddGameObject(new GameObject(50,10,1));
        Find(0).AddComponent(new RenderComponent("g1.jpg"));
        AddGameObject(new GameObject(0,0,0));
        Find(1).AddComponent(new RenderComponent("42.jpg"));
    }
}
