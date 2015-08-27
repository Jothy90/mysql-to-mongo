package com.senzmate.m2m.mysql;

import com.mysql.jdbc.Connection;
import com.senzmate.m2m.table.History;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlDBUtil {
    private static final Logger LOGGER = Logger.getLogger(MySqlDBUtil.class.getName());

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
