package my.uum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class is to connect the database and call the queries
 *
 *
 * @author chowsookqi
 */
public class InsertTable {
    /**
     * This method is connect the database
     *
     * @return conn
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:./assignment-2.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * This method is to insert the data get in telegram user class to table_userInfo
     *
     */
    public void insert(String ICNO, String staff_id,String name,String mobile_telNo, String email, String purpose, String booking_date, String booking_time) {
        String sql = "INSERT INTO table_userInfo(ICNO,staff_id,name,mobile_telNo,email,purpose,booking_Date,booking_Time) VALUES(?,?,?,?,?,?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement ppsm = conn.prepareStatement(sql);
            ppsm.setString(1, ICNO);
            ppsm.setString(2, staff_id);
            ppsm.setString(3, name);
            ppsm.setString(4, mobile_telNo);
            ppsm.setString(5, email);
            ppsm.setString(6,purpose);
            ppsm.setString(7, booking_date);
            ppsm.setString(8,booking_time);
            ppsm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is to insert the data get in telegram user class to userlist
     *
     */
    public void insertBooking(String room_id, String room_description, String max_capacity,String booking_date, String booking_time, String name){

        String sql = "INSERT INTO user_List(Room_Id, Room_Description, Max_capacity,booking_date,booking_time,Booked_By) VALUES(?,?,?,?,?,?)";
        try{
            Connection conn = this.connect();
            PreparedStatement ppsm = conn.prepareStatement(sql);
            ppsm.setString(1, room_id);
            ppsm.setString(2,room_description);
            ppsm.setString(3, max_capacity);
            ppsm.setString(4, booking_date);
            ppsm.setString(5,booking_time);
            ppsm.setString(6, name);

            ppsm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
