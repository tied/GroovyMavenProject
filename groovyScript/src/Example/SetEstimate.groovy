// PostFuncion Script: Set Remain estimate to 0 based on resolution
// JIRA: JTM-1812 - Log Work and Zero Remaining Estimate on Resolve
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.issue.resolution.Resolution

MutableIssue issue = issue;
long remain = 0

Resolution resolutionObject = issue.getResolutionObject();
String resoutionText = resolutionObject.getName().toString();

//check ResolutionText and set remain estimate
if(resoutionText == "No change" || "Duplicate" || "Deferred"){
    issue.setEstimate(remain)
}

