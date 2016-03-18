package com.sharefree.model;

import java.util.List;

import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;

/**
 * Title: CommonQueryModel
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Feb 19, 2016
 *
 */
public class CommonQueryModel extends BaseModel<Object, List<Object[]>> {
	
	/*
	 * 查询业务码（对应查询方法）
	 */
	private String code;
	
	/*
	 * 自定义查询条件
	 */
	private Sql[] sqls;
	
	public CommonQueryModel(){
		this.sqls = new Sql[2];
	}
	
	public CommonQueryModel(String querySql, String countSql){
		this.sqls = new Sql[2];
		this.sqls[0] = Sqls.create(querySql);
		this.sqls[1] = Sqls.create(countSql);
	}
	
	public CommonQueryModel(String code, String querySql, String countSql){
		this.sqls = new Sql[2];
		this.code = code;
		this.sqls[0] = Sqls.create(querySql);
		this.sqls[1] = Sqls.create(countSql);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Sql[] getSqls() {
		return sqls;
	}

	public void setQuerySql(String querySql) {
		this.sqls[0] = Sqls.create(querySql);
	}

	public void setCountSql(String countSql) {
		this.sqls[1] = Sqls.create(countSql);
	}

}
