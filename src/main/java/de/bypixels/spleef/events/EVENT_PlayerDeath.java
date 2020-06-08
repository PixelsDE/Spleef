package de.bypixels.spleef.events;

import de.bypixels.spleef.Spleef;
import de.bypixels.spleef.util.Variables;
import net.minecraft.server.v1_15_R1.PacketPlayInClientCommand;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EVENT_PlayerDeath implements Listener {


    private Spleef plugin;

    public EVENT_PlayerDeath(Spleef plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerDeathbyKill(PlayerDeathEvent event) {
        Player player = event.getEntity();

        Variables.getPlayers().remove(player);
        Variables.getSpectators().add(player.getUniqueId());
        Spleef.getPlugin().getUtility().getShowenPlayers().remove(player);
        Spleef.getPlugin().getUtility().getHiddenPlayers().add(player.getUniqueId());
        ((CraftPlayer) player).getHandle().playerConnection.a(new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN));
    }


}
