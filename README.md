便捷校园项目
一、技术栈及框架
1、前端：vue

2、后端，spring boot、mybatis、MySQL数据库。

二、实现的基本功能
1、这一项目主要是面向学习群体，主要实现了学习资源（包括文件，视频）的发布和下载功能，同时提供评论功能，通过问题的发布和评论形成一个学习区。

2、其次，我们在同层次下有一个悬赏区，用于学习问题和生活问题的悬赏发布，提供即时通信功能进一步和发布者进行交流（因时间问题，暂时没有实现聊天功能）。

3、最后实现的便是基本的登录注册，以及查看搜索的基本功能。在实现注册功能的时候我们使用了邮箱验证，注册成功之后便可通过用户账号和用户邮箱进行登录。

三、实际部署
此项目部署服务器只有一个难点：文件资源的存储和访问。我们在进行这个项目开发的时候对文件资源的处理主要是存放项目的静态资源底下，当我们将spring boot打成jar包部署到服务器上的时候，就必须对静态资源进行处理，我们在jar包的同级目录下新建文件夹作为我们的静态资源区,文件夹的命名根据配置文件的配置为参照（此项目为static），在spring boot项目的application.properties文件中进行如下设置：

#你需要在application.yml配置中加入以下代码，指定两个静态资源的目录，这样你上传的文件就能被外部访问到了。
spring.web.resources.static-locations=classpath:static/,file:static/

server.tomcat.basedir=static/tomcat

项目地址：cccccjy.top/dist
测试账号：28653800
密码：123

可以通过此账号查看项目的具体功能。

四、功能展示
1、新闻主页：
![Screenshot_2021_0312_232526](https://user-images.githubusercontent.com/56211207/110971268-9d752d00-8395-11eb-8e5b-41e7bcfcfe18.jpg)
2、新闻详情页：
![Screenshot_20210312_232504](https://user-images.githubusercontent.com/56211207/110971293-a534d180-8395-11eb-9460-7f2058dd618d.jpg)
3、点击头像，用户主页，可以查看用户信息，发布的悬赏内容和学习内容、文件、视频等资源；同时可以发布，删除数据
![Screenshot_2021_0313_000918](https://user-images.githubusercontent.com/56211207/110971457-e200c880-8395-11eb-86e0-f8a8a2aa3553.jpg)
4、小帮手，可以查看并且根据关键词和用户名搜索悬赏和学习区信息
![Screenshot_2021_0313_000525](https://user-images.githubusercontent.com/56211207/110971559-fe9d0080-8395-11eb-8093-aaa861dfaf23.jpg)

![Screenshot_20210312_232540](https://user-images.githubusercontent.com/56211207/110971682-24c2a080-8396-11eb-951d-63b34ba029c2.jpg)

5、悬赏信息详情，学习区同理
![Screenshot_20210313_000508](https://user-images.githubusercontent.com/56211207/110971633-13799400-8396-11eb-858c-74d211f6e4d8.jpg)
6、我的一栏可以修改信息，上传头像：
![Screenshot_2021_0313_005127](https://user-images.githubusercontent.com/56211207/110971810-4a4faa00-8396-11eb-8752-1f7255387fea.jpg)
