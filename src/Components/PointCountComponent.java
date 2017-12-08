package Components;

import Main.GameObject;
import Main.Scene;
import Systems.ComponentSystem;

/**
 * 计分组件
 */
public class PointCountComponent extends ComponentSystem {
    private float victoryPoints;

    private float points = 0;
    private int achievementProgress = 1;

    private GameObject expBar;

    public PointCountComponent(float victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    @Override
    protected void function() {
        //每秒增加10points
        this.points += 10 * deltaTime;
        expBar.x = points / victoryPoints * 149 - 149;
        //检查得分成就
        CheckAchievement();
        //检查胜利
        CheckVictory();
    }

    @Override
    public void start() {
        this.expBar = gameObject.scene.AddGameObject(new GameObject("expBar", -149, 245, 7));
        this.expBar.AddComponent(new RenderComponent("exp.jpg"));
        Scene.setCurrentGameObject(gameObject);
    }

    //调用增加分数
    public void AddPoint(float points) {
        this.points += points;
        System.out.println("当前分数为：" + this.points);
    }

    private void CheckAchievement() {
        if (points >= (victoryPoints * achievementProgress * 1.0f / 4)) {
            //调用得分成就
            switch (VictoryCheckComponent.level) {
                //第一关
                case 1:
                    switch (achievementProgress) {
                        case 1:
                            AchievementComponent.ShowAchivement("小试牛刀25%", "在第一关达到250分。");
                            break;
                        case 2:
                            AchievementComponent.ShowAchivement("小试牛刀50%", "在第一关达到500分。");
                            break;
                        case 3:
                            AchievementComponent.ShowAchivement("小试牛刀75%", "在第一关达到750分。");
                            break;
                        default:
                            break;
                    }
                    break;
                //第二关
                case 2:
                    switch (achievementProgress) {
                        case 1:
                            AchievementComponent.ShowAchivement("大展身手25%", "在第二关达到250分。");
                            break;
                        case 2:
                            AchievementComponent.ShowAchivement("大展身手50%", "在第二关达到500分。");
                            break;
                        case 3:
                            AchievementComponent.ShowAchivement("大展身手75%", "在第二关达到750分。");
                            break;
                        default:
                            break;
                    }
                    break;
                //第三关
                case 3:
                    switch (achievementProgress) {
                        case 1:
                            AchievementComponent.ShowAchivement("天下无双25%", "在第三关达到250分。");
                            break;
                        case 2:
                            AchievementComponent.ShowAchivement("天下无双50%", "在第三关达到500分。");
                            break;
                        case 3:
                            AchievementComponent.ShowAchivement("天下无双75%", "在第三关达到750分。");
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
            achievementProgress += 1;
        }
    }

    private void CheckVictory() {
        if (points >= victoryPoints) {
            //调用胜利成就
            switch (VictoryCheckComponent.level) {
                case 1:
                    AchievementComponent.ShowAchivement("杀鸡焉用牛刀", "通关第一关。");
                    break;
                case 2:
                    AchievementComponent.ShowAchivement("厉害厉害 给你鼓鼓掌", "通关第二关。");
                    break;
                case 3:
                    AchievementComponent.ShowAchivement("我说 别通关了这么个辣鸡游戏就太得意忘形了", "通关第三关。");
                    break;
                default:
                    break;
            }
            gameObject.GetComponent(VictoryCheckComponent.class).Win();
        }
    }
}
