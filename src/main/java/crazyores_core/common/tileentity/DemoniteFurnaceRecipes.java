package crazyores_core.common.tileentity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

import org.apache.logging.log4j.Level;

import crazyores_core.common.blocks.BlockList;
import crazyores_core.common.core.COLogger;
import crazyores_core.common.items.ItemList;

/**
 * THIS BEEN FIXED
 *
 */
public class DemoniteFurnaceRecipes
{
    public static final DemoniteFurnaceRecipes smeltingBase = new DemoniteFurnaceRecipes();

    public BlockList bl;
    public ItemList il;
    
    /** The list of smelting results. */
    public Map smeltingList = new HashMap();
    public Map smeltingList2 = new HashMap();
    public Map smeltingList3 = new HashMap();
    public Map smeltingList4 = new HashMap();
    public Map smeltingList5 = new HashMap();
    public Map smeltingList6 = new HashMap();
    public Map smeltingList7 = new HashMap();
    public Map smeltingList8 = new HashMap();
    public Map smeltingList9 = new HashMap();
    public Map smeltingList10 = new HashMap();
    public Map smeltingList11 = new HashMap();
    public Map smeltingList12 = new HashMap();
    public Map smeltingList13 = new HashMap();
    public Map smeltingList14 = new HashMap();
    public Map smeltingList15 = new HashMap();
    public Map smeltingList16 = new HashMap();
    public Map smeltingList17 = new HashMap();
    public Map smeltingList18 = new HashMap();
    public Map smeltingList19 = new HashMap();
    public Map smeltingList20 = new HashMap();
    public Map resultList1 = new HashMap();
    public Map resultList12 = new HashMap();
    public Map resultList13 = new HashMap();
    public Map resultList14 = new HashMap();
    public Map resultList15 = new HashMap();
    public Map resultList16 = new HashMap();
    public Map resultList17 = new HashMap();
    public Map resultList18 = new HashMap();
    public Map resultList19 = new HashMap();
    public Map resultList110 = new HashMap();
    public Map resultList111 = new HashMap();
    public Map resultList112 = new HashMap();
    public Map resultList113 = new HashMap();
    public Map resultList114 = new HashMap();
    public Map resultList115 = new HashMap();
    public Map resultList116 = new HashMap();
    public Map resultList117 = new HashMap();
    public Map resultList118 = new HashMap();
    public Map resultList119 = new HashMap();
    public Map resultList120 = new HashMap();
    public Map resultList2 = new HashMap();
    public Map resultList22 = new HashMap();
    public Map resultList23 = new HashMap();
    public Map resultList24 = new HashMap();
    public Map resultList25 = new HashMap();
    public Map resultList26 = new HashMap();
    public Map resultList27 = new HashMap();
    public Map resultList28 = new HashMap();
    public Map resultList29 = new HashMap();
    public Map resultList210 = new HashMap();
    public Map resultList211 = new HashMap();
    public Map resultList212 = new HashMap();
    public Map resultList213 = new HashMap();
    public Map resultList214 = new HashMap();
    public Map resultList215 = new HashMap();
    public Map resultList216 = new HashMap();
    public Map resultList217 = new HashMap();
    public Map resultList218 = new HashMap();
    public Map resultList219 = new HashMap();
    public Map resultList220 = new HashMap();
    public Map metaSmeltingList = new HashMap();
    public Map metaResultList1 = new HashMap();
    public Map metaResultList2 = new HashMap();
    
    public Map[] smeltingListList = {smeltingList, smeltingList2, smeltingList3, smeltingList4, smeltingList5, smeltingList6, smeltingList7, smeltingList8, smeltingList9, smeltingList10, smeltingList11, smeltingList12, smeltingList13, smeltingList14, smeltingList15, smeltingList16, smeltingList17, smeltingList18, smeltingList19, smeltingList20 };
    public Map[] resultListList1 = {resultList1, resultList12, resultList13, resultList14, resultList15, resultList16, resultList17, resultList18, resultList19, resultList110, resultList111, resultList112, resultList113, resultList114, resultList115, resultList116, resultList117, resultList118, resultList119, resultList120 };
    public Map[] resultListList2 = {resultList2, resultList22, resultList23, resultList24, resultList25, resultList26, resultList27, resultList28, resultList29, resultList210, resultList211, resultList212, resultList213, resultList214, resultList215, resultList216, resultList217, resultList218, resultList219, resultList220 };

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final DemoniteFurnaceRecipes smelting()
    {
        return smeltingBase;
    }

    public DemoniteFurnaceRecipes()
    {    
    	this.addDoubleSmelting(bl.copper_ore, bl.copper_ore, new ItemStack(il.copper_ingot, 3));
    	this.addDoubleSmelting(bl.sapphire_ore, bl.sapphire_ore, new ItemStack(il.sapphire_gem, 3));
    	this.addDoubleSmelting(bl.adamite_ore, bl.adamite_ore, new ItemStack(il.adamite_shard, 3));
    	this.addDoubleSmelting(bl.meteorite_ore, bl.meteorite_ore, new ItemStack(il.meteorite_coal, 3));
    	this.addDoubleSmelting(bl.ruby_ore, bl.ruby_ore, new ItemStack(il.ruby_gem, 3));
    	this.addDoubleSmelting(bl.zectium_ore, bl.zectium_ore, new ItemStack(il.zectium_ingot, 3));
    	this.addDoubleSmelting(bl.tapazite_ore, bl.tapazite_ore, new ItemStack(il.tapazite_gem, 3));
    	this.addDoubleSmelting(bl.crystal_ore, bl.crystal_ore, new ItemStack(il.crystal_shard, 3));
    	this.addDoubleSmelting(bl.osmonium_ore, bl.osmonium_ore, new ItemStack(il.osmonium_ingot, 3));
    	this.addDoubleSmelting(bl.starconium_ore, bl.starconium_ore, new ItemStack(il.starconium_gem, 3));
    	this.addDoubleSmelting(bl.demonite_stone, bl.demonite_stone, new ItemStack(il.demonite_orb, 3));	
    	this.addDoubleSmelting(bl.darkstone, bl.darkstone, new ItemStack(il.darkstone_ingot, 3));
    	this.addDoubleSmelting(bl.invisium_ore, bl.invisium_ore, new ItemStack(il.invisium_ingot, 3));
    	this.addDoubleSmelting(bl.ender_ore, bl.ender_ore, new ItemStack(il.ender_gem, 3));
    	this.addDoubleSmelting(bl.luminite_ore, bl.luminite_ore, new ItemStack(il.white_luminite_crystal, 3));
    	this.addDoubleSmelting(bl.experium_ore, bl.experium_ore, new ItemStack(il.experium_orb, 3));
    	this.addDoubleSmelting(bl.fools_ruby_ore, bl.fools_ruby_ore, new ItemStack(il.fools_ruby_mush, 3));
    	this.addDoubleSmelting(bl.ultra_ore, bl.ultra_ore, new ItemStack(il.ultra_gem, 3));
    	
    	this.addDoubleSmelting(Blocks.iron_ore, Blocks.iron_ore, new ItemStack(Items.iron_ingot, 3));
    	this.addDoubleSmelting(Blocks.gold_ore, Blocks.gold_ore, new ItemStack(Items.gold_ingot, 3));
    	this.addDoubleSmelting(Blocks.diamond_ore, Blocks.diamond_ore, new ItemStack(Items.diamond, 3));
        this.addDoubleSmelting(Blocks.coal_ore, Blocks.coal_ore, new ItemStack(Items.coal, 3));
        this.addDoubleSmelting(Blocks.redstone_ore, Blocks.redstone_ore, new ItemStack(Items.redstone, 3));
        this.addDoubleSmelting(Blocks.lapis_ore, Blocks.lapis_ore, new ItemStack(Items.dye, 3, 4));
        this.addDoubleSmelting(Blocks.emerald_ore, Blocks.emerald_ore, new ItemStack(Items.emerald, 3));
        this.addDoubleSmelting(Blocks.quartz_ore, Blocks.quartz_ore, new ItemStack(Items.quartz, 3));
    	
    	this.addDoubleSmelting(Blocks.sand, Blocks.sand, new ItemStack(Blocks.glass, 3));
        this.addDoubleSmelting(Blocks.cobblestone, Blocks.cobblestone, new ItemStack(Blocks.stone, 3));
        this.addDoubleSmelting(Items.clay_ball, Items.clay_ball, new ItemStack(Items.brick, 3));
        this.addDoubleSmelting(Blocks.clay, Blocks.clay, new ItemStack(Blocks.hardened_clay));
        this.addDoubleSmelting(Blocks.gravel, Blocks.gravel, new ItemStack(Items.flint, 3));
        this.addDoubleSmelting(Blocks.cactus, Blocks.cactus, new ItemStack(Items.dye, 3, 2));
        this.addDoubleSmelting(Blocks.log, Blocks.log, new ItemStack(Items.coal, 3, 1));
        this.addDoubleSmelting(Blocks.log2, Blocks.log2, new ItemStack(Items.coal, 3, 1));
        this.addDoubleSmelting(Blocks.log, Blocks.log2, new ItemStack(Items.coal, 3, 1));
        this.addDoubleSmelting(Blocks.netherrack, Blocks.netherrack, new ItemStack(Items.netherbrick));
    	
        this.addDoubleSmelting(Items.porkchop, Items.porkchop, new ItemStack(Items.cooked_porkchop, 3));
        this.addDoubleSmelting(Items.beef, Items.beef, new ItemStack(Items.cooked_beef, 3));
        this.addDoubleSmelting(Items.chicken, Items.chicken, new ItemStack(Items.cooked_chicken, 3));
        this.addDoubleSmelting(Items.potato, Items.potato, new ItemStack(Items.baked_potato, 3));
        ItemFishFood.FishType[] afishtype = ItemFishFood.FishType.values();
        int i = afishtype.length;
        
        for (int j = 0; j < i; j++)
        {
        	ItemFishFood.FishType fishtype = afishtype[j];
        	
        	 if (fishtype.func_150973_i())
             {
                 this.addDoubleSmelting(new ItemStack(Items.fish, 1, fishtype.func_150976_a()), new ItemStack(Items.fish, 1, fishtype.func_150976_a()), new ItemStack(Items.cooked_fished, 1, fishtype.func_150976_a()));
             }
        }
        
//    	this.addDoubleSmelting(m.CrystalShard, m.CrystalShard, new ItemStack(m.CrystalCore, 3));
    }
    
    public void addDoubleSmelting(Block par1, Block par2, ItemStack par2ItemStack)
    {
    	this.addDoubleSmelting(Item.getItemFromBlock(par1), Item.getItemFromBlock(par2), par2ItemStack);
    }
    
    public void addDoubleSmelting(Item par1, Item par2, ItemStack par2ItemStack)
    {
    	this.addDoubleSmelting(new ItemStack(par1, 1), new ItemStack(par2, 1), par2ItemStack);
    }

    public void addDoubleSmelting(ItemStack par1, ItemStack par2, ItemStack par2ItemStack)
    {
        if (!smeltingList.containsKey(par1))
            this.smeltingList.put(par1, par2);
        else if (!smeltingList2.containsKey(par1))
            this.smeltingList2.put(par1, par2);
        else if (!smeltingList3.containsKey(par1))
            this.smeltingList3.put(par1, par2);
        else if (!smeltingList4.containsKey(par1))
            this.smeltingList4.put(par1, par2);
        else if (!smeltingList5.containsKey(par1))
            this.smeltingList5.put(par1, par2);
        else if (!smeltingList6.containsKey(par1))
            this.smeltingList6.put(par1, par2);
        else if (!smeltingList7.containsKey(par1))
            this.smeltingList7.put(par1, par2);
        else if (!smeltingList8.containsKey(par1))
            this.smeltingList8.put(par1, par2);
        else if (!smeltingList9.containsKey(par1))
            this.smeltingList9.put(par1, par2);
        else if (!smeltingList10.containsKey(par1))
            this.smeltingList10.put(par1, par2);
        else if (!smeltingList11.containsKey(par1))
            this.smeltingList11.put(par1, par2);
        else if (!smeltingList12.containsKey(par1))
            this.smeltingList12.put(par1, par2);
        else if (!smeltingList13.containsKey(par1))
            this.smeltingList13.put(par1, par2);
        else if (!smeltingList14.containsKey(par1))
            this.smeltingList14.put(par1, par2);
        else if (!smeltingList15.containsKey(par1))
            this.smeltingList15.put(par1, par2);
        else if (!smeltingList16.containsKey(par1))
            this.smeltingList16.put(par1, par2);
        else if (!smeltingList17.containsKey(par1))
            this.smeltingList17.put(par1, par2);
        else if (!smeltingList18.containsKey(par1))
            this.smeltingList18.put(par1, par2);
        else if (!smeltingList19.containsKey(par1))
            this.smeltingList19.put(par1, par2);
        else if (!smeltingList20.containsKey(par1))
            this.smeltingList20.put(par1, par2);
        else
        	COLogger.log(Level.FATAL, "All lists contain key! All " + smeltingListList.length + " recipe slots have been filled for " + par1);
        
        if (!resultList1.containsKey(par1))
            this.resultList1.put(par1, par2ItemStack);
        else if (!resultList12.containsKey(par1))
            this.resultList12.put(par1, par2ItemStack);
        else if (!resultList13.containsKey(par1))
            this.resultList13.put(par1, par2ItemStack);
        else if (!resultList14.containsKey(par1))
            this.resultList14.put(par1, par2ItemStack);
        else if (!resultList15.containsKey(par1))
            this.resultList15.put(par1, par2ItemStack);
        else if (!resultList16.containsKey(par1))
            this.resultList16.put(par1, par2ItemStack);
        else if (!resultList17.containsKey(par1))
            this.resultList17.put(par1, par2ItemStack);
        else if (!resultList18.containsKey(par1))
            this.resultList18.put(par1, par2ItemStack);
        else if (!resultList19.containsKey(par1))
            this.resultList19.put(par1, par2ItemStack);
        else if (!resultList110.containsKey(par1))
            this.resultList110.put(par1, par2ItemStack);
        else if (!resultList111.containsKey(par1))
            this.resultList111.put(par1, par2ItemStack);
        else if (!resultList112.containsKey(par1))
            this.resultList112.put(par1, par2ItemStack);
        else if (!resultList113.containsKey(par1))
            this.resultList113.put(par1, par2ItemStack);
        else if (!resultList114.containsKey(par1))
            this.resultList114.put(par1, par2ItemStack);
        else if (!resultList115.containsKey(par1))
            this.resultList115.put(par1, par2ItemStack);
        else if (!resultList116.containsKey(par1))
            this.resultList116.put(par1, par2ItemStack);
        else if (!resultList117.containsKey(par1))
            this.resultList117.put(par1, par2ItemStack);
        else if (!resultList118.containsKey(par1))
            this.resultList118.put(par1, par2ItemStack);
        else if (!resultList119.containsKey(par1))
            this.resultList119.put(par1, par2ItemStack);
        else if (!resultList120.containsKey(par1))
            this.resultList120.put(par1, par2ItemStack);
        else
        	COLogger.log(Level.FATAL, "All lists contain key! All " + resultListList1.length + " result slots have been filled for " + par1);
        
        if (!resultList2.containsKey(par2))
            this.resultList2.put(par2, par2ItemStack);
        else if (!resultList22.containsKey(par2))
            this.resultList22.put(par2, par2ItemStack);
        else if (!resultList23.containsKey(par2))
            this.resultList23.put(par2, par2ItemStack);
        else if (!resultList24.containsKey(par2))
            this.resultList24.put(par2, par2ItemStack);
        else if (!resultList25.containsKey(par2))
            this.resultList25.put(par2, par2ItemStack);
        else if (!resultList26.containsKey(par2))
            this.resultList26.put(par2, par2ItemStack);
        else if (!resultList27.containsKey(par2))
            this.resultList27.put(par2, par2ItemStack);
        else if (!resultList28.containsKey(par2))
            this.resultList28.put(par2, par2ItemStack);
        else if (!resultList29.containsKey(par2))
            this.resultList29.put(par2, par2ItemStack);
        else if (!resultList210.containsKey(par2))
            this.resultList210.put(par2, par2ItemStack);
        else if (!resultList211.containsKey(par2))
            this.resultList211.put(par2, par2ItemStack);
        else if (!resultList212.containsKey(par2))
            this.resultList212.put(par2, par2ItemStack);
        else if (!resultList213.containsKey(par2))
            this.resultList213.put(par2, par2ItemStack);
        else if (!resultList214.containsKey(par2))
            this.resultList214.put(par2, par2ItemStack);
        else if (!resultList215.containsKey(par2))
            this.resultList215.put(par2, par2ItemStack);
        else if (!resultList216.containsKey(par2))
            this.resultList216.put(par2, par2ItemStack);
        else if (!resultList217.containsKey(par2))
            this.resultList217.put(par2, par2ItemStack);
        else if (!resultList218.containsKey(par2))
            this.resultList218.put(par2, par2ItemStack);
        else if (!resultList219.containsKey(par2))
            this.resultList219.put(par2, par2ItemStack);
        else if (!resultList220.containsKey(par2))
            this.resultList220.put(par2, par2ItemStack);
        else
            COLogger.log(Level.FATAL, "All lists contain key! All " + resultListList2.length + " result slots have been filled for " + par2);
    }

    @Deprecated
    /**
     * Only retrieves first smelting list
     */
    public Map getSmeltingList()
    {
        return this.smeltingList;
    }
    
    @Deprecated
    /**
     * Add a metadata-sensitive furnace recipe, only allows for single item
     * @param itemID The Item ID
     * @param metadata The Item Metadata
     * @param itemstack The ItemStack for the result
     */
    public void addSmelting(int itemID, int metadata, ItemStack itemstack)
    {
        metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
    }
    
    @Deprecated
    public void addDoubleSmelting(int itemID, int metadata, int itemID2, int metadata2, ItemStack itemstack)
    {
    	COLogger.log(Level.FATAL, "Metadata support is not enabled in the Demonite Furnace!");
        metaSmeltingList.put(Arrays.asList(itemID, metadata), Arrays.asList(itemID2, metadata2));
        metaResultList1.put(Arrays.asList(itemID, metadata), itemstack);
        metaResultList1.put(Arrays.asList(itemID2, metadata2), itemstack);
    }
    
    @Deprecated
    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(item);
    }
    
    public ItemStack getSmeltingResult(ItemStack item, ItemStack item2) 
    {
        if (item == null || item2 == null)
        {
            return null;
        }
        /*ItemStack ret = (ItemStack)metaResultList1.get(Arrays.asList(item, item.getItemDamage()));
        ItemStack ret2 = (ItemStack)metaResultList2.get(Arrays.asList(item2, item2.getItemDamage()));
        if (ret != null && ret2 != null && ret.isItemEqual(ret2)) 
        {
            if (ret != null)
            {
                return ret;
            }
        }*/
        
        Map smelt = this.smeltingList;
        Map result1 = this.resultList1;
        Map result2 = this.resultList2;
        
        for (int i = 0; i < smeltingListList.length; i++)
        {
            if (this.smeltingListList[i].containsKey(item) && (this.smeltingListList[i].get(item).equals(item2)))
            {
                smelt = this.smeltingListList[i];
                break;
            }
        }
        
        int i = 0;
        int x = 0;
        for (i = 0; i < resultListList1.length; i++)
        {
            for (x = 0; x < resultListList2.length; x++)
            {
                if (((ItemStack)(this.resultListList1[i].get(item))) != null && ((ItemStack)(this.resultListList2[x].get(item2))) != null
                        && ((ItemStack)(this.resultListList1[i].get(item))).isItemEqual((ItemStack)(this.resultListList2[x].get(item2))))
                {
                    result1 = this.resultListList1[i];
                    result2 = this.resultListList2[x];
                    break;
                }
            }
        }
        
        if (item != null && item2 != null && ((ItemStack)(result1.get(item)) != null && ((ItemStack)(result2.get(item2)) != null
        		&& ((ItemStack)(result1.get(item))).isItemEqual(((ItemStack)result2.get(item2)))
                && (smelt.get(item)).equals(item2))))
        {
            return (ItemStack)(result1.get(item));
        }
        else
        {
            return null;
        }
    }
}
