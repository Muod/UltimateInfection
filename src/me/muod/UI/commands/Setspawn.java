package me.muod.UI.commands;

import me.muod.UI.GameManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Setspawn
implements SubCommand
{
public boolean onCommand(Player player, String[] args)
{
	if (args[0].equalsIgnoreCase("red") && args.length == 1){
		GameManager.getInstance().addplayer(player);
		player.sendMessage(ChatColor.GREEN + "You set Human spawn in " + ChatColor.RED + "" + ChatColor.GREEN + "!");
	} else{
	}
	if (args[0].equalsIgnoreCase("zombie") && args.length == 1){
		player.sendMessage(ChatColor.GREEN + "You set" + ChatColor.GOLD +  " Zombie" + ChatColor.GREEN +  " spawn!");
	}
  return true;
}

public String help(Player p)
{
  return ChatColor.GOLD + "/ui setpos (Human/Zombie) " + ChatColor.DARK_RED + "- " + ChatColor.YELLOW + "Set a spawn position for humans/zombies";
}
}