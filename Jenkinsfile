pipeline {
    agent any
    options {
        ansiColor('xterm')
        timestamps()
    }
    triggers {
        pollSCM('')
        issueCommentTrigger('.*test this please.*')
    }
    stages {
        stage('Test jenkins') {
           steps {
                sh 'echo test'
           }
        }
        stage('Test') {
            when {
                not {
                    branch 'master'
                }
            }
           steps {
                sh './sbt/sbt test'
           }
        }
        stage('Publish') {
            when {
                branch 'master'
            }
            steps {
                echo 'Rollout'
                withCredentials([usernamePassword(credentialsId: 'nexus_oom_user', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD')]) {
                    sh './sbt/sbt compile publish'
                }
            }
        }
    }
}
