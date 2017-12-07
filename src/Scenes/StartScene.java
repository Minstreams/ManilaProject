package Scenes;

import Components.*;
import Main.GameObject;
import Main.Scene;

public class StartScene extends Scene {

    @Override
    protected void LoadScene() {
        //菜单场景
        //AddGameObject(new GameObject("sin",0,0,0));
        //AddComponent(new RenderComponent("boat.jpg"));
        //AddComponent(new StartMenuComponent());

        //游戏场景
        AddGameObject(new GameObject("BackGround",0,0,0));
        AddComponent(new RenderComponent("sea.gif"));
        //船儿
        AddGameObject(new GameObject("Boat",10,60,1));
        AddComponent(new RenderComponent("boat.gif"));
        //控制类组件
        AddComponent(new BoatTestComponent(5,5));
    }
}
