// PostFuncion Script: Script re assign issue to previous status executor based on issue history
// JIRA: JTM-1615 - When changing status from More Info Required to Info Provided, the issue should be reassigned
import com.atlassian.jira.issue.history.ChangeItemBean;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.MutableIssue;

def userManager = ComponentAccessor.getUserManager();
def changeHistoryManager = ComponentAccessor.getChangeHistoryManager()
def changeHistories = changeHistoryManager.getChangeHistories(issue)
def personName
MutableIssue issue = issue;


def previousAssignees = changeHistories.collect {history ->;
    history.getChangeItemBeans().findResults {ChangeItemBean change ->;
        if (change.getField() == "assignee") {
            return change.getTo()
        }
    }
}.flatten()
//Print Last Fullname executor to String
personName = previousAssignees.last().toString()
//Change Full name to User
def NameOfPerson = userManager.getUserByKey(personName)
issue.setAssigneeId(personName)
