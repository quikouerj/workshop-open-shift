 node('maven') {
    stage('build') {
        echo 'building app :)'
        openshiftBuild(buildConfig: 'workshop-open-shift', showBuildLogs: 'true')
    }
    stage('verify') {
        echo 'dummy verification....'
    }
    stage('deploy') {
        input 'Manual Approval'
        openshiftDeploy(deploymentConfig: 'workshop-open-shift')
    }
    stage('promoting to QA') {
       echo 'fake stage...'
       sleep 5 
    }
}