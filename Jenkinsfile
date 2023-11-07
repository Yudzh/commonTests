pipeline {
    agent any
    tools {
        jdk 'JDK11'
        maven 'Maven3.8.1'
    }
    stages {
        stage('git clone') {
            steps {
                git url: 'https://github.com/Yudzh/commonTests.git',
                    branch: 'master',
                    credentialsId: 'YudzhTokenId'
            }
        }
        stage('tests') {
            steps {
                sh 'mvn clean install -DseleniumHub=selenium-hub:4444'
            }
        }
    }
}