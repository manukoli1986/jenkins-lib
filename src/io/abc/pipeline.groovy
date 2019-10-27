#!/usr/bin/groovy
package io.abc;

def clone() {
  git credentialsId: 'GithubCred', url: 'https://github.com/manukoli1986/simple-java-maven-app.git'
}

def build() {
      withMaven(maven: 'maven') {
          sh "mvn clean verify -DSkiptest=True"
      }
//  mvn clean deploy -U
}
