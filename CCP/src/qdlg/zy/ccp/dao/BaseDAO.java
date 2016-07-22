package qdlg.zy.ccp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 公共DAO接口，定义一些常用的方法
 * @author dyr
 *
 * @param <T> 泛型
 */
public interface BaseDAO<T> {

	/**
	 * 添加方法
	 * @param t 添加的对象
	 */
	public void add(T t);

	/**
	 * 通过id查询
	 * @param id 数据id
	 * @return
	 */
	public T queryById(Object id);

	/**
	 * 更新数据（全部更新，属性为null的也更新）
	 * @param t 待更新的实体
	 * @return
	 */
	public Integer update(T t);

	/**
	 * 更新指定列（属性为null的不更新）
	 * @param t 待更新的实体
	 * @return
	 */
	public Integer updateBySelect(T t);

	/**
	 * 通过id删除数据
	 * @param id 数据id
	 * @return
	 */
	public Integer delete(Object id);

	/**
	 * 查询符合条件的数据 数量（一般用于分页）
	 * @param t 查询条件实体
	 * @return
	 */
	public Long queryCount(@Param("entity") T t);

	/**
	 * 分页查询
	 * @param t 查询条件实体
	 * @param page 分页对象
	 * @return
	 */
	//public List<T> queryList(@Param("entity") T t, @Param("page") Pager<T> page);

}
