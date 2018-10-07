package lv.mtm123.dimores.blocks;

import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;

import static lv.mtm123.dimores.DimOres.MOD_ID;

public class DimOre extends BlockOre {

    public DimOre(String name){
        setHardness(2);
        setHarvestLevel("pickaxe", 2);
        setRegistryName(MOD_ID, name);
        setCreativeTab(CreativeTabs.MATERIALS);
        setTranslationKey(String.format("%s.%s", MOD_ID, name));
    }

}
