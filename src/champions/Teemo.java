package champions;

import champions.mypackage.Champion;

public class Teemo extends Champion {
    public Teemo(String name, int level, int hp, int ad, int ap, int hpInc, double atkSpeed, long atkCoolTime, int atkInc, double atkSpeedInc, double critical, int qDmg, double qCoolTime, int qInc, double skillDelay, double atkCCCoolTime, double skillCCCoolTime) {
        super(name, level, hp, ad, ap, hpInc, atkSpeed, atkCoolTime, atkInc, atkSpeedInc, critical, qDmg, qCoolTime, qInc, skillDelay, atkCCCoolTime, skillCCCoolTime);
    }

    @Override
    public void useQ(Champion trg) {
        long now = System.currentTimeMillis();

        if (now - getSkillCCTimer() >= getSkillCCCoolTime() &&
                now - getqTimer() >= getqCoolTime()){
            setqTimer(System.currentTimeMillis());
            trg.takeDamage(getqDmg() + (int)(getAp() * 0.7));
            trg.takeAtkCC(2000);
        }
    }
}
