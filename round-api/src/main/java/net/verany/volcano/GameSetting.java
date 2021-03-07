package net.verany.volcano;

import net.verany.api.gamemode.GameState;
import net.verany.api.gamemode.countdown.AbstractCountdown;
import net.verany.api.settings.AbstractSetting;
import net.verany.api.settings.SettingWrapper;

public class GameSetting {

    public static final AbstractSetting<AbstractCountdown> LOBBY_TASK = new SettingWrapper.TempSettingWrapper<>("lobbyTask", AbstractCountdown.class, null);
    public static final AbstractSetting<AbstractCountdown> INGAME_TASK = new SettingWrapper.TempSettingWrapper<>("ingameTask", AbstractCountdown.class, null);
    public static final AbstractSetting<AbstractCountdown> END_TASK = new SettingWrapper.TempSettingWrapper<>("endTask", AbstractCountdown.class, null);
    public static final AbstractSetting<GameState> GAME_STATE = new SettingWrapper.TempSettingWrapper<>("gameState", GameState.class, GameState.WAITING);
    public static final AbstractSetting<Boolean> TAB_LIST = new SettingWrapper.TempSettingWrapper<>("tablist", Boolean.class, true);
    public static final AbstractSetting<Boolean> CHAT = new SettingWrapper.TempSettingWrapper<>("chat", Boolean.class, true);
    public static final AbstractSetting<Integer> MAX_PLAYERS = new SettingWrapper.TempSettingWrapper<>("max_players", Integer.class, 20);

}
