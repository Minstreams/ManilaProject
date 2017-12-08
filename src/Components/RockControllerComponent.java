package Components;

import Systems.ComponentSystem;

public class RockControllerComponent extends ComponentSystem {

    private float speedX;
    private float speedY;

    public RockControllerComponent(float speedX, float speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    protected void function() {
        gameObject.x-=speedX;
        gameObject.y+=speedY;
        if(gameObject.x<-50){
            Destroy(gameObject);
        }

    }

    @Override
    public void start() {


    }
}
