# ProjectRoI
Spring Boot REST API

Предметная область проекта реализована на примере онлайн-библиотеки. В качестве товара выступает объект книга, и объект каталог представленый в виде жанров, к которым относятся книги данной библиотеки.

Приложение поддерживает операции CrUD и Find (по части названия книги и поиск по категории).

Требования
Java - 1.8.x
Maven - 3.x.x
Mysql - 5.x.x(или другая база данных)

Шаги по запуску приложения:

1. Клонировать приложение из репозитория.

git clone https://github.com/KrupchakAS/ProjectRoI.git

2. Создать и настроить mysql подлючение username and password согласно вашей установке запуска сервера базы данных.

Открыть src/main/resources/application.properties

Изменить настройки согласно вашей установке запуска сервера базы данных.
1) spring.datasource.username 
2) spring.datasource.password 
(и другие настройки если вы используете иную базу данных)

3. Создание Mysql database.

1) Запустить MySql сервер.
2) Запустить MySQL Command Line Client и ввести ваш пароль от root пользователя для доступа в базе данных
3) create database roi;
4) use roi;
5) source C:\Users\andrey\Desktop\ProjectRoI\src\main\resources\database.sql (ввести путь к локальному расположения файла database.sql проекта) 

4. Создать и запустить приложение с использование Maven из корневой директории приложения:

1) mvn package

2) java -jar target/ProjectRoI.jar

Альтернативный запуск - mvn spring-boot:run 

Приложение запуститься с адресом http://localhost:8080

-------------------------------------------------------

Исследуйте Rest APIs для определения CrUD and Find операций(по части названия книги, и поиск по категории("Приключения","Фантастика","Ужасы")).

GET /book/get

POST /book/create

POST /book/update

DELETE /book/delete

GET /book/find

Возможно тестировать любым REST API client.
