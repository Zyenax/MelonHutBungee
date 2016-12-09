package net.melonhut.main;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;

public class ListPlayersCommand extends Command{
	
	public ListPlayersCommand() {
		super("list");
	  }
	
	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
			if(args.length >= 0){
				sender.sendMessage(Main.color("&8&l[&c&lMelon&a&lHut&8&l] &aThere are &c" + ProxyServer.getInstance().getOnlineCount() + " &aplayers across &c" + ProxyServer.getInstance().getServers().size() + " &aservers!"));
			}
	}
}
