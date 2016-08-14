package per.suanmilk.connect.service.itf;

import java.util.List;


/**
 * 
 * Title: IBaseService
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Feb 17, 2016
 *
 */
public interface IBaseService<Model, Id> {

	/**
	 * 根据主键，获取一条记录
	 * 
	 * @param id
	 * @return
	 */
	Model fetch(Id id);

	/**
	 * 根据条件，获取多条记录
	 * 
	 * @param model
	 * @return
	 */
	List<Model> query(Model model);

	/**
	 * 根据条件，查询数量
	 * 
	 * @param model
	 * @return
	 */
	int count(Model model);

	/**
	 * 插入一条记录
	 * 
	 * @param model
	 * @return
	 */
	Model insert(Model model);

	/**
	 * 根据主键，删除一条记录
	 * 
	 * @param id
	 * @return
	 */
	int delete(Id id);

	/**
	 * 根据条件，删除多条记录
	 * 
	 * @param model
	 * @return
	 */
	int clear(Model model);

	/**
	 * 根据条件，更新一条或者多条记录
	 * 
	 * @param model
	 * @return
	 */
	int update(Model model);
	
}
