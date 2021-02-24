package net.verany.volcano;

import net.verany.api.gamemode.GameState;
import net.verany.api.gamemode.countdown.AbstractCountdown;
import net.verany.api.setting.SettingWrapper;
import net.verany.api.settings.AbstractSetting;

public class GameSetting {

    public static final AbstractSetting<AbstractCountdown> LOBBY_TASK = new SettingWrapper.TempSettingWrapper<>("lobbyTask", AbstractCountdown.class, null);
    public static final AbstractSetting<AbstractCountdown> INGAME_TASK = new SettingWrapper.TempSettingWrapper<>("ingameTask", AbstractCountdown.class, null);
    public static final AbstractSetting<AbstractCountdown> END_TASK = new SettingWrapper.TempSettingWrapper<>("endTask", AbstractCountdown.class, null);
    public static final AbstractSetting<GameState> GAME_STATE = new SettingWrapper.TempSettingWrapper<>("gameState", GameState.class, GameState.WAITING);

}
