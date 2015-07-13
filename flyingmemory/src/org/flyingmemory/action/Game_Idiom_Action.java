package org.flyingmemory.action;

import java.util.List;

import org.flyingmemory.action.system.BaseAction;
import org.flyingmemory.system.util.CommonUtil;

/**
 * Title:成语接龙游戏处理类
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2013-12-01
 * 
 * Company: Shanghai allinfinance Co., Ltd.
 * 
 * author: 徐鹏飞
 *  
 * time: 2015年3月3日下午3:56:08
 * 
 * version: 1.0
 */
public class Game_Idiom_Action extends BaseAction {

	private static final long serialVersionUID = 1292989584231375132L;
	
	private String reqIdiom;
	
	@Override
	protected void subExecute() throws Exception {
		
		// 判断成语是否存在
		String countSql = "SELECT COUNT(*) FROM TBL_IDIOMS_COLLECTION WHERE IDIOM = '" + reqIdiom.trim() + "'";
		if("0".equals(CommonUtil.getCommQueryDAO().findCountBySQLQuery(countSql))){
			writeErrorMsg("你的成语有误！！！");
			return;
		}
		// 系统接成语
		String sql = "SELECT IDIOM FROM TBL_IDIOMS_COLLECTION WHERE SUBSTR(IDIOM,1,1) = '" + reqIdiom.substring(reqIdiom.length()-1) + "'";
		@SuppressWarnings("unchecked")
		List<String> idiomList = CommonUtil.getCommQueryDAO().findBySQLQuery(sql);
		if(idiomList.isEmpty()){
			writeSuccessMsg("你赢了！！！");
		}else{
			String target = CommonUtil.getRangeRandomNum(0, idiomList.size());
			writeSuccessMsg(idiomList.get(Integer.parseInt(target)).toString());
		}
	}

	/**
	 * @return the reqIdiom
	 */
	public String getReqIdiom() {
		return reqIdiom;
	}

	/**
	 * @param reqIdiom the reqIdiom to set
	 */
	public void setReqIdiom(String reqIdiom) {
		this.reqIdiom = reqIdiom;
	}

}
