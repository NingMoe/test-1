package org.flyingmemory.message.resp;

/**
 * Title:文本消息
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2013-12-01
 * 
 * Company: Shanghai allinfinance Co., Ltd.
 * 
 * author: 徐鹏飞
 *  
 * time: 2015年3月3日下午4:28:16
 * 
 * version: 1.0
 */
public class TextMessage extends BaseMessage {  
    // 回复的消息内容  
    private String Content;  
  
    public String getContent() {  
        return Content;  
    }  
  
    public void setContent(String content) {  
        Content = content;  
    }  
}
