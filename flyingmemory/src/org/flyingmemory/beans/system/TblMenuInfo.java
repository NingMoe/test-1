package org.flyingmemory.beans.system;

import java.util.Set;

public class TblMenuInfo {

	private java.lang.String menuId;
	private java.lang.String menuName;
	private java.lang.String menuDesc;
	private java.lang.String menuUrl;
	private java.lang.String menuState;
	private java.lang.String updateTime;
	private java.lang.String updateOpr;
	private java.lang.String createTime;
	private java.lang.String createOpr;
	private TblMenuInfo parent;
	private Set<TblMenuInfo> children;
	/**
	 * @return the menuId
	 */
	public java.lang.String getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(java.lang.String menuId) {
		this.menuId = menuId;
	}
	/**
	 * @return the menuName
	 */
	public java.lang.String getMenuName() {
		return menuName;
	}
	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(java.lang.String menuName) {
		this.menuName = menuName;
	}
	/**
	 * @return the menuDesc
	 */
	public java.lang.String getMenuDesc() {
		return menuDesc;
	}
	/**
	 * @param menuDesc the menuDesc to set
	 */
	public void setMenuDesc(java.lang.String menuDesc) {
		this.menuDesc = menuDesc;
	}
	/**
	 * @return the menuUrl
	 */
	public java.lang.String getMenuUrl() {
		return menuUrl;
	}
	/**
	 * @param menuUrl the menuUrl to set
	 */
	public void setMenuUrl(java.lang.String menuUrl) {
		this.menuUrl = menuUrl;
	}
	/**
	 * @return the menuState
	 */
	public java.lang.String getMenuState() {
		return menuState;
	}
	/**
	 * @param menuState the menuState to set
	 */
	public void setMenuState(java.lang.String menuState) {
		this.menuState = menuState;
	}
	/**
	 * @return the updateTime
	 */
	public java.lang.String getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(java.lang.String updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return the updateOpr
	 */
	public java.lang.String getUpdateOpr() {
		return updateOpr;
	}
	/**
	 * @param updateOpr the updateOpr to set
	 */
	public void setUpdateOpr(java.lang.String updateOpr) {
		this.updateOpr = updateOpr;
	}
	/**
	 * @return the createTime
	 */
	public java.lang.String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(java.lang.String createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the createOpr
	 */
	public java.lang.String getCreateOpr() {
		return createOpr;
	}
	/**
	 * @param createOpr the createOpr to set
	 */
	public void setCreateOpr(java.lang.String createOpr) {
		this.createOpr = createOpr;
	}
	/**
	 * @return the parent
	 */
	public TblMenuInfo getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(TblMenuInfo parent) {
		this.parent = parent;
	}
	/**
	 * @return the children
	 */
	public Set<TblMenuInfo> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(Set<TblMenuInfo> children) {
		this.children = children;
	}

	
}
