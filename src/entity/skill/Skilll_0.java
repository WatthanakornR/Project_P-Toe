package entity.skill;

import entity.base.Skill;
import entity.base.Unit;
import entity.unit.Unit_Player;

public class Skilll_0 extends Skill{

	public Skilll_0() {
		super("Test Skill", 2);
	}
	
	@Override
	public int useSkill(Unit_Player player, Unit enemy) {
		// TODO Auto-generated method stub
		int damage = Math.min(enemy.getHp(), Math.max(0,player.getAtk() - enemy.getDef()));
		enemy.setHp(enemy.getHp() - damage);
		return damage;
	}
}
