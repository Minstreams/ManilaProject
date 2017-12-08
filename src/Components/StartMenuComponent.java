package Components;

import Main.Input;
import Scenes.Scene1;
import Systems.ComponentSystem;

public class StartMenuComponent extends ComponentSystem {
    @Override
    protected void function() {
        if (Input.GetMouseDown(0)) {
            switch (VictoryCheckComponent.level) {
                case 1:
                    LoadScene(new Scene1());
                    break;
                case 2:
                    LoadScene(new Scene1());
                    break;
                case 3:
                    LoadScene(new Scene1());
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
