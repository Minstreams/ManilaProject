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

    }

    @Override
    public void start() {
        gameObject.x=800;
    }
}
