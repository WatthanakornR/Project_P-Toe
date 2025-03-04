//package entity.unit;
//
//import entity.base.Unit;
//
//public class Unit_Normal extends Unit {
//
//	public Unit_Normal(String name, int lv, int hp, int atk, int def,int xp) {
//		super(name, lv, hp, atk, def);
//		setXp(xp);
//	}
//	
//	
//}
//package entity.unit;
//
//import entity.base.Unit;
//import entity.base.BattleInterface;
//
//public class Unit_Normal extends Unit implements BattleInterface {
//
//    public Unit_Normal(String name, int lv, int hp, int atk, int def, int xp) {
//        super(name, lv, hp, atk, def);
//        setXp(xp);
//    }
//
//    /** รับดาเมจจากการโจมตี */
//    @Override
//    public void takeDamage(int damage) {
//        super.takeDamage(damage);
//        System.out.println(getUnitName() + " took " + damage + " damage! HP left: " + getHp());
//        if (isDead()) {
//            onDefeated();
//        }
//    }
//
//    /** ตรวจสอบว่าตายแล้วจริงหรือไม่ */
//    @Override
//    public boolean isDead() {
//        return getHp() == 0;
//    }
//
//    /** แสดงข้อความเมื่อศัตรูถูกกำจัด และให้ XP กับผู้เล่น */
//    private void onDefeated() {
//        System.out.println(getUnitName() + " has been defeated! Player gains " + getXp() + " XP.");
//    }
//
//    /** โจมตีผู้เล่น */
//    @Override
//    public void attack(Unit player) {
//        int damage = Math.max(0, getAtk() - player.getDef());
//        player.takeDamage(damage);
//        System.out.println(getUnitName() + " attacks " + player.getUnitName() + " for " + damage + " damage!");
//    }
//
//    /** ใช้สกิลกับผู้เล่น */
//    @Override
//    public void useSkill(Unit target) {
//        // สมมติว่า Unit_Normal ไม่ใช้สกิลพิเศษสำหรับตอนนี้
//        System.out.println(getUnitName() + " does not have any special skills.");
//    }
//
//    @Override
//    public boolean isDefeated() {
//        return isDead(); // ใช้ฟังก์ชัน isDead เพื่อตรวจสอบการตาย
//    }
//}

package entity.unit;

import entity.base.Unit;

public class Unit_Normal extends Unit {

    public Unit_Normal(String name, int lv, int hp, int atk, int def, int xp) {
        super(name, lv, hp, atk, def);
        setXp(xp);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println(getUnitName() + " took " + damage + " damage! HP left: " + getHp());
        if (isDead()) {
            onDefeated();
        }
    }

    @Override
    public boolean isDead() {
        return getHp() == 0;
    }

    private void onDefeated() {
        System.out.println(getUnitName() + " has been defeated! Player gains " + getXp() + " XP.");
    }

    @Override
    public void attack(Unit player) {
        int damage = Math.max(0, getAtk() - player.getDef());
        player.takeDamage(damage);
        System.out.println(getUnitName() + " attacks " + player.getUnitName() + " for " + damage + " damage!");
    }
}
