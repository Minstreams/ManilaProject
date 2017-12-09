package Scenes;

import Components.*;
import Main.GameObject;
import Main.Scene;

public class Scene1 extends Scene {

    @Override
    protected void LoadScene() {

        //游戏场景
        AddGameObject(new GameObject("BackGround", 159, 0, 0));
        AddComponent(new RenderComponent("sea.gif"));
        //船儿
        AddGameObject(new GameObject("Boat", 160, 60, 2));
        AddComponent(new RenderComponent("boat.gif"));
        AddComponent(new VictoryCheckComponent());
        //控制类组件
        AddComponent(new BoatControllerComponent(150));
        //计分组件
        AddComponent(new PointCountComponent(1500));

        //产生石头,在该物体里面持续产生
        AddGameObject(new GameObject("Rocks", 0, 0, 1));
        //在该组件里面给物体产生子物体 即炸弹
        AddComponent(new RocksCreatAndDestoryComponent(1f, "stone11.png", "stone12.png", "stone13.png", 50, 0));


        AddGameObject(new GameObject("Items", 0, 0, 1));
        AddComponent(new RocksCreatAndDestoryComponent(10f, "item.gif", "item.gif", "item.gif", 150, 50));

        //开火组件
        Find("Boat").AddComponent(new FireComponent(Find("Rocks"), Find("Items")));

        AddGameObject(new GameObject("HeadImage1", -1000, 0, 5));
        AddComponent(new RenderComponent("hurt.png"));
        AddGameObject(new GameObject("HeadImage2", 0, 0, 4));
        AddComponent(new RenderComponent("normal.png"));

        AddGameObject(new GameObject("MouseFollower", 0, 0, 8));
        AddComponent(new FollowMouseComponent());
        AddComponent(new RenderComponent("cursor.png"));
        AddComponent(new AudioClipComponent("bgm1.wav", true));

        //伤害检测组件
        Find("Boat").AddComponent(new BoatDamagedComponent(100, Find("Rocks"), Find("Items"), Find("HeadImage1")));
    }
}
