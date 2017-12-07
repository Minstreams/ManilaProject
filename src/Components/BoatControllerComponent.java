package Components;

import Main.*;
import Systems.ComponentSystem;

public class BoatControllerComponent extends ComponentSystem {

    private float speed = 0;

    public BoatControllerComponent() {
        this.speed = 2;
    }

    public BoatControllerComponent(float speed) {
        this.speed = speed;
    }

    @Override
    public void start() {

    }

    @Override
    protected void function() {
        float x = 0,y = 0;
        if(Input.GetKey(KeyCode.Left) && gameObject.x >= -26) {
            x-=1;
        }
        if(Input.GetKey(KeyCode.Right) && gameObject.x <= 650) {
            x+=1;
        }
        if(Input.GetKey(KeyCode.Up) && gameObject.y >= -50) {
            y-=1;
        }
        if(Input.GetKey(KeyCode.Down) && gameObject.y <= 450) {
            y+=1;
        }

        gameObject.x += x * this.speed;
        gameObject.y += y * this.speed;
    }
}
