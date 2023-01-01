package my.uum;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is to connect the telegram bot
 *
 * @author chowsookqi
 */


public class s279079_A221_bot extends TelegramLongPollingBot {
    List<TelegramUser> users = new ArrayList<>();

    @Override
    /**
     * This method is update and send message when receive any message form user
     *
     */
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String chatId = message.getChatId().toString();
            TelegramUser user = saveUser(chatId);
            if (message.hasText()) {
                String text = message.getText();
                SendMessage sendMessage = new SendMessage();
                if (text.equals("Cancel")) {
                    sendMessage = new SendMessage();
                    sendMessage.setText("Thank you and see you again");
                    sendMessage.setChatId(chatId);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException E) {
                        E.printStackTrace();
                    }user.setStep(BotConstant.CANCEL);
                }
                if (text.equals("2")) {

                    sendMessage = new SendMessage();
                    sendMessage.setText("Thank you and see you again");
                    sendMessage.setChatId(chatId);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException E) {
                        E.printStackTrace();
                    }user.setStep(BotConstant.CANCEL);
                }
                if (text.equals("/start")) {
                    sendMessage = new SendMessage();
                    sendMessage.setText("Hi there! Welcome to Meeting Room Booking System.\n" +
                            "Live chat with me to book a meeting room.\n" +
                            "1 - Yes, start live chat\n" +
                            "2 - No, not interested to book a meeting room");
                    sendMessage.setChatId(chatId);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException E) {
                        E.printStackTrace();
                    }
                    user.setStep(BotConstant.START);
                } else if (user.getStep().equals(BotConstant.START)) {
                    sendMessage = new SendMessage();
                    sendMessage.setText("Please provide us your information for booking purpose\n" +
                            "Please provide us your IC number.");
                    sendMessage.setChatId(chatId);
                    setButtons(sendMessage);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException E) {
                        E.printStackTrace();
                    }
                    user.setStep(BotConstant.ENTER_ICNO);
                } else if (user.getStep().equals(BotConstant.ENTER_ICNO)) {
                    sendMessage = new SendMessage();
                    sendMessage.setText("Please provide us your staff id");
                    sendMessage.setChatId(chatId);
                    setButtons(sendMessage);
                    try {
                        execute(sendMessage);
                        user.setIcno(text);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    user.setStep(BotConstant.ENTER_STAFFID);
                } else if (user.getStep().equals(BotConstant.ENTER_STAFFID)) {
                    sendMessage = new SendMessage();
                    sendMessage.setText("Please provide us your full name as per NRIC/Passport");
                    sendMessage.setChatId(chatId);
                    setButtons(sendMessage);

                    try {
                        execute(sendMessage);
                        user.setStaff_id(text);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    user.setStep(BotConstant.ENTER_NAME);
                } else if (user.getStep().equals(BotConstant.ENTER_NAME)) {
                    sendMessage = new SendMessage();
                    sendMessage.setText("Please provide us your phone no");
                    sendMessage.setChatId(chatId);
                    setButtons(sendMessage);
                    try {
                        execute(sendMessage);
                        user.setName(text);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    user.setStep(BotConstant.ENTER_TELNO);
                } else if (user.getStep().equals(BotConstant.ENTER_TELNO)) {
                    sendMessage = new SendMessage();
                    sendMessage.setText("Please provide us your email");
                    sendMessage.setChatId(chatId);
                    setButtons(sendMessage);
                    try {
                        execute(sendMessage);
                        user.setMobile_Telno(text);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    user.setStep(BotConstant.ENTER_EMAIL);
                } else if (user.getStep().equals(BotConstant.ENTER_EMAIL)) {
                    sendMessage = new SendMessage();
                    sendMessage.setText("Please brief explain your booking purpose");
                    sendMessage.setChatId(chatId);
                    setButtons(sendMessage);
                    try {
                        execute(sendMessage);
                        user.setEmail(text);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    user.setStep(BotConstant.ENTER_PURPOSE);
                } else if (user.getStep().equals(BotConstant.ENTER_PURPOSE)) {
                    sendMessage = new SendMessage();
                    sendMessage.setText("Please provide the date you want to book meeting room in format yyyy-mm-dd.");
                    sendMessage.setChatId(chatId);
                    setButtons(sendMessage);
                    try {
                        execute(sendMessage);
                        user.setPurpose(text);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    user.setStep(BotConstant.ENTER_BOOKINGDATE);
                } else if (user.getStep().equals(BotConstant.ENTER_BOOKINGDATE)) {
                    sendMessage = new SendMessage();
                    sendMessage.setText("Please provide the time you want to book meeting room in format hh:mm(24 hours format).");
                    sendMessage.setChatId(chatId);
                    setButtons(sendMessage);
                    try {
                        execute(sendMessage);
                        user.setBooking_date(text);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    user.setStep(BotConstant.ENTER_BOOKINGTIME);
                }
                else if (user.getStep().equals(BotConstant.ENTER_BOOKINGTIME)) {
                    sendMessage = new SendMessage();
                    InsertTable insert = new InsertTable();
                    sendMessage.setText("Your data is recorded");
                    sendMessage.setChatId(chatId);
                    setButtons(sendMessage);
                    try {
                        execute(sendMessage);
                        user.setBooking_time(text);
                        insert.insert(user.getIcno(), user.getStaff_id(), user.getName(), user.getMobile_Telno(),
                                user.getEmail(), user.getPurpose(), user.getBooking_date(), user.getBooking_time());
                        setRoom(chatId);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    user.setStep(BotConstant.BOOKING);
                }}
        }
//
        else if (update.hasCallbackQuery()) {
            String chatId = update.getCallbackQuery().getFrom().getId().toString();
            String data = update.getCallbackQuery().getData();
            TelegramUser user = saveUser(chatId);
            InsertTable insert = new InsertTable();
            if (user.getStep().equals(BotConstant.BOOKING)) {
                if (data.equals(BotQuery.DEWAN_MAWAR)) {
                    user.setRoom_description("Dewan Mawar is the hall that located at inasis muamalat.");
                    user.setMax_capacity("150");
                    user.setSelectedRoom(BotQuery.DEWAN_MAWAR);
                    insert.insertBooking(user.getSelectedRoom(), user.getRoom_description(),
                            user.getMax_capacity(), user.getBooking_date(), user.getBooking_time(), user.getName());
                    sendText(chatId, "Dewan Mawar is booked successfully.\n" +
                            "Below are the details of your booking\n" +
                            user.toString());
                } else if (data.equals(BotQuery.DEWAN_TRADEWINDS)) {
                    user.setRoom_description("Dewan Tradewinds is the hall that located at inasis tradewinds.");
                    user.setMax_capacity("150");
                    user.setSelectedRoom(BotQuery.DEWAN_TRADEWINDS);
                    insert.insertBooking(user.getSelectedRoom(), user.getRoom_description(),
                            user.getMax_capacity(), user.getBooking_date(), user.getBooking_time(), user.getName());
                    sendText(chatId, "Dewan Tradewinds is booked successfully.\n" +
                            "Below are the details of your booking\n" +
                            user.toString());
                } else if (data.equals(BotQuery.DEWAN_TM)) {
                    user.setRoom_description("Dewan TM is the hall that located at inasis TM.");
                    user.setMax_capacity("300");
                    user.setSelectedRoom(BotQuery.DEWAN_TM);
                    insert.insertBooking(user.getSelectedRoom(), user.getRoom_description(),
                            user.getMax_capacity(), user.getBooking_date(), user.getBooking_time(), user.getName());
                    sendText(chatId, "Dewan TM is booked successfully.\n" +
                            "Below are the details of your booking\n" +
                            user.toString());
                } else if (data.equals(BotQuery.DEWAN_DTSO)) {
                    user.setRoom_description("Dewan DTSO is the hall that located near the library.");
                    user.setMax_capacity("350");
                    user.setSelectedRoom(BotQuery.DEWAN_DTSO);
                    insert.insertBooking(user.getSelectedRoom(), user.getRoom_description(),
                            user.getMax_capacity(), user.getBooking_date(), user.getBooking_time(), user.getName());
                    sendText(chatId, "Dewan DTSO is booked successfully.\n" +
                            "Below are the details of your booking\n" +
                            user.toString());
                } else if (data.equals(BotQuery.DEWAN_DMAS)) {
                    user.setRoom_description("Dewan DMAS is the largest hall in UUM.");
                    user.setMax_capacity("500");
                    user.setSelectedRoom(BotQuery.DEWAN_DMAS);
                    insert.insertBooking(user.getSelectedRoom(), user.getRoom_description(),
                            user.getMax_capacity(), user.getBooking_date(), user.getBooking_time(), user.getName());
                    sendText(chatId, "Dewan DMAS is booked successfully.\n" +
                            "Below are the details of your booking\n" +
                            user.toString());
                }
            }
            user.setStep(BotConstant.WRITE_MSG);
        }
        }

    /**
     * This method is set the inline button for room
     *
     */
    private void setRoom(String chatId) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Please chooose the room that you want to book.");
        sendMessage.setChatId(chatId);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();
        List<InlineKeyboardButton> row5 = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButtonMawar = new InlineKeyboardButton();
        inlineKeyboardButtonMawar.setText("Dewan Mawar");
        inlineKeyboardButtonMawar.setCallbackData(BotQuery.DEWAN_MAWAR);

        InlineKeyboardButton inlineKeyboardButtonTw = new InlineKeyboardButton();
        inlineKeyboardButtonTw.setText("Dewan Tradewinds");
        inlineKeyboardButtonTw.setCallbackData(BotQuery.DEWAN_TRADEWINDS);

        InlineKeyboardButton inlineKeyboardButtonTM = new InlineKeyboardButton();
        inlineKeyboardButtonTM.setText("Dewan TM");
        inlineKeyboardButtonTM.setCallbackData(BotQuery.DEWAN_TM);

        InlineKeyboardButton inlineKeyboardButtonDTSO = new InlineKeyboardButton();
        inlineKeyboardButtonDTSO.setText("Dewan DTSO");
        inlineKeyboardButtonDTSO.setCallbackData(BotQuery.DEWAN_DTSO);

        InlineKeyboardButton inlineKeyboardButtonDmas = new InlineKeyboardButton();
        inlineKeyboardButtonDmas.setText("Dewan DMas");
        inlineKeyboardButtonDmas.setCallbackData(BotQuery.DEWAN_DMAS);

        row1.add(inlineKeyboardButtonMawar);
        row2.add(inlineKeyboardButtonTw);
        row3.add(inlineKeyboardButtonTM);
        row4.add(inlineKeyboardButtonDTSO);
        row5.add(inlineKeyboardButtonDmas);

        List<List<InlineKeyboardButton>> button = new ArrayList<>();
        button.add(row1);
        button.add(row2);
        button.add(row3);
        button.add(row4);
        button.add(row5);

        inlineKeyboardMarkup.setKeyboard(button);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        execute(sendMessage);
    }
    /**
     * This method is save the user input for each instance
     *
     * @return user
     */

    private TelegramUser saveUser(String chatId) {
        for (TelegramUser user : users) {
            if(user.getChatId().equals(chatId)){
                return user;
            }
        }
        TelegramUser user=new TelegramUser();
        user.setChatId(chatId);
        users.add(user);
        return user;
    }

    /**
     * This method is set the cancel keyboard button
     *
     */
    public synchronized void setButtons(SendMessage sendMessage) {
        // Create a keyboard
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Create a list of keyboard rows
        List<KeyboardRow> keyboard = new ArrayList<>();

        // First keyboard row
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Add buttons to the first keyboard row
        keyboardFirstRow.add(new KeyboardButton("Cancel"));

        // Add all of the keyboard rows to the list
        keyboard.add(keyboardFirstRow);

        // and assign this list to our keyboard
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    /**
     * This method is set the send text function after user reply
     *
     */
    private void sendText(String chatId,String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        try {
            execute(sendMessage);
        } catch (TelegramApiException E) {
            E.printStackTrace();
        }
    }
    /**
     * This method is get bot username
     *
     * @return "s279079_A221_bot"
     */
    @Override
    public String getBotUsername() {
        // Method to get the username of bot
        return "s279079_A221_bot";
    }

    /**
     * This method is get the bot token
     *
     * @return "5817812840:AAHtJSgmvqM4r9MozEANcJE9IHklM_1sQkY"
     */
    @Override
    public String getBotToken() {
        // Method to get the Api token of the bot
        return "5817812840:AAHtJSgmvqM4r9MozEANcJE9IHklM_1sQkY";
    }

}
