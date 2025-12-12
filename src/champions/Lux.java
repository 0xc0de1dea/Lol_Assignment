package champions;

import champions.mypackage.Champion;
import champions.mypackage.GameConstants;

public class Lux extends Champion {
    public Lux(){
        super(GameConstants.LUX_NAME, GameConstants.BASE_LEVEL, GameConstants.LUX_HP, GameConstants.LUX_AD, GameConstants.LUX_AP, GameConstants.LUX_HP_INC, GameConstants.LUX_ATK_SPEED, GameConstants.LUX_ATK_COOLTIME,
                GameConstants.LUX_ATK_INC, GameConstants.BASE_ATK_SPEED_INC, GameConstants.BASE_CRITICAL, GameConstants.LUX_Q_DMG, GameConstants.LUX_Q_COOLTIME, GameConstants.LUX_Q_INC,
                GameConstants.BASE_SKILL_DELAY, GameConstants.BASE_ATK_CC_COOLTIME, GameConstants.BASE_SKILL_CC_COOLTIME);
    }

    public Lux(String name, int level, int hp, int ad, int ap, int hpInc, double atkSpeed, long atkCoolTime, int atkInc, double atkSpeedInc, double critical, int qDmg, double qCoolTime, int qInc, double skillDelay, double atkCCCoolTime, double skillCCCoolTime) {
        super(name, level, hp, ad, ap, hpInc, atkSpeed, atkCoolTime, atkInc, atkSpeedInc, critical, qDmg, qCoolTime, qInc, skillDelay, atkCCCoolTime, skillCCCoolTime);
    }

    @Override
    public void useQ(Champion trg) {
        long now = System.currentTimeMillis();

        if (now - getSkillCCTimer() >= getSkillCCCoolTime() &&
        now - getqTimer() >= getqCoolTime()){
            setqTimer(System.currentTimeMillis());
            trg.takeDamage(getqDmg() + (int)(getAp() * 0.65));
            setBattleCount();
        }
    }
}
