### Веб-приложение форум
[![Build Status](https://app.travis-ci.com/PetrBogomolov/job4j_forum.svg?branch=master)](https://app.travis-ci.com/PetrBogomolov/job4j_forum)
[![codecov](https://codecov.io/gh/PetrBogomolov/job4j_forum/branch/master/graph/badge.svg?token=CZVLJEON4F)](https://codecov.io/gh/PetrBogomolov/job4j_forum)
[![Heroku](https://heroku-badge.herokuapp.com/?app=heroku-badge)](https://spring-boot-forum-12232.herokuapp.com)

Проект размещён на облачной PaaS-платформе [Heroku](https://spring-boot-forum-12232.herokuapp.com).

### Технологии:
 
 * Spring (Boot, Core, MVC, Data, Security)
 
 * Hibernate
 
 * PostgreSQL
 
 * Liquibase
 
 * Maven
 
 * JSP, HTML
 
 * Travis CI, CheckStyle
 
 * Heroku
 
### Функционал:
 
 * Регистрация пользователя
 (Регистрация пользователя с одинаковым логином и email запрещена)
 
 * Аутентификация пользователя
 
 * Организация матрицы ролей с разным уровнем 
 прав для Администратора и Пользователя
 
   права ADMIN:
   
   - Добавление темы
   
   - Редактирование любой темы
   
   - Редактирование статуса темы
   
   - Удаление любой темы
   
   - Добавление любого поста
   
   - Редактирование любого поста
   
   - Удаление любого поста
   
   права USER:
   
   - Добаление темы
   
   - Редактирование своей темы
   
   - Удаление своей темы
   
   - Добавление поста
      
   - Редактирование своего поста
      
   - Удаление своего поста
   
-----------------------------------------------
   
#### Страница авторизации
![ScreenShot](images/auth.png)
   
![ScreenShot](images/autherror.png)

------------------------------------------------
   
#### Страница регистрации
![ScreenShot](images/reg.png)
   
![ScreenShot](images/regerror.png)

------------------------------------------------
   
#### Гланая стараница форума со списком тем для обсуждения
![ScreenShot](images/home.png)

-------------------------------------------------
   
#### Страница добавления темы
![ScreenShot](images/addtopic.png)

---------------------------------------------------
   
#### Страница постов под этой темой
![ScreenShot](images/posts.png)

-------------------------------------------------------
   
#### Выход
![ScreenShot](images/exit.png)
 