package crazyores.manager.support;

public interface IName {

	/**
	 * parsePrefix checks the unlocalizedName sent in and if it comes across the char given, it returns a version of the name without everything before the char.
	 * Example: unlocalizedName = "block.hello" char = '.' ---> returns "hello"
	 * @param unlocalizedName is the original string sent in.
	 * @param lastPrefixChar is the char that the method looks out for.
	 * @return a new string without the prefix.
	 */
	String parsePrefix(String unlocalizedName, char lastPrefixChar);
	
	/**
	 * returns the default name without any '.'s or anything attached.
	 * @return a readable string.
	 */
	String getReadableName();
	
}
