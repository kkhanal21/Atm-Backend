/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.bankingapp.dao.impl;

import com.lfa.bankingapp.dao.AtmLoadsDAO;
import com.lfa.bankingapp.entity.Atm;
import com.lfa.bankingapp.entity.AtmLoads;
import com.lfa.bankingapp.entity.Vendor;
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
@Repository(value = "atmLoadDAO")
public class AtmLoadsDAOImpl implements AtmLoadsDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<AtmLoads> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_atm_loads";
        return jdbcTemplate.query(sql, new AtmLoadsMapper());

    }

    @Override

    public AtmLoads getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_atm_loads WHERE load_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new AtmLoadsMapper());
    }

    @Override
    public int insert(AtmLoads a) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_atm_loads(atm_id,vendor_id,amount)"
                + " VALUES (?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{a.getAtm().getId(), a.getVendor().getId(),
            a.getDipositedAmount()});
    }

    @Override
    public int update(AtmLoads a) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbl_atm_loads atm_id=?,vendor_id=?,amount=?,"
                + " WHERE load_id=? ";
        return jdbcTemplate.update(sql, new Object[]{a.getAtm().getId(), a.getVendor().getId(),
            a.getDipositedAmount(), a.getId()});
    }

    @Override
    public int delete(AtmLoads a) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class AtmLoadsMapper implements RowMapper<AtmLoads> {

        @Override
        public AtmLoads mapRow(ResultSet rs, int i) throws SQLException {
            AtmLoads atmL = new AtmLoads();
            atmL.setId(rs.getInt("load_id"));
            atmL.setAtm(new Atm(rs.getInt("atm_id")));
            atmL.setVendor(new Vendor(rs.getInt("vendor_id")));
            atmL.setDipositedDate(rs.getDate("diposited_date"));
            atmL.setDipositedAmount(rs.getInt("amount"));
            return atmL;
        }
    }
}
