# ndarray 多维数组 N Dimension Array
'''
numpy数组是一个多维的数组对象,称为ndarray,具有矢量算数运算能力和复杂的广播能力
并具有执行速度快和节省空间的特点
ndarray的下标从0开始,且数组里的所有元素必须是同类型的

ndarray 拥有的属性
1.ndim 维度个数
2.shape 维度大小
3.dtype 数据类型
'''

import numpy
import csv
import copy
import scipy


def isnumber(aString):
    try:
        float(aString)
        return True
    except:
        return False


if __name__ == '__main__':

    filename = 'C:\\Users\\86183\\Desktop\\111\\allGennerdata.csv'
    filename1 = 'C:\\Users\\86183\\Desktop\\111\\moneyMatrix.csv'
    list1 = []
    ic = 0
    with open(filename)as f:
        reader = csv.reader(f)
        for row in reader:
            for i in row:
                arr = i.split(',')
                list2 = []
                for index in arr:
                    # print(index, end="  ")
                    ic += 1
                    if isnumber(index):
                        list2.append(float(index))
                # print(ic) #检查每一行有多少列
                ic = 0
                list1.append(list2)
    list3 = []  # 结果列表
    with open(filename1) as f:
        r = csv.reader(f)
        for i in r:
            for ii in i:
                list3.append(float(ii))
    arr = numpy.array(list1)  # 常数矩阵
    arr2 = numpy.array(list3)  # 结果矩阵
    index = 0
    # print(len(list1[0]))
    list4 = copy.deepcopy(list1)  # 传递列表,因为为可变类型会修改参数矩阵的值,所以拷贝一份 普通copy对嵌套列表无效,所以用deepcopy方法
    for i in list4:
        i.append(list3[index])
        index += 1
    arr_all = numpy.array(list4)
    matrix_1 = numpy.mat(arr)
    matrix_2 = numpy.mat(arr2)
    # print(len(list4[0]))
    # print(len(list1[0]))

    end = numpy.linalg.matrix_rank(matrix_1)  # 求矩阵的秩,当系数矩阵的秩小于增广矩阵的秩时,无解,等于的时候有唯一解,大于的时候有无穷多解
    end2 = numpy.linalg.matrix_rank(matrix_1, matrix_2)
    end3 = numpy.linalg.matrix_rank(arr_all)
    print(end)  # 83
    print(end3)  # 84

    # jie = numpy.linalg.solve(matrix_1, matrix_2) #必须保证martix_1是方阵才可以
    # jie = numpy.linalg.lstsq(arr_all, matrix_2)[0]  # svd numpy.linalg.LinAlgError: Incompatible dimensions
    jie = scipy.linalg.pinv(matrix_1)
    pia = jie.dot(matrix_2)
    print(jie)
    print(pia)
