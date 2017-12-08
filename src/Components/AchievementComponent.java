package Components;

import Main.Achievement;
import Main.GameObject;
import Systems.ComponentSystem;

import java.util.ArrayList;

public class AchievementComponent extends ComponentSystem {

    private static int startY = 160;
    private static int deltaY = 30;
    private static float moveRate = 3;

    protected static ArrayList<Integer> achievementsShowed = new ArrayList<Integer>();

    public static ArrayList<Achievement> achievementArrayList = new ArrayList<Achievement>();

    private Integer id;

    public AchievementComponent(Integer id) {
        this.id = id;
    }

    /**
     * 获得并显示成就
     *
     * @param achievementName
     * @param achievementInfo
     */
    public static void ShowAchivement(String achievementName, String achievementInfo) {
        Integer id = 0;
        while (achievementsShowed.contains(id)) {
            id++;
        }

        GameObject g = gameWorld.getCurrentScene().AddGameObject(new GameObject("Achievement Board", 959, startY + deltaY * id, 3));
        g.AddComponent(new AchievementComponent(id));
        g.AddComponent(new RenderComponent("achievementBoard.jpg"));
        g.AddComponent(new TextRendererComponent(achievementName));
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
        float delta = gameObject.x - (shown ? 959 : 800);
        gameObject.x -= delta * moveRate * deltaTime;
        if (delta > -2 && delta < 2) {
            if (shown) {
                Destroy(gameObject);
                return;
            }
            timer += deltaTime;
        }
        if (timer > 3) {
            timer = 0;
            shown = true;
        }
    }

    @Override
    public void start() {
        achievementsShowed.add(id);
    }

    @Override
    public void OnDestroy() {
        super.OnDestroy();
        achievementsShowed.remove(id);
    }
}
