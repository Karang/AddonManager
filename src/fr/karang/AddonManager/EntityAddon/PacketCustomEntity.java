package fr.karang.AddonManager.EntityAddon;

import org.getspout.spoutapi.io.AddonPacket;
import org.getspout.spoutapi.io.SpoutInputStream;
import org.getspout.spoutapi.io.SpoutOutputStream;
import org.getspout.spoutapi.player.SpoutPlayer;

public class PacketCustomEntity extends AddonPacket {

	// TODO: preload the texture and send only an id
	
	private int entityId;
	private int type;
	private String texture;
	private double x;
	private double y;
	private double z;
	
	public PacketCustomEntity() {
		
	}
	
	public PacketCustomEntity(int entityId, int type, String texture, double x, double y, double z) {
		this.entityId = entityId;
		this.type = type;
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public void read(SpoutInputStream in) {
		
	}

	@Override
	public void run(SpoutPlayer p) {
		
	}

	@Override
	public void write(SpoutOutputStream out) {
		out.writeInt(entityId);
		out.writeInt(type);
		out.writeString(texture);
		out.writeDouble(x);
		out.writeDouble(y);
		out.writeDouble(z);
	}

}
