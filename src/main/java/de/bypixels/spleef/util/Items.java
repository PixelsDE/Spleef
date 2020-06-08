package de.bypixels.spleef.util;

import de.bypixels.pixelsapi.util.ItemCreator;
import de.bypixels.spleef.Spleef;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Items {


    //TODO: HERE


/*
    public static ItemStack SPLEEF_ITEM_SWORD = new ItemCreator(Material.valueOf("DIAMOND_SWORD")).addItemName(Spleef.getPlugin().getSettings().getStringWithColor("SWORD_NAME")).addEnchantment(Enchantment.DURABILITY, 100).buildItemStack();
*/

    public static ItemStack SPLEEF_ITEM_SWORD = new ItemCreator(Material.valueOf("DIAMOND_SWORD")).addItemName("Schwerd").addEnchantment(Enchantment.DURABILITY, 100).buildItemStack();

/*
    public static ItemStack LEAVE_DOOR = new ItemCreator(Material.valueOf("DIAMOND")).addItemName(Spleef.getPlugin().getSettings().getStringWithColor("LEAVE_DOOR_NAME")).createItemStack();
*/
public static ItemStack LEAVE_DOOR = new ItemCreator(Material.valueOf("OAK_DOOR")).addItemName(Spleef.getPlugin().getSettings().getStringWithColor("LEAVE_DOOR_NAME")).createItemStack();


}
