package lv.mtm123.dimores.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import static lv.mtm123.dimores.DimOres.MOD_ID;

public class DimOreItemBlock extends ItemBlock {

    public DimOreItemBlock(Block block, String name) {
        super(block);
        setRegistryName(MOD_ID, name);
        setTranslationKey(MOD_ID + "." + name);
    }

}
