package com.bawei.entity;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Data
public class MyPageImpl<T> {

    private long lotalElements=0;
    private List<T> content=null;
    private  int totalPages=0;
    private  int number=0;
    private int size=5;

    public MyPageImpl(Page pil) {
//        总条数
        lotalElements = pil.getTotalElements();
//        数据
        content =pil.getContent();
//          总页数
        totalPages =pil.getTotalPages();
//      第几页
        number =pil.getNumber();
//        每页条数
        size = pil.getSize();
    }

    public MyPageImpl() {

    }
}
