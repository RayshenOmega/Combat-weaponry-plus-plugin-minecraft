package me.helleo.cwp.items.weapons.knives;

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

public class NetheriteKnife extends BaseKnife{

    static ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
    static ItemMeta meta = item.getItemMeta();
    static String material = "Netherite";

    public ItemStack getKnife() {
        double attack_damage = 4;
        double attack_speed = -1;
        if (ConfigurationsBool.UseCustomValues.getValue()) {
            attack_damage = ConfigurationsDouble.Knives_NetheriteKnife_Damage.getValue();
            attack_speed = ConfigurationsDouble.Knives_NetheriteKnife_Speed.getValue();
        }

        meta.setLore(getLore(attack_damage,attack_speed));
        //important:
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, setModifier("generic.attack_speed", attack_speed));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, setModifier("generic.attack_damage", attack_damage));

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', setName(material)));
        meta.setCustomModelData(1000006);
        item.setItemMeta(meta);
        return item;
    }

    public ShapedRecipe getKnifeRecipe() {
        NamespacedKey key = new NamespacedKey(CombatWeaponryPlus.plugin, "netherite_knife");
        CombatWeaponryPlus.keys.add(key);
        ShapedRecipe recipe = new ShapedRecipe(key, getKnife());

        recipe.shape(
                "   ",
                " C ",
                " S ");

        if (ConfigurationsBool.NetheriteIngots.getValue()) {
            recipe.setIngredient('C', Material.NETHERITE_INGOT);
        } else {
            recipe.setIngredient('C', Material.NETHERITE_SCRAP);
        }
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }

    public static void setKnifeRecipe(){
        Bukkit.addRecipe(new NetheriteKnife().getKnifeRecipe());
    }
}
