pipeline {
    agent any

     tools {
        // Jenkins arayüzünden tanımlı olan Maven'ın adını kullanarak tanımlama yapın
        maven 'Maven' // Bu kısımı kendi Maven yüklemenize göre değiştirmelisiniz
    }

    stages {
        stage('Run TestNG Tests') {
            steps {
                // TestNG testlerini çalıştırma adımı
                bat 'mvn clean test'
            }
        }
        stage('Process TestNG Reports and Jira Integration') {
            steps {
                script {
                    def testngReportsPath = 'src/test-output/testng.xml' // TestNG raporlarının bulunduğu klasör/dizin
                    
                    // TestNG raporlarını okuma ve istediğiniz bilgileri alarak Jira'ya gönderme işlemleri
                    def testResults = readFile "${testngReportsPath}/testng-results.xml" // Örnek olarak testNG raporu okundu
                    
                    def jiraURL = 'https://your-jira-instance.com/rest/api/2/issue'
                    def auth = 'Basic ' + "${env.darksiddee}:${env.ATATT3xFfGF059OzB6Z5Jkh4FzMvs3Vp7FvSXUlvBU5zaYcY0omUw1MUwNfOpwKEedWbdUL28_4uSuqbeBmBENmFS9yePh22UoL6QGf3C2cHtPEs6Mv4UoyGgaCGyqHAAV84ZjY_4Sv6CSW0ZIi3CvZomnuhdfBxXJtHnmhEvn36fcEmV5bYDUc=1F051CFE}".bytes.encodeBase64().toString()
                    
                    def requestBody = '''
                        {
                            "fields": {
                                "project": {
                                    "key": "Amazon"
                                },
                                "summary": "TestNG Test Results",
                                "description": "${testResults}",
                                "issuetype": {
                                    "name": "Task"
                                }
                            }
                        }
                    '''
                    
                    def response = httpRequest(
                        acceptType: 'APPLICATION_JSON',
                        contentType: 'APPLICATION_JSON',
                        httpMode: 'POST',
                        requestBody: requestBody,
                        url: jiraURL,
                        customHeaders: [[name: 'Authorization', value: auth]]
                    )

                    println "Jira response status: ${response.status}"
                    println "Jira response content: ${response.content}"
                }
            }
        }
    }
}
