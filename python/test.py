import numpy as np

'''
ndarray 随机创建
'''
# 生成指定维度大小 3行4列 的随机多维浮点型数据(二维数组) ,rand固定区间
arr = np.random.rand(3, 4)
print(arr)
print(type(arr))  # 数据类型 矩阵 ndarray
print(arr.ndim)  # 矩阵维度 二维
print(arr.shape)  # 维度大小 3*4

# 生成指定维度大小 3行4列 随机多维浮点类型数据 randint可以指定区间
print('---------------------')

arr2 = np.random.randint(-1, 5, size=(3, 4))
print(arr2)
print(type(arr2))

# 生成指定维度大小 3行4列 的随机多维浮点型数据 ,uniform()指定区间 uniform 产生实数:有理数和无理数的总称,也就是包含小数
print('---------------------')

arr3 = np.random.uniform(-1, 5, (3, 4))
print(arr3)
print(type(arr3))

'''
ndarray 序列创建
'''
# list 序列转换为 ndarry
print('---------------------')
print('list 序列转换为 ndarry')
lis = range(10)
arr5 = np.array(lis)

print(arr5)
print(arr5.ndim)
print(arr5.shape)
# list of list 嵌套序列转换为ndarray
print('---------------------')
list_list = [range(10), range(10)]
arr2 = np.array(list_list)

print(arr2)
print(arr2.ndim)
print(arr2.shape)  # 维度大小 2行10列