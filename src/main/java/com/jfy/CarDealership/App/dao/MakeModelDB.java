/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfy.CarDealership.App.dao;

import com.jfy.CarDealership.App.dto.MakeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fishget
 */
@Repository
public class MakeModelDB implements MakeModelDao {
    @Autowired
    JdbcTemplate jdbc;

     public static final class MakeModelMapper implements RowMapper<MakeModel> {
        @Override
        public MakeModel mapRow(ResultSet rs, int index) throws SQLException {
            MakeModel makemodel = new MakeModel();
            makemodel.setMake(rs.getString("make"));
            makemodel.setModel(rs.getString("model"));
            makemodel.setDate(rs.getString("date"));
            makemodel.setEmail(rs.getString("email"));
            return makemodel;
        }
    }
    @Override
    public List<MakeModel> getAllMakeModels() {
        final String SELECT_ALL_MAKEMODELS = "SELECT * FROM makemodel";
        return jdbc.query(SELECT_ALL_MAKEMODELS, new MakeModelMapper());
    }

    @Transactional
    @Override
    public void addMakeModel(MakeModel makemodel) {
        final String INSERT_MAKEMODEL = "INSERT INTO makemodel(make, model, date,email) VALUES(?,?,?,?)";
        jdbc.update(INSERT_MAKEMODEL,makemodel.getMake(), makemodel.getModel(), makemodel.getDate(), makemodel.getEmail());
    }


}
