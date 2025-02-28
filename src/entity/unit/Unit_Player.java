package entity.unit;

import entity.base.Skill;
import entity.base.Unit;

public class Unit_Player extends Unit {
	private Skill skill;
	private int cooldown;
	
	public Unit_Player(String name, int lv, int hp, int atk, int def, Skill skill) {
		// TODO Auto-generated constructor stub
		super(name, lv, hp, atk, def);
		setXp(0);
		setSkill(skill);
		setCooldown(0);
	}

	@Override
	public int attack(Unit enemy) {
		// TODO Auto-generated method stub
		this.setCooldown(cooldown - 1);
		if (enemy.isDead()) 
			levelup(enemy.getXp());
		return super.attack(enemy);
	}

	public int skillAttack(Unit enemy) {
		if (getCooldown() == 0) {
			cooldown = skill.getCooldown();
			return skill.useSkill(this,enemy);
		}
		return 0;
	}

	public void levelup(int xp) {
		this.setXp(getXp() + xp);
		while (getXp() >= getLv() * 100) {
			this.setXp(getXp() - getLv() * 100);
			setLv(getLv() + 1);
			setMaxHp(getMaxHp() + 100);
			setAtk(getAtk() + 20);
			setDef(getDef() + 10);
		}
		receive();
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = Math.max(0, cooldown);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\nSkill : " + skill.getSkillName() + " ( " + getCooldown() + " )";
	}

}
