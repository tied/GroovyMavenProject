package com.acme

import com.atlassian.jira.issue.history.ChangeItemBean;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.MutableIssue;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

def userManager = ComponentAccessor.getUserManager();
def NameOfPerson = userManager.getUserByName("ss")?.directoryUser;
def changeHistoryManager = ComponentAccessor.getChangeHistoryManager()
def changeHistories = changeHistoryManager.getChangeHistories(issue)
def allChangeHistories = changeHistoryManager.getAllChangeItems(issue)

MutableIssue issue = issue;
Logger log = log;
log.setLevel(Level.INFO);

def previousExecutors = allChangeHistories.collect {history ->;
    history.getChangeItemBeans().findResults {ChangeItemBean change ->;
        history.getChange


        log.info("###############################################$change");

    }
}.flatten()
