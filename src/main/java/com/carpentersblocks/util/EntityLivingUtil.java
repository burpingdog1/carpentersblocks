package com.carpentersblocks.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class EntityLivingUtil 
{

    /**
     * Decrements the player's currently active ItemStack.
     *
     * @param entityPlayer the player
     */
    public static void decrementCurrentSlot(EntityPlayer entityPlayer)
    {
        ItemStack itemStack = entityPlayer.getHeldItemMainhand();
        if (itemStack != null) 
        {
            if (!entityPlayer.capabilities.isCreativeMode && --itemStack.stackSize <= 0) 
            {
                entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem, null);
            }
        }
    }

}
