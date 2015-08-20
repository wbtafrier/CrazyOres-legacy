package crazyores.packs.core.entity;

public class FrozenEntity {

	private int entityID;
	private int ticksLeft;
	
	public FrozenEntity(int ID, int freezeAmount) {
		entityID = ID;
		ticksLeft = freezeAmount;
	}
	
	public int getEntityID() {
		return entityID;
	}
	
	public void update() {
		ticksLeft--;
	}
}
