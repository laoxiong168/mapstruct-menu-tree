package com.jieshun.handle.service;

import com.jieshun.handle.entity.JxTree;
import com.jieshun.handle.entity.MenuTreeVO;

import java.util.List;

public interface HandleService {
   List<MenuTreeVO> queryAllTreeNodes();
}
