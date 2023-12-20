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
                script {
                    def testngReportsPath = 'test-output'
                    def testResults = readFile "${testngReportsPath}/testng-results.xml"
                    
              jiraComment body: 'testResults', issueKey: 'Heheyt'
                    

                }
            }
        }
    }
}
