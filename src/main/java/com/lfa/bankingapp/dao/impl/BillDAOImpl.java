/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.bankingapp.dao.impl;

import com.lfa.bankingapp.dao.BillDAO;
import com.lfa.bankingapp.entity.Bill;
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
@Repository(value = "billDAO")
public class BillDAOImpl implements BillDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Bill> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_bills";
        return jdbcTemplate.query(sql, new BillMapper());

    }

    @Override

    public Bill getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_bills WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BillMapper());
    }

    @Override
    public int insert(Bill b) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_bills(Bill_name)"
                + " VALUES (?)";
        return jdbcTemplate.update(sql, new Object[]{b.getName()});
    }

    @Override
    public int update(Bill b) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbl_bills bill_name=?,bill_contact=? WHERE id=? ";
        return jdbcTemplate.update(sql, new Object[]{b.getName(),
            b.getId()});
    }

    @Override
    public int delete(Bill a) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class BillMapper implements RowMapper<Bill> {

        @Override
        public Bill mapRow(ResultSet rs, int i) throws SQLException {
            Bill bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setName(rs.getString("bill_name"));
            return bill;
        }
    }
}
