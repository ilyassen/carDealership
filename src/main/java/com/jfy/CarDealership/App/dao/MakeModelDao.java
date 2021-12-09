/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfy.CarDealership.App.dao;

import com.jfy.CarDealership.App.dto.MakeModel;

import java.util.List;


/**
 *
 * @author Fishget
 */
public interface MakeModelDao {

    List<MakeModel> getAllMakeModels();;
    void addMakeModel(MakeModel makemodel);

}
