package de.bypixels.spleef.util;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Variables {



    private static List<UUID> Spectators = new ArrayList<>();
    private static List<UUID> Players = new ArrayList<>();


    public static List<UUID> getSpectators() {
        return Spectators;
    }

    public static List<UUID> getPlayers() {
        return Players;
    }



    public static void addSpectator(Player player) {
        getSpectators().add(player.getUniqueId());
    }

    public static void addPlayer(Player player) {
        getPlayers().add(player.getUniqueId());
    }
}
