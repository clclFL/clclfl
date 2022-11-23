package com.github.clclfl.item.toolitem;

import com.github.clclfl.Utils;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ToolTipHelper {

    private ToolTipHelper(){}

    public static class ToolItemContext{
        private ItemStack stack;
        private World worldIn;
        private List<ITextComponent> tooltip;
        private ITooltipFlag flagIn;

        public ToolItemContext(ItemStack stack, @Nullable World worldIn,
                               List<ITextComponent> tooltip, ITooltipFlag flagIn) {
            this.stack = stack;
            this.worldIn = worldIn;
            this.tooltip = tooltip;
            this.flagIn = flagIn;
        }

        public ItemStack getStack() {
            return stack;
        }

        public World getWorldIn() {
            return worldIn;
        }

        public List<ITextComponent> getTooltip() {
            return tooltip;
        }

        public ITooltipFlag getFlagIn() {
            return flagIn;
        }
    }

    /**
     * name key with format : "unlocalizedName.line*num*"
     */
    public static void addNormalToolInfo(ToolItemContext context , String... translationKeys){
        if (!Screen.hasShiftDown()){
            context.getTooltip().add(getNormalDisplayTip());
        } else {
            for (String key : translationKeys){
                context.getTooltip().add(Utils.TipHelper.getTip("tooltip.clclfl." + key));
            }
        }
    }

    /**
     * normal expression that used for displaying information while player
     * hovering point over an item.
     */
    private static ITextComponent getNormalDisplayTip(){
        return new TranslationTextComponent("tooltip.clclfl.weaponOriginalDisplay");
    }

}
