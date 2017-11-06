package com.zjcds.xa.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombotreeTool {

    private static final long serialVersionUID = -3318989776253565435L;


    /**
     * 将角色封装成树开始
     * @param list
     * @param fid 父id
     */
    public List<Map<String,Object>> createComboTreeTree(List<ComboTreeModel> list, String fid) {
        List<Map<String,Object>> comboTreeList  =new ArrayList<Map<String,Object>>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = null;
            ComboTreeModel treemodel = (ComboTreeModel) list.get(i);
            if (treemodel.getFatherId().equals("0")) {//根节点
                map = new HashMap<String, Object>();
                //这里必须要将对象角色的id、name转换成ComboTree在页面的显示形式id、text
                //ComboTree,不是数据表格，没有在页面通过columns转换数据的属性
                map.put("id", list.get(i).getId());         //id
                map.put("text",list.get(i).getName());      //角色名
                map.put("children", createComboTreeChildren(list, treemodel.getId()));
            }
            if (map != null)
                comboTreeList.add(map);
        }
        return comboTreeList;
    }


    /**
     * 递归设置role树
     * @param list
     * @param fid
     * @return
     */
    private List<Map<String, Object>> createComboTreeChildren(List<ComboTreeModel> list, String fid) {
        List<Map<String, Object>> childList = new ArrayList<Map<String, Object>>();
        for (int j = 0; j < list.size(); j++) {
            Map<String, Object> map = null;
            ComboTreeModel treeChild = (ComboTreeModel) list.get(j);
            if (treeChild.getFatherId().equals(fid)) {
                map = new HashMap<String, Object>();
                //这里必须要将对象角色的id、name转换成ComboTree在页面的显示形式id、text
                //ComboTree,不是数据表格，没有在页面通过columns转换数据的属性
                map.put("id", list.get(j).getId());
                map.put("text", list.get(j).getName());
                map.put("children", createComboTreeChildren(list, treeChild.getId()));
            }

            if (map != null)
                childList.add(map);
        }
        return childList;
    }
}
