package de.bypixels.spleef.gamestates;

import de.bypixels.spleef.Spleef;
import de.bypixels.spleef.util.countdowns.LobbyCountDown;

public class Lobby extends GameState{


    Spleef plugin;

    public Lobby(Spleef plugin) {
        this.plugin = plugin;
    }

    public static int MIN_PLAYERS = (Integer) Spleef.getPlugin().getSettings().getValue("MIN_PLAYERS"), MAX_PLAYERS =  (Integer) Spleef.getPlugin().getSettings().getValue("MAX_PLAYERS");
    @Override
    public void start() {


        LobbyCountDown lobbyCountDown = new LobbyCountDown(plugin);
        lobbyCountDown.start();

    }

    @Override
    public void stop() {

    }


}
