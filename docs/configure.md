# Configure



##  接入微信，成为微信开发者 
https://blog.csdn.net/weixin_42172528/article/details/86078942

验证微信消息
触发微信给后台发送请求

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
https://blog.csdn.net/qq_40715775/article/details/79878757

用户发送的信息是先传送到微信服务器，微信服务器在以xml的格式发送给进行公众号