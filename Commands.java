import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
	public String prefix = "!";
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args= event.getMessage().getContentRaw().split(" ");
		if(args[0].equalsIgnoreCase(prefix + "test"))  //ignores if it is upper or lower case
		{
			//event.getMessage().reply("This bot is Working!").queue();
			//event.getChannel().sendMessage("This Bot is Working!").queue(); without replying
			EmbedBuilder embed= new EmbedBuilder();
			embed.setTitle("Embed Title", "");
			embed.setDescription("This describes the Embed");
			embed.addField("Embed field 1", "Contents", false);
			embed.addField("Embed field 2", "Contents", false);
			embed.setColor(Color.GREEN);
			embed.setFooter("This bot was Created by Mrityunjay: <@!482840293347950593>");
			event.getChannel().sendMessage(embed.build()).queue();
			embed.clear();
			
		
			
		}
		if(args[0].equalsIgnoreCase(prefix + "giverole")){
			if(event.getMessage().getMentionedRoles().toArray().length == 1) {
				if(event.getMessage().getMentionedUsers().toArray().length==1) {
					Member member= event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
					Role roleTogive = event.getMessage().getMentionedRoles().get(0);
					event.getGuild().addRoleToMember(member, roleTogive).queue();
					event.getMessage().reply("Role has been given  " + roleTogive.getAsMention() + "to" + member.getAsMention() ).queue();
				}
			else {
				event.getMessage().reply("Please mention only 1 role to give").queue();
			}
			}
			
		}
		if(args[0].equalsIgnoreCase(prefix + "removerole")){
			if(event.getMessage().getMentionedRoles().toArray().length == 1) {
				if(event.getMessage().getMentionedUsers().toArray().length==1) {
					Member member= event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
					Role roleTogive = event.getMessage().getMentionedRoles().get(0);
					event.getGuild().removeRoleFromMember(member, roleTogive).queue();
					event.getMessage().reply("Role has been removed  " + roleTogive.getAsMention() + "to" + member.getAsMention() ).queue();
				}
			else {
				event.getMessage().reply("Please mention only 1 role to remove").queue();
			}
	}
		}
	}
}
	


