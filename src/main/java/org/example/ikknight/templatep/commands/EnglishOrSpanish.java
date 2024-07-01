package org.example.ikknight.templatep.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.example.ikknight.templatep.Main;
import static org.example.ikknight.templatep.Main.EOS;
import static org.example.ikknight.templatep.utils.BasicUtils.getPrefix;

public class EnglishOrSpanish implements CommandExecutor {
    Main m;
    public EnglishOrSpanish(Main main){
        m=main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            commandSender.sendMessage(getPrefix() + ChatColor.DARK_RED + "You cannot run this command from the console!");
            return false;
        }
        Player player = (Player) commandSender;
        // check if english or spanish is being played right now
        if(EOS){
            player.sendMessage(getPrefix()+ChatColor.RED+"The english or spanish game is still being played right now.");
            return false;
        }else{
            Bukkit.broadcastMessage(ChatColor.YELLOW+"English or Spanish?");

            Bukkit.getScheduler ().runTaskLater (m, () -> EOS=true, 10); // wait 1/2 sec
        }

        return false;
    }
}
