package de.bypixels.spleef.util.files;

import de.bypixels.pixelsapi.util.FileManager;
import org.bukkit.Bukkit;

public class PlayerStatistics extends FileManager {
    public PlayerStatistics(String path, String filename) {
        super(path, filename);

    activate();
    }

    @Override
    public void activate() {


        addDefaultValue("PLAYER_UUID.KILLS", 0);
        addDefaultValue("PLAYER_UUID.WINS", 0);
        addDefaultValue("PLAYER_UUID.DEATHS", 0);
        addDefaultValue("PLAYER_UUID.GAMES", 0);
        Bukkit.getConsoleSender().sendMessage("§8[§bSpleef§8] "+"Activation of File 3 Complete!");


        saveFile();
    }
}
