package me.muod.UI.commands;

import me.muod.UI.GameManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Leave
implements SubCommand
{
public boolean onCommand(Player player, String[] args)
{
	String pname = player.getName();
	if (GameManager.getInstance().humans.contains(pname)){
		GameManager.getInstance().humans.remove(pname);
		player.sendMessage(ChatColor.GOLD + "You have left UltimateInfection!");
	}else{
	GameManager.getInstance().humans.add(pname);
	player.sendMessage(ChatColor.GREEN + "You are not in any game!");
	}
  return true;
}

public String help(Player p)
{
  return ChatColor.GOLD + "/ui leave " + ChatColor.DARK_RED + " - " + ChatColor.YELLOW + "Leave the current game ";
}
}