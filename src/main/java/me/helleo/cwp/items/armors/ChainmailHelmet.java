package me.helleo.cwp.items.armors;

import me.helleo.cwp.CombatWeaponryPlus;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class ChainmailHelmet extends BaseArmor {

    static ItemStack item = new ItemStack(Material.CHAINMAIL_HELMET);
    //static ItemMeta meta = item.getItemMeta();


    /*public static ItemStack getArmorPiece() {

    } */


    public static ShapedRecipe getArmorPieceRecipe() {

        //chainmail helmet

        ItemStack item = new ItemStack(Material.CHAINMAIL_HELMET);

        NamespacedKey key = new NamespacedKey(CombatWeaponryPlus.plugin, "chainmail_helmet");
        CombatWeaponryPlus.keys.add(key);
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(
                "CCC",
                "C C",
                "   ");

        recipe.setIngredient('C', Material.CHAIN);

        return recipe;
    }
}