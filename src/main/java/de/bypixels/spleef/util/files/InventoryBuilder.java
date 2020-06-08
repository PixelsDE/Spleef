package de.bypixels.spleef.util.files;

import de.bypixels.pixelsapi.util.InventoryCreator;
import org.bukkit.inventory.Inventory;

public class InventoryBuilder extends InventoryCreator {

    public InventoryBuilder(String inventoryName, int size) {
        super(inventoryName, size);
    }

    public InventoryBuilder(Inventory inventory) {
        super(inventory);
    }
}
