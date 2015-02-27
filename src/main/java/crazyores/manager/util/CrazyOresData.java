package crazyores.manager.util;

import crazyores.manager.proxy.ClientProxy;


public class CrazyOresData {

	public static final String COPrefix = "CrazyOres";
	public static final String COSuffix = "Pack";
	
	public static final String clientProxy = "crazyores.manager.proxy.ClientProxy";
	public static final String serverProxy = "crazyores.manager.proxy.ServerProxy";
	
	//Pack Names
	public static final String corePackName = "Core";
	public static final String foodsPackName = "Foods";
	
	//Full Pack Names
	public static final String crazyOresCoreName = COPrefix + " " + corePackName;
	public static final String crazyOresFoodsName = COPrefix + " " + foodsPackName + " " + COSuffix;
	
	//Pack IDs
	public static final String MOD_ID = "crazyores_core";
	public static final String crazyOresCoreID = "crazyores_core";
	public static final String crazyOresFoodsID = "crazyores_foods";
	
	//Pack Versions
	public static final String crazyOresCoreVersion = "2.0";
	public static final String crazyOresFoodsVersion = "1.0";
}
