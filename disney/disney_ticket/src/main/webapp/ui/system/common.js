
/**操作员性别*/
function gender(val) {
		if(val == '0') {
			//return '<img src="' + Ext.contextPath + '/ext/resources/images/male.png" />';
			return '男';
		} else if(val == '1') {
			//return '<img src="' + Ext.contextPath + '/ext/resources/images/female.png" />';
			return '女';
		}
		return val;
	}
	
	
	function oprState(val) {
		if(val == '0') {
			return '<font color="green">正常</font>';
		} else if(val == '1') {
			return '<font color="red">注销</font>';
		}else if(val == '2') {
			return '<font color="green">正常</font>';
		}
		return '状态未知';
	}
	
	
	
	/**
	 * 商户状态转译
	 */
	function mchntSt(val) {
		if(val == '0') {
			return '<font color="green">正常</font>';
		} else if(val == '1') {
			return '<font color="gray">添加待终审</font>';
		} else if(val == 'B') {
			return '<font color="gray">添加待初审</font>';
		} else if(val == '3') {
			return '<font color="gray">修改待审核</font>';
		} else if(val == '5') {
			return '<font color="gray">冻结待审核</font>';
		} else if(val == '6') {
			return '<font color="red">冻结</font>';
		} else if(val == '7') {
			return '<font color="gray">恢复待审核</font>';
		} else if(val == '8') {
			return '<font color="red">注销</font>';
		} else if(val == '9') {
			return '<font color="gray">注销待审核</font>';
		} else if(val == 'A') {
			return '<font color="blue">添加初审退回</font>';
		} else if(val == '2') {
			return '<font color="blue">添加终审退回</font>';
		} else if(val == '4') {
			return '<font color="blue">修改审核退回</font>';
		} else if(val == 'C') {
			return '<font color="red">拒绝</font>';
		}
		return val;
	}
	
	
	 // 终端状态
    function termSta(val) {
            if(val == '0')
                return "新增未审核";
            else if(val == '1')
                return '<font color="green">启用</font>';
            else if(val == '2')
                return "修改未审核";
            else if(val == '3')
                return "冻结未审核";
            else if(val == '4')
                return '<font color="red">冻结</font>';
            else if(val == '5')
                return "恢复未审核";
            else if(val == '6')
                return "注销未审核";
            else if(val == '7')
                return '<font color="red">注销</font>';
            else if(val == '8')
                return "新增审核拒绝";
            else if(val == '9')
                return "修改审核拒绝";
            else if(val == 'A')
                return "冻结审核拒绝";
            else if(val == 'B')
                return "恢复审核拒绝";
            else if(val == 'C')
                return "注销审核拒绝";
            else if(val == 'D')
                return "复制未修改";
            else return val;
        }
        
        
          // 终端签到状态
	function termSignSta(val) {
			if(val == '0')
				return "未签到";
			else if(val == '1')
				return "已签到";
			else if(val == '2')
				return "已签退";
			else return val;
		}
		
		
		//交易结果
		function txnSta(val) {
			if(val == '0')
				return '<font color="blue">请求中</font>';
			else if(val == '1')
				return '<font color="green">成功</font>';
			else if(val == '2')
				return '<font color="red">卡拒绝</font>';
			else if(val == '3')
				return '<font color="red">超时</font>';
			else if(val == '4')
				return '<font color="red">主机拒绝</font>';
			else if(val == '5')
				return '<font color="red">pin/mac错</font>';
			else if(val == '6')
				return '<font color="red">前置拒绝</font>';
			else if(val == '7')
				return '<font color="blue">记账中</font>';
			else if(val == '8')
				return '<font color="red">记账超时</font>';
			else if(val == 'R')
				return '<font color="gray">已退货</font>';
			return val;
		}
	
		//渠道商户	
	function mchntTmpSt(val) {
		if(val == '0') {
			return '<font color="green">审核通过</font>';
		} else if(val == '1') {
			return '<font color="gray">申请待审核</font>';
		
		} else if(val == '2') {
			return '<font color="red">审核回退</font>';

		}return val;
	}
	
	//退货类型
	function amtBackFlag(val) {
		switch(val) {
			
			case 'C': return '<font color="green">差错退货</font>';
			case 'S': return '<font color="green">手工退货</font>';
			case 'Y': return '<font color="green">业务退货</font>';
			
			default : return val;
		}
	}
	
	//差错退货审核状态
	function applyState(val) {
		switch(val) {
			
			case '0': return '<font color="gray">未审核</font>';
			case '1': return '<font color="green">审核通过</font>';
			case '2': return '<font color="red">审核拒绝</font>';
			
			default : return val;
		}
	}
	
	//退货交易结果状态
	function resState(val) {
		switch(val) {
		    case '2': return '<font color="red">受理拒绝</font>';
			case '1': return '<font color="green">受理成功</font>';
			case '0': return '<font color="gray">待受理</font>';
			default : return val;
		}
	}
	
	//差错退货交易结果状态
	function backState(val) {
		switch(val) {
			
			case '1': return '<font color="green">退货成功</font>';
			case '0': return '<font color="red">退货失败</font>';
			
			default : return val;
		}
	}
	
	/**
	 * 白名单商户申请审核状态
	 */
	function whiteMchtCS(val) {
		if(val == '1') {
			return '<font color="gray">未审核</font>';
		} else if(val == '2') {
			return '<font color="blue">初审通过</font>';
		} else if(val == '3') {
			return '<font color="red">初审不通过</font>';
		} else if(val == '4') {
			return '<font color="green">终审通过</font>';
		} else if(val == '5') {
			return '<font color="red">终审不通过</font>';
		}
		return val;
	}
	 
	/**
	 * 商户结算状态
	 */
	
	function settleFlag(val) {
		if(val == '3') {
			return '<font color="red">冻结</font>';
		} else {
			return '<font color="green">未冻结</font>';
		}
	}
	 
	/**
	 * 商户结算状态
	 */
	
	function withdrawCodeMap(val) {
		if(val == '00') {
			return '<font color="green">此批交易可提现</font>';
		} else if(val == '99') {
			val = '此批交易不可提现：由于下面列表中交易被拒绝提现！';
		} else if(val == '01') {
			val = '此批交易不可提现：提现金额超过提现限额！';
		} else if(val == '02') {
			val = '此批交易不可提现：商户未设置提现手续费！';
		} else if(val == '03') {
			val = '此批交易不可提现：商户位开通T+0！';
		} else if(val == '04') {
			val = '此批交易不可提现：提现金额超过可提现余额！';
		}
		return '<font color="red">'+val+'</font>';
	}
	 
	/**
	 * 提现状态
	 */
	
	function wdStatus(val) {
		if(val == '0') {
			return '<font color="green">已完成</font>';
		} else if(val == '1') {
			return '<font color="gray">待审核</font>';
		} else if(val == '2') {
			return '<font color="red">初审拒绝</font>';
		} else if(val == '3') {
			return '<font color="blue">处理中</font>';
		} else if(val == '4') {
			return '<font color="red">处理失败</font>';
		}
		return '<font color="red">未知状态</font>';
	}
	