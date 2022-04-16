pipeline 
{
    
    environment { 
        registry = "nayandoshi/spe_mini_project_calculator" 
        registryCredential = 'jenkins-docker' 
        dockerImage = '' 
        
    }
  
    agent any

    stages 
    {
        stage('Git pull') {
            steps {
                git branch: 'main', url: 'https://github.com/NayanDoshi/spe_mini_project_calculator_devops.git'
            }
        }
        
        stage('Build Executable Jar'){
                steps {
                     sh 'mvn clean test package'
                }
        }
        
        stage('Building Docker image') { 
        steps { 
            script { 
                dockerImage = docker.build registry + ":$BUILD_NUMBER" 
            }
        } 
        }
        stage('Push image to DockerHub') { 
            steps { 
                script { 
                    docker.withRegistry('', registryCredential ) { 
                        dockerImage.push() 
                        
                    }
                } 
            }
        }
        stage('Ansible Deploy') {
            steps {
                //Ansible Deploy to remote server (managed host)
                ansiblePlaybook installation: 'Ansible', inventory: 'inventory', playbook: 'playbook.yml'

            }
        }
    }    
} 
