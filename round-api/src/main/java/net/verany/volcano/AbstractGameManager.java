package net.verany.volcano;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.verany.api.gamemode.countdown.AbstractCountdown;
import net.verany.api.module.VeranyProject;
import net.verany.api.setting.SettingLoader;
import net.verany.volcano.round.AbstractVolcanoRound;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class AbstractGameManager extends SettingLoader {

    private final AbstractVolcanoRound round;

    public AbstractCountdown startLobby() {
        AbstractCountdown countdown = getSettingValue(GameSetting.LOBBY_TASK);
        if (countdown == null) return null;
        countdown.start();
        return countdown;
    }

    public abstract void setIngame();

    public abstract void reset();

}
