# Desafio - Quantum
Desafio para vaga de estágio como desenvolvedor Java na empresa Quantum.

Programa que lê um conjunto de dados em um arquivo .csv e, para cada ação, calcula os dias e valores de fechamentos e de retornos mínimos e máximos, e o volume médio.

## Especificações técnicas
Linguagem Java 8
IDE: NetBeans 8.2
Gerenciador de dependências: Maven
Dependência: OpenCSV


## Observações
Ao utilizar o maven será gerado um .jar que deve ser executado: mvn clean install.
Para que o .jar ou o código-fonte possa ser executado com sucesso, o arquivo "acoes.csv" deve estar no diretório "C://". 
Para executar o .jar: java -jar QuantumDesafio-1.0-SNAPSHOT-jar-with-dependencies.jar

As funções que eu testei para pegar o diretório atual não funcionaram para o .jar, então coloquei um diretorio fixo e completo no código.
Alterar linha 20 da Classe Principal em Principal.java caso queira executar o arquivo de outro diretório.


## Licença
Copyright 2018 Leonardo Simões	
