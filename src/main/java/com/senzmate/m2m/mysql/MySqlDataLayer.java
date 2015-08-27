package com.senzmate.m2m.mysql;

import com.mysql.jdbc.Connection;
import com.senzmate.m2m.table.History;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlDataLayer {
    private static final Logger LOGGER = Logger.getLogger(MySqlDataLayer.class.getName());


    //Mysql to Mongo
    public static List<History> getAllHistory() {
        String sql = String.format("SELECT * FROM history");
        return MySqlDBUtil.getHistoryList(sql);
    }

    //TODO:For mongo to Mysql
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
