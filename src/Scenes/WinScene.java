package Scenes;

import Components.RenderComponent;
import Components.StartMenuComponent;
import Main.GameObject;
import Main.Scene;

public class WinScene extends Scene {
    @Override
    protected void LoadScene() {
        //关卡1胜利
        AddGameObject(new GameObject("WinScene",0,0,0));
        AddComponent(new RenderComponent("GAMEOVER.jpg"));
        AddComponent(new StartMenuComponent());
    }
}
