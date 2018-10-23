// Validator Groovy script : Check if remaing is zero out when there is no log work at issue
// JIRA: JTM-1812 - Log Work and Zero Remaining Estimate on Resolve
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.worklog.Worklog
import com.opensymphony.workflow.InvalidInputException


long worklog = issue.getTimeSpent()
long remain = issue.getEstimate()
// Throw an InvalidInputException if there is not time logged
if (worklog == 0 ){
    if(remain != 0){
        invalidInputException = new InvalidInputException("worklog_timeLogged", "Please set the remaining estimate to zero or log your work before resolving this issue.")
    }
}