package my.uum;

/**
 * This class is to get name input from user get and set the value for each instance
 *
 * @author chowsookqi
 */
public class TelegramUser {

    private String chatId;
    private String step;



    private String msg;

    private String icno;
    private String staff_id;
    private String name;
    private String mobile_Telno;
    private String email;
    private String purpose;

    private String booking_date;
    private String booking_time;
    private String selectedRoom;

    private String room_description;
    private String max_capacity;


    /**
     * This method is get the chat id
     *
     * @return chatId
     */
    public String getChatId() {
        return chatId;
    }

    /**
     * This method is set the chat id
     *
     */
    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    /**
     * This method is get the step to know that the system is until which step so that the system know the next message to send
     *
     * @return step
     */
    public String getStep() {
        return step;
    }

    /**
     * This method is set the step
     *
     */
    public void setStep(String step) {
        this.step = step;
    }

    /**
     * This method is get the name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method is set the name
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is get the ic number
     *
     * @return icno
     */
    public String getIcno() {
        return icno;
    }

    /**
     * This method is set the icno
     *
     */
    public void setIcno(String icno) {
        this.icno = icno;
    }

    /**
     * This method is get the staff_id
     *
     * @return staff_id
     */
    public String getStaff_id() {
        return staff_id;
    }

    /**
     * This method is set the staff_id
     *
     */
    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    /**
     * This method is get the phone number
     *
     * @return mobile_Telno
     */
    public String getMobile_Telno() {
        return mobile_Telno;
    }

    /**
     * This method is set the phone number
     *
     */
    public void setMobile_Telno(String mobile_Telno) {
        this.mobile_Telno = mobile_Telno;
    }

    /**
     * This method is get the email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method is set the email
     *
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method is get the purpose
     *
     * @return purpose
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * This method is set the purpose
     *
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * This method is get the booking date
     *
     * @return booking_date
     */
    public String getBooking_date() {
        return booking_date;
    }

    /**
     * This method is set the booking date
     *
     */
    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    /**
     * This method is get the booking_time
     *
     * @return booking_time
     */
    public String getBooking_time() {
        return booking_time;
    }

    /**
     * This method is set the booking_time
     *
     */
    public void setBooking_time(String booking_time) {
        this.booking_time = booking_time;
    }

    /**
     * This method is get the room selected by user
     *
     * @return selectedRoom
     */
    public String getSelectedRoom() {
        return selectedRoom;
    }

    /**
     * This method is set the room selected by user
     *
     */
    public void setSelectedRoom(String selectedRoom) {
        this.selectedRoom = selectedRoom;
    }

    /**
     * This method is get the room description
     *
     * @return room_description
     */
    public String getRoom_description() {
        return room_description;
    }

    /**
     * This method is set the room description
     *
     */
    public void setRoom_description(String room_description) {
        this.room_description = room_description;
    }

    /**
     * This method is get the max capacity of room
     *
     * @return max_capacity
     */
    public String getMax_capacity() {
        return max_capacity;
    }

    /**
     * This method is set the max capacity of room
     *
     */
    public void setMax_capacity(String max_capacity) {
        this.max_capacity = max_capacity;
    }

    /**
     * This method is print the details of the booking that user made
     *
     * @return selectedRoom,room_description,max_capacity,booking_date,booking_time,name
     */
    @Override
    public String toString() {
        return "Room id you booked: " + selectedRoom +"\n"+
                "Room description: " + room_description +"\n"+
                "Maximum capacity of the room: " + max_capacity +"\n"+
                "Booking date: " + booking_date +"\n"+
                "Booking Time: " + booking_time + "\n"+
                "Name of user booked: " + name;
    }
}

