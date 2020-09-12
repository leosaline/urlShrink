pipeline {
	agent {
		docker {
			image 'maven'
		}
	}
	stages {
		stage('Checkout') {
			steps {
				/* colocar os jobs do estágio de Checkout aqui */
			}
		}
		stage('Build + Unit tests') {
			steps {
				/* colocar os jobs do estágio de Build e testes unitários aqui */
			}
		}
		stage('Archiving Reports') {
			steps {
				/* colocar os jobs do estágio de arquivamento de relatórios aqui */
			}
		}
		stage('BDD tests job'){
			steps {
				/* colocar os jobs do estágio de execução de BDD aqui */
			}
		}
	}
}
