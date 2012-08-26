package fr.karang.AddonManager.EntityAddon;

import org.getspout.spoutapi.io.AddonPacket;
import org.getspout.spoutapi.io.SpoutInputStream;
import org.getspout.spoutapi.io.SpoutOutputStream;
import org.getspout.spoutapi.player.SpoutPlayer;

public class PacketVehicle extends AddonPacket {

	public final short CONFIG = 0;
	public final short ENTER = 1;
	public final short LEAVE = 2;
	
	private short action;
	private int entityId;
	private String playerName;
	private short seatId;
	private double x;
	private double y;
	private double z;
	
	public PacketVehicle() {
		
	}
	
	public PacketVehicle(int entityId, short seatId, double x, double y, double z) {
		this.action = CONFIG;
		this.entityId = entityId;
		this.seatId = seatId;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public PacketVehicle(int entityId, short seatId, String passenger) {
		this.action = ENTER;
		this.entityId = entityId;
		this.seatId = seatId;
		this.playerName = passenger;
	}
	
	public PacketVehicle(int entityId, String passenger) {
		this.action = LEAVE;
		this.entityId = entityId;
		this.playerName = passenger;
	}
	
	@Override
	public void write(SpoutOutputStream out) {
		out.writeShort(action);
		out.writeInt(entityId);
		if (action==CONFIG) {
			out.writeShort(seatId);
			out.writeDouble(x);
			out.writeDouble(y);
			out.writeDouble(z);
		} else if (action==ENTER) {
			out.writeShort(seatId);
			out.writeString(playerName);
		} else if (action==LEAVE) {
			out.writeString(playerName);
		}
		
	}
	
	@Override
	public void read(SpoutInputStream in) {
		
	}

	@Override
	public void run(SpoutPlayer arg0) {
		
	}

}
