package entity.skill;

import entity.base.Skill;
import entity.base.Unit;
import entity.unit.Unit_Player;

public class Skilll_1 extends Skill {

	public Skilll_1() {
		super("Slash", 2);
	}

	@Override
	public int useSkill(Unit_Player player, Unit enemy) {
		// TODO Auto-generated method stub
		int damage = Math.min(enemy.getHp(), player.getAtk());
		enemy.setHp(enemy.getHp()-damage);
		return damage;
	}

}
