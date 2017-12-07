package Components;

import Main.GameObject;
import Systems.ComponentSystem;

public class BoatDamagedComponent extends ComponentSystem {

    private int maxHP;
    private int HP;
    private GameObject rocks = null;
    private boolean isInvisible = false;

    public BoatDamagedComponent(int maxHP, GameObject rocks) {
        this.maxHP = maxHP;
        this.HP = maxHP;
        this.rocks = rocks;
    }

    @Override
    public void start() {

    }

    @Override
    protected void function() {
        ScanRocks();
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
        System.out.println("Current HP:" + this.HP);
    }

    private void Die(){

    }

    private void ScanRocks() {
        if (isInvisible) {
            return;
        }
        for (GameObject r : rocks.children) {
            if (r == null) {
                continue;
            }

            int deltaX = r.x - gameObject.x - 63;
            int deltaY = r.y - gameObject.y - 67;
            //如果撞到
            if (deltaX <= 87 && deltaX >= -87 && deltaY <= 65 && deltaY >= -65) {
                DecreaseHP(20);
                Destroy(r);
                return;
            }
        }
    }
}
