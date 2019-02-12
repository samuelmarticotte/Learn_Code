#!/Library/Frameworks/Python.framework/Versions/3.7/bin/python3
# To compile: python ./name.py
# For libraries: pipenv install <package>
# pip install pyfiglet / conda install -c conda-forge pyfiglet

from pyfiglet import Figlet  # banners
import numpy as np
import csv
from nltk.stem import WordNetLemmatizer

#--------------------------------------------------UTILITY FUNCTIONS----------------------------
def Banner(text):
    banner = Figlet(font='slant')
    print(banner.renderText(text))

def welcome():
    Banner('Program')
    print('Usage: program [option]')

def goodbye():
    Banner('GoodBye')
    exit()

def t(t):
    print('\033[1;33m---------------%s---------------\033[1;m\n' % t)

def p(p):
    print(p);
#--------------------------------------------------UTILITY FUNCTIONS-----------------------------

import scrapy
Banner("Welcome Numpy and Scipy!!")

t("Building an array")
x = [1,2,5,7,3,11,14,25]
np_arr = np.array(x)
p(np_arr)

t("Let'S build a 2D array")
arr=[[1,2],[13,4],[33,78]]
np_2darr=np.array(arr)
type(np_2darr)
p(np_2darr)

t("Let's slice the array to a list")
p(np_2darr.tolist())

t("Let's show only the two first rows of the array")
p(np_2darr[:2])

t("Let's refer to the third row's first column [2][0]")
p(np_2darr[2][0]) #third row, first column=33

t("Let's create an array by steps of 0.1")
p(np.arange(0.0,1.0,0.1))

t("p Ones")
p(np.ones([1,4]))

t("p zeros")
p(np.zeros([3,4]))

t("Even number evenly spaced")
p(np.linspace(0,2,10))

t("Log space")
p(np.logspace(0,1))

t("More specific logspace")
p(np.logspace(0, 10, num=10, endpoint=True, base=10.0, ))

t("Let's manipulate arrays")
A = np.array([[0,0,0],[0,1,2],[0,2,3],[0,3,6]])
B= np.array([[0,2,7],[1,1,3],[4,9,3],[1,3,5]])
p("matrix A\n")
p(A)
p("\nmatrix B\n")
p(B)


t("p less than 3 in matrix B")
less_than_3 = B<3
p(less_than_3)

t("Let's than 3 in matrix B becomes zero")
p("======Before======")
p(B)
p("======After======")
B[less_than_3] = 0
p(B)

t("Let's get the diagonal of a matrix")
diag_A = np.diag(A)
p(diag_A)

t("Dot product of matrix A by A")
A = np.array([[1,2],[3,4]])
dot_product_A = np.dot(A,A)
print(dot_product_A)

t("'Matix A minus Matrix A ")
print((A-A))

t("Matix A plus Matrix A")
print((A+A))

t("Transpose of matrix A")
p("====Before===")
print(A)
p("====After====")
print(A.T)

t("Basic min, max, mean operations on matrix")
N = np.random.randn(1,10)
p("Random matrix:")
print(N)
mean_N = N.mean()
p("Mean of N")
print(mean_N)
p("Average of N")
avg_N = N.std()
print(avg_N)

t("Reshapig and restacking matrices")
p("Matrix A")
p(A)

(r,c) = A.shape
p("Shaped")
print(r,c)

p("Reshaped A")
reshaped_A = A.reshape((1,r * c))
print(reshaped_A)

p("Flattened matrix A")
flattened_A= A.flatten()
p(flattened_A)

p("Repeated array")
repeat_A = np.repeat(A,2)
print(repeat_A)

p("Tile() a matrix")
tiled_A = np.tile(A,4)
p(tiled_A)

p("Concatenate arrays")
B = np.array([[5,6],[7,8]])
concatenated_A = np.concatenate((A,B), axis=0)
print(concatenated_A)

p("Add column to existing matrix")
column_added_A = np.concatenate((A,B.T),axis=1)
print(column_added_A)

t("Random numbers")
from numpy import random
#uniform random numner from 0 to 1
random_number = random.rand(2,5)
print(random_number)

t("Random numbers between 2 and 5")
rand_2_5 = random.randn(2,5)
print(rand_2_5)



