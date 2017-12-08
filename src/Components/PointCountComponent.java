package Components;

import Systems.ComponentSystem;

public class PointCountComponent extends ComponentSystem {
    private float victoryPoints;

    private float points = 0;
    private int achievementProgress = 1;

    public PointCountComponent(float victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    @Override
    protected void function() {
        //每秒增加10points
        this.points += 10 * deltaTime;

        //检查成就
        CheckAchievement();
        //检查胜利
        CheckVictory();
    }

    @Override
    public void start() {

    }

    //调用增加分数
    public void AddPoint(float points) {
        this.points += points;
        System.out.println("当前分数为：" + this.points);
    }

    private void CheckAchievement() {
        //根据关卡数
        switch (VictoryCheckComponent.level) {
            case 1:
                if (points >= (victoryPoints * (float)(achievementProgress / 4))) {
                    //调用得分成就
                    switch(achievementProgress){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            break;
                    }
                    achievementProgress += 1;
                }
                break;
            case 2:
                if (points >= (victoryPoints * (float)(achievementProgress / 4))) {
                    //调用得分成就
                    switch(achievementProgress){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            break;
                    }
                    achievementProgress += 1;
                }
                break;
            case 3:
                if (points >= (victoryPoints * (float)(achievementProgress / 4))) {
                    //调用得分成就
                    switch(achievementProgress){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            break;
                    }
                    achievementProgress += 1;
                }
                break;
            default:
                    break;
        }

    }

    private void CheckVictory() {
        if (points >= victoryPoints) {
            //调用胜利成就
            switch (VictoryCheckComponent.level){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
            gameObject.GetComponent(VictoryCheckComponent.class).Win();
        }
    }
}
