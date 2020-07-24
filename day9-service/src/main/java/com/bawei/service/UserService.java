package com.bawei.service;

import com.bawei.entity.Depart;
import com.bawei.entity.MyPageImpl;
import com.bawei.entity.User;
import com.bawei.entity.UserVo;

import java.util.List;

public interface UserService {

    MyPageImpl list(UserVo userVo);

    boolean delete(int id);

    boolean add(User user);

//    获取部门的列表
    List<Depart> listDeparts();
}
