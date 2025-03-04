//package entity.skill;
//
//import entity.base.Skill;
//import entity.base.Unit;
//import entity.unit.Unit_Player;
//
//public class Skilll_1 extends Skill {
//
//	public Skilll_1() {
//		super("Slash", 2);
//	}
//
//	@Override
//	public int useSkill(Unit_Player player, Unit enemy) {
//		// TODO Auto-generated method stub
//		int damage = Math.min(enemy.getHp(), player.getAtk());
//		enemy.setHp(enemy.getHp()-damage);
//		return damage;
//	}
//
//}


package entity.skill;

import entity.base.Skill;
import entity.base.Unit;

public class Skilll_1 extends Skill {

    public Skilll_1() {
        super("Slash", 2);
    }

    @Override
    public int useSkill(Unit user, Unit enemy) {
        if (!isReady()) {
            System.out.println(user.getUnitName() + " tried to use " + getSkillName() + ", but it's on cooldown!");
            return 0;
        }

        int damage = Math.min(enemy.getHp(), user.getAtk());
        enemy.takeDamage(damage); // ใช้ takeDamage() แทน setHp()
        resetCooldown(); // รีเซ็ตคูลดาวน์หลังใช้สกิล

        System.out.println(user.getUnitName() + " used " + getSkillName() + " on " + enemy.getUnitName() + " dealing " + damage + " damage!");
        return damage;
    }
}
