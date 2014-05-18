package crazyores_core.common.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import cpw.mods.fml.common.eventhandler.Event;
import crazyores_core.common.core.COData;
import crazyores_core.common.tabs.TabList;

public class Bucket extends Item
{
    /** field for checking if the copperbucket has been filled. */
    private Block isFull;

    public Bucket(Block par2)
    {
        super();
        this.maxStackSize = 1;
        this.isFull = par2;
        this.setCreativeTab(TabList.COMisc);
    }

    @Override
    
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        float var4 = 1.0F;
        double var5 = par3EntityPlayer.prevPosX + (par3EntityPlayer.posX - par3EntityPlayer.prevPosX) * (double)var4;
        double var7 = par3EntityPlayer.prevPosY + (par3EntityPlayer.posY - par3EntityPlayer.prevPosY) * (double)var4 + 1.62D - (double)par3EntityPlayer.yOffset;
        double var9 = par3EntityPlayer.prevPosZ + (par3EntityPlayer.posZ - par3EntityPlayer.prevPosZ) * (double)var4;
        boolean var11 = this.isFull == Blocks.air;
        MovingObjectPosition var12 = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, var11);

        if (var12 == null)
        {
            return par1ItemStack;
        }
        else
        {
            FillBucketEvent event = new FillBucketEvent(par3EntityPlayer, par1ItemStack, par2World, var12);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return par1ItemStack;
            }

            if (event.getResult() == Event.Result.ALLOW)
            {
                if (par3EntityPlayer.capabilities.isCreativeMode)
                {
                    return par1ItemStack;
                }

                if (--par1ItemStack.stackSize <= 0)
                {
                    return event.result;
                }

                if (!par3EntityPlayer.inventory.addItemStackToInventory(event.result))
                {
                    par3EntityPlayer.dropPlayerItemWithRandomChoice(event.result, false);
                }

                return par1ItemStack;
            }

            if (var12.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int var13 = var12.blockX;
                int var14 = var12.blockY;
                int var15 = var12.blockZ;

                if (!par2World.canMineBlock(par3EntityPlayer, var13, var14, var15))
                {
                    return par1ItemStack;
                }

                if (this.isFull == Blocks.air)
                {
                    if (!par2World.canMineBlock(par3EntityPlayer, var13, var14, var15))
                    {
                        return par1ItemStack;
                    }

                    if (!par3EntityPlayer.canPlayerEdit(var13, var14, var15, var12.sideHit, par1ItemStack))
                    {
                        return par1ItemStack;
                    }

                    Material material = par2World.getBlock(var13, var14, var15).getMaterial();
                    int l = par2World.getBlockMetadata(var13, var14, var15);

                    if (material == Material.water && l == 0)
                    {
                        par2World.setBlockToAir(var13, var14, var15);
                        return this.func_150910_a(par1ItemStack, par3EntityPlayer, ItemList.copper_bucket_water);
                    }

                    if (material == Material.lava && l == 0)
                    {
                        par2World.setBlockToAir(var13, var14, var15);
                        return this.func_150910_a(par1ItemStack, par3EntityPlayer, ItemList.copper_bucket_lava);
                    }
                }
                else
                {
                    if (this.isFull == Blocks.air)
                    {
                        return new ItemStack(ItemList.copper_bucket_empty);
                    }

                    if (var12.sideHit == 0)
                    {
                        --var14;
                    }

                    if (var12.sideHit == 1)
                    {
                        ++var14;
                    }

                    if (var12.sideHit == 2)
                    {
                        --var15;
                    }

                    if (var12.sideHit == 3)
                    {
                        ++var15;
                    }

                    if (var12.sideHit == 4)
                    {
                        --var13;
                    }

                    if (var12.sideHit == 5)
                    {
                        ++var13;
                    }

                    if (!par3EntityPlayer.canPlayerEdit(var13, var14, var15, var12.sideHit, par1ItemStack))
                    {
                        return par1ItemStack;
                    }

                    if (this.tryPlaceContainedLiquid(par2World, var5, var7, var9, var13, var14, var15) && !par3EntityPlayer.capabilities.isCreativeMode)
                    {
                        return new ItemStack(ItemList.copper_bucket_empty);
                    }
                }
            }
            return par1ItemStack;
        }
    }
    
    private ItemStack func_150910_a(ItemStack p_150910_1_, EntityPlayer p_150910_2_, Item p_150910_3_)
    {
        if (p_150910_2_.capabilities.isCreativeMode)
        {
            return p_150910_1_;
        }
        else if (--p_150910_1_.stackSize <= 0)
        {
            return new ItemStack(p_150910_3_);
        }
        else
        {
            if (!p_150910_2_.inventory.addItemStackToInventory(new ItemStack(p_150910_3_)))
            {
                p_150910_2_.dropPlayerItemWithRandomChoice(new ItemStack(p_150910_3_, 1, 0), false);
            }

            return p_150910_1_;
        }
    }

    public boolean tryPlaceContainedLiquid(World par1World, double par2, double par4, double par6, int par8, int par9, int par10)
    {
        if (this.isFull == Blocks.air)
        {
            return false;
        }
        else if (!par1World.isAirBlock(par8, par9, par10) && par1World.getBlock(par8, par9, par10).getMaterial().isSolid())
        {
            return false;
        }
        else
        {
            if (par1World.provider.isHellWorld && this.isFull == Blocks.flowing_water)
            {
                par1World.playSoundEffect(par2 + 0.5D, par4 + 0.5D, par6 + 0.5D, "random.fizz", 0.5F, 2.6F + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.8F);

                for (int var11 = 0; var11 < 8; ++var11)
                {
                    par1World.spawnParticle("largesmoke", (double)par8 + Math.random(), (double)par9 + Math.random(), (double)par10 + Math.random(), 0.0D, 0.0D, 0.0D);
                }
            }
            else
            {
                par1World.setBlock(par8, par9, par10, this.isFull, 0, 3);
            }

            return true;
        }
    }
    
}
