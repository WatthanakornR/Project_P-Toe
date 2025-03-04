//package entity.base;
//
//import entity.unit.Unit_Player;
//
//public abstract class Skill {
//	private String skillName;
//	private int cooldown;
//	
//	public Skill(String skillName, int cooldown) {
//		super();
//		this.skillName = skillName;
//		this.cooldown = cooldown;
//	}
//	
//	public abstract int useSkill (Unit_Player player,Unit enemy);
//
//	public String getSkillName() {
//		return skillName;
//	}
//
//	public void setSkillName(String skillName) {
//		this.skillName = skillName;
//	}
//
//	public int getCooldown() {
//		return cooldown;
//	}
//
//	public void setCooldown(int cooldown) {
//		this.cooldown = cooldown;
//	}
//	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return skillName + " ( Cooldown : " + cooldown + " )";
//	}
//
//}


package entity.base;

import entity.base.Unit;

public abstract class Skill {
    private String skillName;
    private int cooldown;
    private int currentCooldown;

    public Skill(String skillName, int cooldown) {
        this.skillName = skillName;
        this.cooldown = cooldown;
        this.currentCooldown = 0; // คูลดาวน์เริ่มต้น = 0 (ใช้ได้ทันที)
    }

    /** ใช้สกิลกับศัตรู */
    public abstract int useSkill(Unit user, Unit enemy);

    /** ลดคูลดาวน์ทุกเทิร์น */
    public void reduceCooldown() {
        if (currentCooldown > 0) {
            currentCooldown--;
        }
    }

    /** รีเซ็ตคูลดาวน์หลังจากใช้สกิล */
    public void resetCooldown() {
        currentCooldown = cooldown;
    }

    /** เช็คว่าสกิลพร้อมใช้งานหรือไม่ */
    public boolean isReady() {
        return currentCooldown == 0;
    }

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

    public int getCurrentCooldown() {
        return currentCooldown;  
    }

    public void setCurrentCooldown(int currentCooldown) {
        this.currentCooldown = Math.max(0, currentCooldown);
    }

    @Override
    public String toString() {
        return skillName + " ( Cooldown: " + currentCooldown + "/" + cooldown + " )";
    }
}
