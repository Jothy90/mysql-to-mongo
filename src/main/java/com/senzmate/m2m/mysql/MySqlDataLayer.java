package com.senzmate.m2m.mysql;

import com.mysql.jdbc.Connection;
import com.senzmate.m2m.table.Device;
import com.senzmate.m2m.table.History;
import com.senzmate.m2m.table.MyTBox;
import com.senzmate.m2m.table.User;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by john on 11/15/14.
 */
public class MySqlDataLayer {
    private static final Logger LOGGER = Logger.getLogger(MySqlDataLayer.class.getName());


    //Mysql to Mongo
    public static List<MyTBox> getAllMyTBoxes() {
        String sql = String.format("SELECT * FROM mytbox");
        return MySqlDBUtil.getMyTBoxList(sql);
    }

    public static List<Device> getAllDevices() {
        String sql = String.format("SELECT * FROM device");
        return MySqlDBUtil.getDeviceList(sql);
    }

    public static List<User> getAllUsers() {
        String sql = String.format("SELECT * FROM user");
        return MySqlDBUtil.getUserList(sql);
    }

    public static List<History> getAllHistory() {
        String sql = String.format("SELECT * FROM history");
        return MySqlDBUtil.getHistoryList(sql);
    }


    //TODO:For mongo to Mysql
    public static int add(MyTBox myTBox) {
        Connection con = MySqlDBConnector.getConnection();
        int result = 0;
        String sql = String.format("INSERT INTO mytbox (name, password)" +
                " VALUES (\"%s\",\"%s\")"
                , myTBox.getName(),myTBox.getPassword());
        try {
            result = MySqlDBUtil.sqlUpdate(con, sql);
            con.close();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQLException: " + e);
        }
        return result;
    }

    public static int add(Device device) {
        Connection con = MySqlDBConnector.getConnection();
        int result = 0;
        String sql = String.format("INSERT INTO device (id, pin)" +
                " VALUES (\"%s\",\"%s\")"
                , device.getId(),device.getPin());
        try {
            result = MySqlDBUtil.sqlUpdate(con, sql);
            con.close();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQLException: " + e);
        }
        return result;
    }


    public static int add(User user) {
        Connection con = MySqlDBConnector.getConnection();
        int result = 0;
        String sql = String.format("INSERT INTO user (id, device_id)" +
                " VALUES (\"%s\",\"%s\")"
                , user.getId(),user.getDeviceId());
        try {
            result = MySqlDBUtil.sqlUpdate(con, sql);
            con.close();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQLException: " + e);
        }
        return result;
    }


    public static int add(History history) {
        Connection con = MySqlDBConnector.getConnection();
        int result = 0;
        String sql = String.format("INSERT INTO history (device_id,entry,date)" +
                " VALUES (\"%s\",\"%s\",\"%s\")"
                , history.getDeviceId(),history.getEntry(),history.getDate());
        try {
            result = MySqlDBUtil.sqlUpdate(con, sql);
            con.close();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQLException: " + e);
        }
        return result;
    }
}
