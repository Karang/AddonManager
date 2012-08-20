package fr.karang.AddonManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.io.AddonPacket;
import org.getspout.spoutapi.player.SpoutPlayer;

import fr.karang.AddonManager.EntityAddon.*;

public class AddonManager extends JavaPlugin {
	
	public static AddonManager plugin;
	
	public void onEnable() {
		AddonPacket.register(CustomEntityPacket.class, "entity");
		AddonPacket.register(EntityDesignPacket.class, "entityDesign");
		
		CustomEntityManager.registerCustomDesign("https://dl.dropbox.com/u/99253345/mailbox.obj");
		
		getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
	}
	
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
		if (!(sender instanceof Player))
			return false;
		
		SpoutPlayer player = (SpoutPlayer) sender;
		
		CustomEntity entity = new CustomEntity(player.getLocation());
		entity.setDesign(0);
		entity.setTexture("https://dl.dropbox.com/u/99253345/furnitures.png");
		
		CustomEntityManager.addEntity(entity);
		
		player.sendMessage("Entity spawn");
		
		return false;
	}
}
