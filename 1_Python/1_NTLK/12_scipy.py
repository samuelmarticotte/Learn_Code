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

Banner("Welcome to scipy")

import numpy as np
import scipy as sp

from scipy.integrate import quad, dblquad, tplquad

def f(x):
    return x

x_lower = 0
x_upper = 1
val, abserr = quad(f, x_lower, x_upper)
print(val,abserr)

t("How linear algebra can be used")
A = sp.rand(2,2)
B = sp.rand(2,2)
from scipy import linalg as LA
X = LA.solve(A,B)
print(X)

t("Eigenvalues and Eigenvectors")
evals = LA.eigvals(A)
print(evals)
evals, evect = LA.eig(A)

print("Eigenvalues : {} \nEigenvectors : {}".format(evals, evect))

t("Inverse, tranpose an determinant")
print("Inverse : {} ".format(LA.inv(A)))
print("determinant : {}".format(LA.det(A)))

t("Let's play with sparse matrices")

from scipy import sparse as s

A = sp.array([[1,0,0],[0,2,0],[0,0,3]])
print(A)

t("Optimization")
from scipy import optimize
def f(x):
    return (x**2-4)
optimize.fmin_bfgs(f,0)

t("Let get some help()")
#prints help of a specific function
#help(optimize.fmin_bfgs)
