package lv.mtm123.dimores.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import static lv.mtm123.dimores.DimOres.MOD_ID;

public class TestItemBlock extends ItemBlock {

    public TestItemBlock(Block block) {
        super(block);
        setRegistryName(MOD_ID, "test");
        setTranslationKey(MOD_ID + ".test");
    }

}
