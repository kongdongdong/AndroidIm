package com.kdd.androidim.service.impl;

import com.kdd.androidim.dao.entity.ImMeun;
import com.kdd.androidim.dao.mapping.ImMenuMapper;
import com.kdd.androidim.service.ImMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kdd on 17/9/5.
 */
@Service
public class ImMenuServiceImpl implements ImMenuService {

    @Autowired(required = false)
    private ImMenuMapper imMenuMapper;

    public List<ImMeun> findMenuByUsername(String username) {
        return imMenuMapper.findMenuByUsername(username);
    }
}
