package Components;

import Systems.ComponentSystem;

public class ShotBuffComponent extends ComponentSystem {
    private float timer = 0;
    private float maxTime;
    private int killNum;

    public ShotBuffComponent(float maxTime) {
        this.maxTime = maxTime;
    }

    @Override
    protected void function() {
        timer += deltaTime;
        if (timer > maxTime) {
            killNum = FireComponent.getKillNum() - killNum;
            if (killNum >= 5) {
                AchievementComponent.ShowAchivement("势如破竹  ！", "Buff里杀了5个以上的石头");
            }


            Destroy(this);
        }
    }

    @Override
    public void start() {
        FireComponent.setFireColdTime(0.3f);
        AchievementComponent.ShowAchivement("我充满了力量！", "捡到道具。");
        killNum = FireComponent.getKillNum();
    }

    @Override
    public void OnDestroy() {
        super.OnDestroy();
        FireComponent.setFireColdTime(1);
    }
}
