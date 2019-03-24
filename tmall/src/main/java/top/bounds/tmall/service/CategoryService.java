package top.bounds.tmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import top.bounds.tmall.dao.CategoryDAO;
import top.bounds.tmall.pojo.Category;

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
	 * @return 查找所有分类，并通过分类id倒排序
	 */
	public List<Category> list() {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		return categoryDAO.findAll(sort);
	}
}
