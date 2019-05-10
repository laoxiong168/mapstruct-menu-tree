package com.jieshun.handle.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * jx_tree
 * @author
 */
@Data
public class JxTree implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 父节点
     */
    private Integer parentId;

    private Integer mSort;

    /**
     * 名称
     */
    private String name;

    private String url;

}