package fr.karang.AddonManager.EntityAddon;


import java.util.List;
import java.util.UUID;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.metadata.*;
import org.bukkit.plugin.*;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.player.SpoutPlayer;

public class CustomEntity implements Entity {
	private int entityId;
	private int designId;
	private String texture;
	
	private SpoutPlayer[] passengers = new SpoutPlayer[4];
	private Location location;
	
	public CustomEntity (Location loc) {
		location = loc;
	}
	
	public int getCustomId() {
		return entityId;
	}
	
	public void setCustomId(int entityId) {
		this.entityId = entityId;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setDesign(int designId) {
		this.designId = designId;
	}
	
	public int getDesign() {
		return designId;
	}
	
	public void setTexture(String texture) {
		this.texture = texture;
	}
	
	public String getTexture() {
		return texture;
	}
	
	public boolean addPassenger(SpoutPlayer passenger) {
		for (int i=0 ; i<4 ; i++) {
			if (passengers[i]==null) {
				passengers[i] = passenger;
				PacketVehicle packet = new PacketVehicle(i, passenger.getName());
				for (Player p : passenger.getWorld().getPlayers())
					packet.send((SpoutPlayer) p);
				return true;
			}
		}
		return false;
	}
	
	public void ejectPassenger(SpoutPlayer passenger) {
		
	}
	
	public SpoutPlayer getDriver() {
		return passengers[0];
	}

	@Override
	public List<MetadataValue> getMetadata(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasMetadata(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeMetadata(String arg0, Plugin arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMetadata(String arg0, MetadataValue arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean eject() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getEntityId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getFallDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFireTicks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EntityDamageEvent getLastDamageCause() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxFireTicks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Entity> getNearbyEntities(double arg0, double arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity getPassenger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Server getServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTicksLived() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EntityType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID getUniqueId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity getVehicle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getVelocity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public World getWorld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInsideVehicle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean leaveVehicle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void playEffect(EntityEffect arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFallDistance(float arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFireTicks(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLastDamageCause(EntityDamageEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setPassenger(Entity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setTicksLived(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVelocity(Vector arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean teleport(Location arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean teleport(Entity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean teleport(Location arg0, TeleportCause arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean teleport(Entity arg0, TeleportCause arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
