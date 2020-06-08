package de.bypixels.spleef.events;

import de.bypixels.spleef.Spleef;
import de.bypixels.spleef.gamestates.Ingame;
import de.bypixels.spleef.gamestates.Lobby;
import de.bypixels.spleef.util.Variables;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class EVENT_PlayerQuit  implements Listener {

    private Spleef plugin;

    public EVENT_PlayerQuit(Spleef plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(null);



        if (Spleef.getPlugin().getGameStateHandler().getCurrentGameState() instanceof Lobby){
            if (Variables.getPlayers().contains(player.getUniqueId())){
                Bukkit.getServer().broadcastMessage(Spleef.getPlugin().getMessages().getStringWithColor("Prefix")+Spleef.getPlugin().getMessages().getStringWithColor("PLAYER_LEFT_GAME").replaceAll("%player%", player.getName()).replaceAll("%current%", Integer.toString(Variables.getPlayers().size()-1)).replaceAll("%max%", Integer.toString((int) Spleef.getPlugin().getSettings().getValue("MAX_PLAYERS"))));
            }
        }else{
            Bukkit.getServer().broadcastMessage(Spleef.getPlugin().getMessages().getStringWithColor("Prefix")+Spleef.getPlugin().getMessages().getStringWithColor("PLAYER_LEFT").replaceAll("%player%", player.getName()));
        }

        if (Variables.getPlayers().contains(player.getUniqueId())){
            Variables.getPlayers().remove(player.getUniqueId());
            Spleef.getPlugin().getUtility().removeHiddenPlayer(player);
            Spleef.getPlugin().getUtility().removeShowenPlayer(player);

        }else if(Variables.getSpectators().contains(player.getUniqueId())){
            Spleef.getPlugin().getUtility().removeHiddenPlayer(player);
            Spleef.getPlugin().getUtility().removeShowenPlayer(player);

        }
       Spleef.getPlugin().syncPlayers();

        if (Variables.getPlayers().size() == 0 && Spleef.getPlugin().getGameStateHandler().getCurrentGameState() instanceof Ingame){
            Bukkit.getServer().savePlayers();
            Bukkit.getServer().reload();
            Bukkit.getServer().reloadData();
        }

    }
}
