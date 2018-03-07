package com.huimin.effective.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class MenuTest {

	public static void main(String[] args) {
		MenuTest menuTest = new MenuTest();
		menuTest.init();
		Menu handle = menuTest.handle();
		System.out.println(handle);
		List<Integer> ids = new ArrayList<>();
		Menu byId = menuTest.getById(handle, 3);
		menuTest.handleIds(byId, ids);
		System.out.println(ids);
		String join = StringUtils.join(ids, ",");
		System.out.println(join);

	}

	public void handleIds(Menu mu, List<Integer> ids) {
		Integer id = mu.getId();
		ids.add(id);
		if (mu.hasChildern()) {
//			mu.getChildern().forEach(action ->{
//				handleIds(action, ids);
//			});
			for (Menu menu : mu.getChildern()) {
				handleIds(menu, ids);
			}
		}
	}
	
	public Menu getById(Menu root, Integer id) {
		if (root.getId().equals(id)) {
			return root;
		}
		if (root.hasChildern()) {
			for (Menu menu : root.getChildern()) {
				return getById(menu, id);
			}
		}
		return null;
	}
	List<Menu> datas = new ArrayList<>();

	public Menu handleStream() {
		return datas.stream().flatMap(ro -> datas.stream().map(ch -> {
			if (ch.getParentId() == ro.getId()) {
				ro.addChildern(ch);
			}
			return ro;
		})).filter(mu -> mu.getParentId() == 0)
				.collect(Collectors.toList()).get(0);
	}

	public Menu handle() {
		Menu root = null;
		for (Menu menu : datas) {
			if (menu.getParentId() == 0) {
				root = menu;
			}
			t(menu);
		}
		return root;
	}

	public void t(Menu root) {
		for (Menu menu : datas) {
			if (menu.getParentId() == root.getId()) {
				root.addChildern(menu);
			}
		}
	}

	public void init() {
		Menu menu1 = new Menu(1, "根", 0);
		Menu menu2 = new Menu(2, "一级菜单", 1);
		Menu menu3 = new Menu(3, "一级菜单", 1);
		Menu menu4 = new Menu(4, "二级菜单", 2);
		Menu menu5 = new Menu(5, "二级菜单", 2);
		Menu menu6 = new Menu(6, "二级菜单", 3);
		Menu menu7 = new Menu(7, "二级菜单", 3);
		Menu menu8 = new Menu(8, "三级菜单", 4);
		Menu menu9 = new Menu(9, "三级菜单", 5);
		Menu menu10 = new Menu(10, "三级菜单", 6);
		Menu menu11 = new Menu(11, "三级菜单", 7);
		datas.add(menu11);
		datas.add(menu10);
		datas.add(menu9);
		datas.add(menu8);
		datas.add(menu7);
		datas.add(menu6);
		datas.add(menu5);
		datas.add(menu4);
		datas.add(menu3);
		datas.add(menu2);
		datas.add(menu1);
	}
}

class Menu {
	private Integer id;
	private String name;
	private Integer parentId;
	private List<Menu> childern = new ArrayList<>();

	public Menu() {
	}

	public Menu(Integer id, String name, Integer parentId) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<Menu> getChildern() {
		return childern;
	}

	public void addChildern(Menu childern) {
		this.childern.add(childern);
	}

	public boolean hasChildern() {
		return !this.childern.isEmpty();
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", parentId=" + parentId + "]";
	}

}