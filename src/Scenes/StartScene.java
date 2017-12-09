package Scenes;

import Components.*;
import Main.GameObject;
import Main.Scene;

/**
 * 菜单场景
 */
public class StartScene extends Scene {

    @Override
    protected void LoadScene() {
        //菜单场景
        AddGameObject(new GameObject("StartScene",0,0,0));
        AddComponent(new RenderComponent("boat.jpg"));
        AddComponent(new MenuComponent());

        AddGameObject(new GameObject("Start",525,450,1));
        AddComponent(new RenderComponent("start.gif"));

        AddGameObject(new GameObject("MouseFollower", 0, 0, 8));
        AddComponent(new FollowMouseComponent());
        AddComponent(new RenderComponent("cursor.png"));
        AddComponent(new AudioClipComponent("bgm0.wav", true));
    }
}
