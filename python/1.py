# 1）.现有学员姓名的字符串names="张三,李四,王五,赵六,孙七,周八"，将字符串中的每个姓名做为key并获取随机数0-100（包含0和100）做为代表成绩的value，存入字典。
# 2）.遍历字典将成绩大于等于60的学员信息写入根目录下的data.txt文件，写入格式如下：
# 张三-82
# 王五-63
# 周八-66
import random
import os
name = "张三,李四,王五,赵六,孙七,周八"
l=name.split(',')
dict1={}
for i in l:
    print(i)
    num=random.randint(0,100)
    dict1[i]=num
print(dict1)
f = os.open('data.txt','w')
for i,j in dict1.items():
    if j>60:
        print(f'{i}:{j}')
