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
         stage('Process TestNG Reports and Jira Integration') {
            steps {
                script {
                    def testngReportsPath = 'test-output'
                    def testResults = readFile "${testngReportsPath}/testng-results.xml"
                    
                    def jiraIssue = [
                        issueUpdates: [
                            [
                                update: [
                                    summary: ["set": "TestNG Test Results"],
                                    description: ["set": testResults]
                                ]
                            ]
                        ]
                    ]
                    
                    def issue = jiraEditIssue idOrKey: 'Heheyt', issueUpdates: jiraIssue
                    
                    echo "JIRA response status: ${issue.status}"
                    echo "JIRA response content: ${issue.data}"
                }
            }
        }
    }
}
