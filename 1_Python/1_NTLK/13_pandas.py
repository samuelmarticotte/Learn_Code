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

Banner("Welcome to Pandas")

import pandas as pd

data = pd.read_csv("input/iris-data.csv", names=["sepal length", "sepal width", "petal length", "petal width", "Category"], header=None)
t("Let's print an excerpt of the data")
print(data.head())
t("Let's describe the data")
print(data.describe())
t("Let's print the sepal length count")
sepal_len_cnt = data['sepal length'].value_counts()
print(sepal_len_cnt)
t("Let's print by categories")
print(data['Category'].value_counts())
t("Let's find the iris-setosa")
print(data['Category'] == 'Iris-setosa')
t("Let's print the first 5 Iris setosa")
sntosa=data['Category'] == 'Iris-setosa'
print(sntosa[:5])

t("Let's look at stocks data")
stockdata=pd.read_csv("input/dow_jones_index.csv", parse_dates=['date'], index_col=['date'], nrows=100)
print(stockdata.head())
print("Here is the max volume of stocks: {}".format(max(stockdata['volume'])))

print(stockdata.index.day)
print(stockdata.index.month)
print(stockdata.index.year)
print(stockdata.resample('M', how=np.sum))



