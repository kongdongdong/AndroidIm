package com.kdd.androidim.dao.mapping;

import com.kdd.androidim.dao.entity.ImUser;

import java.util.List;

/**
 * Created by kdd on 17/8/31.
 */
public interface ImUserMapper {

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    ImUser findUserByUsername(String username);

    /**
     * 查找所有的用户
     * @return
     */
    List<ImUser> findAllUser();



}
