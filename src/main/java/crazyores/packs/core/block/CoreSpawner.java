package crazyores.packs.core.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.pack.data.CrazyOresData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class CoreSpawner extends BlockMobSpawner {

	private String unlocalizedName;
	private String entityName;
	
	protected CoreSpawner(String blockUnlocalizedName, String spawnEntityName, CreativeTabs tab, Block.SoundType soundType, float hardness, float resistance) {
		super();
		unlocalizedName = blockUnlocalizedName;
		entityName = spawnEntityName;
		this.setCreativeTab(tab);
		this.setStepSound(soundType);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		TileEntityMobSpawner spawner = new TileEntityMobSpawner();
		spawner.func_145881_a().setEntityName(getEntityName());
		System.out.println(spawner.func_145881_a().getEntityNameToSpawn());
		return spawner;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }
	
	public String getEntityName() {
		return CrazyOresData.corePackID + "." + entityName;
	}
	
	@Override
	public String getUnlocalizedName() {
		return unlocalizedName;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", this.unlocalizedName));
	}

	@Override
	public IIcon getIcon(int side, int metadata) {
		return this.blockIcon;
	}
}
