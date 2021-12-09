package com.jfy.CarDealership.App.dao;

import com.jfy.CarDealership.App.dto.Purchase;

import java.util.List;

public interface PurchaseDao {

    int addPurchase(Purchase purchase);

    List<Purchase> getAllPurchases();

    Purchase getPurchaseById(int purchaseId);



}
