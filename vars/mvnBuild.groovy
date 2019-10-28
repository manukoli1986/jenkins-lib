#!/usr/bin/env groovy

def call() {
//      withMaven(maven: 'maven') {
//      sh 'mvn clean verify -DSkiptest=True'
//      }
      /opt/apache-maven-3.5.4/bin/mvn clean verify -DSkiptest=True
}
