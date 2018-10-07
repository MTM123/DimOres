package lv.mtm123.dimores.worldgen;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class OreGen implements IWorldGenerator {

    private final WorldGenerator oregen;

    private final int minHeight;
    private final int maxHeight;
    private final int spawnChance;
    private final int dimension;

    public OreGen(Block b, int amount, int minHeight, int maxHeight, int spawnChance, int dimension) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.spawnChance = spawnChance;
        this.dimension = dimension;

        if(minHeight < 0 || maxHeight > 256 || minHeight > maxHeight){
            throw new IllegalArgumentException("Incorrect generator arguments!");
        }

        oregen = new WorldGenMinable(b.getDefaultState(), amount, BlockMatcher.forBlock(getBlockToReplace(dimension)));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        if(world.provider.getDimension() != dimension)
            return;

        int dh = maxHeight - minHeight + 1;
        for(int i = 0; i < spawnChance; i++){
            int x = (chunkX << 4) + random.nextInt(16);
            int y = minHeight + random.nextInt(dh);
            int z = (chunkZ << 4) + random.nextInt(16);

            oregen.generate(world, random, new BlockPos(x, y, z));
        }

    }

    public static Block getBlockToReplace(int dimension){
        switch (dimension){
            case -1:
                return Blocks.NETHERRACK;
            case 0:
                return Blocks.STONE;
            case 1:
                return Blocks.END_STONE;
                default:
                    return Blocks.STONE;
        }
    }

}
