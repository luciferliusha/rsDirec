package com.zjcds.xa.common.utils;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author renshui
 *
 *
 */
public class Pagination {
 
 private int startIndex;//rownum
 private int endIndex;//rownum
 
 /**
  * ȡoracle rownum
  * @return
  */
 public Map<String, Integer> getRowNumRang(int totalRow,int currentPage,int pageSize){
	 
	 Map<String, Integer> rangMap=new HashMap<String, Integer>();
	 if(currentPage==1){
		 startIndex=1;
		 endIndex=pageSize;
	 }else{
		 startIndex=pageSize*(currentPage-1)+1;
		 endIndex=startIndex+pageSize-1;
	 }
	 rangMap.put("startIndex", startIndex);
	 rangMap.put("endIndex", endIndex);
	 return rangMap; 
 }
  
}