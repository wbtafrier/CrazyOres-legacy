package crazyores.packs.core.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.manager.pack.COPackManager;
import crazyores.packs.core.tabs.CoreTabList;

public class CoreBucket extends ItemBucket {

	private Block containedBlock;
	private String itemUnlocalizedName;
	
	protected CoreBucket(String unlocalizedName, Block liquid) {
		super(liquid);
		containedBlock = liquid;
		this.setCreativeTab(CoreTabList.coreToolsTab);
		itemUnlocalizedName = unlocalizedName;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
       
		if (world.isRemote) return itemStack;
		
		boolean flag = this.containedBlock == Blocks.air;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, flag);

        if (movingobjectposition == null) {
            return itemStack;
        }
        else {
            FillBucketEvent event = new FillBucketEvent(player, itemStack, world, movingobjectposition);
            if (MinecraftForge.EVENT_BUS.post(event)) {
                return itemStack;
            }

            if (event.getResult() == Event.Result.ALLOW) {
                if (player.capabilities.isCreativeMode) {
                    return itemStack;
                }

                if (--itemStack.stackSize <= 0) {
                    return event.result;
                }

                if (!player.inventory.addItemStackToInventory(event.result)) {
                    player.dropPlayerItemWithRandomChoice(event.result, false);
                }

                return itemStack;
            }
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!world.canMineBlock(player, i, j, k)) {
                    return itemStack;
                }

                if (flag) {
                    if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStack)) {
                        return itemStack;
                    }

                    Material material = world.getBlock(i, j, k).getMaterial();
                    int l = world.getBlockMetadata(i, j, k);

                    if (material == Material.water && l == 0) {
                        world.setBlockToAir(i, j, k);
                        return this.getNewBucket(itemStack, player, CoreItems.copperBucketWater);
                    }

                    if (material == Material.lava && l == 0) {
                        world.setBlockToAir(i, j, k);
                        return this.getNewBucket(itemStack, player, CoreItems.copperBucketLava);
                    }
                }
                else {
                    if (this.containedBlock == Blocks.air) {
                        return new ItemStack(CoreItems.copperBucketEmpty);
                    }

                    if (movingobjectposition.sideHit == 0) {
                        --j;
                    }

                    if (movingobjectposition.sideHit == 1) {
                        ++j;
                    }

                    if (movingobjectposition.sideHit == 2) {
                        --k;
                    }

                    if (movingobjectposition.sideHit == 3) {
                        ++k;
                    }

                    if (movingobjectposition.sideHit == 4) {
                        --i;
                    }

                    if (movingobjectposition.sideHit == 5) {
                        ++i;
                    }

                    if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStack)) {
                        return itemStack;
                    }

                    if (this.tryPlaceContainedLiquid(world, i, j, k) && !player.capabilities.isCreativeMode) {
                        return new ItemStack(CoreItems.copperBucketEmpty);
                    }
                }
            }
            return itemStack;
        }
    }

    private ItemStack getNewBucket(ItemStack oldBucket, EntityPlayer player, Item newBucket) {
        if (player.capabilities.isCreativeMode) {
            return oldBucket;
        }
        else if (--oldBucket.stackSize <= 0) {
            return new ItemStack(newBucket);
        }
        else {
            if (!player.inventory.addItemStackToInventory(new ItemStack(newBucket))) {
                player.dropPlayerItemWithRandomChoice(new ItemStack(newBucket, 1, 0), false);
            }

            return oldBucket;
        }
    }
    
//    public boolean tryPlaceContainedLiquid(World world, int xPos, int yPos, int zPos) {
//        if (this.containedBlock == Blocks.air) {
//            return false;
//        }
//        else {
//            Material material = world.getBlock(xPos, yPos, zPos).getMaterial();
//            boolean flag = !material.isSolid();
//
//            if (!world.isAirBlock(xPos, yPos, zPos) && !flag) {
//                return false;
//            }
//            else {
//                if (world.provider.isHellWorld && this.containedBlock == Blocks.flowing_water) {
//                    world.playSoundEffect((double)((float)xPos + 0.5F), (double)((float)yPos + 0.5F), (double)((float)zPos + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
//
//                    for (int l = 0; l < 8; ++l) {
//                        world.spawnParticle("largesmoke", (double)xPos + Math.random(), (double)yPos + Math.random(), (double)zPos + Math.random(), 0.0D, 0.0D, 0.0D);
//                    }
//                }
//                else {
//                    if (!world.isRemote && flag && !material.isLiquid()) {
//                        world.func_147480_a(xPos, yPos, zPos, true);
//                    }
//                    world.setBlock(xPos, yPos, zPos, this.containedBlock, 0, 3);
//                }
//                return true;
//            }
//        }
//    }
    
    @Override
	public String getUnlocalizedName() {
		return itemUnlocalizedName;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
        return itemUnlocalizedName;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", this.getUnlocalizedName()));
    }
}
