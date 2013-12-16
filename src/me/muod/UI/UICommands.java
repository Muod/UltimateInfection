package me.muod.UI;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import me.muod.UI.commands.Join;
import me.muod.UI.commands.Leave;
import me.muod.UI.commands.Setspawn;
import me.muod.UI.commands.SubCommand;

public class UICommands
  implements CommandExecutor
{
  private Plugin plugin;
  private HashMap<String, SubCommand> commands;

  public UICommands(Plugin plugin)
  {
    this.plugin = plugin;
    this.commands = new HashMap();
    loadCommands();
  }
  private void loadCommands()
  {
    this.commands.put("join", new Join());
    this.commands.put("leave", new Leave());
    this.commands.put("setspawn", new Setspawn());
  }
	  
  public boolean onCommand(CommandSender sender, Command cmd1, String commandLabel, String[] args)
  {
    String cmd = cmd1.getName();
    PluginDescriptionFile pdfFile = this.plugin.getDescription();

    Player player = null;
    if ((sender instanceof Player)) {
      player = (Player)sender;
    }
    else {
      System.out.println("Only ingame players can use Spleef commands");
      return true;
    }

    if (cmd.equalsIgnoreCase("ultimateinfection")) {
      if ((args == null) || (args.length < 1)) {
        player.sendMessage(ChatColor.GOLD  + "UltimateInfection - Muod" + ChatColor.RESET + ChatColor.YELLOW + " Version: " + pdfFile.getVersion());
        player.sendMessage(ChatColor.GOLD + "Type /ultimateinfection help, or /ui help for help");

        return true;
      }
      if (args[0].equalsIgnoreCase("help")) {
        help(player);
        return true;
      }
      String sub = args[0];

      Vector l = new Vector();
      l.addAll(Arrays.asList(args));
      l.remove(0);
      args = (String[])l.toArray(new String[0]);
      if (!this.commands.containsKey(sub)) {
        player.sendMessage(ChatColor.RED + "Command dosent exist.");
        player.sendMessage(ChatColor.GOLD + "Type /ultimateinfection help or /ui help for help");
        return true;
      }
      try
      {
        ((SubCommand)this.commands.get(sub)).onCommand(player, args); } catch (Exception e) {
        e.printStackTrace(); player.sendMessage(ChatColor.RED + "An error occured while executing the command. Check the      console"); player.sendMessage(ChatColor.BLUE + "Type /ui help for help");
      }
      return true;
    }
    return false;
  }

  public void help(Player p) {
    p.sendMessage("/ultimateinfection <command> <args>");
    for (SubCommand v : this.commands.values())
      p.sendMessage(ChatColor.AQUA + v.help(p));
  }
}