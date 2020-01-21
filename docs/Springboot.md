# Springboot


@PathVariable注解使用
https://blog.csdn.net/sswqzx/article/details/84194979

springboot获取application.yml中的配置信息

http://www.mamicode.com/info-detail-2255070.html
通过@Autowired 把bean的内容自动把yml装配起来
如何定义bean
@Component
@ConfigurationProperties(prefix = "wechat")
@Data
可以有层级关系@ConfigurationProperties(prefix = "wechat.config")

# SpringBoot之Controller使用

项目前后台交互的话 无非两种方式
- 一种普通整体页面提交，比如form提交；
- 还有一种局部刷新，或者叫做异步刷新，ajax提交；

@Controller就是整体页面刷新提交的处理注解

Spring4之后新加入的注解，原来返回json需要@ResponseBody和@Controller配合。
@RestController就是ajax提交，一般返回json格式，相当于我们经常使用的@ResponseBody配合@Controller组合

@GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。该注解将HTTP Get 映射到 特定的处理方法上。

@Controller必须配合模版来使用。src/main/resources 下有个templates 目录，这里就是让我们放模版文件的

spring-boot 支持多种模版引擎包括： 
1. FreeMarker 
2. Groovy 
3. Thymeleaf （Spring 官网使用这个） 
4. Velocity 
5. JSP

当控制器在类级别上添加@RequestMapping注解时，这个注解会应用到控制器的所有处理器方法上。处理器方法上的@RequestMapping注解会对类级别上的@RequestMapping的声明进行补充。 

