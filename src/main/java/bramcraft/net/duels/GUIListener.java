package bramcraft.net.duels;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("§6Select a Kit")) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            ItemStack clicked = e.getCurrentItem();
            if (clicked == null || !clicked.hasItemMeta()) return;

            String name = ChatColor.stripColor(clicked.getItemMeta().getDisplayName());

            switch (name.toLowerCase()) {
                case "knight", "archer" -> {
                    Duels.getSelectedKits().put(player.getUniqueId(), name.toLowerCase());
                    player.sendMessage("§eSelected kit: §f" + name);
                }
                case "done" -> {
                    player.closeInventory();
                    player.sendMessage("§aNow select a player to duel.");
                    // Hier komt straks de Invite GUI
                }
            }
        }
    }
}
