package champions;

import champions.mypackage.Champion;
import champions.mypackage.GameConstants;

public class Teemo extends Champion {
    public Teemo(){
        super(GameConstants.TEEMO_NAME, GameConstants.BASE_LEVEL, GameConstants.TEEMO_HP, GameConstants.TEEMO_AD, GameConstants.TEEMO_AP, GameConstants.TEEMO_HP_INC, GameConstants.TEEMO_ATK_SPEED, GameConstants.TEEMO_ATK_COOLTIME,
                GameConstants.TEEMO_ATK_INC, GameConstants.BASE_ATK_SPEED_INC, GameConstants.BASE_CRITICAL, GameConstants.TEEMO_Q_DMG, GameConstants.TEEMO_Q_COOLTIME, GameConstants.TEEMO_Q_INC,
                GameConstants.BASE_SKILL_DELAY, GameConstants.BASE_ATK_CC_COOLTIME, GameConstants.BASE_SKILL_CC_COOLTIME);
    }

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
            setBattleCount();
        }
    }
}
