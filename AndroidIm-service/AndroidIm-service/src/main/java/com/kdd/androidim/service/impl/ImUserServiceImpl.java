package com.kdd.androidim.service.impl;

import com.kdd.androidim.dao.entity.ImUser;
import com.kdd.androidim.dao.mapping.ImUserMapper;
import com.kdd.androidim.service.ImUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kdd on 17/8/19.
 */
@Service
public class ImUserServiceImpl implements ImUserService {

    @Autowired(required = false)
    private ImUserMapper imUserMapper;

    public ImUser getImUserByUserName(String username) {
        ImUser imUser = imUserMapper.findUserByUsername(username);
        return imUser;
    }

    public List<ImUser> findAllUser() {
        return imUserMapper.findAllUser();
    }
}
