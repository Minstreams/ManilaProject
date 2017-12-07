package Components;

import Main.Input;
import Systems.ComponentSystem;

public class FollowMouseComponent extends ComponentSystem {
    @Override
    protected void function() {
        gameObject.x = Input.GetMouseXPosition();
        gameObject.y = Input.GetMouseYPosition();
    }

    @Override
    public void start() {

    }
}
