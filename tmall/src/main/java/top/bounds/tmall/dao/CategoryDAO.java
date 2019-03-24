package top.bounds.tmall.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import top.bounds.tmall.pojo.Category;

/**
 * @author Bounds
 * @describe 类继承 JpaRepository，就提供了CRUD和分页 的各种常见功能。 这就是采用 JPA 方便的地方
 */
public interface CategoryDAO extends JpaRepository<Category, Integer> {
	
}
