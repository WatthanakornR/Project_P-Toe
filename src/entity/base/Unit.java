package entity.base;

public abstract class Unit {
	protected String unitName;
	protected int hp;
	protected int mp;
	protected int atk;
	protected int def;
	protected int speed;
	protected boolean isWounded; // use for poison 
	protected boolean isIncapacitated; // use for freeze or stun
	protected Element element;

	public Unit(String unitName, int hp, int mp, int atk, int def, int speed, Element element) {
		super();
		setName(unitName);
		setHp(hp);
		setMp(mp);
		setAtk(atk);
		setDef(def);
		setSpeed(speed);
		setWounded(false);
		setIncapacitated(false);
		setElement(element);
	}

	public String getName() {
		return unitName;
	}

	public void setName(String name) {
		this.unitName = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = Math.max(hp, 0);
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = Math.max(0, mp);
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = Math.max(0, atk);
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = Math.max(0, def);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = Math.max(0, speed);
	}

	public boolean isWounded() {
		return isWounded;
	}

	public void setWounded(boolean isWounded) {
		this.isWounded = isWounded;
	}

	public boolean isIncapacitated() {
		return isIncapacitated;
	}

	public void setIncapacitated(boolean isIncapacitated) {
		this.isIncapacitated = isIncapacitated;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}
	
	

}
