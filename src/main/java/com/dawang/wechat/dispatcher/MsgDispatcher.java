package com.dawang.wechat.dispatcher;

import java.util.Date;
import java.util.Map;

import com.dawang.wechat.util.MessageUtil;
import com.dawang.wechat.message.resp.*;

/**
 * ClassName: MsgDispatcher
 * @Description: 消息业务处理分发器
 * @author dapengniao
 * @date 2016 年 3 月 7 日 下午 4:04:21
 */
public class MsgDispatcher {
    public static String processMessage(Map<String, String> map) {
    	String openid=map.get("FromUserName"); //用户 openid
    	String mpid=map.get("ToUserName");  
    	
    	TextMessage txtmsg=new TextMessage();
    	txtmsg.setToUserName(openid);
    	txtmsg.setFromUserName(mpid);
    	txtmsg.setCreateTime(new Date().getTime());
    	txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
            System.out.println("==============这是文本消息! "+openid);
            txtmsg.setContent("来自 "+openid+" 的朋友， "+"你好，这里是"+mpid+"(dawang)的账号！");
            return MessageUtil.textMessageToXml(txtmsg);
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
            System.out.println("==============这是图片消息！"+map.get("PicUrl"));
            ImageMessage imgMsg = new ImageMessage();
            Image img = new Image();
            img.setMediaId(map.get("MediaId"));
            imgMsg.setImage(img);
            imgMsg.setToUserName(openid);
            imgMsg.setFromUserName(mpid);
            imgMsg.setCreateTime(new Date().getTime());
            imgMsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_IMAGE);
           
            imgMsg.setMsgType("image");
           
            return MessageUtil.imageMessageToXml(imgMsg);
            
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
            System.out.println("==============这是链接消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
            System.out.println("==============这是位置消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
            System.out.println("==============这是视频消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
            System.out.println("==============这是语音消息！");
        }

        return null;
    }
}