package nexus;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;

public class ChatAdvice extends PluginBase implements Listener{
   public void onEnable(){
   	  this.getPluginManager().registerEvents(this,this);
   }
   public void onChat(PlayerChatEvent ev){
   	  Player player=ev.getPlayer();
   	  String message=ev.getMessage();
   	  Level level=player.getLevel();
   	  if()//#an 을 angelless 로
   	  if(message.indexOf("@월드")){
   	  	  ev.setCancelled();
   	  	  for(Player players : level.getPlayers().values()){
   	  	  	  players.sendMessage(message.replaceFirst("@월드",""));
   	  	  }
   	  }
   	  if(message.indexOf("@전체")){
   	  	  ev.setCancelled();
   	  	  this.getServer().broadcastMessage(message.replaceFirst("@전체",""));
   	  }
   	  else if(message.indexOf("@")){//@플레이어 닉네임 일경우
   	  	  if()
   	  }
   	  else{//딱히 없을때 월드채팅으로 ㄱㄱ
   	  	  ev.setCancelled();
   	  	  for(Player players : level.getPlayers().values()){
   	  	  	  players.sendMessage(message.replaceFirst("@월드",""));
   	  	  }
   	  }
   }
}