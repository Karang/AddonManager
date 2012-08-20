package fr.karang.AddonManager;

import org.bukkit.event.*;
import org.bukkit.event.player.PlayerJoinEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

import fr.karang.AddonManager.EntityAddon.CustomEntityManager;

public class PlayerListener implements Listener {
	
	private AddonManager plugin;
	
	public PlayerListener(AddonManager plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		SpoutPlayer player = (SpoutPlayer) event.getPlayer();
		/*for (String k : player.getAddons().keySet())
			player.sendMessage(k + " : " + player.getAddons().get(k));*/
		CustomEntityManager.sendCustomDesigns(player);
	}
}
