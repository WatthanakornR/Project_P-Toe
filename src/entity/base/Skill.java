package entity.base;

public abstract class Skill {
	protected String skillName;
	protected boolean useMp;

	public Skill(String skillName) {
		super();
		this.skillName = skillName;
		useMp = false;
	}

	public boolean isUseMp() {
		return useMp;
	}

	public void setUseMp(boolean useMp) {
		this.useMp = useMp;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

}
