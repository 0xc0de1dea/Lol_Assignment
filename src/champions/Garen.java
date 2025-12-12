package champions;

import champions.mypackage.Champion;
import champions.mypackage.GameConstants;

public class Garen extends Champion {
    public Garen(){
        super(GameConstants.GAREN_NAME, GameConstants.BASE_LEVEL, GameConstants.GAREN_HP, GameConstants.GAREN_AD, GameConstants.GAREN_AP, GameConstants.GAREN_HP_INC, GameConstants.GAREN_ATK_SPEED, GameConstants.GAREN_ATK_COOLTIME,
                GameConstants.GAREN_ATK_INC, GameConstants.BASE_ATK_SPEED_INC, GameConstants.BASE_CRITICAL, GameConstants.GAREN_Q_DMG, GameConstants.GAREN_Q_COOLTIME, GameConstants.GAREN_Q_INC,
                GameConstants.BASE_SKILL_DELAY, GameConstants.BASE_ATK_CC_COOLTIME, GameConstants.BASE_SKILL_CC_COOLTIME);
    }

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
            setBattleCount();
        }
    }
}
