package ch.kg9dh.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class CheckCommands extends JavaPlugin{
	
	public Map<Player, Boolean>ENABLED = new HashMap<Player, Boolean>();
	public List<Player>CHECKERS = new ArrayList<Player>();
	 	
	    public void onEnable() {
	        this.getServer().getPluginManager().registerEvents(new CheckCommandsListener(this), this);
	    }
	 	
	 	
	 	public void onDisable() {
	 	}
	 	
	 	@Override
	 	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){			
	 		
	 		Player p =(Player) sender;
	 		
	 		if(cmd.getName().equalsIgnoreCase("checkcommands")){
	 			if(p.hasPermission("checkcommands.check")||p.isOp()){
		 			if(args.length==1){
		 				if(args[0].equalsIgnoreCase("on")){
		 					if(!CHECKERS.contains(p)){
		 						CHECKERS.add(p);
		 					}
		 					ENABLED.put(p, true);
		 					p.sendMessage(ChatColor.DARK_AQUA + "Checkcommands is ENABLED for you!");
		 				}else if(args[0].equalsIgnoreCase("off")){
		 					if(CHECKERS.contains(p)){
		 						CHECKERS.remove(p);
		 					}
		 					ENABLED.put(p, false);
		 					p.sendMessage(ChatColor.DARK_AQUA + "Checkcommands is DISABLED for you!");
		 				}else if(args[0].equalsIgnoreCase("check")){
		 					if(ENABLED.get(p)==true){
		 						p.sendMessage(ChatColor.DARK_AQUA + "Checkcommands is ENABLED for you!");
		 					}else{
		 						p.sendMessage(ChatColor.DARK_AQUA + "Checkcommands is DISABLED for you!");
		 					}
		 				}
		 			}else if(!(p.hasPermission("checkcommands.check")||p.isOp())){
		 				p.sendMessage(ChatColor.RED + "You are not permitted to use this command!");
		 			}
	 				
	 				
	 			}else{
	 				p.sendMessage(ChatColor.RED + "Correct usage: /checkcommands <on/off>");
	 			}
	 		}
	 		
	 		return false;
	 	}
}

