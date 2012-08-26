package fr.karang.AddonManager.EntityAddon;

public class EntityDesign {
	public String url;
	public boolean canBeCollidedWith = false;
	public float width = 0.f;
	public float height = 0.f;
	
	public EntityDesign (String url) {
		this.url = url;
	}
}
