package com.kdd.androidim.dao.mapping;

import com.kdd.androidim.dao.entity.ImMeun;

import java.util.List;

/**
 * Created by kdd on 17/9/5.
 */
public interface ImMenuMapper {

    List<ImMeun> findMenuByUsername(String username);

}
