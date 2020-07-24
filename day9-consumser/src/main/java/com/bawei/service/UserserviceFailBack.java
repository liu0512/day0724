package com.bawei.service;

import com.bawei.entity.Depart;
import com.bawei.entity.MyPageImpl;
import com.bawei.entity.User;
import com.bawei.entity.UserVo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserserviceFailBack implements UserService{


    @Override
    public MyPageImpl<User> list(UserVo userVo) {
        System.out.println(" 对不起，熔断了。。。。");
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public List<Depart> listDeparts() {
        return new ArrayList<Depart>();
    }
}
