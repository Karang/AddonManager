package fr.karang.AddonManager;

import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.getspout.spoutapi.player.SpoutPlayer;

import fr.karang.AddonManager.EntityAddon.*;

public class PlayerListener implements Listener {
	
	private final AddonManager plugin;
	
	public PlayerListener(AddonManager plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		final SpoutPlayer player = (SpoutPlayer) event.getPlayer();
		
		plugin.getEntityManager().sendCustomDesigns(player);
		plugin.getEntityManager().sendCustomEntities(player);
	}
	
	@EventHandler
	public void onEntityInterract(PlayerInteractEntityEvent event) {
		SpoutPlayer p = (SpoutPlayer) event.getPlayer();
		
		if (event.getRightClicked() instanceof CustomEntity) {
			CustomEntity entity = (CustomEntity) event.getRightClicked();
			p.sendMessage("EntityId:"+entity.getCustomId());
			entity.addPassenger(p);
		}
	}
}
