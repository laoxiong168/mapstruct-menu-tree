package com.jieshun.handle.service;

import com.jieshun.handle.dao.JxTreeDao;
import com.jieshun.handle.entity.JxTree;
import com.jieshun.handle.entity.MenuTreeVO;
import com.jieshun.handle.transfer.HandlerTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HandleServiceImpl implements HandleService {
    @Autowired
    private JxTreeDao jxTreeDao;

    @Autowired
    private HandlerTransfer handlerTransfer;

    @Override
    public List<MenuTreeVO> queryAllTreeNodes() {
        List<JxTree> respList = jxTreeDao.queryAll();
        if (respList.size() <= 0) {
            return null;
        }
        List<MenuTreeVO> listVO = new ArrayList<>();
        List<MenuTreeVO> rootList = new ArrayList<>();
        for (JxTree jxTree : respList) {
            if (0 == jxTree.getParentId()) {
                MenuTreeVO menuTreeVO = new MenuTreeVO();
                listVO.add(handlerTransfer.vo2vo(jxTree));
            }
            MenuTreeVO menuTreeVO1 = new MenuTreeVO();
            rootList.add(handlerTransfer.vo2vo(jxTree));
        }


        /**
         * 遍历设置各个节点信息
         */
        listVO.forEach(x -> {
            x.setChildrenNodes(getChildNodes(x.getId(), rootList));
        });
        return listVO;
    }

    /**
     * 遍历获取子节点
     *
     * @param id
     * @param rootList
     * @return
     * @throws
     */
    private List<MenuTreeVO> getChildNodes(Integer id, List<MenuTreeVO> rootList) {
        // The list of child nodes
        List<MenuTreeVO> childList = new ArrayList<>();
        // Fill the list of child'nodes which parent id equal params of id
        for (MenuTreeVO typeEntity : rootList) {
            if (0 != typeEntity.getParentId()) {
                if (id.equals(typeEntity.getParentId())) {
                    childList.add(typeEntity);
                }
            }
        }
        if (childList.size() == 0) {
            return null;
        }
        // Look up it's child node and fill
        for (MenuTreeVO entity : childList) {
            entity.setChildrenNodes(getChildNodes(entity.getId(), rootList));
        }
        return childList;
    }
}
