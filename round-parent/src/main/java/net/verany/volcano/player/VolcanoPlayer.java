package net.verany.volcano.player;

import lombok.Getter;
import lombok.Setter;
import net.verany.api.Verany;
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
    public void joinRound(String id) {
        round = VeranyServer.ROUNDS.stream().filter(found -> found.getId().equals(id)).findFirst().orElse(null);

        assert round != null;

        round.getPlayers().add(this);
        Verany.sync(round.getProject(), () -> Bukkit.getPluginManager().callEvent(new VolcanoPlayerJoinEvent(player, round)));
    }

    @Override
    public void quitRound() {
        round.getPlayers().remove(this);
        System.out.println("ID:" + round.getId());
        Verany.sync(round.getProject(), () -> {
            Bukkit.getPluginManager().callEvent(new VolcanoPlayerQuitEvent(player, round));
            round = null;
        });
    }
}
