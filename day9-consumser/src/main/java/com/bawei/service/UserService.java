package com.bawei.service;

import com.bawei.entity.Depart;
import com.bawei.entity.MyPageImpl;
import com.bawei.entity.User;
import com.bawei.entity.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "day9-service")
public interface UserService {

    @RequestMapping("/user/list")
    MyPageImpl<User> list(@RequestBody UserVo userVo);

    @RequestMapping("/user/delete")
    public boolean delete(@RequestParam(value = "id")int id);

    @RequestMapping("/user/add")
    public boolean add(@RequestBody User user);

    @RequestMapping("/user/departs")
    List<Depart> listDeparts();
}
