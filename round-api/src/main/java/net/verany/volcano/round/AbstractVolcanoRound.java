package net.verany.volcano.round;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.verany.api.AbstractVerany;
import net.verany.api.gamemode.AbstractGameMode;
import net.verany.api.module.VeranyProject;
import net.verany.api.player.IPlayerInfo;
import net.verany.api.settings.SettingLoader;
import net.verany.volcano.AbstractGameManager;
import net.verany.volcano.player.IVolcanoPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public abstract class AbstractVolcanoRound extends SettingLoader {

    private final String id = AbstractVerany.generate(10);
    private final VeranyProject project;
    private final AbstractGameMode gameMode;
    private final List<IVolcanoPlayer> players = new ArrayList<>();

    public abstract <T extends AbstractGameManager> T getGameManager(Class<T> tClass);

    public abstract <T extends AbstractGameManager> void setGameManager(Class<T> tClass, T gameManager);

    public List<IVolcanoPlayer> getOtherPlayers() {
        List<IVolcanoPlayer> toReturn = new ArrayList<>();
        for (IVolcanoPlayer player : AbstractVerany.getPlayers(IVolcanoPlayer.class))
            if (!players.contains(player))
                toReturn.add(player);
        return toReturn;
    }

    public List<IPlayerInfo> getVeranyPlayers() {
        List<IPlayerInfo> toReturn = new ArrayList<>();
        for (IVolcanoPlayer player : players)
            toReturn.add(AbstractVerany.getPlayer(player.getUniqueId()));
        return toReturn;
    }

    public List<Player> getBukkitPlayers() {
        List<Player> toReturn = new ArrayList<>();
        for (IVolcanoPlayer player : players)
            toReturn.add(Bukkit.getPlayer(player.getUniqueId()));
        return toReturn;
    }

}
