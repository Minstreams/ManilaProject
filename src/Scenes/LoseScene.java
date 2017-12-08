package Scenes;

import Components.*;
import Main.GameObject;
import Main.Scene;

public class LoseScene extends Scene{
    @Override
    protected void LoadScene() {
        //失败场景
        AddGameObject(new GameObject("LoseScene",0,0,0));
        AddComponent(new RenderComponent("FAIL.png"));
        AddComponent(new MenuComponent());

        AddGameObject(new GameObject("MouseFollower", 0, 0, 8));
        AddComponent(new FollowMouseComponent());
        AddComponent(new RenderComponent("cursor.png"));
        AddComponent(new AudioClipComponent("bgm1.wav", true));
    }
}
