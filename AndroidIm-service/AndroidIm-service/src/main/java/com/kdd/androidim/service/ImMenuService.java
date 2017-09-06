package com.kdd.androidim.service;

import com.kdd.androidim.dao.entity.ImMeun;

import java.util.List;

/**
 * Created by kdd on 17/9/5.
 */
public interface ImMenuService {

    List<ImMeun> findMenuByUsername(String username);

}
