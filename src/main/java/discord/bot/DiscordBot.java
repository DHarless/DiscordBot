package discord.bot;

/**
 * Created by Daniel on 5/2/2017.
 */

import com.google.common.util.concurrent.FutureCallback;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;


public class DiscordBot {
    //MzA5MTUyOTk0MzI1Mjk5MjAw.C-ru5A.iDEtuIO1ktl1w7wdSh6wW6YjIoc

    public DiscordBot(String token) {
        // See "How to get the token" below
        DiscordAPI api = Javacord.getApi(token, true);
        //api.setToken(token, false);
        // connect
        api.connect(new FutureCallback<DiscordAPI>() {
            //@Override
            public void onSuccess(DiscordAPI api) {
                // register listener
                api.registerListener(new MessageCreateListener() {
                    @Override
                    public void onMessageCreate(DiscordAPI api, Message message) {
                        // check the content of the message
                        if (message.getContent().equalsIgnoreCase("ping")) {
                            // reply to the message
                            message.reply("pong");
                            
                        }
                    }
                });
            }

            //@Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }
    public static void main(String[] args){
        String token = "MzA5MTUyOTk0MzI1Mjk5MjAw.C-ru5A.iDEtuIO1ktl1w7wdSh6wW6YjIoc";
        new DiscordBot(token);

    }
}
