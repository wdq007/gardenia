package com.dawang.wechat;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dawang.wechat.util.MessageUtil;
import com.dawang.wechat.util.SignatureUtil;
import com.dawang.wechat.dispatcher.EventDispatcher;
import com.dawang.wechat.dispatcher.MsgDispatcher;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping(value="/dawang")

public class WxController {
	@Autowired
    private MyProperties myp;
	@Autowired
    private HttpServletResponse response;
	
	@GetMapping(produces = "text/plain;charset=utf-8",value = "/{appid}")
	public void wxGet(@PathVariable String appid,
            @RequestParam(name = "signature", required = false) String signature,
            @RequestParam(name = "timestamp", required = false) String timestamp,
            @RequestParam(name = "nonce", required = false) String nonce,
            @RequestParam(name = "echostr", required = false) String echostr) throws Exception {
		
		log.info(echostr);
		log.info(signature);
		log.info(timestamp);
		log.info(nonce);
		String note = "dawang";
		log.info(myp.getAppid());
		if (SignatureUtil.checkSignature(signature, timestamp, nonce)) {
			  // 随机字符串
            log.info("接入成功，echostr {}", echostr);
            this.response.getWriter().write(echostr);
            
        }
		}
	//@RequestMapping(value = "wx8ee3c7b701e38f2e", method = RequestMethod.POST)
    // post 方法用于接收微信服务端消息
	@PostMapping(produces = "text/plain;charset=utf-8",value = "/{appid}")
    public void doPost(
    		@PathVariable String appid,
    		HttpServletRequest request,HttpServletResponse response) {
        System.out.println("==========进入 post 方法！==============================");
        try{
       
        Map<String, String> map=MessageUtil.parseXml(request);
        String msgtype=map.get("MsgType");
        System.out.println("======msgtype: "+msgtype+"=======");
        if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)){
        	String respXML = EventDispatcher.processEvent(map); //进入事件处理
        	PrintWriter out = response.getWriter();
        	out.print(respXML);
        	out.flush();
        	out.close();
        }else{
        	response.setCharacterEncoding("utf-8");
        	String respXML = MsgDispatcher.processMessage(map); //进入消息处理
        	PrintWriter out = response.getWriter();
        	out.print(respXML);
        	out.flush();
        	out.close();
        	
        }
        System.out.println("==========发给公众号： "+appid+" 的消息===================\n"+map.get("Content"));
        }catch(Exception e){
            log.error(e.toString(),e);
        }
    }
		


}

