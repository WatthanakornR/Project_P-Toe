package entity.base;

public interface BattleInterface {
    void attack(Unit target);   // ฟังก์ชันโจมตีศัตรู
    void useSkill(Unit target); // ฟังก์ชันใช้สกิลกับศัตรู
    boolean isDefeated();       // ตรวจสอบว่าตายหรือไม่
}
