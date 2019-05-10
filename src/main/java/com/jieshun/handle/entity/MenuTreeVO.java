package com.jieshun.handle.entity;


import lombok.Data;

import java.util.List;

@Data
public class MenuTreeVO {
    private int id;
    private int parentId;
    private String name;
    private String url;
    private int mSort;
    private List<MenuTreeVO> childrenNodes;

}
