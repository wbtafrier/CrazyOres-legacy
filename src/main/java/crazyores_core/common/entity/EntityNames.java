package crazyores_core.common.entity;

import crazyores_core.common.core.COData;

public class EntityNames
{
	public static String
	CO_PREFIX = COData.modID + ":",
	MOB_PATH = "textures/mob/",
	MISC_PATH = "textures/misc/",
	FILE_EXTENSION = ".png",
	
	// Used so entities can be localized and registered. Localization is required to prevent display name issues in mods that display the entity name, or for Spawn Eggs.
	COPPER_GOLEM = "copper_golem",
	SAPPHIRE_GOLEM = "sapphire_golem",
	ADAMITE_GOLEM = "adamite_golem",
	RUBY_GOLEM = "ruby_golem",
	ZECTIUM_GOLEM = "zectium_golem",
	TAPAZITE_GOLEM = "tapazite_golem",
	FOOLS_RUBY_GOLEM = "fools_ruby_golem",
	CRYSTAL_GOLEM = "crystal_golem",
	OSMONIUM_GOLEM = "osmonium_golem",
	DEMONITE_GOLEM = "demonite_golem",
	STARCONIUM_GOLEM = "starconium_golem",
	
	METEORITE_ARROW = "meteorite_arrow",
	COPPER_ARROW = "copper_arrow",
	INVISIUM_ARROW = "invisium_arrow",
	SAPPHIRE_ARROW = "sapphire_arrow",
	ADAMITE_ARROW = "adamite_arrow",
	RUBY_ARROW = "ruby_arrow",
	ZECTIUM_ARROW = "zectium_arrow",
	TAPAZITE_ARROW = "tapazite_arrow",
	CRYSTAL_ARROW = "crystal_arrow",
	OSMONIUM_ARROW = "osmonium_arrow",
	ENDER_ARROW = "ender_arrow",
	STARCONIUM_ARROW = "starconium_arrow",
	
	// Used so Forge can find entity images, so entities are properly rendered.
	COPPER_GOLEM_PATH = CO_PREFIX + MOB_PATH + "copper_golem" + FILE_EXTENSION,
	SAPPHIRE_GOLEM_PATH = CO_PREFIX + MOB_PATH + "sapphire_golem" + FILE_EXTENSION,
	ADAMITE_GOLEM_PATH = CO_PREFIX + MOB_PATH + "adamite_golem" + FILE_EXTENSION,
	RUBY_GOLEM_PATH = CO_PREFIX + MOB_PATH + "ruby_golem" + FILE_EXTENSION,
	ZECTIUM_GOLEM_PATH = CO_PREFIX + MOB_PATH + "zectium_golem" + FILE_EXTENSION,
	TAPAZITE_GOLEM_PATH = CO_PREFIX + MOB_PATH + "tapazite_golem" + FILE_EXTENSION,
	FOOLS_RUBY_GOLEM_PATH = CO_PREFIX + MOB_PATH + "fools_ruby_golem" + FILE_EXTENSION,
	CRYSTAL_GOLEM_PATH = CO_PREFIX + MOB_PATH + "crystal_golem" + FILE_EXTENSION,
	OSMONIUM_GOLEM_PATH = CO_PREFIX + MOB_PATH + "osmonium_golem" + FILE_EXTENSION,
	DEMONITE_GOLEM_PATH = CO_PREFIX + MOB_PATH + "demonite_golem" + FILE_EXTENSION,
	STARCONIUM_GOLEM_PATH = CO_PREFIX + MOB_PATH + "starconium_golem" + FILE_EXTENSION,
	
	METEORITE_ARROW_PATH = CO_PREFIX + MISC_PATH + "meteorite_arrow" + FILE_EXTENSION,
	COPPER_ARROW_PATH = CO_PREFIX + MISC_PATH + "copper_arrow" + FILE_EXTENSION,
	INVISIUM_ARROW_PATH = CO_PREFIX + MISC_PATH + "invisium_arrow" + FILE_EXTENSION,
	SAPPHIRE_ARROW_PATH = CO_PREFIX + MISC_PATH + "sapphire_arrow" + FILE_EXTENSION,
	ADAMITE_ARROW_PATH = CO_PREFIX + MISC_PATH + "adamite_arrow" + FILE_EXTENSION,
	RUBY_ARROW_PATH = CO_PREFIX + MISC_PATH + "ruby_arrow" + FILE_EXTENSION,
	ZECTIUM_ARROW_PATH = CO_PREFIX + MISC_PATH + "zectium_arrow" + FILE_EXTENSION,
	TAPAZITE_ARROW_PATH = CO_PREFIX + MISC_PATH + "tapazite_arrow" + FILE_EXTENSION,
	CRYSTAL_ARROW_PATH = CO_PREFIX + MISC_PATH + "crystal_arrow" + FILE_EXTENSION,
	OSMONIUM_ARROW_PATH = CO_PREFIX + MISC_PATH + "osmonium_arrow" + FILE_EXTENSION,
	ENDER_ARROW_PATH = CO_PREFIX + MISC_PATH + "ender_arrow" + FILE_EXTENSION,
	STARCONIUM_ARROW_PATH = CO_PREFIX + MISC_PATH + "starconium_arrow" + FILE_EXTENSION;
}
