pipeline {
    agent any

    tools {
        maven 'Maven' // Maven yüklemesinin adı burada belirtilmelidir
    }

    stages {
        stage('Run TestNG Tests') {
            steps {
                // TestNG testlerini çalıştırma adımı
                script {
                    bat 'mvn clean test'
                }
            }
        }
         stage('Process TestNG Reports and Write Comment in JIRA') {
            steps {
                jiraUploadAttachment file: 'test-output/testng-results.xml', idOrKey: 'Heheyt', site: 'Jira'

                    
                    

                }
            }
        }
    }
}
