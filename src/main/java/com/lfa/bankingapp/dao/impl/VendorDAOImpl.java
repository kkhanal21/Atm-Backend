/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.bankingapp.dao.impl;

import com.lfa.bankingapp.dao.VendorDAO;
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
@Repository(value = "vendorDAO")
public class VendorDAOImpl implements VendorDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Vendor> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_vendors";
        return jdbcTemplate.query(sql, new VendorMapper());

    }

    @Override

    public Vendor getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_vendors WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new VendorMapper());
    }

    @Override
    public int insert(Vendor v) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_vendors(Vendor_name,vendor_contact)"
                + " VALUES (?,?)";
        return jdbcTemplate.update(sql, new Object[]{v.getName(), v.getContact()});
    }

    @Override
    public int update(Vendor v) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbl_vendors vendor_name=?,vendor_contact=? WHERE id=? ";
        return jdbcTemplate.update(sql, new Object[]{v.getName(),
            v.getContact(), v.getId()});
    }

    @Override
    public int delete(Vendor a) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class VendorMapper implements RowMapper<Vendor> {

        @Override
        public Vendor mapRow(ResultSet rs, int i) throws SQLException {
            Vendor vendor = new Vendor();
            vendor.setId(rs.getInt("id"));
            vendor.setName(rs.getString("vendor_name"));
            vendor.setContact(rs.getString("vendor_contact"));
            return vendor;
        }
    }
}
