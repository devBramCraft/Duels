package bramcraft.net.duels;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitSelectionGUI {

    public void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, "§6Select a Kit");

        // Voorbeeldkits, je vervangt dit later door dynamische kits
        ItemStack knight = createItem(Material.IRON_SWORD, "§7Knight");
        ItemStack archer = createItem(Material.BOW, "§aArcher");
        ItemStack done = createItem(Material.LIME_WOOL, "§aDone");

        inv.setItem(11, knight);
        inv.setItem(15, archer);
        inv.setItem(26, done);

        player.openInventory(inv);
    }

    private ItemStack createItem(Material mat, String name) {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            item.setItemMeta(meta);
        }
        return item;
    }
}
