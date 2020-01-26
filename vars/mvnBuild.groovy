#!/usr/bin/env groovy

tools {
  maven 'maven'
  jdk 'jdk'
}

def call(verify) {
      sh 'mvn clean package -U -X'
      }
//def call(mvn) {
//      withMaven(maven: 'maven') {
//      sh 'mvn clean verify -DSkiptest=True -U -X'
//      }
//}
