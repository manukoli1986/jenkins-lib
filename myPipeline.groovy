def call(Map pipelineParams) {
pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'jdk'
    }
	options {
		timeout(time:5, unit: 'MINUTES')
		buildDiscarder(logRotator(numToKeepStr: '10'))
		timestamps()
		ansiColor("xterm")
	}
    stages {
        stage ('Clone') {
          steps {
            git branch: 'master', credentialsId: 'GithubCred', url: pipelineParams.gitUrl
          }
        }

        stage ('Build') {
          input {
            message "Please click if you're ready"
            ok "OK"
            parameters {
              string(name: 'Environment')
              string(name: 'Tag')
            }
          }
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
        stage ('test') {
            steps {
                parallel (
                    "unit tests": { sh 'mvn test' },
                    "integration tests": { sh 'mvn integration-test' }
                )
            }
        }
        
	}
}
