//package entity.unit;
//
//import entity.base.Unit;
//
//public class Unit_Boss extends Unit {
//	private int life;
//	private int xp;
//
//	public Unit_Boss(String name, int lv, int hp, int atk, int def, int life,int xp) {
//		super(name, lv, hp, atk, def);
//		setXp(xp);
//		this.life = life;
//	}
//
//	@Override
//	public boolean isDead() {
//		// TODO Auto-generated method stub
//		if (life != 0 && getHp() == 0) {
//			setLife(life - 1);
//			receive();
//		} 
//		return super.isDead();
//	}
//
//	public int getLife() {
//		return life;
//	}
//
//	public void setLife(int life) {
//		this.life = Math.max(0, life);
//	}
//
//}


//package entity.unit;
//
//import entity.base.Unit;
//
//public class Unit_Boss extends Unit {
//    private int life;
//    private int xp;
//
//    public Unit_Boss(String name, int lv, int hp, int atk, int def, int life, int xp) {
//        super(name, lv, hp, atk, def);
//        setXp(xp);
//        this.life = life;
//    }
//
//    @Override
//    public boolean isDead() {
//        if (getHp() == 0) {
//            if (life > 0) {
//                onRevive();
//                life--;
//                receive();
//                return false;
//            } else {
//                System.out.println(getUnitName() + " has been completely defeated!");
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public void takeDamage(int damage) {
//        super.takeDamage(damage);
//        System.out.println(getUnitName() + " took " + damage + " damage! HP left: " + getHp());
//        if (isDead()) {
//            System.out.println(getUnitName() + " gives " + getXp() + " XP!");
//        }
//    }
//
//    /** แสดงข้อความเมื่อบอสคืนชีพ */
//    private void onRevive() {
//        System.out.println(getUnitName() + " has revived! Lives left: " + life);
//    }
//
//    /** โจมตีผู้เล่น */
//    public int attack(Unit player) {
//        int damage = Math.max(0, getAtk() - player.getDef());
//        player.takeDamage(damage);
//        System.out.println(getUnitName() + " unleashes a powerful attack on " + player.getUnitName() + " for " + damage + " damage!");
//        return damage;
//    }
//
//    public int getLife() {
//        return life;
//    }
//
//    public void setLife(int life) {
//        this.life = Math.max(0, life);
//    }
//}


package entity.unit;

import entity.base.Unit;
import entity.base.BattleInterface;

public class Unit_Boss extends Unit implements BattleInterface {
    private int life;
    private int xp;

    public Unit_Boss(String name, int lv, int hp, int atk, int def, int life, int xp) {
        super(name, lv, hp, atk, def);
        setXp(xp);
        this.life = life;
    }

    @Override
    public boolean isDead() {
        if (getHp() == 0) {
            if (life > 0) {
                onRevive();
                life--;
                receive();
                return false;
            } else {
                System.out.println(getUnitName() + " has been completely defeated!");
                return true;
            }
        }
        return false;
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println(getUnitName() + " took " + damage + " damage! HP left: " + getHp());
        if (isDead()) {
            System.out.println(getUnitName() + " gives " + getXp() + " XP!");
        }
    }

    /** แสดงข้อความเมื่อบอสคืนชีพ */
    private void onRevive() {
        System.out.println(getUnitName() + " has revived! Lives left: " + life);
    }

    /** โจมตีผู้เล่น */
    @Override
    public void attack(Unit player) {
        int damage = Math.max(0, getAtk() - player.getDef());
        player.takeDamage(damage);
        System.out.println(getUnitName() + " unleashes a powerful attack on " + player.getUnitName() + " for " + damage + " damage!");
    }


    /** ใช้สกิลพิเศษ */
    @Override
    public void useSkill(Unit target) {
        // สมมติว่าเป็นสกิลโจมตีที่แรงขึ้น
        System.out.println(getUnitName() + " uses a devastating special attack on " + target.getUnitName());
        int damage = Math.max(0, (getAtk() * 2) - target.getDef());
        target.takeDamage(damage);
        System.out.println(getUnitName() + " deals " + damage + " damage with the special attack!");
    }

    @Override
    public boolean isDefeated() {
        return getHp() == 0;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = Math.max(0, life);
    }
}



