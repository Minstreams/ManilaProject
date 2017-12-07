package Components;

import Main.GameObject;
import Systems.ComponentSystem;
import java.util.Random;

public class RocksCreatAndDestoryComponent extends ComponentSystem {

    private float timeLoop=0;
    private int randomPositionY;
    @Override
    protected void function() {
        if(timeLoop>=2){
            timeLoop=0;
            randomPositionY=Math.abs(new Random().nextInt())%10;
            CreatOneRock(800,randomPositionY);
        }
        else{
            timeLoop+=deltaTime;
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void OnDestroy() {

    }

    private  void CreatOneRock(int xPosition,int yPosition){
        GameObject rockChild=new GameObject("RockChild",xPosition,yPosition);
        gameObject.scene.AddGameObject(rockChild);
        rockChild.AddComponent(new RenderComponent("rock.jpg"));
        rockChild.AddComponent(new RockControllerComponent(xPosition,yPosition));
    }
}