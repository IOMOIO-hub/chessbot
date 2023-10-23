package oop.chessbot;

import java.util.ArrayList;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot implements Bot {

    @Override
    public String getBotUsername() {
        return System.getenv("BOT_USERNAME");
    }

    @Override
    public String getBotToken() {
        return System.getenv("BOT_TOKEN");
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

    public void send(Long id, String message) {
        SendMessage sendMessage = SendMessage.builder().chatId(id.toString()).text(message).build();
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    public void send(Long id, Message message) {
        SendMessage sendMessage = SendMessage.builder().chatId(id.toString()).text(message.getText()).build();
        
        if (message.getKeyboard() != null)
            sendMessage.setReplyMarkup(buildKeyboard(message.getKeyboard()));

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private ReplyKeyboardMarkup buildKeyboard(ArrayList<String> buttons) {

        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setResizeKeyboard(true);
        keyboard.setOneTimeKeyboard(true);

        ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        for (int i = 0; i < buttons.size(); i++) {
            if (i % 6 == 0) {
                keyboardRow = new KeyboardRow();
                keyboardRows.add(keyboardRow);
            }
            keyboardRow.add(new KeyboardButton(buttons.get(i)));
        }

        keyboard.setKeyboard(keyboardRows);
        return keyboard;
    }
}
