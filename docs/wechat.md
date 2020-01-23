# Java微信公众号开发

## About wechat

### 参考资料

[崔用志博客]http://www.cuiyongzhi.com/tags-1.html, 
[也可以在极客学院看到：] http://wiki.jikexueyuan.com/project/java-wechat/1.html

[源码参考]https://github.com/cyzh/wechat

[WxJava - 微信开发 Java SDK（开发工具包）] https://github.com/Wechat-Group/WxJava.git 

[Binary Wang] https://github.com/binarywang

##  接入微信，成为微信开发者 

https://blog.csdn.net/weixin_42172528/article/details/86078942

验证微信消息, 触发微信给后台发送请求.用户发送的信息是先传送到微信服务器，微信服务器在以xml的格式发送给进行公众号

接收到的参数为
signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
timestamp	时间戳
nonce	随机数
echostr	随机字符串

我们需要验证signature
- 将token、timestamp、nonce三个参数进行字典序排序
- 将三个参数字符串拼接成一个字符串进行sha1加密
- 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信

## 消息的接受与响应

[wechat message](https://developers.weixin.qq.com/doc/offiaccount/en/Message_Management/Receiving_standard_messages.html)


https://blog.csdn.net/qq_40715775/article/details/79878757


### 关键字回复以及客服接口实现（该公众号暂时无法提供服务解决方案）

[关键字回复以及客服接口实现（该公众号暂时无法提供服务解决方案）] http://www.cuiyongzhi.com/post/47.html "崔用志博客"

[多客服的相关使用和下载] http://mp.weixin.qq.com/wiki/11/f0e34a15cec66fefb28cf1c0388f68ab.html 
"微信开发"

微信给我们制定了两种模式，一种是开发者模式（也就是我们一直在做的开发），还有一种模式是编辑模式，
然而很蛋疼的是有些功能一旦我们切换到开发者模式下就无法使用了，
比较典型的就是关键字回复以及服务器无响应的时候返回的【服务器无法响应】等问题。

解决方案是：①对关键字给出关键字回复的代码实现；②【服务器5s无响应】解决方案是接入多客服，以方便我们的消息处理！

（一）关键字自动回复


首先获取到消息文本的内容content，然后更具获取content去匹配自己需要设定的关键字，然后根据匹配到的不同结果给出不同的消息回复


（二）该公众号暂时无法提供服务解决方案——多客服接口使用

①直接给微信服务器回复【空】，注意这里是直接回复空而不是回复内容为空！
