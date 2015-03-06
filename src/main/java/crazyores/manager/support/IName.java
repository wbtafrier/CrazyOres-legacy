package crazyores.manager.support;

public interface IName {
	
	/**
	 * Returns the default name without any '.'s or anything attached.
	 * @return a readable string.
	 */
	String getReadableName();
	
	/**
	 * Returns the unlocalized name used to locate the image file and localize the object.
	 * @return unlocalized name
	 */
	String getUnlocalizedName();
}
