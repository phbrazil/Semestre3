1 - Baixar o Mysql no link https://dev.mysql.com/downloads/installer/

Na instalacao configure com o user "root" e a senha "adminadmin"


2 - Baixar a versao mais recente do Java no link https://java.com/pt_BR/download/

3 - Importe o projeto zipado no netbeans.


4 - Abra o cmd.exe e cole os comandos na sequencia abaixo:



cd c:\

cd Program Files

cd MySQL Server 5.7

cd bin


5 - Antes de rodar o comando abaixo, altere o nome do user de acordo com o nome em sua maquina:

mysql -u root -p <"C:\Users\NOMEUSER\Documents\NetBeansProjects\LojadeBrinquedos-master\Banco de Dados\ScriptT
abelas.sql" --default-character-set=utf8


6 - Para acessar o sistema insira o user “professor” a senha “professor”

