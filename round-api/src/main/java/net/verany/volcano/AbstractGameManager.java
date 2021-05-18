package net.verany.volcano;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.verany.api.gamemode.countdown.AbstractCountdown;
import net.verany.volcano.round.AbstractVolcanoRound;

import java.util.HashMap;
import java.util.Random;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class AbstractGameManager {

    private final AbstractVolcanoRound round;

    public final Random random = new Random();

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
