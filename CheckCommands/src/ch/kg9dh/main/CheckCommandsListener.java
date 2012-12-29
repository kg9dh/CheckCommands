package ch.kg9dh.main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CheckCommandsListener implements Listener{

	CheckCommands plugin;
	
	public CheckCommandsListener(CheckCommands instance) {
        plugin = instance;
    }
	
    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
       
        if(event.getMessage().startsWith("/")){
        	        	
        	   for(Player ply : plugin.CHECKERS){
        		 //  if(ply!=event.getPlayer()){
            		   ply.sendMessage(ChatColor.DARK_AQUA + "The User " + 
            				   		   ChatColor.GOLD + event.getPlayer().getDisplayName() + 
            				   		   ChatColor.DARK_AQUA + " used the command " + 
            				   		   ChatColor.GOLD + event.getMessage());
        		//  }
        	   }
        }
        
    }
	
}
