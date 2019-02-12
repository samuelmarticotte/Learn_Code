#!/Library/Frameworks/Python.framework/Versions/3.7/bin/python3
# To compile: python ./name.py
# For libraries: pipenv install <package>
# pip install pyfiglet / conda install -c conda-forge pyfiglet

from pyfiglet import Figlet  # banners
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

def title(title):
    print('\033[1;33m---------------%s---------------\033[1;m\n' % title)
#--------------------------------------------------UTILITY FUNCTIONS-----------------------------

import scrapy
Banner("Welcome to Web Crawling!")


#Look at scrapy tutorials online to login, scrape by dom objects and create json files from that.


