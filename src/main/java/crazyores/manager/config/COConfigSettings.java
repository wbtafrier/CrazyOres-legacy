package crazyores.manager.config;

public class COConfigSettings {

	//Booleans to check if a pack is installed
	private static final boolean isCoreInstalled = true;
	protected static boolean isFoodsInstalled = true;
	
	public static boolean isCoreActivated() {
		return isCoreInstalled;
	}
	
	public static boolean isFoodsActivated() {
		return isFoodsInstalled;
	}
	
}
