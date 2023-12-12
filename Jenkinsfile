pipeline
{
    environment{
        BACKEND_IMAGE_NAME = "chinx23/backend"
        FRONTEND_IMAGE_NAME = "chinx23/frontend"
        registryCredential = "dockersignin"
				backendImage=""
				frontendImage=""
    }
    agent any
    stages
    {
        stage('Stage 1: Git Clone')
        {
            steps
            {
                git branch: 'main',
                url:'https://github.com/Tejsharma15/SPE-MajorProject-Splitwise'
            }
        }
        stage('Stage 2: Build Backend') {
            steps {
                sh 'cd MiniSplitwise && mvn clean install'
            }
        }
        stage('Stage 3: Build Frontend') {
            steps {
                sh 'cd frontend && npm install && npm run build'
            }
        }
        stage('Stage 4: Build and Push Backend Docker Image') {
            steps {
                script {
                    backendImage = docker.build(env.BACKEND_IMAGE_NAME, './MiniSplitwise')
                    docker.withRegistry('', registryCredential) {
                        backendImage.push('latest')
                    }
                }
            }
        }
        stage('Stage 5: Build and Push Frontend Docker Image') {
            steps {
                script {
                    frontendImage = docker.build(env.FRONTEND_IMAGE_NAME, './frontend')
                    docker.withRegistry('', registryCredential) {
                        frontendImage.push('latest')
                    }
                }
            }
        }
        stage('Stage 6: Clean Docker Images') {
            steps {
                script {
                    sh 'docker rmi $BACKEND_IMAGE_NAME'
                    sh 'docker rmi $FRONTEND_IMAGE_NAME'
                }
            }
        }
    }
}