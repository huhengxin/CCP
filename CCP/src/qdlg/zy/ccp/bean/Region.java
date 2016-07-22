package qdlg.zy.ccp.bean;

import java.io.Serializable;

/**
 * 地区表 （用户选择地区用）
 * 
 * @author Administrator
 * 
 */
public class Region implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 地区id 主键（非自增）
	 */
	private Long id;
	/**
	 * 地区名
	 */
	private String regionName;
	/**
	 * 级别
	 */
	private Integer level;
	/**
	 * 编号
	 */
	private String code;
	/**
	 * 上级编号
	 */
	private String parentCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

}
