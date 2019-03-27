package top.bounds.tmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import top.bounds.tmall.dao.CategoryDAO;
import top.bounds.tmall.pojo.Category;
import top.bounds.tmall.util.Page4Navigator;

/**
 * @author Bounds
 * @Service 标记这个类是Service类
 * @Autowired 自动装配,注入对象
 */
@Service
public class CategoryService {
	@Autowired
	CategoryDAO categoryDAO;

	/**
	 * @param start
	 * @param size
	 * @param navigatePages
	 * @return 为分类数据提供分页
	 */
	public Page4Navigator<Category> list(int start, int size, int navigatePages) {
		//设置倒排序
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		//根据start,size和sort创建分页对象
		Pageable pageable = new PageRequest(start, size, sort);
		//CategoryDAO根据这个分页对象获取结果page. 
		Page<Category> pageFromJPA = categoryDAO.findAll(pageable);
		return new Page4Navigator<>(pageFromJPA, navigatePages);

	}

	/**
	 * @return 查找所有分类，并通过分类id倒排序
	 */
	public List<Category> list() {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		return categoryDAO.findAll(sort);
	}
}
