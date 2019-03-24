package top.bounds.tmall.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import top.bounds.tmall.pojo.Category;
import top.bounds.tmall.service.CategoryService;

/**
 * @author Bounds
 * @RestController 表示这是一个控制器，对每个方法的返回值都会直接转换为 json 数据格式
 */
@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	/**
	 * @return 返回所有的分类信息（这里转换为JSON数组）
	 * @throws Exception
	 */
	@GetMapping("/categories")
	public List<Category> list() throws Exception {
		return categoryService.list();
	}
}
