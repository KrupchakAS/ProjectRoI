# ProjectRoI
Spring Boot REST API

Предметная область проекта реализована на примере онлайн-библиотеки. В качестве товара выступает объект книга, и объект каталог представленый в виде жанров к которым относятся книги данной библиотеки.

Приложение поддерживает операции CrUD и Find(по части названия книги, и поиск по категории).

Требования
Java - 1.8.x
Maven - 3.x.x
Mysql - 5.x.x

Шаги по запуску приложения

1. Клонировать приложение из репозитория

git clone https://github.com/KrupchakAS/ProjectRoI.git

2. Создать и настроить mysql подлючение username and password согласно вашей установке запуска сервера базы данных

Открыть src/main/resources/application.properties

Изменить spring.datasource.username and spring.datasource.password согласно вашей установке запуска сервера базы данных

3. Создание Mysql database

Запустить src/main/resources/database.sql

4. Создать и запустить приложение с использование Maven из корневой директории приложения

а)mvn package

б)java -jar target/ProjectRoI.jar

Альтернативный запуск -
mvn spring-boot:run

Приложение запустится с адресом http://localhost:8080.
-------------------------------------------------------
Исследуйте Rest APIs
для определения CRUD and Find операция(по части названия книги, и поиск по категории).

GET /book/get

POST /book/create

POST /book/update

DELETE /book/delete

GET /book/find

Возможно тестировать любым REST API client.
