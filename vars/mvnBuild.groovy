#!/usr/bin/env groovy
def build {
//      withMaven(maven: 'maven') {
//      mvn clean verify -DSkiptest=True
//      }
      mvn clean verify -DSkiptest=True

}
