package fr.karang.AddonManager.EntityAddon;

import java.util.*;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

import fr.karang.AddonManager.*;

public class CustomEntityManager {
	public static List<CustomEntity> entities = new ArrayList<CustomEntity>();
	public static List<String> customDesigns = new ArrayList<String>();
	
	public static void addEntity(CustomEntity entity) {
		entities.add(entity);
		Location loc = entity.getLocation();
		CustomEntityPacket packet = new CustomEntityPacket(entity.getDesign(),entity.getTexture(), loc.getX(), loc.getY(), loc.getZ());
		for (Player p : loc.getWorld().getPlayers())
			packet.send((SpoutPlayer) p);
	}
	
	public static int registerCustomDesign(String url) {
		if (customDesigns.contains(url))
			return customDesigns.indexOf(url);
		
		customDesigns.add(url);
		int id = customDesigns.size()-1;
		
		return id;
	}
	
	public static void sendCustomDesigns(SpoutPlayer player) {
		for (int id=0 ; id<customDesigns.size() ; id++) {
			if (customDesigns.get(id)!=null) {
				EntityDesignPacket packet = new EntityDesignPacket(id, customDesigns.get(id));
				packet.send(player);
			}
		}
	}
}
