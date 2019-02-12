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

from gensim import corpora, models, similarities

from itertools import chain

import nltk

from nltk.corpus import stopwords
from operator import itemgetter
import re

def preprocessing(text):
    text = text.decode("utf8")
    # tokenize into words
    tokens = [word for sent in nltk.sent_tokenize(text) for word in nltk.word_tokenize(sent)]

    # remove stopwords
    stop = stopwords.words('english')
    tokens = [token for token in tokens if token not in stop]

    # remove words less than three letters
    tokens = [word for word in tokens if len(word) >= 3]

    # lower capitalization
    tokens = [word.lower() for word in tokens]

    # lemmatize
    lmtzr = WordNetLemmatizer()
    tokens = [lmtzr.lemmatize(word) for word in tokens]
    preprocessed_text= ' '.join(tokens)

    return preprocessed_text


smsdata = open('SMSSpamCollection','rU') # check the structure of this file!
sms_data = []
sms_labels = []
csv_reader = csv.reader(smsdata,delimiter=';', )
for line in csv_reader:
     # adding the sms_id
    sms_labels.append( line[0])
    # adding the cleaned text We are calling preprocessing method
    print(line[1])
    sms_data.append(preprocessing(line[1]))

smsdata.close()

#Let's do topic modelling
title("Let's do topic modelling ")

#We doa bag-of-words and then a tf-idf with the corpus

documents = [document for document in sms_data]
stoplist = stopwords.words('english')
texts = [[word for word in document.lower().split() if word not in stoplist] \
for document in documents]
dictionary = corpora.Dictionary(texts)
corpus = [dictionary.doc2bow(text) for text in texts]
tfidf = models.TfidfModel(corpus)
corpus_tfidf = tfidf[corpus]
si = models.LsiModel(corpus_tfidf, id2word=dictionary, num_topics=100)
si.print_topics(20)
n_topics = 5
lda = models.LdaModel(corpus_tfidf, id2word=dictionary, num_topics=n_topics)
for i in range(0, n_topics):
    temp = lda.show_topic(i, 100)
    terms = []
    for term in temp:
        terms.append(term[0])
    print "Top 10 terms for topic #" + str(i) + ": " + ", ".join(terms)