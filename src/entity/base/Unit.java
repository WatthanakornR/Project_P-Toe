//package entity.base;
//
//public abstract class Unit {
//	private String unitName;
//	private int lv;
//	private int maxHp;
//	private int hp;
//	private int atk;
//	private int def;
//	private int xp;
//	private boolean isWounded;
//	private boolean isIncapacitated;
//	private int damageWounded;
//	
//	public Unit(String name, int lv, int hp, int atk, int def) {
//		setUnitName(name);
//		setLv(lv);
//		setMaxHp(hp);
//		setHp(hp);
//		setAtk(atk);
//		setDef(def);
//		setWounded(false);
//		setIncapacitated(false);
//		setDamageWounded(0);
//		setXp(0);
//	}
//	
//	public int attack (Unit enemy) {
//		int damage = Math.min(enemy.getHp(), Math.max(0,atk - enemy.def));
//		enemy.setHp(enemy.hp - damage);
//		return damage;
//	}
//	
//	public boolean isDead() {
//		return hp == 0;
//	}
//	
//	public void receive() {
//		setHp(getMaxHp());
//		setWounded(false);
//		setIncapacitated(false);
//		setDamageWounded(0);
//	}
//
//	public String getUnitName() {
//		return unitName;
//	}
//
//	public void setUnitName(String unitName) {
//		this.unitName = unitName;
//	}
//
//	public int getMaxHp() {
//		return maxHp;
//	}
//
//	public void setMaxHp(Integer maxHp) {
//		this.maxHp = Math.max(maxHp, 1);
//	}
//
//	public int getHp() {
//		return hp;
//	}
//
//	public void setHp(Integer hp) {
//		this.hp = Math.max(Math.min(hp, maxHp), 0);
//	}
//
//	public int getAtk() {
//		return atk;
//	}
//
//	public void setAtk(Integer atk) {
//		this.atk = Math.max(atk, 0);
//	}
//
//	public int getDef() {
//		return def;
//	}
//
//	public void setDef(Integer def) {
//		this.def = Math.max(def, 0);
//	}
//
//	public boolean isWounded() {
//		return isWounded;
//	}
//
//	public void setWounded(boolean isWounded) {
//		this.isWounded = isWounded;
//	}
//
//	public int getDamageWounded() {
//		return damageWounded;
//	}
//
//	public void setDamageWounded(Integer damageWounded) {
//		this.damageWounded = Math.max(0, damageWounded);
//	}
//
//	public boolean isIncapacitated() {
//		return isIncapacitated;
//	}
//
//	public void setIncapacitated(boolean isIncapacitated) {
//		this.isIncapacitated = isIncapacitated;
//	}
//	
//	public int getLv() {
//		return lv;
//	}
//	
//	public void setLv(Integer lv) {
//		this.lv = Math.max(1, lv);
//	}
//	
//	public int getXp() {
//		return xp;
//	}
//
//	public void setXp(int xp) {
//		this.xp = Math.max(0, xp);
//	}
//
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return 	"Name : " + unitName + " (Lv:" + lv + ")\n" + 
//				"HP : " + hp + " / " + maxHp + ", Atk : " + atk + ", Def : " + def;
//	}
//	
//
//}




package entity.base;

public abstract class Unit {
    private String unitName;
    private int lv;
    private int maxHp;
    private int hp;
    private int atk;
    private int def;
    private int xp;
    private boolean isWounded;
    private boolean isIncapacitated;
    private int damageWounded;

    public Unit(String name, int lv, int hp, int atk, int def) {
        setUnitName(name);
        setLv(lv);
        setMaxHp(hp);
        setHp(hp);
        setAtk(atk);
        setDef(def);
        setWounded(false);
        setIncapacitated(false);
        setDamageWounded(0);
        setXp(0);
    }

    /** ฟังก์ชันโจมตีศัตรู */
    /** ฟังก์ชันโจมตีศัตรู */
    public void attack(Unit enemy) {
        if (isIncapacitated) {
            System.out.println(unitName + " is incapacitated and cannot attack!");
            return;
        }

        int damage = Math.min(enemy.getHp(), Math.max(0, atk - enemy.getDef()));
        enemy.takeDamage(damage);
        System.out.println(unitName + " attacks " + enemy.getUnitName() + " for " + damage + " damage!");
    }

    /** ฟังก์ชันรับดาเมจ */
    public void takeDamage(int damage) {
        setHp(this.hp - damage);
        if (isDead()) {
            System.out.println(unitName + " has been defeated!");
        }
    }

    /** ตรวจสอบว่ายูนิตยังมีชีวิตอยู่หรือไม่ */
    public boolean isAlive() {
        return hp > 0;
    }

    /** ตรวจสอบว่ายูนิตตายแล้วหรือไม่ */
    public boolean isDead() {
        return hp == 0;
    }

    /** ฟื้นฟูพลังชีวิตและรีเซ็ตสถานะ (ใช้สำหรับบอสหรือไอเท็มพิเศษ) */
    public void receive() {
        setHp(getMaxHp());
        setWounded(false);
        setIncapacitated(false);
        setDamageWounded(0);
    }

    /** เพิ่ม XP (ใช้กับ Unit_Player) */
    public void gainXp(int amount) {
        setXp(this.xp + amount);
        System.out.println(unitName + " gained " + amount + " XP!");
    }

    /** ------------------ GETTERS & SETTERS ------------------ **/

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(Integer maxHp) {
        this.maxHp = Math.max(maxHp, 1);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = Math.max(Math.min(hp, maxHp), 0);
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(Integer atk) {
        this.atk = Math.max(atk, 0);
    }

    public int getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = Math.max(def, 0);
    }

    public boolean isWounded() {
        return isWounded;
    }

    public void setWounded(boolean isWounded) {
        this.isWounded = isWounded;
    }

    public int getDamageWounded() {
        return damageWounded;
    }

    public void setDamageWounded(Integer damageWounded) {
        this.damageWounded = Math.max(0, damageWounded);
    }

    public boolean isIncapacitated() {
        return isIncapacitated;
    }

    public void setIncapacitated(boolean isIncapacitated) {
        this.isIncapacitated = isIncapacitated;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(Integer lv) {
        this.lv = Math.max(1, lv);
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = Math.max(0, xp);
    }

    @Override
    public String toString() {
        return "Name : " + unitName + " (Lv:" + lv + ")\n" + 
               "HP : " + hp + " / " + maxHp + ", Atk : " + atk + ", Def : " + def;
    }
}

