package com.carpentersblocks.util.registry;

import com.carpentersblocks.CarpentersBlocks;
import com.carpentersblocks.item.ItemCarpentersChisel;
import com.carpentersblocks.item.ItemCarpentersHammer;
import com.carpentersblocks.item.ItemCarpentersTile;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import static com.carpentersblocks.Reference.*;

public class ItemRegistry 
{ 
    public static Item itemCarpentersHammer;
    public static Item itemCarpentersChisel;
    public static Item itemCarpentersDoor;
    public static Item itemCarpentersBed;
    public static Item itemCarpentersTile;   
    
    public static void preInit(FMLPreInitializationEvent event)
    {      
        if (enableHammer)
        {
            itemCarpentersHammer = new ItemCarpentersHammer()
            		.setRegistryName("carpenters_hammer")
            		.setUnlocalizedName("itemCarpentersHammer")
            		.setCreativeTab(CarpentersBlocks.CREATIVE_TAB)
            		.setMaxStackSize(1);
            GameRegistry.register(itemCarpentersHammer);
            
            if (itemCarpentersToolsDamageable)
            {
            	itemCarpentersHammer.setMaxDamage(itemCarpentersToolsUses);
            }
            
            if (Side.CLIENT.equals(event.getSide()))
            {
            	ModelLoader.setCustomModelResourceLocation(itemCarpentersHammer, 0, new ModelResourceLocation(MOD_ID + ":" + "carpenters_hammer"));
            }
        }
        
        if (enableChisel) 
        {
            itemCarpentersChisel = new ItemCarpentersChisel()
            		.setRegistryName("carpenters_chisel")
            		.setUnlocalizedName("itemCarpentersChisel")
            		.setCreativeTab(CarpentersBlocks.CREATIVE_TAB)
            		.setMaxStackSize(1);
            GameRegistry.register(itemCarpentersChisel);
            
            if (itemCarpentersToolsDamageable)
            {
            	itemCarpentersChisel.setMaxDamage(itemCarpentersToolsUses);
            }
            
            if (Side.CLIENT.equals(event.getSide()))
            {
            	ModelLoader.setCustomModelResourceLocation(itemCarpentersChisel, 0, new ModelResourceLocation(MOD_ID + ":" + "carpenters_chisel"));
            }
        }
        
        if (enableTile) 
        {
            itemCarpentersTile = new ItemCarpentersTile()
            		.setUnlocalizedName("itemCarpentersTile")
            		.setRegistryName("carpenters_tile") 
            		.setCreativeTab(CarpentersBlocks.CREATIVE_TAB);
            GameRegistry.register(itemCarpentersTile);
            
            if (Side.CLIENT.equals(event.getSide()))
            {
            	ModelLoader.setCustomModelResourceLocation(itemCarpentersTile, 0, new ModelResourceLocation(MOD_ID + ":" + "carpenters_tile"));
            }
        }
    }

    public static void init(FMLInitializationEvent event)
    {
        if (enableHammer)
        {
            GameRegistry.addRecipe(new ItemStack(itemCarpentersHammer, 1), new Object[] { "XX ", " YX", " Y ", 'X', Items.IRON_INGOT, 'Y', BlockRegistry.blockCarpentersBlock });
        }
        
        if (enableChisel) 
        {
            GameRegistry.addRecipe(new ItemStack(itemCarpentersChisel, 1), new Object[] { "X", "Y", 'X', Items.IRON_INGOT, 'Y', BlockRegistry.blockCarpentersBlock });
        }
        
        if (enableTile) 
        {
            GameRegistry.addRecipe(new ItemStack(itemCarpentersTile, recipeQuantityTile), new Object[] { "XXX", "YYY", 'X', Blocks.HARDENED_CLAY, 'Y', BlockRegistry.blockCarpentersBlock });
        }
    }  
}