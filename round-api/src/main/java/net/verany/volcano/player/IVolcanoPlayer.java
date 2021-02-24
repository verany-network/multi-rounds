package net.verany.volcano.player;

import net.verany.api.interfaces.IDefault;
import net.verany.volcano.round.AbstractVolcanoRound;

import java.util.UUID;

public interface IVolcanoPlayer extends IDefault<UUID> {

    AbstractVolcanoRound getRound();

    void joinRound(String id);

    void quitRound();

}
