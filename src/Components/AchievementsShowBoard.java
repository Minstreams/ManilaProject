package Components;

import Main.Achievement;
import Main.GameObject;
import Main.Input;
import Systems.ComponentSystem;

import java.util.ArrayList;

public class AchievementsShowBoard extends ComponentSystem {
    private static int startY = 30;
    private static int deltaY = 80;
    private static float moveRate = 3;

    private boolean isInfo;//是否显示信息

    protected static ArrayList<Integer> achievementsShowed = new ArrayList<Integer>();

    private Integer id;//屏幕面板序号
    private int pid;//成就序号
    private String name;
    private String info;
    private static int maxAchievementNum = 6;//一面显示的最多成就数

    public AchievementsShowBoard(boolean isInfo, Integer id, int pid) {
        this.isInfo = isInfo;
        this.id = id;
        this.pid = pid;
        Achievement a = AchievementComponent.achievementArrayList.get(pid);
        name = isInfo ? "info.jpg" : "message.png";
        info = isInfo ? a.info : a.name;
    }

    /**
     * 获得并显示成就
     */
    public static void ShowInfo(int pid, boolean isInfo) {
        Integer id = 0;
        while (achievementsShowed.contains(id)) {
            id++;
        }
        GameObject g = gameWorld.getCurrentScene().AddGameObject(new GameObject("Achievement Board", 0, 0, 7));
        g.AddComponent(new AchievementsShowBoard(isInfo, id, pid));
    }

    public static void ShowAll(){
        for(int i = 0;i<maxAchievementNum;i++){
            ShowInfo(i,false);
            ShowInfo(i,true);
        }
        Input.GetMouseUp(0);
        Input.GetMouseDown(0);
    }

    private boolean shown = false;

    @Override
    protected void function() {
        float delta = gameObject.x - (isInfo ? (shown ? 960 : 200) : (shown ? -175 : 0));
        gameObject.x -= delta * moveRate * deltaTime;
        if (delta > -4 && delta < 4) {
            if (shown) {
                Destroy(gameObject);
                return;
            }
            if(!isInfo){
                if(Input.GetMouseDown(0)){
                    shown = true;
                }
            }
            else if(Input.GetMouseUp(0)){
                shown = true;
            }
        }
    }

    @Override
    public void start() {
        gameObject.x = isInfo ? 960 : -175;
        gameObject.y = startY + deltaY * (id/2);
        achievementsShowed.add(id);
        gameObject.AddComponent(new RenderComponent(name));
        gameObject.AddComponent(new TextRendererComponent(info, isInfo ? 750 : 175));
    }

    @Override
    public void OnDestroy() {
        pid += maxAchievementNum;
        if (pid >= AchievementComponent.achievementArrayList.size()) {
            pid -= AchievementComponent.achievementArrayList.size();
        }
        achievementsShowed.remove(id);
        ShowInfo(pid, isInfo);
        super.OnDestroy();
    }
}
