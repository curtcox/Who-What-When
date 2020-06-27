package com.curtcox.www.data.sample;

import com.curtcox.www.data.Data;

public final class SampleData implements Data {

    public String root() {
        return
"""
me,married to,my wife
me,brother of,my brother
me,sister of,my sister
me,father of,my son
me,father of,my daughter
my daughter,has cat,my daughter's cat
my daughter's cat,image,http://placekitten.com/50/50
me,has cat,my cat
my cat,image,http://placekitten.com/49/49

my wife,married to,me
my wife,mother of,my son
my wife,mother of,my daughter
my wife,brother of,my wife's brother
my wife,sister of,my wife's sister

my mother,married,my father
my mother,mother of,me
my mother,mother of,my brother
my mother,mother of,my sister

my father,married to,my mother
my father,father of,me
my father,father of,my brother
my father,father of,my sister

my brother,married to,my brother's wife
my brother,brother of,me
my brother,father of,my brother's son

my sister,married to,my sister's husband
my sister,brother of,me
my sister,mother of,my sister's daughter

my wife's father,father of,my wife
my wife's mother,mother of,my wife

my mother's mother,married,my mother's father
my mother's mother,mother of,my mother
my mother's mother,mother of,my mother's brother
my mother's mother,mother of,my mother's sister

my mother's father,married to,my mother's mother
my mother's father,father of,my mother
my mother's father,father of,my mother's brother
my mother's father,father of,my mother's sister

my father's mother,married,my father's father
my father's mother,mother of,my father
my father's mother,mother of,my father's brother

my father's father,married to,my father's mother
my father's father,father of,my father
my father's father,father of,my father's brother

""";
    }
}