package com.jieshun.handle.transfer;

import com.jieshun.handle.entity.JxTree;
import com.jieshun.handle.entity.MenuTreeVO;
import org.mapstruct.Mapper;

@Mapper
public interface HandlerTransfer {
    MenuTreeVO vo2vo(JxTree jxTree);
}

