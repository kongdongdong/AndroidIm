package com.kdd.androidim.dao.entity;

import java.util.List;

/**
 * Created by kdd on 17/9/5.
 */
public class ImMeun extends BaseEntity{


    private Integer id;

    private Integer menuId;

    private Integer menuNo;

    private Integer menuParentNo;

    private Integer menuOrder;

    private String menuName;

    private String menuUrl;

    private String menuIcon;

    private Integer menuType;

    private Boolean isVisible;

    private Boolean isLeaf;


    private List<MenuChild> children;


    public Integer getMenuParentNo() {
        return menuParentNo;
    }

    public void setMenuParentNo(Integer menuParentNo) {
        this.menuParentNo = menuParentNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(Integer menuNo) {
        this.menuNo = menuNo;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Boolean getVisible() {
        return isVisible;
    }

    public void setVisible(Boolean visible) {
        isVisible = visible;
    }

    public Boolean getLeaf() {
        return isLeaf;
    }

    public void setLeaf(Boolean leaf) {
        isLeaf = leaf;
    }

    public List<MenuChild> getChildren() {
        return children;
    }

    public void setChildren(List<MenuChild> children) {
        this.children = children;
    }
}
