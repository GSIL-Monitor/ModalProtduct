package com.huimin.base;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.huimin.entity.bo.TreeBo;
import com.huimin.util.TreeUtil;

public class TreeTest {

	@Test
	public void testTree() {
		TreeBo root = new TreeBo();
		root.setId(1);
		root.setTitle("根节点");
		TreeBo root2 = new TreeBo();
		root2.setId(2);
		root2.setTitle("子节点");
		root2.setParentId(1);
		TreeBo root3 = new TreeBo();
		root3.setId(3);
		root3.setTitle("孙子节点");
		root3.setParentId(2);
		TreeBo root4 = new TreeBo();
		root4.setId(4);
		root4.setTitle("孙子节点2");
		root4.setParentId(2);
		List<TreeBo> treeBos = new ArrayList<TreeBo>();
		treeBos.add(root);
		treeBos.add(root2);
		treeBos.add(root3);
		treeBos.add(root4);
		List<TreeBo> tree = TreeUtil.getTree(treeBos, null);
		System.out.println(tree);
		List<TreeBo> treeToList = TreeUtil.treeToList(tree.get(0));
		System.out.println(treeToList);
	}
}
