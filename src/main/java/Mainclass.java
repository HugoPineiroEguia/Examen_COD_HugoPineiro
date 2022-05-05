import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.GuildMessageChannel;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;

import java.time.Instant;

public class Mainclass {

    public static void main(String[] args) {
        final String token = "OTUzNjMxMDM5Mjk5OTExNjkx.YjHYHQ.BvNOEjXgAnm_NZ9tW05pvM7G7TE";
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();

        EmbedCreateSpec embed = EmbedCreateSpec.builder()
                .color(Color.GREEN)
                .title("Nuclear NX-Shadowclaw")
                .url("https://www.youtube.com/watch?v=dLkNUX-Ovys")
                .author("TiToPinha", "https://www.youtube.com/channel/UCxgVhB-sNnZ-O27LZAkck9A", "https://i.pinimg.com/564x/2f/ec/a5/2feca5357102b2264947f7aae5f295c5.jpg")
                .description("Unica nuclear de Espanha y W/r de kills  a ballesta en duelo por equipos ")
                .thumbnail("https://cdn.pixabay.com/photo/2015/02/23/16/51/radiation-646213_960_720.png")
                .image("https://callofdutymaps.com/wp-content/uploads/redwoodsnow1.jpg")
                .timestamp(Instant.now())
                .footer("footer", "https://i.pinimg.com/564x/2f/ec/a5/2feca5357102b2264947f7aae5f295c5.jpg")
                .build();


        gateway.on(MessageCreateEvent.class).subscribe(event -> { //Crea un evento.
            final Message message = event.getMessage(); // Lee lo que ponemos.
            if ("/nuke".equals(message.getContent())) { //Comprueba si el mensaje es "!ping".
                final MessageChannel channel = message.getChannel().block(); // Crea un onjetp MessageChannel.
                channel.createMessage(embed).block(); //Nos devuelve "pong!".
            }
        });
        gateway.onDisconnect().block();
    }
}
