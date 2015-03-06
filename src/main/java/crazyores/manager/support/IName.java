package crazyores.manager.support;

public interface IName {

	/**
	 * returns the default name without any '.'s or anything attached.
	 * @return a readable string.
	 */
	String getReadableName();
	
	/**
	 * Returns the unlocalized name used to locate the image file and localize the 
	 * @return unlocalized name
	 */
	String getUnlocalizedName();
}
