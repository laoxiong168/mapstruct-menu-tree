package com.jieshun.handle.controller;

import com.jieshun.handle.entity.MenuTreeVO;
import com.jieshun.handle.service.HandleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class HandleController {
    @Autowired
    private HandleService handleService;

    @PostMapping("handle")
    public List handle() {

        List<MenuTreeVO> respList = null;
        try {
            respList = handleService.queryAllTreeNodes();
            log.info("[HandleController]获取到的树形数据为{}",respList);
        } catch (Exception e) {
            log.info("[HandleController出错]",e);
        }
        return respList;
    }


}
