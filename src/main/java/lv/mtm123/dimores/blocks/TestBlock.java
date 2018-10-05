package lv.mtm123.dimores.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import static lv.mtm123.dimores.DimOres.MOD_ID;

public class TestBlock extends Block {

    public TestBlock(String name, Material mat) {
        super(mat);
        setHardness(2);
        setHarvestLevel("pickaxe", 2);
        setRegistryName(MOD_ID, name);
        setCreativeTab(CreativeTabs.MATERIALS);
        setTranslationKey(MOD_ID + ".test");
    }


}
