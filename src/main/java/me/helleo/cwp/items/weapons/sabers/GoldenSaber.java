package me.helleo.cwp.items.weapons.sabers;

import me.helleo.cwp.CombatWeaponryPlus;
import me.helleo.cwp.configurations.ConfigurationsBool;
import me.helleo.cwp.configurations.ConfigurationsDouble;
import me.helleo.cwp.configurations.ConfigurationsString;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GoldenSaber extends BaseSaber{

    static ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
    static ItemMeta meta = item.getItemMeta();

    public ItemStack getSaber() {
        List<String> lore = setLore();
        lore.add(ChatColor.translateAlternateColorCodes('&', ConfigurationsString.DescriptionGoldenSaber_Line5.getValue()));
        lore.add(ChatColor.translateAlternateColorCodes('&', ConfigurationsString.DescriptionGoldenSaber_Line6.getValue()));
        lore.add(ChatColor.translateAlternateColorCodes('&', ConfigurationsString.DescriptionGoldenSaber_Line7.getValue()));
        meta.setLore(lore);
        //important:
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        double dmg = 3;
        double spd = -2.4;
        if (ConfigurationsBool.UseCustomValues.getValue()) {
            dmg = ConfigurationsDouble.Sabers_GoldenSaber_Damage.getValue();
            spd = ConfigurationsDouble.Sabers_GoldenSaber_Speed.getValue();
        }
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", spd,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", dmg,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);


        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ConfigurationsString.DescriptionGoldenSaber_Name.getValue()));
        meta.setCustomModelData(1000010);
        item.setItemMeta(meta);
        return item;
    }

    public ShapedRecipe getSaberRecipe() {
        NamespacedKey key = new NamespacedKey(CombatWeaponryPlus.plugin, "golden_saber");
        CombatWeaponryPlus.keys.add(key);
        ShapedRecipe recipe = new ShapedRecipe(key, getSaber());

        recipe.shape(
                " aa",
                " a ",
                "S  ");

        recipe.setIngredient('a', Material.GOLD_INGOT);
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public static void setSaberRecipe(){
        Bukkit.addRecipe(new GoldenSaber().getSaberRecipe());
    }
}
