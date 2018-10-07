package lv.mtm123.dimores.worldgen;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class GenData {

    private final Block block;
    private final int amount;
    private final int minHeight;
    private final int maxHeight;
    private final int spawnChance;

    private WorldGenMinable genMinable;

    public GenData(Block block, int amount, int minHeight, int maxHeight, int spawnChance) {
        this.block = block;
        this.amount = amount;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;

        if(minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Incorrect generator arguments!");

        this.spawnChance = spawnChance;

    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getSpawnChance() {
        return spawnChance;
    }

    public WorldGenMinable getGenMinable(int dimension) {

        if(genMinable == null){
            genMinable = new WorldGenMinable(block.getDefaultState(), amount, BlockMatcher.forBlock(OreGen.getBlockToReplace(dimension)));
        }

        return genMinable;
    }

}
