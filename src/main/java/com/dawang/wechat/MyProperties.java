package com.dawang.wechat;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import lombok.Data;

@Component
@ConfigurationProperties(prefix = "wechat")
@Data
//@Primary
public class MyProperties {
	private String appid;
	private String appsecret;
	
}
