package org.example.ikknight.templatep.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.Random;

import static org.example.ikknight.templatep.Main.EOS;

public class PlayerMove implements Listener {
    Random rand = new Random();
    @EventHandler
    public void PlayerMoveEvent(PlayerMoveEvent event) {
        if(!EOS){
            return;
        }
        EOS=false;
        Player p = event.getPlayer();
        p.sendMessage(ChatColor.GREEN+"You Moved...");
        Bukkit.broadcastMessage(ChatColor.DARK_RED+p.getDisplayName()+ChatColor.AQUA+" is gay since they moved!");
        p.setDisplayName("GayGuy#"+rand.nextInt(10000));
        p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,9999999,255));

    }
}
