-- 游客订单
CREATE TABLE
    tourist_order
    (
        orderId INT(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单ID',
        orderNo VARCHAR(16) NOT NULL COMMENT '订单编号',
        customerId INT(8) unsigned DEFAULT 0 COMMENT '客户ID',
        customerName VARCHAR(64) COMMENT '客户名称',
        visitDate DATETIME NOT NULL COMMENT '入园日期',
        visitNum SMALLINT(4) unsigned NOT NULL COMMENT '入园人数',
        isNeedOccupy CHAR(1) COMMENT '是否需要占位',
        needOccupyNum SMALLINT(4) unsigned DEFAULT 0 COMMENT '需要占位人数',
        priority SMALLINT(4) unsigned DEFAULT 9 COMMENT '优先级',
        crtTime DATETIME NOT NULL COMMENT '下单时间',
        crtOptId INT(8) unsigned NOT NULL COMMENT '下单人员',
        importTime DATETIME COMMENT '录入时间',
        importOptId INT(8) unsigned COMMENT '录入人员',
        status CHAR(1) DEFAULT '0' COMMENT '状态[0：已取消；1：未出票；2：部分出票；3：已出票；9：正常]',
        PRIMARY KEY (orderId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='游客订单';

--游客明细
CREATE TABLE
    tourist_detail
    (
        touristId INT(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '游客明细ID',
        orderId INT(8) unsigned NOT NULL COMMENT '订单ID',
        orderNo VARCHAR(16) NOT NULL COMMENT '订单编号',
        visitDate DATETIME NOT NULL COMMENT '入园日期',
        touristName VARCHAR(64) NOT NULL COMMENT '游客名称',
        idcType CHAR(1) NOT NULL COMMENT '证件类型',
        idcNo VARCHAR(32) NOT NULL COMMENT '证件号码',
        telephone VARCHAR(16) NOT NULL COMMENT '联系电话',
        email VARCHAR(32) NOT NULL COMMENT '邮箱',
        status CHAR(1) DEFAULT '0' NOT NULL COMMENT '状态[0：已取消；1：正常]',
        importTime DATETIME NOT NULL COMMENT '录入时间',
        importOptId INT(8) unsigned NOT NULL COMMENT '录入人员',
        PRIMARY KEY (touristId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='游客明细';

--游客门票
CREATE TABLE
    tourist_ticket
    (
        ticketId INT(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '游客门票ID',
        orderId INT(8) unsigned NOT NULL COMMENT '订单ID',
        orderNo VARCHAR(16) NOT NULL COMMENT '订单编号',
        visitDate DATETIME NOT NULL COMMENT '入园日期',
        touristId INT(8) unsigned COMMENT '游客明细ID',
        contactName VARCHAR(64) COMMENT '联系人名称',
        contactTel VARCHAR(16) COMMENT '联系人电话',
        contactEmail VARCHAR(32) COMMENT '联系人邮箱',
        pnr VARCHAR(8) NOT NULL COMMENT '小编码',
        bigPnr VARCHAR(8) NOT NULL COMMENT '大编码',
        platOrderNo VARCHAR(32) COMMENT '平台订单编号',
        planeTicketNo VARCHAR(32) COMMENT '出票票号',
        ticketingTime DATETIME COMMENT '出票时间',
        ticketingOptId INT(8) unsigned COMMENT '出票人员',
        glaCode VARCHAR(32) COMMENT 'GLA编码',
        status CHAR(1) DEFAULT '0' NOT NULL COMMENT '状态[0：已取消；1：已支付；2：已出票]',
        createTime DATETIME NOT NULL COMMENT '下单时间',
        createOptId INT(8) unsigned NOT NULL COMMENT '下单人员',
        PRIMARY KEY (ticketId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='游客门票';

--占座明细
CREATE TABLE
    occupy_detail
    (
        occupyId INT(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '占座明细ID',
        pnr VARCHAR(8) NOT NULL COMMENT '小编码',
        bigPnr VARCHAR(8) NOT NULL COMMENT '大编码',
        orderId INT(8) unsigned NOT NULL COMMENT '订单ID',
        orderNo VARCHAR(16) NOT NULL COMMENT '订单编号',
        visitDate DATETIME NOT NULL COMMENT '入园日期',
        occupyName VARCHAR(64) NOT NULL COMMENT '游客名称',
        idcType CHAR(1) NOT NULL COMMENT '证件类型',
        idcNo VARCHAR(32) NOT NULL COMMENT '证件号码',
        telephone VARCHAR(16) NOT NULL COMMENT '联系电话',
        email VARCHAR(32) NOT NULL COMMENT '邮箱',
        contactName VARCHAR(64) COMMENT '联系人名称',
        contactTel VARCHAR(16) COMMENT '联系人电话',
        contactEmail VARCHAR(32) COMMENT '联系人邮箱',
        occupyNum SMALLINT(4) unsigned NOT NULL COMMENT '占位数',
        status CHAR(1) DEFAULT '0' COMMENT '状态[0：已取消；1：待使用；2：订单取消异常；3：PNR取消异常]',
        platOrderNo VARCHAR(32) NOT NULL COMMENT '平台订单编号',
        occupyTime DATETIME NOT NULL COMMENT '占位时间',
        cancelTime DATETIME COMMENT '取消时间',
        PRIMARY KEY (occupyId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='占座明细';

--门票库存信息
CREATE TABLE
    ticket_stock
    (
        stockId INT(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '库存ID',
        visitDate DATETIME NOT NULL COMMENT '入园日期',
        stock SMALLINT(5) unsigned NOT NULL COMMENT '库存',
        checkTime DATETIME NOT NULL COMMENT '校验时间',
        PRIMARY KEY (stockId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='门票库存信息';

--行程信息
CREATE TABLE
    trip
    (
        tripId INT(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '行程ID',
        departAirportCode CHAR(3) NOT NULL COMMENT '出发机场三字码',
        arriveAirportCode CHAR(3) NOT NULL COMMENT '到达机场三字码',
        airlineCode CHAR(2) NOT NULL COMMENT '航司二字码',
        flightNo VARCHAR(6) NOT NULL COMMENT '航班号',
        DepartTime VARCHAR(5) NOT NULL COMMENT '出发时间',
        ArriveTime VARCHAR(5) NOT NULL COMMENT '到达时间',
        cabinArray VARCHAR(32) NOT NULL COMMENT '符合条件仓位数组',
        PRIMARY KEY (tripId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='行程信息';

--乘客信息
CREATE TABLE
    passenger
    (
        passengerId INT(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '乘客ID',
        name VARCHAR(16) NOT NULL COMMENT '乘客名称',
        idcType CHAR(1) NOT NULL COMMENT '证件类型',
        idcNo VARCHAR(32) NOT NULL COMMENT '证件号码',
        tel VARCHAR(16) COMMENT '手机号',
        email VARCHAR(64) COMMENT '邮箱',
        PRIMARY KEY (passengerId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='乘客信息';

--操作员信息
CREATE TABLE
    operator
    (
        optId INT(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '操作员ID',
        optNo VARCHAR(16) NOT NULL COMMENT '操作员账号',
        password VARCHAR(64) DEFAULT '000000' COMMENT '密码',
        optName VARCHAR(32) COMMENT '操作员名称',
        gender CHAR(1) COMMENT '性别',
        tel VARCHAR(16) COMMENT '手机号',
        pictureUrl VARCHAR(128) COMMENT '头像URL',
        status CHAR(1) DEFAULT '0' COMMENT '状态[0：正常；9：注销]',
        crtOptId INT(8) unsigned NOT NULL COMMENT '创建人ID',
        crtTime DATETIME NOT NULL COMMENT '创建时间',
        PRIMARY KEY (optId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='操作员信息';















