def call(Map pipelineParams) {
pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'jdk'
    }
//	options {
//		timeout(time:5, unit: 'MINUTES')
//		buildDiscarder(logRotator(numToKeepStr: '10'))
//		timestamps()
//		ansiColor("xterm")
//	}
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
                sh 'mvn clean package -X -U' 
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
                    "unit tests": { sh 'mvn test -X' },
                    "integration tests": { sh 'mvn integration-test -X' }
                )
            }
	    post {
            	failure {
                	mail to: pipelineParams.email, subject: 'Pipeline failed', body: "${env.BUILD_URL}"
            }
        }
        }
        
	}
}
}
