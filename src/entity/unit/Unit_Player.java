//package entity.unit;
//
//import entity.base.Skill;
//import entity.base.Unit;
//
//public class Unit_Player extends Unit {
//	private Skill skill;
//	private int cooldown;
//	
//	public Unit_Player(String name, int lv, int hp, int atk, int def, Skill skill) {
//		// TODO Auto-generated constructor stub
//		super(name, lv, hp, atk, def);
//		setXp(0);
//		setSkill(skill);
//		setCooldown(0);
//	}
//
//	@Override
//	public int attack(Unit enemy) {
//		// TODO Auto-generated method stub
//		this.setCooldown(cooldown - 1);
//		if (enemy.isDead()) 
//			levelup(enemy.getXp());
//		return super.attack(enemy);
//	}
//
//	public int skillAttack(Unit enemy) {
//		if (getCooldown() == 0) {
//			cooldown = skill.getCooldown();
//			return skill.useSkill(this,enemy);
//		}
//		return 0;
//	}
//
//	public void levelup(int xp) {
//		this.setXp(getXp() + xp);
//		while (getXp() >= getLv() * 100) {
//			this.setXp(getXp() - getLv() * 100);
//			setLv(getLv() + 1);
//			setMaxHp(getMaxHp() + 100);
//			setAtk(getAtk() + 20);
//			setDef(getDef() + 10);
//		}
//		receive();
//	}
//
//	public Skill getSkill() {
//		return skill;
//	}
//
//	public void setSkill(Skill skill) {
//		this.skill = skill;
//	}
//
//	public int getCooldown() {
//		return cooldown;
//	}
//
//	public void setCooldown(int cooldown) {
//		this.cooldown = Math.max(0, cooldown);
//	}
//
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString() + "\nSkill : " + skill.getSkillName() + " ( " + getCooldown() + " )";
//	}
//
//}
package entity.unit;

import entity.base.Skill;
import entity.base.Unit;
import entity.base.BattleInterface;

public class Unit_Player extends Unit implements BattleInterface {
    private Skill skill;
    private int cooldown;

    public Unit_Player(String name, int lv, int hp, int atk, int def, Skill skill) {
        super(name, lv, hp, atk, def);
        setXp(0);
        setSkill(skill);
        setCooldown(0);
    }

    /** โจมตีศัตรูแบบปกติ */
    @Override
    public void attack(Unit enemy) {
        int damage = Math.max(0, getAtk() - enemy.getDef());
        enemy.takeDamage(damage);
        resetCooldown();
        System.out.println(getUnitName() + " attacks " + enemy.getUnitName() + " for " + damage + " damage!");
        if (enemy.isDead()) {
            levelUp(enemy.getXp());
        }
    }

    /** ใช้สกิลโจมตีศัตรู */
    @Override
    public void useSkill(Unit enemy) {
        if (getCooldown() == 0) {
            cooldown = skill.getCooldown();
            int damage = skill.useSkill(this, enemy);
            System.out.println(getUnitName() + " used " + skill.getSkillName() + " on " + enemy.getUnitName() + "!");
        } else {
            System.out.println("Skill is on cooldown for " + cooldown + " more turns.");
        }
    }

    /** เลเวลอัพเมื่อ XP ถึงเกณฑ์ */
    public void levelUp(int xp) {
        setXp(getXp() + xp);
        while (getXp() >= getLv() * 100) {
            setXp(getXp() - getLv() * 100);
            setLv(getLv() + 1);
            setMaxHp(getMaxHp() + 100);
            setAtk(getAtk() + 20);
            setDef(getDef() + 10);
            System.out.println(getUnitName() + " leveled up to Level " + getLv() + "!");
        }
        receive();
    }

    /** ลดคูลดาวน์สกิลหลังจบเทิร์น */
    public void resetCooldown() {
        if (cooldown > 0) {
            cooldown--;
        }
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

    /** ตรวจสอบว่า Unit_Player แพ้หรือไม่ */
    @Override
    public boolean isDefeated() {
        return isDead(); // ใช้ฟังก์ชัน isDead() ที่มีอยู่ใน Unit เพื่อตรวจสอบการตาย
    }

    @Override
    public String toString() {
        return super.toString() + "\nSkill : " + skill.getSkillName() + " (Cooldown: " + getCooldown() + " turns)";
    }
}
