package Scenes;

import Components.AudioClipComponent;
import Components.RenderComponent;
import Components.MenuComponent;
import Main.GameObject;
import Main.Scene;

public class WinScene extends Scene {
    @Override
    protected void LoadScene() {
        //关卡1胜利
        AddGameObject(new GameObject("WinScene",0,0,0));
        AddComponent(new RenderComponent("GAMEOVER.jpg"));
        AddComponent(new MenuComponent());
        AddComponent(new AudioClipComponent("win.wav",true));
    }
}
