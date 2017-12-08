package Components;

import Main.Achievements;
import Systems.ComponentSystem;

public class PointCountComponent extends ComponentSystem {
    private float victoryPoints;
    private float achievementDeltaPoint;


    private float points = 0;
    private float achievementPoints;

    public PointCountComponent(float victoryPoints, float achievementDeltaPoint) {
        this.victoryPoints = victoryPoints;
        this.achievementDeltaPoint = achievementDeltaPoint;
        achievementPoints = achievementDeltaPoint;
    }

    @Override
    protected void function() {
        //每秒增加10points
        this.points += 10 * deltaTime;

        //检查
        Check();
    }

    @Override
    public void start() {

    }

    //调用增加分数
    public void AddPoint(float points) {
        this.points += points;
        System.out.println("当前分数为：" + this.points);
    }

    private void Check() {
        if (points >= achievementPoints) {
            AchivementComponent.ShowAchivement(Achievements.成就1);
            achievementPoints += achievementDeltaPoint;
        }
        if (points >= victoryPoints) {
            gameObject.GetComponent(VictoryCheckComponent.class).Win();
        }
    }

}
