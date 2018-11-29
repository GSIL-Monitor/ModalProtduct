package com.huimin.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huimin.entity.bo.BasicTree;

public class TreeUtil {
	/**
	 * 生成树形结构
	 * @param sources
	 * @return
	 */
	 public static <T extends BasicTree<T>> List<T> getTree(List<T> sources, Integer parentId){
	        List<T> rootList =  getTreeRoot(sources, parentId);
	        int len = rootList.size();
	        for(int i=0;i<len;i++){
	            getTreeChildNode(sources,rootList.get( i ));
	        }
	        return rootList;
	    }

	 
	 public static <T extends BasicTree<T>> List<T> treeToList(T tree){
		 List<T> list = new ArrayList<>();
		 handleTree(tree, list);
		 return list;
	 }
	    /**
	     * 分离出根节点
	     * @return
	     */
	    private  static <T extends BasicTree<T>> List<T> getTreeRoot(List<T> sources, Integer parentId){
	        List<T> rootList = new ArrayList<>(  );
	        Iterator<T> iterator = sources.iterator();
	        while (iterator.hasNext()) {
				T next = iterator.next();
				if(next.getParentId() == null || next.getParentId().equals(parentId)){
	                rootList.add(next);
	       //         iterator.remove();
	            }
			}
	        return rootList;
	    }


	    /**
	     * 分离出子节点
	     * @return
	     */
	    private  static <T extends BasicTree<T>> void getTreeChildNode(List<T> sources,T parentNode){
	        Iterator<T> iterator = sources.iterator();
	        while (iterator.hasNext()) {
				T next = iterator.next();
				if(next.getParentId().equals(parentNode.getId())){
					next.setParentName(parentNode.getTitle());
	                parentNode.getChildren().add(next);
	        //        iterator.remove();
	                getTreeChildNode(sources,next);
	            }
			}
	    }
	    
	    private static <T extends BasicTree<T>> void handleTree(T tree, List<T> list) {
	    	List<T> children = tree.getChildren();
	    	tree.setChildren(null);
	    	list.add(tree);
	    	for (T t : children) {
				handleTree(t, list);
			}
	    }
}
