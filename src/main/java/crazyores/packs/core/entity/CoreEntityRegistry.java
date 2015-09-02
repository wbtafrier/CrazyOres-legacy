package crazyores.packs.core.entity;

import java.util.Arrays;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.packs.core.entity.arrow.EntityExplosiveArrow;
import crazyores.packs.core.entity.arrow.EntityFlamingArrow;
import crazyores.packs.core.entity.arrow.EntityFreezingArrow;
import crazyores.packs.core.entity.arrow.EntityLightningArrow;
import crazyores.packs.core.entity.golem.EntityAdamiteGolem;
import crazyores.packs.core.entity.golem.EntityCopperGolem;
import crazyores.packs.core.entity.golem.EntityDemoniteGolem;
import crazyores.packs.core.entity.golem.EntityEnderGolem;
import crazyores.packs.core.entity.golem.EntityFoolsRubyGolem;
import crazyores.packs.core.entity.golem.EntityOsmoniumGolem;
import crazyores.packs.core.entity.golem.EntityRubyGolem;
import crazyores.packs.core.entity.golem.EntitySapphireGolem;
import crazyores.packs.core.entity.golem.EntityStarconiumGolem;
import crazyores.packs.core.entity.golem.EntityTapaziteGolem;
import crazyores.packs.core.entity.golem.EntityZectiumGolem;
import crazyores.packs.core.entity.mob.EntityAdamiteShark;
import crazyores.packs.core.entity.mob.EntityGreatWhiteShark;
import crazyores.packs.core.entity.mob.EntityZectiumProtector;
import crazyores.packs.core.entity.tileentity.TileEntityDemoniteFurnace;
import crazyores.packs.core.entity.tileentity.TileEntityLuminiteDisco;
import crazyores.packs.core.entity.tileentity.TileEntityReinforcedChest;
import crazyores.packs.core.entity.tileentity.TileEntityTapaziteCrystal;
import crazyores.packs.core.item.CoreItems;
import crazyores.packs.core.item.CoreSpawnEgg;
import crazyores.packs.core.main.CrazyOresCore;

public class CoreEntityRegistry {

	//Only use getUniqueGlobalID when creating a mob with spawn eggs. Otherwise the ids are specific to each mod.
	private static int coreIDCounter = 0;
	
	//Put names in the lang file! They read as: entity.crazyores_core.theentityname.name
	
	public static void registerCoreEntities() {
		EntityRegistry.registerModEntity(EntityZectiumCore.class, "zectium_core", coreIDCounter++, CrazyOresCore.instance, 64, 10, true);
		EntityRegistry.registerModEntity(EntityCopperGolem.class, "copper_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntitySapphireGolem.class, "sapphire_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityAdamiteGolem.class, "adamite_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityRubyGolem.class, "ruby_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityFoolsRubyGolem.class, "fools_ruby_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityZectiumGolem.class, "zectium_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityTapaziteGolem.class, "tapazite_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityOsmoniumGolem.class, "osmonium_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityStarconiumGolem.class, "starconium_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityDemoniteGolem.class, "demonite_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityEnderGolem.class, "ender_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		
		EntityRegistry.registerModEntity(EntityFlamingArrow.class, "flaming_arrow", coreIDCounter++, CrazyOresCore.instance, 128, 1, true);
		EntityRegistry.registerModEntity(EntityExplosiveArrow.class, "explosive_arrow", coreIDCounter++, CrazyOresCore.instance, 128, 1, true);
		EntityRegistry.registerModEntity(EntityLightningArrow.class, "electric_arrow", coreIDCounter++, CrazyOresCore.instance, 128, 1, true);
		EntityRegistry.registerModEntity(EntityFreezingArrow.class, "freezing_arrow", coreIDCounter++, CrazyOresCore.instance, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityZectiumProtector.class, "zectium_protector", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		
		EntityRegistry.registerModEntity(EntityGreatWhiteShark.class, "great_white_shark", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityAdamiteShark.class, "adamite_shark", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		
		BiomeGenBase[] allBiomes = FluentIterable.from(Arrays.asList(BiomeGenBase.getBiomeGenArray())).filter(Predicates.notNull()).toArray(BiomeGenBase.class);
		EntityRegistry.addSpawn(EntityGreatWhiteShark.class, 1, 1, 1, EnumCreatureType.waterCreature, allBiomes);
		EntityRegistry.addSpawn(EntityEnderGolem.class, 2, 1, 1, EnumCreatureType.monster, allBiomes);
	}
	
	public static void registerCoreTileEntities() {
		GameRegistry.registerTileEntity(TileEntityTapaziteCrystal.class, "tapazite_crystal");
		GameRegistry.registerTileEntity(TileEntityDemoniteFurnace.class, "demonite_furnace");
		GameRegistry.registerTileEntity(TileEntityLuminiteDisco.class, "luminite_disco");
		GameRegistry.registerTileEntity(TileEntityReinforcedChest.class, "reinforced_chest");
	}
	
	public static void registerDispenserBehaviors() {
		BlockDispenser.dispenseBehaviorRegistry.putObject(CoreItems.flamingArrow, new BehaviorProjectileDispense()
        {
            /**
             * Return the projectile entity spawned by this dispense behavior.
             */
            protected IProjectile getProjectileEntity(World world, IPosition position)
            {
                EntityFlamingArrow entityarrow = new EntityFlamingArrow(world, position.getX(), position.getY(), position.getZ());
                entityarrow.canBePickedUp = 1;
                return entityarrow;
            }
        });
		
		BlockDispenser.dispenseBehaviorRegistry.putObject(CoreItems.explosiveArrow, new BehaviorProjectileDispense()
        {
            /**
             * Return the projectile entity spawned by this dispense behavior.
             */
            protected IProjectile getProjectileEntity(World world, IPosition position)
            {
                EntityExplosiveArrow entityarrow = new EntityExplosiveArrow(world, position.getX(), position.getY(), position.getZ());
                entityarrow.canBePickedUp = 1;
                return entityarrow;
            }
        });
		
		BlockDispenser.dispenseBehaviorRegistry.putObject(CoreItems.freezingArrow, new BehaviorProjectileDispense()
        {
            /**
             * Return the projectile entity spawned by this dispense behavior.
             */
            protected IProjectile getProjectileEntity(World world, IPosition position)
            {
                EntityFreezingArrow entityarrow = new EntityFreezingArrow(world, position.getX(), position.getY(), position.getZ());
                entityarrow.canBePickedUp = 1;
                return entityarrow;
            }
        });
		
		BlockDispenser.dispenseBehaviorRegistry.putObject(CoreItems.lightningArrow, new BehaviorProjectileDispense()
        {
            /**
             * Return the projectile entity spawned by this dispense behavior.
             */
            protected IProjectile getProjectileEntity(World world, IPosition position)
            {
                EntityLightningArrow entityarrow = new EntityLightningArrow(world, position.getX(), position.getY(), position.getZ());
                entityarrow.canBePickedUp = 1;
                return entityarrow;
            }
        });
		
		BlockDispenser.dispenseBehaviorRegistry.putObject(CoreItems.zectiumCore, new BehaviorProjectileDispense()
        {
            /**
             * Return the projectile entity spawned by this dispense behavior.
             */
            protected IProjectile getProjectileEntity(World world, IPosition position)
            {
                EntityZectiumCore core = new EntityZectiumCore(world, position.getX(), position.getY(), position.getZ());
                return core;
            }
        });
		
		BlockDispenser.dispenseBehaviorRegistry.putObject(CoreItems.greatWhiteSharkEgg, new BehaviorDefaultDispenseItem()
        {
            /**
             * Dispense the specified stack, play the dispense sound and spawn particles.
             */
            public ItemStack dispenseStack(IBlockSource blockSource, ItemStack stack)
            {
                EnumFacing enumfacing = BlockDispenser.func_149937_b(blockSource.getBlockMetadata());
                double d0 = blockSource.getX() + (double)((float)enumfacing.getFrontOffsetX() * 3.125F);
                double d1 = (double)blockSource.getYInt();
                double d2 = blockSource.getZ() + (double)((float)enumfacing.getFrontOffsetZ() * 3.125F);
                Entity entity = ((CoreSpawnEgg)CoreItems.greatWhiteSharkEgg).spawnEntity(blockSource.getWorld(), d0, d1, d2);

                if (entity instanceof EntityLivingBase && stack.hasDisplayName())
                {
                    ((EntityLiving)entity).setCustomNameTag(stack.getDisplayName());
                }

                stack.splitStack(1);
                return stack;
            }
        });
		
		BlockDispenser.dispenseBehaviorRegistry.putObject(CoreItems.adamiteSharkEgg, new BehaviorDefaultDispenseItem()
        {
            /**
             * Dispense the specified stack, play the dispense sound and spawn particles.
             */
            public ItemStack dispenseStack(IBlockSource blockSource, ItemStack stack)
            {
                EnumFacing enumfacing = BlockDispenser.func_149937_b(blockSource.getBlockMetadata());
                double d0 = blockSource.getX() + (double)((float)enumfacing.getFrontOffsetX() * 3.125F);
                double d1 = (double)blockSource.getYInt();
                double d2 = blockSource.getZ() + (double)((float)enumfacing.getFrontOffsetZ() * 3.125F);
                Entity entity = ((CoreSpawnEgg)CoreItems.adamiteSharkEgg).spawnEntity(blockSource.getWorld(), d0, d1, d2);

                if (entity instanceof EntityLivingBase && stack.hasDisplayName())
                {
                    ((EntityLiving)entity).setCustomNameTag(stack.getDisplayName());
                }

                stack.splitStack(1);
                return stack;
            }
        });
		
		BlockDispenser.dispenseBehaviorRegistry.putObject(CoreItems.zectiumProtectorEgg, new BehaviorDefaultDispenseItem()
        {
            /**
             * Dispense the specified stack, play the dispense sound and spawn particles.
             */
            public ItemStack dispenseStack(IBlockSource blockSource, ItemStack stack)
            {
                EnumFacing enumfacing = BlockDispenser.func_149937_b(blockSource.getBlockMetadata());
                double d0 = blockSource.getX() + (double)enumfacing.getFrontOffsetX();
                double d1 = (double)((float)blockSource.getYInt() + 0.2F);
                double d2 = blockSource.getZ() + (double)enumfacing.getFrontOffsetZ();
                Entity entity = ((CoreSpawnEgg)CoreItems.zectiumProtectorEgg).spawnEntity(blockSource.getWorld(), d0, d1, d2);

                if (entity instanceof EntityLivingBase && stack.hasDisplayName())
                {
                    ((EntityLiving)entity).setCustomNameTag(stack.getDisplayName());
                }

                stack.splitStack(1);
                return stack;
            }
        });
	}
}
