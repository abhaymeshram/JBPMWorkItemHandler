# JBPMWorkItemHandler
As it was mentioned, form renderers are pluggable and out of the box there are two implementations

based on PatternFly - this is the default renderer that keeps the look and feel consistent with workbench
based on Bootstrap
Renderers can be switched per each form rendering request by simply appending query parameter
?renderer=patternfly or ?renderer=boostrap if not given patternfly is the default one.

Here are few examples of the REST endpoints that illustrate how to get these forms rendered

http://localhost:8080/kie-server/services/rest/server/containers/evaluation/forms/processes/evaluation/content
http://localhost:8080/kie-server/services/rest/server/containers/evaluation/forms/tasks/1/content


http://localhost:8080/kie-server/services/rest/server/containers/mortgage-process/forms/processes/Mortgage_Process.MortgageApprovalProcess/content
http://localhost:8080/kie-server/services/rest/server/containers/mortgage-process/forms/tasks/2/content


http://localhost:8080/kie-server/services/rest/server/containers/itorders/forms/cases/itorders.orderhardware/content
http://localhost:8080/kie-server/services/rest/server/containers/itorders/forms/tasks/3/content
