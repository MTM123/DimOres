package lv.mtm123.dimores;

import lv.mtm123.dimores.blocks.DimOre;
import lv.mtm123.dimores.items.DimOreItemBlock;
import lv.mtm123.dimores.worldgen.GenData;
import lv.mtm123.dimores.worldgen.OreGen;
import lv.mtm123.dimores.worldgen.TestGen;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

@Mod(
        modid = DimOres.MOD_ID,
        name = DimOres.MOD_NAME,
        version = DimOres.VERSION
)
public class DimOres {

    public static final String MOD_ID = "dimores";
    public static final String MOD_NAME = "DimOres";
    public static final String VERSION = "1.0-SNAPSHOT";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static DimOres INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        Set<GenData> genData = new HashSet<>();

        genData.add(new GenData(Blocks.netherCoalOre, 10, 0, 120, 30));
        genData.add(new GenData(Blocks.netherIronOre, 7, 0, 120, 24));
        genData.add(new GenData(Blocks.netherGoldOre, 6, 0, 120, 12));
        genData.add(new GenData(Blocks.netherRedstoneOre, 5, 0, 120, 9));
        genData.add(new GenData(Blocks.netherLapisOre, 4, 0, 120, 6));
        genData.add(new GenData(Blocks.netherDiamondOre, 3, 0, 45, 4));
        genData.add(new GenData(Blocks.netherEmeraldOre, 2, 85, 120, 4));

        GameRegistry.registerWorldGenerator(new TestGen(genData, -1), 0);

/*        GameRegistry.registerWorldGenerator(new OreGen(Blocks.netherCoalOre, 10, 0, 120, 30, -1), 0);
        GameRegistry.registerWorldGenerator(new OreGen(Blocks.netherIronOre, 7, 0, 120, 24, -1), 0);
        GameRegistry.registerWorldGenerator(new OreGen(Blocks.netherGoldOre, 6, 0, 120, 12, -1), 0);
        GameRegistry.registerWorldGenerator(new OreGen(Blocks.netherRedstoneOre, 5, 0, 120, 9, -1), 0);
        GameRegistry.registerWorldGenerator(new OreGen(Blocks.netherDiamondOre, 3, 0, 45, 4, -1), 0);
        GameRegistry.registerWorldGenerator(new OreGen(Blocks.netherLapisOre, 4, 0, 120, 6, -1), 0);
        GameRegistry.registerWorldGenerator(new OreGen(Blocks.netherEmeraldOre, 2, 85, 120, 4, -1), 0);*/

        //        /fill ~-10 ~-25 ~-10 ~10 ~25 ~10 minecraft:air 0 replace minecraft:end_stone

        Set<GenData> endData = new HashSet<>();

        //new GenData(block, amount, minHeight, maxHeight, spawnChance)
        endData.add(new GenData(Blocks.endCoalOre, 5, 0, 70, 40));
        endData.add(new GenData(Blocks.endIronOre, 4, 0, 70, 32));
        endData.add(new GenData(Blocks.endGoldOre, 4, 0, 70, 28));
        endData.add(new GenData(Blocks.endRedstoneOre, 3, 0, 70, 18));
        endData.add(new GenData(Blocks.endLapisOre, 3, 0, 70, 18));
        endData.add(new GenData(Blocks.endDiamondOre, 2, 0, 70, 40));
        endData.add(new GenData(Blocks.endEmeraldOre, 2, 0, 70, 40));

        GameRegistry.registerWorldGenerator(new TestGen(endData, 1), 0);



/*        GameRegistry.registerWorldGenerator(new OreGen(Blocks.endCoalOre, 5, 0, 70, 40, 1), 5);
        GameRegistry.registerWorldGenerator(new OreGen(Blocks.endIronOre, 4, 0, 70, 32, 1), 6);
        GameRegistry.registerWorldGenerator(new OreGen(Blocks.endGoldOre, 4, 0, 70, 28, 1), 7);
        GameRegistry.registerWorldGenerator(new OreGen(Blocks.endRedstoneOre, 3, 0, 70, 18, 1), 9);
        GameRegistry.registerWorldGenerator(new OreGen(Blocks.endDiamondOre, 2, 0, 70, 8, 1), 10);
        GameRegistry.registerWorldGenerator(new OreGen(Blocks.endLapisOre, 3, 0, 70, 18, 1), 9);
        GameRegistry.registerWorldGenerator(new OreGen(Blocks.endEmeraldOre, 2, 0, 70, 8, 1), 10);*/


    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    /**
     * Forge will automatically look up and bind blocks to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Blocks {

        public static final Block netherCoalOre = new DimOre("nether_coal_ore");
        public static final Block endCoalOre = new DimOre("end_coal_ore");
        public static final Block netherIronOre = new DimOre("nether_iron_ore");
        public static final Block endIronOre = new DimOre("end_iron_ore");
        public static final Block netherGoldOre = new DimOre("nether_gold_ore");
        public static final Block endGoldOre = new DimOre("end_gold_ore");
        public static final Block netherRedstoneOre = new DimOre("nether_redstone_ore");
        public static final Block endRedstoneOre = new DimOre("end_redstone_ore");
        public static final Block netherDiamondOre = new DimOre("nether_diamond_ore");
        public static final Block endDiamondOre = new DimOre("end_diamond_ore");
        public static final Block netherLapisOre = new DimOre("nether_lapis_ore");
        public static final Block endLapisOre = new DimOre("end_lapis_ore");
        public static final Block netherEmeraldOre = new DimOre("nether_emerald_ore");
        public static final Block endEmeraldOre = new DimOre("end_emerald_ore");

    }

    /**
     * Forge will automatically look up and bind items to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Items {
        public static final Item netherCoalOre = new DimOreItemBlock(Blocks.netherCoalOre, "nether_coal_ore");
        public static final Item endCoalOre = new DimOreItemBlock(Blocks.endCoalOre, "end_coal_ore");
        public static final Item netherIronOre = new DimOreItemBlock(Blocks.netherIronOre, "nether_iron_ore");
        public static final Item endIronOre = new DimOreItemBlock(Blocks.endIronOre, "end_iron_ore");
        public static final Item netherGoldOre = new DimOreItemBlock(Blocks.netherGoldOre, "nether_gold_ore");
        public static final Item endGoldOre = new DimOreItemBlock(Blocks.endGoldOre, "end_gold_ore");
        public static final Item netherRedstoneOre = new DimOreItemBlock(Blocks.netherRedstoneOre, "nether_redstone_ore");
        public static final Item endRedstoneOre = new DimOreItemBlock(Blocks.endRedstoneOre, "end_redstone_ore");
        public static final Item netherDiamondOre = new DimOreItemBlock(Blocks.netherDiamondOre, "nether_diamond_ore");
        public static final Item endDiamondOre = new DimOreItemBlock(Blocks.endDiamondOre, "end_diamond_ore");
        public static final Item netherLapisOre = new DimOreItemBlock(Blocks.netherLapisOre, "nether_lapis_ore");
        public static final Item endLapisOre = new DimOreItemBlock(Blocks.endLapisOre, "end_lapis_ore");
        public static final Item netherEmeraldOre = new DimOreItemBlock(Blocks.netherEmeraldOre, "nether_emerald_ore");
        public static final Item endEmeraldOre = new DimOreItemBlock(Blocks.endEmeraldOre, "end_emerald_ore");



      /*
          public static final ItemBlock mySpecialBlock = null; // itemblock for the block above
          public static final MySpecialItem mySpecialItem = null; // placeholder for special item below
      */
    }

    /**
     * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
     */
    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        /**
         * Listen for the register event for creating custom items
         */
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {

            for(Field f : Items.class.getDeclaredFields()){
                try {
                    event.getRegistry().register((Item) f.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

           /*
             event.getRegistry().register(new ItemBlock(Blocks.myBlock).setRegistryName(MOD_ID, "myBlock"));
             event.getRegistry().register(new MySpecialItem().setRegistryName(MOD_ID, "mySpecialItem"));
            */
        }

        /**
         * Listen for the register event for creating custom blocks
         */
        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {

            for(Field f : Blocks.class.getDeclaredFields()){
                try {
                    event.getRegistry().register((Block) f.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @SubscribeEvent
    public void registerRenders(ModelRegistryEvent event){

        for(Field f : Blocks.class.getDeclaredFields()) {
            try {
                Item item = Item.getItemFromBlock((Block) f.get(null));
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
    /* EXAMPLE ITEM AND BLOCK - you probably want these in separate files
    public static class MySpecialItem extends Item {

    }

    public static class MySpecialBlock extends Block {

    }
    */
}
