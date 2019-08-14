---
title: Git
tags: 编码
---

​在前几天华为发布鸿蒙系统时，它的定义是微内核、分布式操作系统。鸿蒙系统基于“微内核”，也就是micro kernel，这个是与目前主流面向个人端的操作系统完全不同的内核理念。微内核并非新鲜事物，几十年前就有人提出并进行应用了。

关于微内核，在2011年LinuxFR对Linux的创始人Linus Torvalds进行了采访，显然作为目前应用最为广泛的开源操作系统的创始人，从他的角度看，微内核并不是理想的技术形式。

-------

　　LinuxFR：你对微内核的看法是什么?你仍然认为它是一个技术失败吗?

　　Linus Torvalds：是的，我仍然认为这些想法只是听起来不错，纸上谈兵罢了，在现实中必将会失败，因为现实中真正复杂的是在交互，而不是独立的模块。

　　微内核宣扬的是产生更多独立的模块，使交互更曲折和复杂，最终会削减掉大量的直接通信渠道。

-------

微内核的大致思想其实类似于微服务，前几天有一篇微服务的文章可以参考一下，其大致目的在于将系统功能细化，从根本上看是为了系统的可扩展性，其有优也有劣。

而鸿蒙的另一个要点，`分布式系统`就是我们今天的主题，今天我要介绍的就是一款分布式应用系统！

全球最大同性交友网站！

GitHub!

早在我初学编程时，对我最重要的就是我敲得那些惨不忍睹的c语言代码。我甚至买了一个1T的移动硬盘把他们存了下来，还每天说一些奇奇怪怪的话，什么“这些代码没了我就转专业了”“这个硬盘丢了我就不学计算机了”。

直到有一天，我遇到了这个网站。

首先去申请一个GitHub账号

![1](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_1.png)

填写用户名邮件地址和密码完成验证，之后选择身份和兴趣领域即可。

那么就开始GitHub开源之旅吧！

首先下载GitHub Bash。

[https://desktop.github.com/](https://desktop.github.com/)

安装后其实有Bash和GUI两种，一个是命令行版的，一个是有图形化界面的，相对来说我喜欢命令行Bash来操作。

![3](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_3.png)

从这张图来看，CS-Node是我在GitHub上的一个公开仓库，后面的`master`就是指分支名称。

后面的`git status`命令，就是指出你改动的文件。

让我们从头开始，创建的公开的仓库。

![4](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_4.png)

点击`New repository`新建一个仓库。

![5](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_5.png)

填写仓库的信息。

`Repository name`是仓库的名称。

`Description`是对此仓库的描述。

`Public/Private`是指仓库是公开还是私有，这会决定其他人能不能看到这个仓库。

`Initialize this repository with a README`这个选项是指是否初始化`README.md`文件，一般勾选上。

`Add .gitignore`是该仓库使用的编程语言标签。

`Add a license`是该项目使用的开源协议。

##### 各类协议的区别

| 协议 | 描述 | 要求 | 允许 | 禁止 |
| -------- | -------- | -------- | -------- | -------- |
| Apache | 一个较宽松且简明地指出了专利授权的协议。| 协议和版权信息、声明变更 | 商用、分发、修改、专利授权、私用、附加协议 | 责任承担（禁止让作者承担责任，可以理解为免责）、商标使用 |
| GPL | 此协议是应用最为广泛的开源协议，拥有较强的版权自由( copyleft )要求。衍生代码的分发需开源并且也要遵守此协议。此协议有许多变种，不同变种的要求略有不同。 | 公开源码、协议和版权信息、声明变更 | 商用、分发、修改、专利授权、私用 | 责任承担、附加协议 |
| MIT | 宽松简单且精要的一个协议。在适当标明来源及免责的情况下，它允许你对代码进行任何形式的使用。 | 协议和版权信息 | 商用、分发、修改、私用、附加协议 | 责任承担 |
| Artistic | Perl社区尤为钟爱此协议。要求更改后的软件不能影响原软件的使用。 | 协议和版权信息、声明变更 | 商用、分发、修改、私用、附加协议 | 责任承担、商标使用 |
| BSD | 较为宽松的协议，包含两个变种BSD 2-Clause 和BSD 3-Clause，两者都与MIT协议只存在细微差异。 | 协议和版权信息 | 商用、分发、修改、私用、附加协议 | 责任承担 |
| Eclipse | 对商用非常友好的一种协议，可以用于软件的商业授权。包含对专利的优雅授权，并且也可以对相关代码应用商业协议。 | 公开源码、协议和版权信息 | 商用、分发、修改、专利授权、私用、附加协议 | 责任承担 |
| LGPL | 主要用于一些代码库。衍生代码可以以此协议发布（言下之意你可以用其他协议），但与此协议相关的代码必需遵循此协议。 | 公开源码、库引用、协议和版权信息 | 商用、分发、修改、专利授权、私用、附加协议 | 责任承担 |
| Mozilla | Mozilla Public License(MPL 2.0)是由Mozilla基金创建维护的。此协议旨在较为宽松的BSD协议和更加互惠的GPL协议中寻找一个折衷点。 | 公开源码、协议和版权信息 | 商用、分发、修改、专利授权、私用、附加协议 | 责任承担、商标使用 |
| No license | 你保留所有权利，不允许他人分发，复制或者创造衍生物。当你将代码发表在一些网站上时需要遵守该网站的协议，此协议可能包含了一些对你劳动成果的授权许可。比如你将代码发布到GitHub，那么你就必需同意别人可以查看和Fork你的代码。 | 协议和版权信息 | 商用、私用 | 分发、修改、附加协议 |
| Public domain dedication | 在许多国家，默认版权归作者自动拥有，所以Unlicense协议提供了一种通用的模板，此协议表明你放弃版权，将劳动成果无私贡献出来。你将丧失对作品的全部权利，包括在MIT/X11中定义的无担保权利。 | N/A | 商用、分发、修改、私用 | 责任承担 |

接下来就可以开始上传我们的代码了！

![6](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_6.png)


复制`Clone or download`中的git链接。

在`Git Bash`中使用`clone`命令将仓库克隆下来。

![7](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_7.png)

接下来加入仓库文件夹，使用`git branch`命令查看当前的分支。

![8](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_8.png)

关于已有的分支，你可以用命令查看，也可以在仓库的左上角点击查看并且切换，分支就类似于不同的版本，相互之间并不影响。当a分支修改完之后，你可以新建一个`Pull Request`将它合并到master主分支中。这是Git非常重要的一个功能！

![9](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_9.png)

我们可以用`git branch [分支名称]`的方式新建一个分支，也可以使用`git branch`查看已有的分支，可以用`git checkout [分支名称]`命令来切换分支。

注意观察后面蓝色括号内的当前分支的变化。

![10](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_10.png)

我们编辑仓库内的代码之后，现在需要将代码同步到GitHub仓库。先使用`git status`命令查看更改了的文件。

然后使用`git add [文件名]`将文件添加进提交，文件多时可以使用`.`来代替所有。

接着`git commit -m 描述信息`，在commit提交时，添加一段你对本次提交的描述，接着就可以push了，命令格式基本是`git push origin [分支名称]`。因为我的当前分支是`x-resource-2019`，所以这里就用了这个名称而不是push到master。

![11](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_11.png)

你的push可能会出现问题，这是因为没有配置sshkey，可以在Bash中直接输入`ssh-key`，接着一直回车即可。

![sshkey](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_sshkey.png)

然后在C盘User目录的`.ssh`文件夹中用`cat`命令打印key的值。将它们复制之后，在[GitHub个人设置](https://github.com/settings/keys)中。点击`New SSH key`将它那段字符串添加进去即可。

![pub](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_pub.png)

接着打开GitHub上的仓库，可以发现这里能看到某一个分支的push变动。 点击`Compare&Pull request`，

![12](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_12.png)

选择要将哪个分支合并到哪个分支，然后点击`Create Pull Request`即可。

![13](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_13.png)

若是自己的仓库，可以直接在这个`Pull Request`页面中点击`Merge Pull Request`来合并这个请求，这样你的新分支就会成功合并到主分支了！

![13](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_14.png)

上图中的`commits`是指我们之前commit的记录，`Files Changed`是非常强的功能，它可以看到我们项目文件的具体变动内容。

![15](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_15.png)

在这里，左边是上一个版本，右边是你的修改，红色代表删除的行，绿色代表新增加的行，如果是多人协同开发，当你看完别人的`Pull Request`的`Files Changed`之后，觉的没问题就可以点一下`Review Change`中的`Approve`来代表你看过这个修改并且同意了，还有`Comment`等选项来提出建议。

![16](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_16.png)

`Merge`之后，这个请求就会变成紫色了，这说明它成功通过了。`x-resource-2019`成功合并到了`master`中。

这就是一个完整的提交流程了。

另外还有一些比较重要的命令，在Bash中，我们可以使用`git diff`看到每次修改的详细内容。

`git diff --stat`用来查看每个文件的增加和删除行数。

![17](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_17.png)

`git diff`可以查看尚未`git add`的文件改动。

`git diff --cached`可以查看已经`git add`缓存了的文件的改动。

![17](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_19.png)

对于一些已经`git add`了的文件，如果你想要撤销，可以使用`git reset HEAD/文件名`来将文件从缓存中取消。

`git reset HEAD`是对全体add过的进行撤销。

`git reset 文件名`是对某个文件进行撤销。

另一个命令是关于查看历史commit的。

`git log`，这个命令可以列出历史的commit记录。每个commit后面都有一个散列码，可以用这个字符串来进行版本回退。

![17](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_20.png)

还可以用`--oneline`选项来查看历史记录的简洁的版本。

![17](https://www.cnblogs.com/images/cnblogs_com/LexMoon/1524728/o_21.png)

使用`--graph`还可以将分支的合并切出状态直接以图形的方式显示出来。

如果你的仓库现在处于一个重要的修改版本，你可以用`git tag -a [版本]`命令给它打上一个版本的标签。


学完这些，你就可以开始寻找你感兴趣的开源项目，并且为其贡献自己的代码，拉取你的第一个合并分支请求了！