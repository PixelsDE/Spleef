package de.bypixels.spleef.util.files;

import de.bypixels.pixelsapi.util.FileManager;
import org.bukkit.Bukkit;

public class Settings extends FileManager {

    public Settings(String path, String filename) {
        super(path, filename);
        activate();
    }


    @Override
    public void activate() {



        addDefaultValue("MIN_PLAYERS", 1);
        addDefaultValue("MAX_PLAYERS", 10);
        addDefaultValue("LOBBY_DELAY", 15);
        addDefaultValue("END_DELAY", 10);
        addDefaultValue("EDIT_MODE", false);
        addDefaultValue("ACTIVATE_GAME", true);
        addDefaultValue("SWORD_NAME", "&6Diamond Spleef Caster");
        addDefaultValue("LEAVE_DOOR_NAME", "&cLeave Game");

        Bukkit.getConsoleSender().sendMessage("§8[§bSpleef§8] "+"Activation of File 1 Complete!");
        saveFile();
    }


}
