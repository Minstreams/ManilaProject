package Components;

import Main.Input;
import Main.KeyCode;
import Scenes.*;
import Systems.ComponentSystem;

public class MenuComponent extends ComponentSystem {
    @Override
    protected void function() {
        if (Input.GetMouseDown(0) || Input.GetKeyDown(KeyCode.X)) {
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
                case 4:
                    AchievementsShowBoard.ShowAll();
                    Destroy(this);
                    break;
                default:
                    break;
            }
        }
        if (Input.GetKeyDown(KeyCode.P)) {
            AchievementsShowBoard.ShowAll();
        }
    }

    @Override
    public void start() {

    }
}
