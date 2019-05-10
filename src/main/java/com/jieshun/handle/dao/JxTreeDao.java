package com.jieshun.handle.dao;


import com.jieshun.handle.entity.JxTree;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JxTreeDao {
   List<JxTree> queryAll();
}