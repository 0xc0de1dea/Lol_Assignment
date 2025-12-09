package champions;

import champions.mypackage.Champion;

public class Annie extends Champion {
    private int combo;

    public Annie(String name, int level, int hp, int ad, int ap, int hpInc, double atkSpeed, long atkCoolTime, int atkInc, double atkSpeedInc, double critical, int qDmg, double qCoolTime, int qInc, double skillDelay, double atkCCCoolTime, double skillCCCoolTime) {
        super(name, level, hp, ad, ap, hpInc, atkSpeed, atkCoolTime, atkInc, atkSpeedInc, critical, qDmg, qCoolTime, qInc, skillDelay, atkCCCoolTime, skillCCCoolTime);
        this.combo = 0;
    }

    @Override
    public void useQ(Champion trg) {
        long now = System.currentTimeMillis();

        if (now - getSkillCCTimer() >= getSkillCCCoolTime() &&
                now - getqTimer() >= getqCoolTime()){
            setqTimer(System.currentTimeMillis());
            combo++;
            trg.takeDamage(getqDmg() + (int)(getAp() * 0.8));

            if (combo == 4){
                combo = 0;
                trg.takeAtkCC(1250);
                trg.takeSkillCC(1250);
            }
        }
    }
}
