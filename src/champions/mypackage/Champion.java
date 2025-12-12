package champions.mypackage;

import java.util.ArrayList;

public abstract class Champion {
    public class Log {
        static StringBuilder sb = new StringBuilder();

        public static void setLog(String s){
            sb.append(s).append("\n");
        }

        public static String getLog(){
            return sb.toString();
        }
    }

    private String name;
    private int level;
    private int hp;
    private int ad;
    private int ap;
    private int hpInc;
    private double atkSpeed;
    private long atkCoolTime;
    private int atkInc;
    private double atkSpeedInc;
    private double critical;
    private int qDmg;
    private double qCoolTime;
    private int qInc;
    private double skillDelay;
    private double atkCCCoolTime;
    private double skillCCCoolTime;

    private long atkTimer;
    private long qTimer;
    private long atkCCTimer;
    private long skillCCTimer;

    private static int battleCount = 0;

    public Champion(String name, int level, int hp, int ad, int ap, int hpInc, double atkSpeed, long atkCoolTime, int atkInc, double atkSpeedInc, double critical, int qDmg, double qCoolTime, int qInc, double skillDelay, double atkCCCoolTime, double skillCCCoolTime) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.ad = ad;
        this.ap = ap;
        this.hpInc = hpInc;
        this.atkSpeed = atkSpeed;
        this.atkCoolTime = atkCoolTime;
        this.atkInc = atkInc;
        this.atkSpeedInc = atkSpeedInc;
        this.critical = critical;
        this.qDmg = qDmg;
        this.qCoolTime = qCoolTime;
        this.qInc = qInc;
        this.skillDelay = skillDelay;
        this.atkCCCoolTime = atkCCCoolTime;
        this.skillCCCoolTime = skillCCCoolTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public double getAtkSpeed() {
        return atkSpeed;
    }

    public void setAtkSpeed(double atkSpeed) {
        this.atkSpeed = atkSpeed;
    }

    public long getAtkCoolTime() {
        return atkCoolTime;
    }

    public void setAtkCoolTime(long atkCoolTime) {
        this.atkCoolTime = atkCoolTime;
    }

    public int getAtkInc() {
        return atkInc;
    }

    public void setAtkInc(int atkInc) {
        this.atkInc = atkInc;
    }

    public double getAtkSpeedInc() {
        return atkSpeedInc;
    }

    public void setAtkSpeedInc(double atkSpeedInc) {
        this.atkSpeedInc = atkSpeedInc;
    }

    public double getCritical() {
        return critical;
    }

    public void setCritical(double critical) {
        this.critical = critical;
    }

    public int getqDmg() {
        return qDmg;
    }

    public void setqDmg(int qDmg) {
        this.qDmg = qDmg;
    }

    public double getqCoolTime() {
        return qCoolTime;
    }

    public void setqCoolTime(double qCoolTime) {
        this.qCoolTime = qCoolTime;
    }

    public int getqInc() {
        return qInc;
    }

    public void setqInc(int qInc) {
        this.qInc = qInc;
    }

    public double getSkillDelay() {
        return skillDelay;
    }

    public void setSkillDelay(double skillDelay) {
        this.skillDelay = skillDelay;
    }

    public double getAtkCCCoolTime() {
        return atkCCCoolTime;
    }

    public void setAtkCCCoolTime(double atkCCCoolTime) {
        this.atkCCCoolTime = atkCCCoolTime;
    }

    public double getSkillCCCoolTime() {
        return skillCCCoolTime;
    }

    public void setSkillCCCoolTime(double skillCCCoolTime) {
        this.skillCCCoolTime = skillCCCoolTime;
    }

    public void takeDamage(int dmg){
        this.hp -= dmg;

        if (this.hp <= 0) this.hp = 0;

        Champion.Log.setLog(name + " 이(가) " + dmg + " 만큼의 데미지를 입음.");
        System.out.println(name + " 이(가) " + dmg + " 만큼의 데미지를 입음.");
        Champion.Log.setLog(name + " 의 현재 체력 : " + this.hp);
        System.out.println(name + " 의 현재 체력 : " + this.hp);
    }

    public void levelUp(int num){
        this.ad += atkInc * num;
        this.hp += hpInc * num;
        this.qDmg += qInc * num;
        this.atkSpeed += atkSpeedInc * num;
        this.atkCoolTime = (long)(1000 / atkSpeed);
    }

    public long getAtkTimer() {
        return atkTimer;
    }

    public void setAtkTimer(long atkTimer) {
        this.atkTimer = atkTimer;
    }

    public long getqTimer() {
        return qTimer;
    }

    public void setqTimer(long qTimer) {
        this.qTimer = qTimer;
    }

    public long getAtkCCTimer() {
        return atkCCTimer;
    }

    public void setAtkCCTimer(long atkCCTimer) {
        this.atkCCTimer = atkCCTimer;
    }

    public long getSkillCCTimer() {
        return skillCCTimer;
    }

    public void setSkillCCTimer(long skillCCTimer) {
        this.skillCCTimer = skillCCTimer;
    }

    public static int getBattleCount() {
        return battleCount;
    }

    public static void setBattleCount() {
        Champion.battleCount++;
    }

    public void takeSkillCC(long time){
        this.skillCCCoolTime = time;
        this.skillCCTimer = System.currentTimeMillis();
    }

    public void takeAtkCC(long time){
        this.atkCCCoolTime = time;
        this.atkCCTimer = System.currentTimeMillis();
    }

    public void attack(Champion trg){
        long now = System.currentTimeMillis();

        if (now - getAtkCCTimer() >= getAtkCCCoolTime() &&
        now - getAtkTimer() >= getAtkCoolTime()){
            trg.takeDamage(ad);
            setAtkTimer(System.currentTimeMillis());
            setBattleCount();
        }
    }

    public final void resurrect(){
        setHp(1);
    }

    public abstract void useQ(Champion trg);
}
