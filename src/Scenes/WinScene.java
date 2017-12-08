package Scenes;

import Components.AudioClipComponent;
import Components.FollowMouseComponent;
import Components.RenderComponent;
import Components.MenuComponent;
import Main.GameObject;
import Main.Scene;

public class WinScene extends Scene {
    @Override
    protected void LoadScene() {
        //关卡1胜利
        AddGameObject(new GameObject("WinScene",0,0,0));
        AddComponent(new RenderComponent("WIN.png"));
        AddComponent(new MenuComponent());

        AddGameObject(new GameObject("MouseFollower", 0, 0, 8));
        AddComponent(new FollowMouseComponent());
        AddComponent(new RenderComponent("cursor.png"));
        AddComponent(new AudioClipComponent("win.wav", true));
    }
}
