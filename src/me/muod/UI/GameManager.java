package me.muod.UI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

	public class GameManager implements Listener
	{
	  private static GameManager instance = new GameManager();
	  private Main m = new Main();
	  Main plugin;
		public static ArrayList<String> zombies = new ArrayList();
		public static ArrayList<String> humans = new ArrayList();
		Map<String, ItemStack[]> inv = new HashMap();
		Map<String, ItemStack[]> armor = new HashMap();
		Map<String, Double> lbtpX = new HashMap();
		Map<String, Double> lbtpY  = new HashMap();
	    Map<String, Double> lbtpZ = new HashMap();
	    Map<String, World> lbtpWORLD = new HashMap();
	    public static GameManager getInstance() {
	        return instance;
	      }


	      public void addplayer(Player player){
	    	  m.getInstance().getConfig().set("Locations.Humans.X", player.getLocation().getX());
	    	  player.sendMessage("Succefully set the x!");
	      }
	      public void haspaid(Player player){
	    	  
	      }
}
