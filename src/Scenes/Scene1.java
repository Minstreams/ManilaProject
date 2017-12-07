package Scenes;

import Components.*;
import Main.GameObject;
import Main.Scene;

public class Scene1 extends Scene {

    @Override
    protected void LoadScene() {

        //游戏场景
        AddGameObject(new GameObject("BackGround", 0, 0, 0));
        AddComponent(new RenderComponent("sea.gif"));
        //船儿
        AddGameObject(new GameObject("Boat", 10, 60, 1));
        AddComponent(new RenderComponent("boat.gif"));
        //控制类组件
        AddComponent(new BoatControllerComponent(4));

        //产生石头,在该物体里面持续产生
        AddGameObject(new GameObject("Rocks", 0, 0, 2));
        //在该组件里面给物体产生子物体 即炸弹
        AddComponent(new RocksCreatAndDestoryComponent());
        //伤害检测组件
        Find("Boat").AddComponent(new BoatDamagedComponent(100, Find("Rocks")));
        //开火组件
        Find("Boat").AddComponent(new FireComponent(Find("Rocks")));
    }
}
