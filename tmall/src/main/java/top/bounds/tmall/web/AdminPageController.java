package top.bounds.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Bounds
 * @Controller 表示这是一个控制器
 * @describe 后台管理页面跳转专用控制器，仅提供页面跳转，不传数据
 */
@Controller
public class AdminPageController {
	@GetMapping(value = "/admin")
	public String admin() {
		return "redirect:admin_category_list";
	}

	@GetMapping(value = "/admin_category_list")
	public String listCategory() {
		return "admin/listCategory";
	}
}
