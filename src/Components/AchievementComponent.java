package Components;

import Main.GameObject;
import Systems.ComponentSystem;

public class AchievementComponent extends ComponentSystem {

    private static int startY = 160;
    private static int deltaY = 30;
    private static float moveRate = 0.1f;

    public static int achievementsGainedNum = 0;

    public static void ShowAchivement(String achievementName) {
        //TODO
        GameObject g = gameWorld.getCurrentScene().AddGameObject(new GameObject("Achievement Board", 959, startY + deltaY * achievementsGainedNum));
        g.AddComponent(new AchievementComponent());
        g.AddComponent(new RenderComponent("achievementBoard.jpg"));
        g.AddComponent(new TextRendererComponent(achievementName));
        System.out.println("获得" + achievementName + "!");
    }

    @Override
    protected void function() {
        gameObject.x += (800 - gameObject.x) * moveRate;
    }

    @Override
    public void start() {
        achievementsGainedNum++;
    }

    @Override
    public void OnDestroy() {
        super.OnDestroy();
        achievementsGainedNum--;
    }
}
