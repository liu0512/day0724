package com.bawei.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "hg_user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer uid;

    private  String username;

    private  String password;

    private  String name;

    private  String email;

    private  String telephone;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private  int sex;

    private  int state;

    private  String code;

//    一对一
    @OneToOne(targetEntity=DriverCard.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "card_id",referencedColumnName = "id",insertable = true,updatable = false,nullable = false)
    private DriverCard driverCard;

//    多对一
//    cascade = CascadeType.DETACH 不级联
    @ManyToOne(targetEntity = Depart.class,cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
//    name是user表中的id referencedColumnName是子表中的id insertable要不要插入  updatable = false要不要更新  nullable = true要不要为空
    @JoinColumn(name = "depart_id",referencedColumnName = "id",insertable = true,updatable = true,nullable = true,foreignKey = @ForeignKey(value=ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private Depart depart;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "uid",insertable = true,updatable = true,nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Room> roomlist;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "hg_user_favourite",joinColumns = {@JoinColumn()})
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Favourite> favouriteList;
}
