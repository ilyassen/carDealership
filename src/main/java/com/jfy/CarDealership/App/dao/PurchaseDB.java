package com.jfy.CarDealership.App.dao;

import com.jfy.CarDealership.App.dto.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class PurchaseDB implements PurchaseDao{

    @Autowired
    JdbcTemplate jdbc;

    public static final class PurchaseMapper implements RowMapper<Purchase> {
        @Override
        public Purchase mapRow(ResultSet rs, int index) throws SQLException {
            Purchase purchase = new Purchase();
            purchase.setPurchaseId(rs.getInt("purchase_id"));
            purchase.setCustomerName(rs.getString("customer_name"));
            purchase.setCustomerPhone(rs.getString("customer_phone"));
            purchase.setCustomerEmail(rs.getString("customer_email"));
            purchase.setCustomerStreet1(rs.getString("customer_street1"));
            purchase.setCustomerStreet2(rs.getString("customer_street2"));
            purchase.setCustomerCity(rs.getString("customer_city"));
            purchase.setCustomerState(rs.getString("customer_state"));
            purchase.setCustomerZip(rs.getString("customer_zip"));
            purchase.setPurchaseType(rs.getString("purchase_type"));
            purchase.setPurchaseTime(rs.getDate("purchase_time"));
            purchase.setCarId(rs.getInt("car_id"));
            return purchase;
        }
    }

    @Transactional
    public int addPurchase(Purchase purchase) {
        final String INSERT_PURCHASE = "INSERT INTO purchase(customer_name, customer_phone, customer_email, customer_street1, customer_street2, " +
                "customer_city, customer_state, customer_zip, purchase_type, purchase_time, car_id) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        jdbc.update(INSERT_PURCHASE, purchase.getCustomerName(), purchase.getCustomerPhone(), purchase.getCustomerEmail(), purchase.getCustomerStreet1(), purchase.getCustomerStreet2(),
         purchase.getCustomerCity(), purchase.getCustomerState(), purchase.getCustomerZip(), purchase.getPurchaseType(), purchase.getPurchaseTime(), purchase.getCarId());
        int newPurchaseId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        return newPurchaseId;
    }

    public List<Purchase> getAllPurchases() {
        final String SELECT_ALL_PURCHASE = "SELECT * FROM purchase";
        return jdbc.query(SELECT_ALL_PURCHASE, new PurchaseDB.PurchaseMapper());
    }


    public Purchase getPurchaseById(int purchaseId) {
        try {
            final String SELECT_PURCHASE_BY_ID = "SELECT * FROM purchase WHERE purchase_id = ?";
            return jdbc.queryForObject(SELECT_PURCHASE_BY_ID, new PurchaseDB.PurchaseMapper(), purchaseId);
        } catch(DataAccessException ex) {
            return null;
        }
    }

}
