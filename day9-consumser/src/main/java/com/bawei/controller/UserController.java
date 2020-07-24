package com.bawei.controller;

import com.bawei.entity.Depart;
import com.bawei.entity.MyPageImpl;
import com.bawei.entity.User;
import com.bawei.entity.UserVo;
import com.bawei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(allowedHeaders = "*",allowCredentials = "true")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public MyPageImpl<User> list(UserVo userVo){
        System.out.print(" 消费者参数是  " + userVo);
        MyPageImpl<User> page = userService.list(userVo);
        System.out.println ("  消费者 ========== 已经获取数据了。。。。。。。。。。。。");
//        page.getContent().iterator().forEachRemaining(x->{System.out.println("消费者  x is " + x);});
        System.out.println(page.getContent());
        return page;
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam(value = "id") int id){
        return userService.delete(id);

    }

    @RequestMapping("add")
    public boolean add(@RequestBody User user){
        return userService.add(user);
    }

//    获取所有的部门
    @RequestMapping("departs")
    public List<Depart> getDepart(){
        return userService.listDeparts();
    }
}
