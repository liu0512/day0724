package com.bawei.controller;

import com.bawei.entity.Depart;
import com.bawei.entity.MyPageImpl;
import com.bawei.entity.User;
import com.bawei.entity.UserVo;
import com.bawei.repository.UserRepository;
import com.bawei.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("user")
@Slf4j
@CrossOrigin(allowedHeaders = "*",allowCredentials = "true")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping("test")
    public String test(){
        return "test";
    }

    @RequestMapping("testa")
    public String testAdd(){
        User user = new User();
        user.setName("张三");
        user.setUsername("zhangsan");
        user.setPassword("123123");
        user.setEmail("aaaa@qq.com");
        user.setTelephone("135123123123");
        user.setBirthday(new Date());
        user.setSex(1);
        user.setState(1);
        user.setCode("啊实打实大");
        userRepository.save(user);
        return "ok";
    }

    @RequestMapping("list")
    public MyPageImpl<User> list(@RequestBody UserVo userVo){
        System.out.print(" 服务提供者  参数是  " + userVo);
        MyPageImpl<User> userpage = userService.list(userVo);
        log.info(" 已经获取数据了。。。。。。。。。。。。");
//        userpage.getContent().iterator().forEachRemaining(x->{System.out.println("x is " + x);});
        log.info("page.class is " + userpage.getContent());
        return userpage;
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam("id")int id){
        return userService.delete(id);
    }

    @RequestMapping("add")
    public boolean add(@RequestBody User user){
        return userService.add(user);
    }

    @RequestMapping("departs")
    public List<Depart> getDepart(){
        return userService.listDeparts();
    }
}
