package net.melonhut.main;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HubCommand extends Command{
	
	public HubCommand() {
		super("hub", null, "lobby");
	  }
	
	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer){
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if(!player.getServer().getInfo().getName().equalsIgnoreCase("lobby")){
            	ServerInfo target = ProxyServer.getInstance().getServerInfo("lobby");
            	player.connect(target);
            }else{
                    player.sendMessage(Main.color("&8&l[&c&lMelon&a&lHut&8&l] &cYou are already connected to the lobby server!"));
            }
		}else{
			sender.sendMessage(Main.color("&8&l[&c&lMelon&a&lHut&8&l] &cYou are not a player!"));
		}
	}
}
