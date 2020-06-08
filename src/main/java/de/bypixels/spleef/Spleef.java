package de.bypixels.spleef;


import de.bypixels.pixelsapi.PixelsAPI;
import de.bypixels.pixelsapi.util.Utility;
import de.bypixels.spleef.commands.*;
import de.bypixels.spleef.events.EVENT_PlayerDeath;
import de.bypixels.spleef.events.EVENT_PlayerInteract;
import de.bypixels.spleef.events.EVENT_PlayerJoin;
import de.bypixels.spleef.events.*;
import de.bypixels.spleef.gamestates.GameStateHandler;
import de.bypixels.spleef.gamestates.GameStatesEnums;
import de.bypixels.spleef.util.Inventories;
import de.bypixels.spleef.util.Items;
import de.bypixels.spleef.util.Variables;
import de.bypixels.spleef.util.files.Extra;
import de.bypixels.spleef.util.files.Messages;
import de.bypixels.spleef.util.files.PlayerStatistics;
import de.bypixels.spleef.util.files.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Spleef extends JavaPlugin {


    private Settings settings;
    private Messages messages;
    private PlayerStatistics playerStatistics;
    private Extra extra;

    private Variables variables;



    private de.bypixels.pixelsapi.util.Utility utility;
    private de.bypixels.pixelsapi.PixelsAPI PixelsAPI;
    private Inventories inventories;
    private Items items;
    private GameStateHandler gameStateHandler;



    private static Spleef plugin;

    private PluginManager pluginManager = Bukkit.getPluginManager();

    public static Spleef getPlugin() {
        return plugin;
    }

    public Variables getVariables() {
        return variables;
    }

    public Items getItems() {
        return items;
    }

    public Settings getSettings() {
        return settings;
    }

    public Messages getMessages() {
        return messages;
    }

    public Inventories getInventories() {
        return inventories;
    }
    public PlayerStatistics getPlayerStatistics() {
        return playerStatistics;
    }

    public GameStateHandler getGameStateHandler() {
        return gameStateHandler;
    }

    public de.bypixels.pixelsapi.PixelsAPI getPixelsAPI() {
        return PixelsAPI;
    }

    public de.bypixels.pixelsapi.util.Utility getUtility() {
        return utility;
    }

    public Extra getExtra() {
        return extra;
    }

    public PluginManager getPluginManager() {
        return pluginManager;
    }


    @Override
    public void onEnable() {
        // Plugin startup logic

        try {
            plugin = this;
            PixelsAPI = new PixelsAPI(this);
            initiate();


            Bukkit.getServer().getConsoleSender().sendMessage(this.getMessages().getStringWithColor("Prefix") + ChatColor.GREEN + "The Plugin is Enabled");
        } catch (Exception e) {
            e.printStackTrace();
            pluginManager.disablePlugin(this);
        }

    }

    public void syncPlayers() {
        Spleef.getPlugin().getUtility().syncDataFiles(Spleef.getPlugin().getUtility().getHiddenPlayers(), Variables.getSpectators());
        Spleef.getPlugin().getUtility().syncDataFiles(Spleef.getPlugin().getUtility().getShowenPlayers(), Variables.getPlayers());
        Spleef.getPlugin().getUtility().hideHiddenPlayersFromShowen();
    }

    private void initiate() {

        settings = new Settings("Spleef", "Settings");
        messages = new Messages("Spleef", "Messages");
        playerStatistics = new PlayerStatistics("Spleef", "Stats");

        utility = new Utility(getPlugin());
        extra = new Extra();
        variables = new Variables();
    //   items = new Items();
      //  inventories = new Inventories();
        registerCommands();
        registerEvents(pluginManager);
        gameStateHandler = new GameStateHandler(plugin);
        gameStateHandler.setCurrentGameState(GameStatesEnums.LOBBY_STATE);


    }


    private void registerEvents(PluginManager pluginManager) {

        pluginManager.registerEvents(new EVENT_PlayerInteract(this), this);
        pluginManager.registerEvents(new EVENT_PlayerJoin(this), this);
        pluginManager.registerEvents(new EVENT_PlayerDeath(this), this);
        pluginManager.registerEvents(new EVENT_PlayerQuit(this), this);

    }

    private void registerCommands() {

        getCommand("leave").setExecutor(new COMMAND_Leave());
        getCommand("activate").setExecutor(new COMMAND_Activate());
        getCommand("edit").setExecutor(new COMMAND_EditMode());
        getCommand("set").setExecutor(new COMMAND_SetLocations());
        getCommand("start").setExecutor(new COMMAND_Start());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        Bukkit.getServer().getConsoleSender().sendMessage(this.getMessages().getStringWithColor("Prefix") + ChatColor.DARK_RED + "The Plugin is Disabled");
    }
}
