package net.verany.volcano.player;

import lombok.Getter;
import lombok.Setter;
import net.verany.api.AbstractVerany;
import net.verany.api.module.VeranyProject;
import net.verany.volcano.VeranyServer;
import net.verany.volcano.event.VolcanoPlayerJoinEvent;
import net.verany.volcano.event.VolcanoPlayerQuitEvent;
import net.verany.volcano.round.AbstractVolcanoRound;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
@Setter
public class VolcanoPlayer implements IVolcanoPlayer {

    private UUID uniqueId;
    private AbstractVolcanoRound round;

    private Player player = null;

    @Override
    public void load(UUID uuid) {
        this.uniqueId = uuid;
        this.player = Bukkit.getPlayer(uuid);
    }

    @Override
    public void update() {

    }

    @Override
    public void joinRound(String id, VeranyProject project) {
        round = VeranyServer.ROUNDS.stream().filter(found -> found.getId().equals(id)).findFirst().orElse(null);

        assert round != null;

        round.getPlayers().add(this);

        for (IVolcanoPlayer otherPlayer : round.getOtherPlayers()) {
            Player otherBukkitPlayer = Bukkit.getPlayer(otherPlayer.getUniqueId());
            otherBukkitPlayer.hidePlayer(project, player);
            player.hidePlayer(project, otherBukkitPlayer);
        }

        AbstractVerany.sync(round.getProject(), () -> Bukkit.getPluginManager().callEvent(new VolcanoPlayerJoinEvent(player, round)));
    }

    @Override
    public void quitRound() {
        round.getPlayers().remove(this);
        System.out.println("ID:" + round.getId());
        AbstractVerany.sync(round.getProject(), () -> {
            Bukkit.getPluginManager().callEvent(new VolcanoPlayerQuitEvent(player, round));
            round = null;
        });
    }
}
