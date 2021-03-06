package net.melonhut.main;

import java.net.InetSocketAddress;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Command;

public class AddServerCommand extends Command{
	
	public AddServerCommand() {
	      super("addserver", "melon.addserver");
	  }
	
	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
			if(args.length == 0){
				sender.sendMessage(Main.color("&8&l[&c&lMelon&a&lHut&8&l] &e/addserver [name] [port]"));
			}
		
			if(args.length == 1){
				String target = args[0];
					if(target == null){
						sender.sendMessage(Main.color("&8&l[&c&lMelon&a&lHut&8&l] &cYou must supply a server name."));
					}
				sender.sendMessage(Main.color("&8&l[&c&lMelon&a&lHut&8&l] &cYou must supply a port number."));
			}
		
		if(args.length == 2){
			String target = args[0];
			try{
				Integer port = Integer.parseInt(args[1]);
				
				ServerInfo serverInfo = ProxyServer.getInstance().constructServerInfo(target, new InetSocketAddress("127.0.0.1", port), "", false);
                ProxyServer.getInstance().getServers().put(target, serverInfo);
                sender.sendMessage(Main.color("&8&l[&c&lMelon&a&lHut&8&l] &aServer &e" + target + " &ahas been added."));
			}catch (NumberFormatException e1){
				sender.sendMessage(Main.color("&8&l[&c&lMelon&a&lHut&8&l] &cPort must be a number."));
			}
		}

	}
}
