# Gerenciador de Documentos Técnicos
O objetivo de projeto visa implementar um Repositório de Documentos técnicos para centralizar e gerenciar a criação de uma documentação técnica relacionada a projetos de software em uma organização. Assim servindo como um local centralizado para armazenar, controlar e compartilhar documentos técnicos, como manuais, especificações, diagramas, requisitos e outros artefatos importantes. O objetivo principal é fornecer aos membros da equipe uma forma sistematizada de criá-los com acesso fácil e rápido às informações necessárias para chegar à publicação.

# Membros do Projeto
- Alex Teixeira
- Beatriz Rios
- Felipe Vilela
- Paulo Victor
- Rodrigo Lucas

# Utilização
Esta aplicação foi desenvolvida utilizando o Agile Kip com JHipster. Antes de começar, verifique se você atende aos seguintes requisitos:

- Java 13 instalado e definido como padrão.
- Docker instalado e configurado corretamente.

## Passo 1: Instalação do Java 13
Verifique a versão do Java instalado em seu sistema. A versão testada e recomendada é o Java 13. Para instalá-lo e defini-lo como padrão, execute os seguintes comandos:
```
sudo apt install openjdk-13-jdk
```
Após a instalação, verifique o caminho da instalação executando o seguinte comando:
```
sudo update-alternatives --config java
```
## Passo 2: Configuração do Container
Execute o seguinte comando para criar um container:
```
sudo docker container run   --name agilekip.v0.0.12   -v $PWD:/home/jhipster/app   -d -t agilekip/generator-jhipster-agilekip:v0.0.12
```
Este comando só precisa ser executado uma única vez. Nas próximas vezes, utilize o comando a seguir para iniciar o container:
```
sudo docker container exec -it agilekip.v0.0.12 bash
```
Se você receber uma mensagem de erro informando que o container não está sendo executado, execute o seguinte comando, substituindo `<id_container>` pelo ID do container iformado no erro:
```
sudo docker container start <id_container>
```

## Passo 3: Execução da Aplicação
Abra um segundo terminal e navegue até o diretório `document_repositories` na raiz deste projeto. Em seguida, execute o seguinte comando:
```
./mvnw
```
A aplicação deve estar sendo executada na porta 8080.

Certifique-se de revisar as instruções e adaptá-las de acordo com as necessidades específicas do seu projeto.

### Mais informações podem ser encontradas na wiki do projeto
https://github.com/AlexTeixeira1/QualiSoft/wiki
