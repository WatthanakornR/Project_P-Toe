package entity.skill;

import entity.base.Skill;
import entity.base.Unit;

public class Skilll_0 extends Skill {

    public Skilll_0() {
        super("Test Skill", 2);
    }

    @Override
    public int useSkill(Unit user, Unit enemy) {
        // แก้พารามิเตอร์ให้ถูกต้อง
        if (!isReady()) {
            System.out.println(user.getUnitName() + " tried to use " + getSkillName() + ", but it's on cooldown!");
            return 0;
        }

        // ตรวจสอบว่า Unit.java มี takeDamage(int damage) แล้วหรือไม่
        int damage = Math.min(enemy.getHp(), Math.max(0, user.getAtk() - enemy.getDef()));
        enemy.takeDamage(damage);  // ใช้ takeDamage() แทน setHp()

        resetCooldown();  // รีเซ็ตคูลดาวน์หลังใช้สกิล

        System.out.println(user.getUnitName() + " used " + getSkillName() + " on " + enemy.getUnitName() + " dealing " + damage + " damage!");
        return damage;
    }
}
