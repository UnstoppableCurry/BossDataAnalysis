# BossDataAnalysis
![image](https://user-images.githubusercontent.com/65523997/230296246-aeed227d-95b5-4eff-835e-fa10d3be580f.png)
![image](https://user-images.githubusercontent.com/65523997/230296359-00b8b910-5be1-4251-a8c4-004604866f9e.png)
![image](https://user-images.githubusercontent.com/65523997/230296942-3e502218-4c7d-4ae6-b0a4-e90aa0db816d.png)
![image](https://user-images.githubusercontent.com/65523997/230297100-a1ee0319-f57d-4628-a30c-49e9d266ff48.png)
- hashTF工具使用
	- 算法
		- 创建一个document.length长度的稀疏矩阵,按照hashcode 进行数据存储,在数据量大时有意义,但当数据量比较小时没必要用,因为调用这个方法会丢失变量与hashcode的映射关系,并且无法解决哈希冲突
	- mlib 基于rdd做计算
	- ml 基于dataFrame做计算,抽象层级更高
|[硕士, 深度, 学习, 算法, ...|(1048576,[28698,7...|
|[硕士, 深度, 学习, 算法, ...|(1048576,[73080,9...|
- 相同的值,hashcode不同
	- string类型和stringbuilder的差异
		- String是char[]数组存放
		- 返回hashcode的时候是每一位字符的ascll码乘31
		- 传入时因为长度不一致,即使ascll码相同但hashcode 不同

 - 视频教程
  - https://www.bilibili.com/video/BV1Kh41167mS?p=1&vd_source=291a370896a189f23083e981b5fb49b5
 - 全部代码与连接
  - 链接：https://pan.baidu.com/s/1czBsipp3JmWcAhFxmfkIjQ 提取码：ma2q 

这个项目通过Java-Scala实现基本的数据挖掘
项目初衷有三个
 - 1.自己也是程序员,希望通过这个项目能帮助程序员们很好了解IT行业市场行情,不要被996.007压榨,同时能根据标签很好的衡量自身价值
 
 - 2.帮助未来希望程序员的同学们,通过项目的学习可以很好的认知IT行业,选择自己将要学习的技术栈是什么,并且深刻的知道自己学完值多少钱,而不听教育机构的忽悠自己没有认知
 
 - 3.是帮助需要写毕设的同学,希望你们通过学习这个项目体验到编程的快乐,做一些真正有意义的事情,而不是为了毕业而毕业
