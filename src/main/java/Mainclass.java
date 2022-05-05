import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

public class Mainclass {
    public static void main(String[] args) {
        final String token = "d1447ce73859ba6b39bb1b7a213ce2e99bd330c697c8868d9f20a8c0a3714e1b";
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();


        gateway.on(MessageCreateEvent.class).subscribe(event -> { //Crea un evento.
            final Message message = event.getMessage(); // Lee lo que ponemos.
            if ("!ping".equals(message.getContent())) { //Comprueba si el mensaje es "!ping".
                final MessageChannel channel = message.getChannel().block(); // Crea un onjetp MessageChannel.
                channel.createMessage("Pong!").block(); //Nos devuelve "pong!".
            }
        });
        gateway.onDisconnect().block();
    }
}
