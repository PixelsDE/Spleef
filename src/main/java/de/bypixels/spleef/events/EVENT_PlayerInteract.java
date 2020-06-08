package de.bypixels.spleef.events;

import de.bypixels.spleef.Spleef;
import de.bypixels.spleef.gamestates.Lobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class EVENT_PlayerInteract implements Listener {

    private Spleef plugin;

    public EVENT_PlayerInteract(Spleef plugin) {
        this.plugin = plugin;
    }


    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOW)
    public void onClickOnItemInventoryInLobby(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (player.hasPermission("Spleef.UseItem.*")) {

                if (Spleef.getPlugin().getGameStateHandler().getCurrentGameState() instanceof Lobby) {
                    event.setCancelled(true);
                    player.updateInventory();
                }
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onEntityDamageinLobby(EntityDamageEvent event) {
        if (Spleef.getPlugin().getGameStateHandler().getCurrentGameState() instanceof Lobby && event.getEntity() instanceof Player) {
            event.setDamage(0);
            event.setCancelled(true);
        }

    }
    @EventHandler(ignoreCancelled = true)
    public void onEntityDamageByEntityinLobby(EntityDamageByEntityEvent event) {
        if (Spleef.getPlugin().getGameStateHandler().getCurrentGameState() instanceof Lobby) {
            if (event.getEntity()instanceof Player || event.getDamager() instanceof Player) {
                event.setDamage(0);
                event.setCancelled(true);
                event.getDamager().sendMessage(Spleef.getPlugin().getMessages().getStringWithColor("Prefix")+Spleef.getPlugin().getMessages().getStringWithColor("NO_PVP_LOBBY"));
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onInventoryInteractInLobbyEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        player.sendMessage("hi");
        if (Spleef.getPlugin().getGameStateHandler().getCurrentGameState() instanceof Lobby) {
            event.setCancelled(true);
            player.updateInventory();
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerDropIteminLobby(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (Spleef.getPlugin().getGameStateHandler().getCurrentGameState() instanceof Lobby) {
            event.setCancelled(true);
            player.updateInventory();
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlaceBlockinLobbyPhse(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (Spleef.getPlugin().getGameStateHandler().getCurrentGameState() instanceof Lobby) {
            event.setCancelled(true);
            player.sendMessage(Spleef.getPlugin().getMessages().getStringWithColor("Prefix")+Spleef.getPlugin().getMessages().getStringWithColor("BREAK_LOBBY_STATE"));
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void breakBlockinLobby(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (Spleef.getPlugin().getGameStateHandler().getCurrentGameState() instanceof Lobby) {
            event.setCancelled(true);
            player.sendMessage(Spleef.getPlugin().getMessages().getStringWithColor("Prefix")+Spleef.getPlugin().getMessages().getStringWithColor("BREAK_LOBBY_STATE"));
        }
    }
}
