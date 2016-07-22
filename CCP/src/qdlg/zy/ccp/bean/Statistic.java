package qdlg.zy.ccp.bean;

import java.io.Serializable;

/**
 * 注册用户所属省市统计表
 * 
 * @author Administrator
 * 
 */
public class Statistic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 统计表  id 主键（自增）
	 */
	private Long id;
	/**
	 * 地区名
	 */
	private String name;
	/**
	 * 编号
	 */
	private String code;
	/**
	 * 注册人数
	 */
	private Long value;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
}
