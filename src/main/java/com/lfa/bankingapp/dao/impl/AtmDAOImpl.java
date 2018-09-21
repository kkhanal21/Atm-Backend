/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.bankingapp.dao.impl;

import com.lfa.bankingapp.dao.AtmDAO;
import com.lfa.bankingapp.entity.Atm;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kamal
 */
@Repository(value = "atmDAO")
public class AtmDAOImpl implements AtmDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Atm> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_atms";
        return jdbcTemplate.query(sql, new AtmMapper());

    }

    @Override

    public Atm getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_atms WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new AtmMapper());
    }

    @Override
    public int insert(Atm a) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_atms(serial_No,location,longitude,latitude)"
                + " VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{a.getSerialNo(), a.getLocation(), 
            a.getLongitude(), a.getLatitude()});
    }

    @Override
    public int update(Atm a) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbl_atms serial_No=?,location=?,longitude=?,"
                + "latitude=? WHERE id=? ";
        return jdbcTemplate.update(sql, new Object[]{a.getSerialNo(),
            a.getLocation(), a.getLongitude(), a.getLatitude(),a.getId()});}

    @Override
    public int delete(Atm a) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class AtmMapper implements RowMapper<Atm> {

        @Override
        public Atm mapRow(ResultSet rs, int i) throws SQLException {
            Atm atm = new Atm();
            atm.setId(rs.getInt("id"));
            atm.setSerialNo(rs.getString("serial_No"));
            atm.setLocation(rs.getString("location"));
            atm.setLongitude(rs.getString("longitude"));
            atm.setLatitude(rs.getString("latitude"));
            return atm;
        }
    }
}
