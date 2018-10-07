package lv.mtm123.dimores.worldgen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Collection;
import java.util.Random;

public class TestGen implements IWorldGenerator {

    private final GenData[] genData;
    private final int dimension;

    public TestGen(Collection<GenData> genData, int dimension){
        this.genData = genData.toArray(new GenData[0]);
        this.dimension = dimension;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        if(world.provider.getDimension() != dimension)
            return;

        for(GenData g : genData){
            int dh = g.getMaxHeight() - g.getMinHeight() + 1;
            for(int i = 0; i < g.getSpawnChance(); i++){
                int x = (chunkX << 4) + random.nextInt(16);
                int y = g.getMinHeight() + random.nextInt(dh);
                int z = (chunkZ << 4) + random.nextInt(16);

                g.getGenMinable(dimension).generate(world, random, new BlockPos(x, y, z));
            }
        }

    }

    private static Block getBlockToReplace(int dimension){
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
