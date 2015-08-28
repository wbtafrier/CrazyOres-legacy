package crazyores.packs.core.item;

import net.minecraft.block.BlockDispenser;
import net.minecraft.block.material.Material;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class CoreFluidContainerRegistry {
	
	public static final ItemStack EMPTY_COPPER_BUCKET = new ItemStack(CoreItems.copperBucketEmpty);
	
	public static void registerFluidContainers() {
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.WATER, new ItemStack(CoreItems.copperBucketWater), EMPTY_COPPER_BUCKET);
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.LAVA, new ItemStack(CoreItems.copperBucketLava), EMPTY_COPPER_BUCKET);
		registerDispenserBehaviors();
	}
	
	public static void registerDispenserBehaviors() {
		BehaviorDefaultDispenseItem fullBucketDispenseBehavior = new BehaviorDefaultDispenseItem()
        {
            private final BehaviorDefaultDispenseItem dispenserItemBehavior = new BehaviorDefaultDispenseItem();
            public ItemStack dispenseStack(IBlockSource blockSource, ItemStack itemStack)
            {
                CoreBucket bucket = (CoreBucket)itemStack.getItem();
                int i = blockSource.getXInt();
                int j = blockSource.getYInt();
                int k = blockSource.getZInt();
                EnumFacing enumfacing = BlockDispenser.func_149937_b(blockSource.getBlockMetadata());

                if (bucket.tryPlaceContainedLiquid(blockSource.getWorld(), i + enumfacing.getFrontOffsetX(), j + enumfacing.getFrontOffsetY(), k + enumfacing.getFrontOffsetZ()))
                {
                    itemStack.func_150996_a(CoreItems.copperBucketEmpty);
                    itemStack.stackSize = 1;
                    return itemStack;
                }
                else
                {
                    return this.dispenserItemBehavior.dispense(blockSource, itemStack);
                }
            }
        };
        
        BlockDispenser.dispenseBehaviorRegistry.putObject(CoreItems.copperBucketWater, fullBucketDispenseBehavior);
        BlockDispenser.dispenseBehaviorRegistry.putObject(CoreItems.copperBucketLava, fullBucketDispenseBehavior);
        
        BehaviorDefaultDispenseItem emptyBucketDispenseBehavior = new BehaviorDefaultDispenseItem()
        {
        	private final BehaviorDefaultDispenseItem dispenserItemBehavior = new BehaviorDefaultDispenseItem();
            /**
             * Dispense the specified stack, play the dispense sound and spawn particles.
             */
            public ItemStack dispenseStack(IBlockSource blockSource, ItemStack itemStack)
            {
                EnumFacing enumfacing = BlockDispenser.func_149937_b(blockSource.getBlockMetadata());
                World world = blockSource.getWorld();
                int i = blockSource.getXInt() + enumfacing.getFrontOffsetX();
                int j = blockSource.getYInt() + enumfacing.getFrontOffsetY();
                int k = blockSource.getZInt() + enumfacing.getFrontOffsetZ();
                Material material = world.getBlock(i, j, k).getMaterial();
                int l = world.getBlockMetadata(i, j, k);
                Item item;

                if (Material.water.equals(material) && l == 0)
                {
                    item = CoreItems.copperBucketWater;
                }
                else
                {
                    if (!Material.lava.equals(material) || l != 0)
                    {
                        return super.dispenseStack(blockSource, itemStack);
                    }

                    item = CoreItems.copperBucketLava;
                }

                world.setBlockToAir(i, j, k);

                if (--itemStack.stackSize == 0)
                {
                    itemStack.func_150996_a(item);
                    itemStack.stackSize = 1;
                }
                else if (((TileEntityDispenser)blockSource.getBlockTileEntity()).func_146019_a(new ItemStack(item)) < 0)
                {
                    this.dispenserItemBehavior.dispense(blockSource, new ItemStack(item));
                }

                return itemStack;
            }
        };
        
        BlockDispenser.dispenseBehaviorRegistry.putObject(CoreItems.copperBucketEmpty, emptyBucketDispenseBehavior);
	}
}
