package champions;

import champions.mypackage.Champion;
import champions.mypackage.GameConstants;

public class Annie extends Champion {
    private int combo;

    public Annie(){
        super(GameConstants.ANNIE_NAME, GameConstants.BASE_LEVEL, GameConstants.ANNIE_HP, GameConstants.ANNIE_AD, GameConstants.ANNIE_AP, GameConstants.ANNIE_HP_INC, GameConstants.ANNIE_ATK_SPEED, GameConstants.ANNIE_ATK_COOLTIME,
                GameConstants.ANNIE_ATK_INC, GameConstants.BASE_ATK_SPEED_INC, GameConstants.BASE_CRITICAL, GameConstants.ANNIE_Q_DMG, GameConstants.ANNIE_Q_COOLTIME, GameConstants.ANNIE_Q_INC,
                GameConstants.BASE_SKILL_DELAY, GameConstants.BASE_ATK_CC_COOLTIME, GameConstants.BASE_SKILL_CC_COOLTIME);
    }

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
            setBattleCount();

            if (combo == 4){
                combo = 0;
                trg.takeAtkCC(1250);
                trg.takeSkillCC(1250);
            }
        }
    }
}
