# Prova Prática Sambatech


Repositório para o projeto de testes automatizados do processo de seleção Sambatech.

### Arquitetura ###

Stack de Ferramentas:

* IDE: Eclipse Oxigen version 4.7.0
* Gerenciamento de Dependências: Maven version 3.5.0
* Test Framework: Selenium WebDriver version 3.11.0
* Test Run: JUnit version 4.12
* Design Pattern: Page Objects
* Leitura de Dados: Data Driven com Excel
* Driver: ChromeDriver.

Estrutura:

* src/main/java: armazenam os pacotes e classes das páginas da aplicação e utilitários.
* src/main/test: armazenam os pacotes e classes de teste. Cada classe de teste contém vários cenários de teste descritos nos métodos.
* arquivos: armazenam arquivos variados.
* drivers: armazenam os drivers de execução.

Execução:

Os testes podem ser executados via maven (mvn clean test -Dtests="RunAllTests") ou via Junit acessando br.com.sambatech.Util > RunAllTests.

