package net.melonhut.main;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class SendToServerCommand extends Command{
	
	public SendToServerCommand() {
	      super("join", null, "server");
	  }
	
	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer){
			ProxiedPlayer player = (ProxiedPlayer)sender;
			if(args.length == 0){
				sender.sendMessage(Main.color("&8&l[&c&lMelon&a&lHut&8&l] &e/join [name]"));
			}
		
			if(args.length == 1){
				String target = args[0];
					if(!ProxyServer.getInstance().getServers().containsKey(target)){
						sender.sendMessage(Main.color("&8&l[&c&lMelon&a&lHut&8&l] &cYou must supply a valid server name."));
					}else{
						if(!player.getServer().getInfo().getName().equalsIgnoreCase(target)){
							sender.sendMessage(Main.color("&8&l[&c&lMelon&a&lHut&8&l] &eSending you to &c" + target));
							ServerInfo targetserver = ProxyServer.getInstance().getServerInfo(target);
							player.connect(targetserver);
						}else{
							sender.sendMessage(Main.color("&8&l[&c&lMelon&a&lHut&8&l] &cYou are already connected to that server."));
						}
						
					}
			}
		}else{
			sender.sendMessage(Main.color("&8&l[&c&lMelon&a&lHut&8&l] &cYou are not allowed to type this command"));
		}
	}
}
