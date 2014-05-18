package crazyores_core.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import crazyores_core.common.core.COData;
import crazyores_core.common.items.ItemList;
import crazyores_core.common.tabs.TabList;

public class Ore extends BlockOre
{	
	
	public Ore() 
	{
        super();
        this.setCreativeTab(TabList.COBlocks);
	}
	
	@Override
    public Item getItemDropped(int par1, Random rand, int par3)
    {
    	if (this.isAssociatedBlock(BlockList.sapphire_ore))
		{
			return ItemList.sapphire_gem;
		}
    	else if (this.isAssociatedBlock(BlockList.adamite_ore))
    	{
    		return ItemList.adamite_shard;
    	}
    	else if (this.isAssociatedBlock(BlockList.meteorite_ore))
		{
    		if((rand.nextInt(100)+1) <= 80)
    		return ItemList.meteorite_coal;
    		else return ItemList.meteorite_gem;
		}
    	else if (this.isAssociatedBlock(BlockList.luminite_ore))
		{
//    		if((rand.nextInt(100)+1) <= 80)
    		return ItemList.white_luminite_crystal;
//    		else return ItemList.meteorite_gem;
		}
    	else if (this.isAssociatedBlock(BlockList.ender_ore))
		{
    		return ItemList.ender_gem;
		}
    	else if (this.isAssociatedBlock(BlockList.ruby_ore))
		{
    		return ItemList.ruby_gem;
		}
    	else if (this.isAssociatedBlock(BlockList.fools_ruby_ore))
		{
    		return ItemList.fools_ruby_gem;
		}
    	else if (this.isAssociatedBlock(BlockList.experium_ore))
		{
    		if((rand.nextInt(200)+1) >= 150)
    			return ItemList.experium_orb;
    		else
    			return null;
		}
    	else if (this.isAssociatedBlock(BlockList.tapazite_ore))
    	{
    		return ItemList.tapazite_gem;
    	}
    	else if (this.isAssociatedBlock(BlockList.crystal_ore))
		{
    		return ItemList.crystal_shard;
		}
    	else if (this.isAssociatedBlock(BlockList.starconium_ore))
		{
    		return ItemList.starconium_gem;
		}
    	else if (this.isAssociatedBlock(BlockList.demonite_stone))
		{
    		return ItemList.demonite_orb;
		}
		return Item.getItemFromBlock(this);
    }

    public int quantityDropped(Random rand)
    {
    	
    	if (this.isAssociatedBlock(BlockList.fools_ruby_ore) || this.isAssociatedBlock(BlockList.luminite_ore))
    	{
    		return rand.nextInt(4) + 1;
    	}
    	else if (this.isAssociatedBlock(BlockList.experium_ore))
    	{
    		return rand.nextInt(5) + 1;
    	}
    	else if (this.isAssociatedBlock(BlockList.demonite_stone))
    	{
    		return rand.nextInt(3) + 1;
    	}
		return 1;
    }
    
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

        if (this.getItemDropped(par5, par1World.rand, par7) != Item.getItemFromBlock(this))
        {
            int var8 = 0;

            if (this.isAssociatedBlock(BlockList.sapphire_ore))
            {
            	var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 6);
            }
            if (this.isAssociatedBlock(BlockList.adamite_ore))
            {
            	var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 7);
            }
            else if (this.isAssociatedBlock(BlockList.meteorite_ore))
            {
            	var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
            }
            else if (this.isAssociatedBlock(BlockList.luminite_ore))
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 6);
            }
            else if (this.isAssociatedBlock(BlockList.ruby_ore))
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            }
            else if (this.isAssociatedBlock(BlockList.fools_ruby_ore))
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 0, 1);
            }
            else if (this.isAssociatedBlock(BlockList.tapazite_ore))
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 8, 12);
            }
            else if (this.isAssociatedBlock(BlockList.crystal_ore))
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 12, 15);
            }
            else if (this.isAssociatedBlock(BlockList.starconium_ore))
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 15, 18);
            }
            else if (this.isAssociatedBlock(BlockList.experium_ore))
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 200, 300);
            }
            else if (this.isAssociatedBlock(BlockList.demonite_stone))
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 13, 16);
            }
            else if (this.isAssociatedBlock(BlockList.ender_ore))
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 20, 25);
            }
            else if (this.isAssociatedBlock(BlockList.ultra_ore))
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 30, 45);
            }
            this.dropXpOnBlockBreak(par1World, par2, par3, par4, var8);
        }
    }
	
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        if (par1 > 0 && !this.isAssociatedBlock(Block.getBlockFromItem(this.getItemDropped(0, par2Random, par1))))
        {
            int j = par2Random.nextInt(par1 + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(par2Random) * (j + 1);
        }
        else
        {
            return this.quantityDropped(par2Random);
        }
    }
    
    @Override
    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
    {
        return !this.isAssociatedBlock(BlockList.ender_ore) && !this.isAssociatedBlock(BlockList.ultra_ore) && !this.isAssociatedBlock(BlockList.ender_block) && !this.isAssociatedBlock(BlockList.ultra_block);
    }
        
    @Override
    public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side)
    {
        if (this.isAssociatedBlock(BlockList.darkstone) && side == ForgeDirection.UP)
        {
            return true;
        }
        return false;
    }
}
