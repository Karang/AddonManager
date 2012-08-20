package fr.karang.AddonManager.EntityAddon;

import org.getspout.spoutapi.io.AddonPacket;
import org.getspout.spoutapi.io.SpoutInputStream;
import org.getspout.spoutapi.io.SpoutOutputStream;
import org.getspout.spoutapi.player.SpoutPlayer;


public class EntityDesignPacket extends AddonPacket {

	private int id;
	private String url;
	
	public EntityDesignPacket () {
		
	}
	
	public EntityDesignPacket (int id, String url) {
		this.id = id;
		this.url = url;
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
	}

}
