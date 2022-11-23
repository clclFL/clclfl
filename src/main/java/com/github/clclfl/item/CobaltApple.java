package com.github.clclfl.item;


import com.github.clclfl.creativetab.ModCreativeTab;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

@Deprecated
public class CobaltApple extends Item {

    private static final Food food = (new Food.Builder())
            .saturation(20).hunger(10).setAlwaysEdible().build();

    public CobaltApple(){
        super(new Properties().food(food).group(ModCreativeTab.TAB_CLCLFL));
    }

}
