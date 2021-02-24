package net.verany.volcano;

import net.verany.api.gamemode.AbstractGameMode;
import net.verany.api.module.VeranyProject;
import net.verany.volcano.round.AbstractVolcanoRound;
import net.verany.volcano.round.VolcanoRound;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class VeranyServer {

    public static final List<AbstractVolcanoRound> ROUNDS = new ArrayList<>();

    public static void registerGameMode(VeranyProject project, AbstractGameMode gameMode) {
        for (int i = 0; i < project.getModule().maxRounds(); i++)
            ROUNDS.add(new VolcanoRound(project, gameMode));
    }

    public static void setGameManager(Consumer<List<AbstractVolcanoRound>> rounds) {
        rounds.accept(ROUNDS);
    }

}
