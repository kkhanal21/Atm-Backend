/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.bankingapp.dao.impl;

import com.lfa.bankingapp.dao.BillLoadDAO;
import com.lfa.bankingapp.entity.AtmLoads;
import com.lfa.bankingapp.entity.Bill;
import com.lfa.bankingapp.entity.BillLoad;
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
@Repository(value = "billLoadDAO")
public class BillLoadDAOImpl implements BillLoadDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<BillLoad> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_bill_loads";
        return jdbcTemplate.query(sql, new BillLoadMapper());

    }

    @Override

    public BillLoad getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_bill_loads WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BillLoadMapper());
    }

    @Override
    public int insert(BillLoad l) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_bill_loads(serial_No,location,longitude,latitude)"
                + " VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{l.getAtmLoad().getId(), l.getBill().getId(),
            l.getTotal()});
    }

    @Override
    public int update(BillLoad l) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbl_bill_loads serial_No=?,location=?,longitude=?,"
                + "latitude=? WHERE id=? ";
        return jdbcTemplate.update(sql, new Object[]{l.getAtmLoad().getId(),
            l.getBill().getId(), l.getTotal(), l.getId()});
    }

    @Override
    public int delete(BillLoad a) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class BillLoadMapper implements RowMapper<BillLoad> {

        @Override
        public BillLoad mapRow(ResultSet rs, int i) throws SQLException {
            BillLoad bLoad = new BillLoad();
            bLoad.setId(rs.getInt("id"));
            bLoad.setAtmLoad(new AtmLoads(rs.getInt("load_id")));
            bLoad.setBill(new Bill(rs.getInt("bill_id")));
            bLoad.setTotal(rs.getInt("total_bill"));
            return bLoad;
        }
    }
}
