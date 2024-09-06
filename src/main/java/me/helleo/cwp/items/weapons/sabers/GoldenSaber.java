package me.helleo.cwp.items.weapons.sabers;

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

public class GoldenSaber extends BaseSaber{

    static ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
    static ItemMeta meta = item.getItemMeta();
    static String material = "Golden";

    public ItemStack getSaber() {
        double attack_damage = 3;
        double attack_speed = -2.4;
        if (ConfigurationsBool.UseCustomValues.getValue()) {
            attack_damage = ConfigurationsDouble.Sabers_GoldenSaber_Damage.getValue();
            attack_speed = ConfigurationsDouble.Sabers_GoldenSaber_Speed.getValue();
        }

        meta.setLore(getLore(attack_damage,attack_speed));
        //important:
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, setModifier("generic.attack_speed", attack_speed));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, setModifier("generic.attack_damage", attack_damage));

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', setName(material)));
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
