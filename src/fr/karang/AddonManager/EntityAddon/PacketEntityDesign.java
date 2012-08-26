package fr.karang.AddonManager.EntityAddon;

import org.getspout.spoutapi.io.AddonPacket;
import org.getspout.spoutapi.io.SpoutInputStream;
import org.getspout.spoutapi.io.SpoutOutputStream;
import org.getspout.spoutapi.player.SpoutPlayer;


public class PacketEntityDesign extends AddonPacket {

	private int id;
	private String url;
	private boolean canBeCollidedWith;
	private float width;
	private float height;
	
	public PacketEntityDesign () {
		
	}
	
	public PacketEntityDesign (int id, EntityDesign design) {
		this.id = id;
		this.url = design.url;
		this.canBeCollidedWith = design.canBeCollidedWith;
		this.width = design.width;
		this.height = design.height;
	}

	@Override
	public void read(SpoutInputStream in) {
		
	}

	@Override
	public void run(SpoutPlayer p) {
		
	}

	@Override
	public void write(SpoutOutputStream out) {
		out.writeInt(id);
		out.writeString(url);
		out.writeBoolean(canBeCollidedWith);
		out.writeFloat(width);
		out.writeFloat(height);
	}

}
