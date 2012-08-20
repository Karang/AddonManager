package fr.karang.AddonManager.EntityAddon;

import java.util.*;

import org.bukkit.Location;
import org.getspout.spoutapi.player.SpoutPlayer;

public class CustomEntity {
	private int designId;
	private String texture;
	
	private List<SpoutPlayer> passengers = new ArrayList<SpoutPlayer>();
	private Location location;
	
	public CustomEntity (Location loc) {
		location = loc;
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
	
	public void addPassenger(SpoutPlayer p) {
		passengers.add(p);
	}
	
	public SpoutPlayer getDriver() {
		return passengers.get(0);
	}
	
	
}
