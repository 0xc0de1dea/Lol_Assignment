package champions;

import champions.mypackage.Champion;

public class Garen extends Champion {
    public Garen(String name, int level, int hp, int ad, int ap, int hpInc, double atkSpeed, long atkCoolTime, int atkInc, double atkSpeedInc, double critical, int qDmg, double qCoolTime, int qInc, double skillDelay, double atkCCCoolTime, double skillCCCoolTime) {
        super(name, level, hp, ad, ap, hpInc, atkSpeed, atkCoolTime, atkInc, atkSpeedInc, critical, qDmg, qCoolTime, qInc, skillDelay, atkCCCoolTime, skillCCCoolTime);
    }

    @Override
    public void useQ(Champion trg) {
        long now = System.currentTimeMillis();

        if (now - getSkillCCTimer() >= getSkillCCCoolTime() &&
                now - getqTimer() >= getqCoolTime()){
            setqTimer(System.currentTimeMillis());
            trg.takeDamage(getqDmg());
            trg.takeSkillCC(1500);
        }
    }
}
