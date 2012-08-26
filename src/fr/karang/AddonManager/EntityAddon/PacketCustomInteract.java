package fr.karang.AddonManager.EntityAddon;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.getspout.spoutapi.io.*;
import org.getspout.spoutapi.player.SpoutPlayer;

import fr.karang.AddonManager.AddonManager;

public class PacketCustomInteract extends AddonPacket {

	private int entityId;
	
	public PacketCustomInteract () {
		
	}
	
	public PacketCustomInteract (int entityId) {
		this.entityId = entityId;
	}
	
	@Override
	public void read(SpoutInputStream in) {
		entityId = in.readInt();
	}

	@Override
	public void write(SpoutOutputStream out) {
		out.writeInt(entityId);
	}

	@Override
	public void run(SpoutPlayer player) {
		Entity e = AddonManager.getPlugin().getEntityManager().getEntity(entityId);
		Bukkit.getPluginManager().callEvent(new PlayerInteractEntityEvent(player, e));
	}

}

