package Components;

import Main.GameObject;
import Main.Scene;
import Systems.ComponentSystem;

/**
 * 伤害检测组件
 */
public class BoatDamagedComponent extends ComponentSystem {

    private int maxHP;
    private int HP;
    private GameObject rocks = null;
    private GameObject items = null;
    private boolean isInvisible = false;

    private GameObject HPBar;
    private GameObject HeadImage;
    private AudioClipComponent audio1;
    private AudioClipComponent audio2;

    public BoatDamagedComponent(int maxHP, GameObject rocks, GameObject items, GameObject headImage) {
        this.maxHP = maxHP;
        this.HP = maxHP;
        this.rocks = rocks;
        this.items = items;

        this.HPBar = gameWorld.getCurrentScene().AddGameObject(new GameObject("HPBar", 0, 206, 7));
        this.HPBar.AddComponent(new RenderComponent("hp.jpg"));

        HeadImage = headImage;
    }

    @Override
    public void start() {
        audio1 = new AudioClipComponent("Crashed.wav", false);
        gameObject.AddComponent(audio1);
        audio2 = new AudioClipComponent("buff.wav", false);
        gameObject.AddComponent(audio2);
        Scene.setCurrentGameObject(gameObject);
    }

    @Override
    protected void function() {
        ScanRocks();
        InvisibleTime();
    }

    private void IncreaseHP(int value) {
        this.HP += value;
        if (this.HP > this.maxHP) {
            this.HP = this.maxHP;
        }
    }

    private void DecreaseHP(int value) {
        this.HP -= value;
        audio1.Play();
        if (this.HP <= 20) {
            AchievementComponent.ShowAchivement("你的生命已是风中残烛！", "再挨一下就要死了。");
        }
        if (this.HP <= 0) {
            this.HP = 0;
            Die();
        }
        ChangeHPBarPos();
    }

    /**
     * 改变血条位置
     */
    private void ChangeHPBarPos() {
        HPBar.x = (int) (HP * 1.0f / maxHP * 149) - 149;
    }


    private void Die() {
        gameObject.GetComponent(VictoryCheckComponent.class).Lose();
    }

    private void ScanRocks() {
        for (GameObject r : rocks.children) {
            if (r == null) {
                continue;
            }

            float deltaX = r.x - gameObject.x - 63;
            float deltaY = r.y - gameObject.y - 67;
            //如果撞到
            if (deltaX <= 60 && deltaX >= -87 && deltaY <= 65 && deltaY >= -15) {
                if (!isInvisible) {
                    DecreaseHP(20);
                    BecomeInvisible();
                } else {
                    AchievementComponent.ShowAchivement("第二次对圣斗士无效", "受伤CD中撞到岩石。");
                }
                Destroy(r);
                return;
            }
        }
        for (GameObject r : items.children) {
            if (r == null) {
                continue;
            }

            float deltaX = r.x - gameObject.x - 63;
            float deltaY = r.y - gameObject.y - 67;
            //如果撞到
            if (deltaX <= 87 && deltaX >= -87 && deltaY <= 65 && deltaY >= -65) {
                audio2.Play();
                gameObject.AddComponent(new ShotBuffComponent(3));
                Destroy(r);
                return;
            }
        }
    }

    private void BecomeInvisible() {
        HeadImage.x = 0;
        isInvisible = true;
        FireComponent.setKillNum(0);
    }

    private void BecomeNormal() {
        HeadImage.x = -1000;
        isInvisible = false;
    }

    private float timer = 0;

    private void InvisibleTime() {
        if (!isInvisible) {
            return;
        }
        timer += deltaTime;

        if (timer > 0.8f) {
            timer = 0;
            BecomeNormal();
        }
    }

}
