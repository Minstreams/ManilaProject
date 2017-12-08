package Scenes;

import Components.RenderComponent;
import Components.MenuComponent;
import Main.GameObject;
import Main.Scene;

public class LoseScene extends Scene{
    @Override
    protected void LoadScene() {
        //失败场景
        AddGameObject(new GameObject("LoseScene",0,0,0));
        AddComponent(new RenderComponent("GAMEOVER.jpg"));
        AddComponent(new MenuComponent());
    }
}
