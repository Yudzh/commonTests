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
                sh 'mvn clean install -DseleniumHub=http://selenium-hub:4444'
            }
        }
    }
    post {
        always {
            echo 'create allure reports'
            sh 'mkdir -p allure-results'
            sh 'mv target/allure-results/* allure-results/'
            allure([
                                    includeProperties: false,
                                    jdk              : '',
                                    properties       : [],
                                    reportBuildPolicy: 'ALWAYS',
                                    results          : [[path: '/target/allure-results']]
                            ])

        }
    }
}