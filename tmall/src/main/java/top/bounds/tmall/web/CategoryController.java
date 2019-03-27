package top.bounds.tmall.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.bounds.tmall.pojo.Category;
import top.bounds.tmall.service.CategoryService;
import top.bounds.tmall.util.Page4Navigator;

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
	public Page4Navigator<Category> list(@RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		// 如果 start 为负，那么修改为0. 这个事情会发生在当前是首页，并点击了上一页的时候
		start = start < 0 ? 0 : start;
		// 5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
		Page4Navigator<Category> page = categoryService.list(start, size, 5);
		// 在这个page对象里，不仅包含了分页信息，还包含了数据信息，即有哪些分类数据。 这个可以通过getContent()获取出来。
		return page;
	}
}
