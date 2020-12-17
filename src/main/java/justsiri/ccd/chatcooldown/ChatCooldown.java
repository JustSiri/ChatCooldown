package justsiri.ccd.chatcooldown;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatCooldown extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Plugin ChatCooldown enabled");
        Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin ChatCooldown disabled");
    }
}
