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
                AchievementComponent.ShowAchivement("欧拉欧拉欧拉！", "强化状态下摧毁五块岩石。");
            }


            Destroy(this);
        }
    }

    @Override
    public void start() {
        FireComponent.setFireColdTime(0.3f);
        AchievementComponent.ShowAchivement("强化道具？能不用吗？", "获得强化状态。");
        killNum = FireComponent.getKillNum();
    }

    @Override
    public void OnDestroy() {
        super.OnDestroy();
        FireComponent.setFireColdTime(1);
    }
}
