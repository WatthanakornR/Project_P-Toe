package entity.base;

import entity.unit.Unit_Player;

public abstract class Skill {
	private String skillName;
	private int cooldown;
	
	public Skill(String skillName, int cooldown) {
		super();
		this.skillName = skillName;
		this.cooldown = cooldown;
	}
	
	public abstract int useSkill (Unit_Player player,Unit enemy);

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return skillName + " ( Cooldown : " + cooldown + " )";
	}

}
