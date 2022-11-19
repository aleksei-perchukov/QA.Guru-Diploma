# Проект автоматизации тестирования для <a target="_blank" href="https://habr.com/">Habr</a> и <a target="_blank" href="https://reqres.in/">Reqres.in</a>

## Содержание:
- [Технологии и инструменты](#gear-в-проекте-используются-следующие-технологии-и-инструменты)
- [Что проверяем](#heavy_check_mark-что-проверяем)
- [Запуск тестов из Jenkins](#-запуск-тестов-из-jenkins)
- [Запуск тестов из терминала](#computer-запуск-тестов-из-терминала)
- [Отчеты](#bar_chart-отчеты-о-прохождении-тестов-доступны-в-allure)
- - [Allure](#-allure)
- - [Telegram](#-telegram)
- [Видео с прогоном тестов](#movie_camera-видео-с-прогоном-тестов)
- [Allure TestOps](#-проект-интегрирован-с-allure-testOps)

## В проекте используются следующие технологии и инструменты:

<p align="center">
<img src="img/logo/Idea.svg" width="50" height="50"  alt="IDEA"/>
<img src="img/logo/Java.svg" width="50" height="50"  alt="Java"/>
<img src="img/logo/GitHub.svg" width="50" height="50"  alt="Github"/>
<img src="img/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/>
<img src="img/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/>
<img src="img/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/>
<img src="img/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/>
<img src="img/logo/Allure.svg" width="50" height="50"  alt="Allure"/>
<img src="img/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/>
<img src="img/logo/Telegram.svg" width="50" height="50"  alt="Telegram"/>
<img src="img/logo/Allure.svg" width="50" height="50"  alt="Allure"/>
<img src="img/logo/Allure_TO.svg" width="50" height="50"  alt="Allure_TO"/>
</p>

## Описание
В проекте реализованы UI, API и Mobile тесты, небольшой части функционала и приложения сайта Habr.com и сайта Reqres.in для демонстрации возможностей проекта автоматизации. Использован паттерн проектирования автотестов PageObject.

## Что проверяем

> - Регистрацию нового пользователя;
> - Поиск курса;
> - Запись на курс;

## <img width="4%" title="Jenkins" src="img/logo/Jenkins.svg"> Запуск тестов из Jenkins (<h3><a href=https://jenkins.autotests.cloud/job/aleksei-perchukov-Diploma-Browserstack/>Browserstack</a></h3>  & <h3><a href=https://jenkins.autotests.cloud/job/aleksei-perchukov-Diploma-Desktop/>WEB+API</a></h3>): 

<p>Для запуска тестов из Jenkins:
<br>Необходимо нажать кнопку "Собрать сейчас".
<br>
<img src="img/screen/Jenkins-run.jpg" alt="Jenkins"/>

## Запуск тестов из терминала

Для локального запуска WEB & API тестов необходимо выполнить команду:
```
gradle clean web_api_test -Dos=desktop-local
```

Для локального запуска WEB & API тестов через selenoid необходимо выполнить команду:
```
gradle clean web_api_test -Dos=desktop-remote
```

Для локального запуска мобильных тестов в Browserstack необходимо выполнить команду:
```
gradle clean mobile_test -Dos=mobile-browserstack
```

Для локального запуска мобильных тестов на эмуляторе необходимо выполнить команду:
```
gradle clean mobile_test -Dos=mobile-local
```

Для локального запуска мобильных тестов на реальном девайсе необходимо выполнить команду:
```
gradle clean mobile_test -Dos=mobile-real
```

## Отчеты о прохождении тестов доступны в Allure

### <img width="3%" title="Allure" src="img/logo/Allure.svg"> Allure

#### Главная страница

<img src="img/screen/AllureMain.jpg" alt="Allure"/>

#### Графики

<img src="img/screen/AllureGraph.jpg" alt="Allure"/>

#### Тесты

<img src="img/screen/AllureTests.jpg" alt="Allure"/>

### <img width="3%" title="Telegram" src="img/logo/Telegram.svg"> Telegram

Настроена отправка отчета ботом в Telegram

<img src="img/screen/Bot.jpg" alt="Telegram"/>

## Видео с прогоном тестов

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста

<p align="center">
  <img title="Video" src="img/gif/test.gif">
</p>

## Проект интегрирован с Allure TestOps
<img width="3%" title="Allure" src="img/logo/Allure_TO.svg"> 

#### Представлены тест-кейсы

<img src="img/screen/TOTest.jpg" alt="TO"/>

#### Представлены дашборды аналитики

<img src="img/screen/TODash.jpg" alt="TO"/>

#### Представлены запуски

<img src="img/screen/TOLaunch.jpg" alt="TO"/>

