package crazyores.manager.support;

public interface IName {
	
	/**
	 * returns the default name without any '.'s or anything attached.
	 * @return a readable string.
	 */
	String getReadableName();
	
	/**
	 * @return the unlocalized name of the object.
	 */
	String getUnlocalizedName();
	
}
