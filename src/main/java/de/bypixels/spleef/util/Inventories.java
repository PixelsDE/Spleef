package de.bypixels.spleef.util;

import de.bypixels.pixelsapi.util.InventoryCreator;
import de.bypixels.pixelsapi.util.ItemCreator;
import de.bypixels.spleef.util.files.InventoryBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inventories {



    private Inventory userStartInventory = new InventoryBuilder(" ", 36).addItemToInventory(Items.LEAVE_DOOR, 8).fillInventory(new ItemCreator(Material.DIAMOND).addItemName(" ").addEnchantment(Enchantment.DURABILITY, 1).buildItemStack());

    public Inventory getUserStartInventory() {
        return userStartInventory;
    }
}
