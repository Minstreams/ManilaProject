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
        AddGameObject(new GameObject(0,20,1));
        Find(0).AddComponent(new RenderComponent("boat.gif"));
        AddGameObject(new GameObject(0,0,0));
        Find(1).AddComponent(new RenderComponent("sea.gif"));
        AddGameObject(new GameObject(400,400,2));
        Find(2).AddComponent(new RenderComponent("rock.jpg"));
    }
}
