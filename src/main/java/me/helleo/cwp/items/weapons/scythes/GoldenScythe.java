package me.helleo.cwp.items.weapons.scythes;

import me.helleo.cwp.CombatWeaponryPlus;
import me.helleo.cwp.configurations.ConfigurationsBool;
import me.helleo.cwp.configurations.ConfigurationsDouble;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

public class GoldenScythe extends BaseScythe{

    static ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
    static ItemMeta meta = item.getItemMeta();
    static String material = "Golden";

    public ItemStack getScythe() {
        double attack_damage = 6;
        double attack_speed = -2.8;
        if (ConfigurationsBool.UseCustomValues.getValue()) {
            attack_damage = ConfigurationsDouble.Scythes_GoldenScythe_Damage.getValue();
            attack_speed = ConfigurationsDouble.Scythes_GoldenScythe_Speed.getValue();
        }

        meta.setLore(getLore(attack_damage,attack_speed));
        //important:
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, setModifier("generic.attack_speed", attack_speed));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, setModifier("generic.attack_damage", attack_damage));

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', setName(material)));
        meta.setCustomModelData(1000003);
        item.setItemMeta(meta);
        return item;
    }

    public ShapedRecipe getScytheRecipe() {
        NamespacedKey key = new NamespacedKey(CombatWeaponryPlus.plugin, "golden_scythe");
        CombatWeaponryPlus.keys.add(key);
        ShapedRecipe recipe = new ShapedRecipe(key, getScythe());

        recipe.shape(
                "GGG",
                "  S",
                "  S");

        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('G', Material.GOLD_INGOT);

        return recipe;
    }
    public static void setScytheRecipe(){
        Bukkit.addRecipe(new GoldenScythe().getScytheRecipe());
    }
}
