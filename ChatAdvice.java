package nexus;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatAdvice extends PluginBase implements Listener {
    final Pattern chatRegExp = Pattern.compile("^(@.*?)\s((.|\r|\n)+)");

    @Override
    public void onEnable() {
        this.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onChat(PlayerChatEvent ev) {
        String message = ev.getMessage();
        Level level = ev.getPlayer().getLevel();
        Matcher result = chatRegExp.matcher(message);
        if (result.find()) {
            switch (m.group(1)) {
                case "@월드" :
                    ev.setCancelled();
                    for (Player players: level.getPlayers().values()) {
                        players.sendMessage(message.replaceFirst("@월드", ""));
                    }
                break;
                case "@전체" :
                    ev.setCancelled();
                    this.getServer().broadcastMessage(message.replaceFirst("@전체", ""));
                break;
                default : //@플레이어닉네임 메시지 일경우
                    ev.setCancelled();
                    String username = m.group(1).replaceFirst("@", "");
                    for (Player players : ev.getPlayer().getServer().getOnlinePlayers().values()) {
                        if (players.getName().equals(username)) {
                            players.sendMessage(m.group(2));
                        }
                    }
                break;
            }
        } else { //딱히 없을때 월드채팅으로 ㄱㄱ
            ev.setCancelled();
            for (Player players: level.getPlayers().values()) {
                players.sendMessage(message);
            }
        }
    }
}
