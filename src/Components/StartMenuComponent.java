package Components;

import Main.Input;
import Scenes.Scene1;
import Systems.ComponentSystem;

public class StartMenuComponent extends ComponentSystem {
    @Override
    protected void function() {
        if(Input.GetMouseDown(0)){
            LoadScene(new Scene1());
        }
    }

    @Override
    public void start() {

    }
}
