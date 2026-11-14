
pipeline {
    agent any

    tools {
        jdk 'JDK'
        maven 'Maven 3.9.11'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Execute Test Cases') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true,
                  testResults: '**/target/surefire-reports/*.xml'

            archiveArtifacts(
                artifacts: '**/target/surefire-reports/**',
                allowEmptyArchive: true
            )
        }
    }
}
