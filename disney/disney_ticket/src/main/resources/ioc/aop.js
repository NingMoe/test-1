/**
 * AOP事务
 */
var ioc = {

	// 声明5种事务等级对应的拦截器
	txNONE : {
        type : 'org.nutz.aop.interceptor.TransactionInterceptor',
        args : [0]
    },
    txREAD_UNCOMMITTED : {
        type : 'org.nutz.aop.interceptor.TransactionInterceptor',
        args : [1]
    },
    txREAD_COMMITTED : {
        type : 'org.nutz.aop.interceptor.TransactionInterceptor',
        args : [2]
    },
    txREPEATABLE_READ : {
        type : 'org.nutz.aop.interceptor.TransactionInterceptor',
        args : [4]
    },
    txSERIALIZABLE : {
        type : 'org.nutz.aop.interceptor.TransactionInterceptor',
        args : [8]
    },
    
    // transaction_aop
    $aop : {
    	type : 'org.nutz.ioc.aop.config.impl.ComboAopConfigration',
        fields : {
            aopConfigrations  : [
                {	
                	type : 'org.nutz.ioc.aop.config.impl.JsonAopConfigration',
                    fields : {
                        itemList : [
                                    ['com.sharefree.biz.imp.+','.+','ioc:txREAD_COMMITTED']
		                ]
                    }
                },
                {
                	type : 'org.nutz.ioc.aop.config.impl.AnnotationAopConfigration'
        		}
            ]
        }
    }
};