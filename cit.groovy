node("$NodeName"){
    wrks = env.WORKSPACE
    stage("Prepare"){
        println("Preparing the workspace...")
        git(
            url: "git@github.com:jayabalandevsecops/arappjjnpls.git",
            branch: "master"
        )
        dir('config'){
            git(
                url: "git@github.com:jayabalandevsecops/arappjjnconf.git",
                branch: "master"
            )
        }
        println("Prepared the workspace..!")
    }
    stage("Cloning"){
        println("Cloning the App Repo...")
        load('app/clone.groovy')
        println("Cloned the App Repo...!")
    }
    stage("Build"){
        println("Building the Application...")
        load('app/build.groovy')
        println("Built the ARAPP application..!")
    }
}