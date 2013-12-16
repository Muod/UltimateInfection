package me.muod.UI.commands;

import org.bukkit.entity.Player;

public abstract interface SubCommand
{
  public abstract boolean onCommand(Player paramPlayer, String[] paramArrayOfString);

  public abstract String help(Player paramPlayer);
}
