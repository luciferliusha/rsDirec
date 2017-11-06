package com.zjcds.xa.common.utils;

public class ComboTreeModel {

    private static final long serialVersionUID = -6614052029623997372L;



    private String id;
    private String name;                    //角色名称
    private String fatherId;                //父角色id
    private String fatherName;              //父角色名称

    private String children;                //子角色
    private String checked;                 //节点是否被选中

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
