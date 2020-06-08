package de.bypixels.spleef.events;

import de.bypixels.spleef.Spleef;
import de.bypixels.spleef.gamestates.Lobby;
import de.bypixels.spleef.util.Variables;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EVENT_PlayerJoin implements Listener {

    private Spleef plugin;

    public EVENT_PlayerJoin(Spleef plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        Player player = event.getPlayer();
        player.getInventory().clear();
        if (Spleef.getPlugin().getGameStateHandler().getCurrentGameState() instanceof Lobby) {
            if (player.hasPermission("spleef.join")) {
                if ((Integer) Spleef.getPlugin().getSettings().getValue("MAX_PLAYERS") >= Bukkit.getServer().getOnlinePlayers().size()) {
                    if (!Variables.getPlayers().contains(player.getUniqueId())) {
                        //Adding Item to Players Inventory and adding him to Players List
                        player.getInventory().setContents(Spleef.getPlugin().getInventories().getUserStartInventory().getContents());
                        Variables.getPlayers().add(player.getUniqueId());
                        player.setDisplayName(Spleef.getPlugin().getMessages().getStringWithColor("Prefix") + ChatColor.BLUE + player.getName() + "§f");
                        player.setPlayerListName(Spleef.getPlugin().getMessages().getStringWithColor("Prefix") + ChatColor.BLUE + player.getName() + "§f");

                        Spleef.getPlugin().getUtility().BroadcastGlobalMessage(Spleef.getPlugin().getMessages().getStringWithColor("Prefix"), Spleef.getPlugin().
                                getMessages().getStringWithColor("PLAYER_JOINS_GAME").replaceAll("%current%", Integer.toString(Variables.getPlayers().size())).replaceAll("%player%", player.getName()).replaceAll("%max%", Integer.toString((Integer) Spleef.getPlugin().
                                getSettings().getValue("MAX_PLAYERS"))));

                        Spleef.getPlugin().syncPlayers();
                    }
                } else {
                    player.sendMessage(Spleef.getPlugin().getMessages().getStringWithColor("Prefix") + Spleef.getPlugin().getMessages().getStringWithColor("FULL_PLAYER"));
                    Variables.addSpectator(player);
                    Spleef.getPlugin().getUtility().addHiddenPlayer(player);
                    Spleef.getPlugin().syncPlayers();
                }

            } else {
                Spleef.getPlugin().getUtility().addHiddenPlayer(player);
                Spleef.getPlugin().syncPlayers();
                try {
                    player.kickPlayer("§cYou Dont Have the Permission to Play");
                } catch (Exception e) {
                }
            }
        } else {
            Spleef.getPlugin().getUtility().addHiddenPlayer(player);
            Spleef.getPlugin().syncPlayers();
            Variables.addSpectator(player);
        }
    }


    private void sendJoinMessage(Player player) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.sendMessage(Spleef.getPlugin().getMessages().getStringWithColor("Prefix") + Spleef.getPlugin().getMessages().getStringWithColor("JOIN_GAME").replaceAll("%player%", player.getName()).replaceAll("%min%", Integer.toString((int) Spleef.getPlugin().getSettings().getValue("MIN_PLAYERS"))).replaceAll("%amount%", Integer.toString(Variables.getPlayers().size())));
        }
    }
}
