package com.Motel6.HotelBooking.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.Motel6.HotelBooking.model.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class RoomRepository {

    @Autowired Room roomModel;

    @Autowired JdbcTemplate template;

    public List<Room> getAll() {
        String sql = "select * from rooms";
        RowMapper<Room> rm = new RowMapper<Room>() {
            @Override
            public Room mapRow(ResultSet resultSet, int i) throws SQLException{
                Room room = new Room(resultSet.getString("roomType"), resultSet.getInt("roomcode"), resultSet.getFloat("cost"));
                return room;
            }
        };
        return template.query(sql, rm);
    }
    
}
