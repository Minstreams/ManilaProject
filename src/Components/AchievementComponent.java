package Components;

import Main.Achievement;
import Main.GameObject;
import Systems.ComponentSystem;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;

public class AchievementComponent extends ComponentSystem {

    private static int startY = 160;
    private static int deltaY = 30;
    private static float moveRate = 0.08f;

    protected static int achievementsShowedNum = 0;

    public static ArrayList<Achievement> achievementArrayList = new ArrayList<Achievement>();

    /**
     * 获得并显示成就
     *
     * @param achievementName
     * @param achievementInfo
     */
    public static void ShowAchivement(String achievementName, String achievementInfo) {
        //TODO
        GameObject g = gameWorld.getCurrentScene().AddGameObject(new GameObject("Achievement Board", 959, startY + deltaY * achievementsShowedNum));
        g.AddComponent(new AchievementComponent());
        g.AddComponent(new RenderComponent("achievementBoard.jpg"));
        //g.AddComponent(new TextRendererComponent(achievementName));
        achievementArrayList.add(new Achievement(achievementName, achievementInfo));
    }

    /**
     * 判定是否已经获得成就
     *
     * @param name
     * @return
     */
    public boolean isAchievementGained(String name) {
        for (Achievement achievement : achievementArrayList) {
            if (achievement.name.equals(name)) {
                return true;
            }
        }
        return false;
    }


    private boolean shown = false;

    private float timer = 0;

    @Override
    protected void function() {
        float delta = shown ? 959 : 800 - gameObject.x;
        gameObject.x += delta * moveRate;
        if (delta > -2 && delta < 2) {
            if(shown){
                Destroy(gameObject);
                return;
            }
            timer += deltaTime;
        }
        if(timer> 3){
            timer = 0;
            shown = true;
        }
    }

    @Override
    public void start() {
        achievementsShowedNum++;
    }

    @Override
    public void OnDestroy() {
        super.OnDestroy();
        achievementsShowedNum--;
        System.out.println("asdasd");
    }
}
