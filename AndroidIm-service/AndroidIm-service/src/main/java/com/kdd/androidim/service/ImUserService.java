package com.kdd.androidim.service;


import com.kdd.androidim.dao.entity.ImUser;

import java.util.List;

/**
 * Created by kdd on 17/8/19.
 */
public interface ImUserService {

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    ImUser getImUserByUserName(String username);

    /**
     * 查找所有用户
     * @return
     */
    List<ImUser> findAllUser();
}
