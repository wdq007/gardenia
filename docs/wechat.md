# Java微信公众号开发

## About wechat

### Wechat Message

[wechat message](https://developers.weixin.qq.com/doc/offiaccount/en/Message_Management/Receiving_standard_messages.html)


### 
现微信给我们制定了两种模式，一种是开发者模式（也就是我们一直在做的开发），还有一种模式是编辑模式，然而很蛋疼的是有些功能一旦我们切换到开发者模式下就无法使用了，比较典型的就是关键字回复以及服务器无响应的时候返回的【服务器无法响应】等问题 ，这里我给出的解决方案是：①对关键字给出关键字回复的代码实现；②【服务器5s无响应】解决方案是接入多客服，以方便我们的消息处理！


## springboot框架开发微信公众号

### 参考资料

[崔用志博客](http://www.cuiyongzhi.com/tags-1.html)， [也可以在极客学院看到：http://wiki.jikexueyuan.com/project/java-wechat/1.html](http://wiki.jikexueyuan.com/project/java-wechat/1.html)

[源码参考](https://github.com/cyzh/wechat)

[WxJava - 微信开发 Java SDK（开发工具包）](https://github.com/Wechat-Group/WxJava.git) 

[Binary Wang](https://github.com/binarywang)

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
