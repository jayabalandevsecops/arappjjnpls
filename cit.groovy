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
}