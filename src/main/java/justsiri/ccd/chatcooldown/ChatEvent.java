package justsiri.ccd.chatcooldown;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Timer;
import java.util.TimerTask;

public class ChatEvent implements Listener {

    int timer = 300;
    boolean canChat = true;

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (!canChat && timer > 0) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "Stop spamming!");
        } else {
            canChat = false;
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        canChat = true;
        if (!(e.getPlayer().isOp())) {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    timer--;
                    if (timer <= 0 && !canChat) {
                       timer = 300;
                       canChat = true;
                    }
                }
            };
            new Timer().schedule(task, 0l, 10l);
        }
    }

}
