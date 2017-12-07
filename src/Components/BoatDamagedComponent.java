package Components;

import Main.GameObject;
import Systems.ComponentSystem;

public class BoatDamagedComponent extends ComponentSystem {

    private int maxHP;
    private int HP;
    private GameObject rocks = null;
    private boolean isInvisible = false;

    private GameObject HPBar;
    private GameObject HeadImage;

    public BoatDamagedComponent(int maxHP, GameObject rocks, GameObject HPBar, GameObject headImage) {
        this.maxHP = maxHP;
        this.HP = maxHP;
        this.rocks = rocks;
        this.HPBar = HPBar;
        HeadImage = headImage;
    }

    @Override
    public void start() {

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
        HPBar.x = 959 - (int) (HP * 1.0f / maxHP * 149);
    }


    private void Die() {
        gameObject.GetComponent(VictoryCheckComponent.class).Lose();
    }

    private void ScanRocks() {
        for (GameObject r : rocks.children) {
            if (r == null) {
                continue;
            }

            int deltaX = r.x - gameObject.x - 63;
            int deltaY = r.y - gameObject.y - 67;
            //如果撞到
            if (deltaX <= 87 && deltaX >= -87 && deltaY <= 65 && deltaY >= -65) {
                if (!isInvisible) {
                    DecreaseHP(20);
                    BecomeInvisible();
                }
                Destroy(r);
                return;
            }
        }
    }

    private void BecomeInvisible() {
        HeadImage.x = 1000;
        isInvisible = true;
    }

    private void BecomeNormal() {
        HeadImage.x = 800;
        isInvisible = false;
    }

    private float timer = 0;

    private void InvisibleTime() {
        if (!isInvisible) {
            return;
        }
        timer += deltaTime;

        if(timer>0.8f){
            timer = 0;
            BecomeNormal();
        }
    }

}
