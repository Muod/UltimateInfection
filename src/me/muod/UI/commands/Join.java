package me.muod.UI.commands;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.Plugin;
import me.muod.UI.GameManager;

public class Join
implements SubCommand
{
public boolean onCommand(Player player, String[] args)
{
	String pname = player.getName();
	if (GameManager.getInstance().humans.contains(pname)){
		player.sendMessage(ChatColor.GOLD + "You are already in the game!");
	}else{
	GameManager.getInstance().humans.add(pname);
	player.sendMessage(ChatColor.GREEN + "You have joined the game!");
	}
  return true;
}

public String help(Player p)
{
  return ChatColor.GOLD + "/ui join " + ChatColor.DARK_RED + " - " + ChatColor.YELLOW + "Join the current game ";
}
}