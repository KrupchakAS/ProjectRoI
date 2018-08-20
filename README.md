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

а) spring.datasource.username 

б) spring.datasource.password 

(и другие настройки если вы используете иную базу данных)

3. Создание Mysql database.

а) Запустить MySql сервер.

б) Запустить MySQL Command Line Client и ввести ваш пароль от root пользователя для доступа в базе данных

в) create database roi;

г) use roi;

д) source C:\Users\andrey\Desktop\ProjectRoI\src\main\resources\database.sql (ввести путь к локальному расположения файла database.sql проекта) 

4. Создать и запустить приложение с использование Maven из корневой директории приложения:

а) mvn package

б) java -jar target/ProjectRoI.jar

Альтернативный запуск - mvn spring-boot:run 

Приложение запуститься с адресом http://localhost:8080

-------------------------------------------------------

Исследуйте Rest APIs для определения CrUD and Find операций(по части названия книги(name, description, pages), и поиск по категории жанры(genres) и полем(name="Приключения","Фантастика","Ужасы")).

GET /book/get  - поиск по id книги библиотеки

POST /book/create  - добавление книги в библиотеку

POST /book/update  - обновление свойств книги по id

DELETE /book/delete  - удаление по id книги библиотеки

GET /book/find (/book/find) - поиск всех книг библиотеки, (/book/find?name=) - поиск по названию или части названия, (/book/find?genre=) - поиск по жанру(категории) книги.

Возможно тестировать любым REST API client.
