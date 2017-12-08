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
        AddComponent(new VictoryCheckComponent());
        //控制类组件
        AddComponent(new BoatControllerComponent(150));
        //计分组件
        AddComponent(new PointCountComponent(1000));

        //产生石头,在该物体里面持续产生
        AddGameObject(new GameObject("Rocks", 0, 0, 2));
        //在该组件里面给物体产生子物体 即炸弹
        AddComponent(new RocksCreatAndDestoryComponent(1f,"rock.jpg",50,0));

        //开火组件
        Find("Boat").AddComponent(new FireComponent(Find("Rocks")));

        AddGameObject(new GameObject("HPBackGround",805,578,4));
        AddComponent(new RenderComponent("hpBar.jpg"));
        AddGameObject(new GameObject("HPBar",810,583,5));
        AddComponent(new RenderComponent("hp.jpg"));
        AddGameObject(new GameObject("HeadImage1",800,0,5));
        AddComponent(new RenderComponent("normal.jpg"));
        AddGameObject(new GameObject("HeadImage2",800,0,4));
        AddComponent(new RenderComponent("hurt.jpg"));

        AddGameObject(new GameObject("MouseFollower",0,0,8));
        AddComponent(new FollowMouseComponent());
        AddComponent(new RenderComponent("00.png"));
        AddComponent(new AudioClipComponent("bgm1.wav",true));

        //伤害检测组件
        Find("Boat").AddComponent(new BoatDamagedComponent(100, Find("Rocks"),Find("HPBar"),Find("HeadImage1")));
    }
}
