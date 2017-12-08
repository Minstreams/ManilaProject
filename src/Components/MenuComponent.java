package Components;

import Main.Input;
import Main.KeyCode;
import Scenes.*;
import Systems.ComponentSystem;

public class MenuComponent extends ComponentSystem {
    @Override
    protected void function() {
        if (Input.GetMouseDown(0) || Input.GetKeyDown(KeyCode.Z)) {
            switch (VictoryCheckComponent.level) {
                case 1:
                    LoadScene(new Scene1());
                    break;
                case 2:
                    LoadScene(new Scene2());
                    break;
                case 3:
                    LoadScene(new Scene3());
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void start() {

    }
}
