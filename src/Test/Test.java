package Test;

import Components.RenderComponent;
import Main.GameWorld;
import Scenes.Scene01;
import Scenes.StartScene;
import Systems.RenderSystem;

public class Test {
    public static void main(String[] args) {
        GameWorld gameWorld = new GameWorld(new StartScene());
    }
}
