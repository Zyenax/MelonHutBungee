package net.melonhut.main;

import java.util.Random;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class Main extends Plugin implements Listener {
	
	@SuppressWarnings("deprecation")
	public void onEnable() {
		CommandSender console = getProxy().getConsole();
		console.sendMessage(color("&8[&cMelon&aHut&8] &aHas been enabled!"));
		getProxy().getPluginManager().registerListener(this, this);
		getProxy().getPluginManager().registerCommand(this, new AddServerCommand());
		getProxy().getPluginManager().registerCommand(this, new RemoveServerCommand());
		getProxy().getPluginManager().registerCommand(this, new ListPlayersCommand());
		getProxy().getPluginManager().registerCommand(this, new HubCommand());
		getProxy().getPluginManager().registerCommand(this, new SendToServerCommand());
	}
	
	@SuppressWarnings("deprecation")
	public void onDisable() {
		CommandSender console = getProxy().getConsole();
		console.sendMessage(color("&8[&cMelon&aHut&8] &cHas been disabled!"));
	}

	@SuppressWarnings("deprecation")
	@EventHandler(priority = 64)
	public void onPing(ProxyPingEvent ev) {
		ServerPing r = ev.getResponse();
		ServerPing.Players p = r.getPlayers();
		p = new ServerPing.Players(p.getOnline() + 1, p.getOnline(),
				p.getSample());
		Integer num = randomNum(1, 5);
		ServerPing ping = null;
		if(num == 1){
			ping = new ServerPing(r.getVersion(), p,
					color("&c&lMelon&a&lHut &e&l- &aComing Soon!"),
					r.getFaviconObject());
		}else if(num == 2){
			ping = new ServerPing(r.getVersion(), p,
					color("&c&lMelon&a&lHut &e&l- &bComing Soon!"),
					r.getFaviconObject());
		}else if(num == 3){
			ping = new ServerPing(r.getVersion(), p,
					color("&c&lMelon&a&lHut &e&l- &cComing Soon!"),
					r.getFaviconObject());
		}else if(num == 4){
			ping = new ServerPing(r.getVersion(), p,
					color("&c&lMelon&a&lHut &e&l- &dComing Soon!"),
					r.getFaviconObject());
		}else if(num == 5){
			ping = new ServerPing(r.getVersion(), p,
					color("&c&lMelon&a&lHut &e&l- &eComing Soon!"),
					r.getFavicon());
		}
		ev.setResponse(ping);
	}

	public static String color(String string) {
		return net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&',
				string);
	}
	
	public static int randomNum(int Low, int High){
		Random r = new Random();
		int R = r.nextInt(High-Low) + Low;
		return R;
	}
}
