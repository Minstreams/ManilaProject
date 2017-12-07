package Components;

import Scenes.LoseScene;
import Scenes.Scene1;
import Systems.ComponentSystem;

public class VictoryCheckComponent extends ComponentSystem{
    public VictoryCheckComponent() {
    }

    @Override
    public void start() {

    }

    @Override
    protected void function() {

    }

    public static void Win(){

    }

    public void Lose(){
        LoadScene(new LoseScene());
    }
}
