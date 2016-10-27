package com.sharefree.biz.itf.disney;

import com.sharefree.common.CommonException;
import com.sharefree.model.plane.PlaneOrderModel;

public interface IEtermBiz {

	/**
	 * 生成PNR编码
	 * 
	 * @param trip
	 * @param passengers
	 * @return
	 * @throws CommonException
	 */
	public String[] createPNR(PlaneOrderModel order) throws CommonException;

	/**
	 * 取消PNR编码
	 * 
	 * @param pnr
	 * @throws CommonException
	 */
	public boolean cancelPNR(String pnr) throws CommonException;

	/**
	 * 解析PNR(RT&PAT)
	 * 
	 * @param pnr
	 * @throws CommonException
	 */
	public PlaneOrderModel analysisPNR(String pnr) throws CommonException;

	/**
	 * 解析RT
	 * 
	 * @param pnr
	 * @throws CommonException
	 */
	public PlaneOrderModel analysisRT(String pnr) throws CommonException;

	/**
	 * 解析PAT
	 * 
	 * @param pnr
	 * @throws CommonException
	 */
	public PlaneOrderModel analysisPAT(String pnr) throws CommonException;

	/**
	 * 使用PNR编码出票
	 * 
	 * @param pnr
	 * @return 票号
	 * @throws CommonException
	 */
	public String ticket(String pnr) throws CommonException;

}
