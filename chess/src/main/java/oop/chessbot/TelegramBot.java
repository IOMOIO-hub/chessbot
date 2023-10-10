package oop.chessbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot implements Bot {

    @Override
    public String getBotUsername() {
        return "ultraChessBot";
    }

    @Override
    public String getBotToken() {
        return "6394255673:AAGgl_v92jYtyun5Lguut41VB2vXmC6yrqw";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Long id = update.getMessage().getChatId();
            String messageText = update.getMessage().getText();

            Executor executor = Executor.getInstance();
            executor.execute(messageText, id);
        }
    }

    public void send(Long id, String message){
        SendMessage sendMessage = SendMessage.builder().chatId(id.toString()).text(message).build();
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
