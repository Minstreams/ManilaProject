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
        AddComponent(new StartMenuComponent());
    }
}
