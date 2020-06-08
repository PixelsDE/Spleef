package de.bypixels.spleef.util.files;

import de.bypixels.pixelsapi.util.FileManager;
import org.bukkit.Bukkit;

public class Messages extends FileManager {

    public Messages(String path, String filename) {
        super(path, filename);
        activate();
    }

    @Override
    public void activate() {
        addDefaultValue("Prefix", "&7[&bSpleef&7] ");
        addDefaultValue("WELLCOME", "&aWillkommen auf dem Server");
        addDefaultValue("FULL_PLAYER", "&cSorry but the Game is full!");
        addDefaultValue("MISSING_PLAYERS", "&7There are/s &c%player% &7Player/s missing!");
        addDefaultValue("COUNTDOWN_LEFT", "&7There are/is &9%time% &7seconds left!");
        addDefaultValue("JOIN_GAME", "&7The Player &6%player% &7has joined the Game! [&d%min% &7/ &d%amount%&7]");
        addDefaultValue("BREAK_LOBBY_STATE", "&cYou cant Break or Place Blocks while youre in the Lobby!");
        addDefaultValue("NO_PVP_LOBBY", "&cThere is no PVP allowed on this Server while beeing in the Lobby!");
        addDefaultValue("PLAYER_JOINS_GAME", "&7The Player &6%player%&7 has joined the Game! &8[&6%current% &7/ &6%max%&8]");
        addDefaultValue("PLAYER_LEFT_GAME", "&7The Player &6%player%&7 has left the Game! &8[&6%current% &7/ &6%max%&8]");
        addDefaultValue("START_GAME", "&6Lets Goooo!");
        addDefaultValue("PLAYER_LEFT", "&7The Player &6%player%&f has left the Game!");



        Bukkit.getConsoleSender().sendMessage("§8[§bSpleef§8] "+"Activation of File 2 Complete!");
        saveFile();

    }


}
