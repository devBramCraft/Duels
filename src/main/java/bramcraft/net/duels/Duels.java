package bramcraft.net.duels;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public final class Duels extends JavaPlugin {

    public static <V, K> Map<K, V> getSelectedKits() {
        return null;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Duels plugin has been enabled!");
        getCommand("duel").setExecutor(new DuelCommand());
        getServer().getPluginManager().registerEvents(new GUIListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Duels plugin has been disabled!");
    }
}
