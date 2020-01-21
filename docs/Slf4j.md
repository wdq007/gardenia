# 使用@Slf4j的正确方法
https://blog.csdn.net/cslucifer/article/details/80953400

在pom中添加上面的所有依赖，很多教程里都只说添加lombok依赖就行了，
其实不然。总共还需要slf4j以及它的实现，这里我选择了logback，其他的实现也是可以的。除此之外，还需要安装一个lombok插件，