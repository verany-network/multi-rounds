package net.verany.volcano;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.verany.api.gamemode.countdown.AbstractCountdown;
import net.verany.volcano.round.AbstractVolcanoRound;

import java.util.HashMap;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class AbstractGameManager {

    private final AbstractVolcanoRound round;

    public AbstractCountdown startLobby() {
        AbstractCountdown countdown = round.getSettingValue(GameSetting.LOBBY_TASK);
        if (countdown == null) return null;
        countdown.start();
        return countdown;
    }

    public abstract void update();

    public abstract void setIngame();

    public abstract void reset();


}
