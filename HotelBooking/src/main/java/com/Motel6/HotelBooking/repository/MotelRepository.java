package com.Motel6.HotelBooking.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.Motel6.HotelBooking.model.Motel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MotelRepository {

    @Autowired Motel motelModel;

    @Autowired JdbcTemplate template;

    public List<Motel> getAll() {
        String sql = "select * from motels";
        RowMapper<Motel> rm = new RowMapper<Motel>() {
            @Override
            public Motel mapRow(ResultSet resultSet, int i) throws SQLException{
                Motel motel = new Motel(resultSet.getString("citySt"), resultSet.getInt("motelcode"));
                return motel;
            }
        };
        return template.query(sql, rm);
    }
    
}
