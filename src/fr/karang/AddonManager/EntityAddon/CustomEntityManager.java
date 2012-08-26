package fr.karang.AddonManager.EntityAddon;

import java.util.*;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class CustomEntityManager {
	private final List<CustomEntity> entities = new ArrayList<CustomEntity>();
	private final List<EntityDesign> customDesigns = new ArrayList<EntityDesign>();
	
	public void addEntity(CustomEntity entity) {
		entities.add(entity);
		entity.setCustomId(entities.size()-1);
		Location loc = entity.getLocation();
		
		PacketCustomEntity packet = new PacketCustomEntity(entity.getCustomId(),entity.getDesign(),entity.getTexture(), loc.getX(), loc.getY(), loc.getZ());
		for (Player p : loc.getWorld().getPlayers())
			packet.send((SpoutPlayer) p);
		
		Bukkit.getServer().broadcastMessage("Spawn entity with id:"+entity.getCustomId());
	}
	
	public CustomEntity getEntity(int entityId) {
		return entities.get(entityId);
	}
	
	public int registerCustomDesign(EntityDesign design) {
		if (customDesigns.contains(design))
			return customDesigns.indexOf(design);
		
		customDesigns.add(design);
		int id = customDesigns.size()-1;
		
		return id;
	}
	
	public void sendCustomDesigns(SpoutPlayer player) {
		for (int id=0 ; id<customDesigns.size() ; id++) {
			if (customDesigns.get(id)!=null) {
				PacketEntityDesign packet = new PacketEntityDesign(id, customDesigns.get(id));
				packet.send(player);
			}
		}
	}
	
	public void sendCustomEntities(SpoutPlayer player) {
		for (int id=0 ; id<entities.size() ; id++) {
			if (entities.get(id)!=null) {
				CustomEntity e = entities.get(id);
				PacketCustomEntity packet = new PacketCustomEntity(e.getCustomId(), e.getDesign(), e.getTexture(), e.getLocation().getX(), e.getLocation().getY(), e.getLocation().getZ());
				packet.send(player);	
			}
		}
	}
}
