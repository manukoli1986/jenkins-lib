#!/usr/bin/env groovy

def call() {
//      withMaven(maven: 'maven') {
//      sh 'mvn clean verify -DSkiptest=True'
//      }
      sh 'mvn clean verify -DSkiptest=True'
}
