/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.models.UserModel;
import java.util.List;

/**
 *
 * @author User1
 */
public interface UserDAO {
    public UserModel checkLogin(String username,String password);
    public UserModel getUserWithId(Integer userId);
    public List<UserModel> getAllUsers();
    public Integer deleteUser(Integer userId);
    public Integer updateUser(UserModel userModel);
    public Integer addUser(UserModel userModel);
    public Integer changePassword(UserModel userModel);
}
