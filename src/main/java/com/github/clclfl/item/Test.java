package com.github.clclfl.item;

import com.github.clclfl.client.gui.OpenGUI;
import com.github.clclfl.client.gui.ToastMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Test extends Item {

    public Test(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isRemote) {
            Minecraft.getInstance().deferTask(() -> {
                ToastMessage toastMessage = new ToastMessage();
                toastMessage.show("Hello", "World");
            });
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
