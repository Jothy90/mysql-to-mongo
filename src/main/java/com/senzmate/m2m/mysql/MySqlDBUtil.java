package com.senzmate.m2m.mysql;

import com.mysql.jdbc.Connection;
import com.senzmate.m2m.table.Device;
import com.senzmate.m2m.table.History;
import com.senzmate.m2m.table.MyTBox;
import com.senzmate.m2m.table.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Project Trackler Platform
 * Created by jaykrish on 5/25/14.
 */
public class MySqlDBUtil {
    private static final Logger LOGGER = Logger.getLogger(MySqlDBUtil.class.getName());

    /**
     * Create Device instance by MyTBox resultSet on current index.
     *
     * @param sql SQL String
     * @return device with positive id if successful, or id 0.
     */
    public static List<MyTBox> getMyTBoxList(String sql) {


        MyTBox myTBox =null;
        List<MyTBox> myTBoxes=new ArrayList<MyTBox>();
        try {
            Connection con = MySqlDBConnector.getConnection();
            ResultSet resultSet = sqlQuery(con, sql);
            while (resultSet.next()) {
                myTBox = new MyTBox();
                myTBox.setName(resultSet.getString("name"));
                myTBox.setId(resultSet.getInt("id"));
                myTBox.setPassword(resultSet.getString("password"));
                myTBoxes.add(myTBox);
            }
            resultSet.close();
            con.close();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQLException: " + e);
        }
        return myTBoxes;
    }


    /**
     * Create Devices instance by device resultSet on current index.
     *
     * @param sql SQL String
     * @return device with positive id if successful, or id 0.
     */
    public static List<Device> getDeviceList(String sql) {

        Device device =null;
        List<Device> deviceList=new ArrayList<Device>();
        try {
            Connection con = MySqlDBConnector.getConnection();
            ResultSet resultSet = sqlQuery(con, sql);
            while (resultSet.next()) {
                device = new Device();
                device.setId(resultSet.getString("id"));
                device.setName(resultSet.getString("name"));
                device.setTboxId(resultSet.getInt("tbox_id"));
                device.setHighHum(resultSet.getInt("high_hum"));
                device.setLowHum(resultSet.getInt("low_hum"));
                device.setHumidity(resultSet.getInt("humidity"));
                device.setHighTemp(resultSet.getInt("high_temp"));
                device.setLowTemp(resultSet.getInt("low_temp"));
                device.setTemperature(resultSet.getInt("temperature"));
                device.setPosition(resultSet.getString("position"));
                deviceList.add(device);
            }
            resultSet.close();
            con.close();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQLException: " + e);
        }
        return deviceList;
    }

    public static List<User> getUserList(String sql) {
        List<User> userList =new ArrayList<User>();
        User user;
        try{
            Connection con = MySqlDBConnector.getConnection();
            ResultSet resultSet=sqlQuery(con,sql);
            while(resultSet.next()){
                user =new User();
                user.setId(resultSet.getString("id"));
                user.setDeviceId(resultSet.getString("device_id"));
                userList.add(user);
            }
            resultSet.close();
            con.close();
        }catch (SQLException e){
            LOGGER.log(Level.SEVERE, "SQLException: " + e);
        }
        return userList;
    }

    public static List<History> getHistoryList(String sql) {
        List<History> historyList =new ArrayList<History>();
        History history;
        try{
            Connection con = MySqlDBConnector.getConnection();
            ResultSet resultSet=sqlQuery(con,sql);
            while(resultSet.next()){
                history =new History();
                history.setId(resultSet.getInt("id"));
                history.setDeviceId(resultSet.getString("device_id"));
                history.setEntry(resultSet.getString("entry"));
                history.setDate(resultSet.getString("date"));
                historyList.add(history);
            }
            resultSet.close();
            con.close();
        }catch (SQLException e){
            LOGGER.log(Level.SEVERE, "SQLException: " + e);
        }
        return historyList;
    }

    /**
     * @param sql executeQuery the sql in track DB connection
     * @return resultSet or null
     */
    public static ResultSet sqlQuery(Connection con, String sql) throws SQLException {
        ResultSet resultSet = null;
        Statement stmt = con.createStatement();
        resultSet = stmt.executeQuery(sql);
        return resultSet;
    }

    /**
     * @param sql executeUpdate the sql in track DB connection
     * @return positive on success, or 0
     */
    public static int sqlUpdate(Connection con, String sql)  throws SQLException {
        int resultInt = 0;
            Statement stmt = con.createStatement();
            resultInt = stmt.executeUpdate(sql);
        return resultInt;
    }
}
