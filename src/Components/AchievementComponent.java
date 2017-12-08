package Components;

import Main.Achievements;
import Main.GameObject;
import Systems.ComponentSystem;

public class AchievementComponent extends ComponentSystem {

    private static int startY = 160;
    private static int deltaY = 30;
    private static float moveRate = 0.1f;

    protected static int boardNum = 0;

    public static void ShowAchivement(Achievements achievement) {
        //TODO
        GameObject g = gameWorld.getCurrentScene().AddGameObject(new GameObject("Achievement Board", 959, startY + deltaY * boardNum));
        g.AddComponent(new AchievementComponent());
        g.AddComponent(new RenderComponent("achievementBoard.jpg"));
        System.out.println("获得" + achievement.name() + "!");
    }

    @Override
    protected void function() {
        gameObject.x += (800 - gameObject.x) * moveRate;
    }

    @Override
    public void start() {
        boardNum++;
    }

    @Override
    public void OnDestroy() {
        super.OnDestroy();
        boardNum--;
    }
}
