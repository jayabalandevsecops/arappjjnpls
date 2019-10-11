folder("$BUName"){}
folder("$BUName/$ProductName"){}
pipelineJob("$BUName/$ProductName/CICD_$AppName"){
    parameters{
        stringParam("AppRepo", "$ApplicationRepo", "Git URL")
        stringParam("AppName", "$AppName", "")
        stringParam("UnitTestTool", "$UnitTestRun","")
        stringParam("NodeName", "$NodeName", "")
        activeChoiceParam('Branch'){
            // filterable()
            description("Select the Branch to be built...")
            choiceType('SINGLE_SELECT')
            groovyScript{
                script('["Select","master","develop"]')
                fallbackScript('"Fallback choice"')
            }
        }
    }
    definition{
        cps{
            def jobScript = readFileFromWorkspace('cit.groovy')
            def approvals = org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval.get()
            approvals.approveScript(approvals.hash(jobScript, "groovy"))
            script(jobScript)
        }
    }
}