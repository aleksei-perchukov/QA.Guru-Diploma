# Test automation project for <a target="_blank" href="https://habr.com/">Habr</a> & <a target="_blank" href="https://reqres.in/">Reqres.in</a>

## Contents:
- [Technologies and instruments](#gear)
- [What we check](#check_mark)
- [Launch from Jenkins](#jenkins)
- [Launch from terminal](#terminal)
- [Reports](#reports)
- - [Allure](#allure)
- - [Telegram notifications](#telegram)
- [Test execution video](#test_video)
- [Allure TestOps](#testops)

## В проекте используются следующие технологии и инструменты:

<p align="center">
<img src="src/test/resources/img/logo/Idea.svg" width="50" height="50"  alt="IDEA"/>
<img src="src/test/resources/img/logo/Java.svg" width="50" height="50"  alt="Java"/>
<img src="src/test/resources/img/logo/GitHub.svg" width="50" height="50"  alt="Github"/>
<img src="src/test/resources/img/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/>
<img src="src/test/resources/img/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/>
<img src="src/test/resources/img/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/>
<img src="src/test/resources/img/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/>
<img src="src/test/resources/img/logo/Allure.svg" width="50" height="50"  alt="Allure"/>
<img src="src/test/resources/img/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/>
<img src="src/test/resources/img/logo/Telegram.svg" width="50" height="50"  alt="Telegram"/>
<img src="src/test/resources/img/logo/Allure.svg" width="50" height="50"  alt="Allure"/>
<img src="src/test/resources/img/logo/Allure_TO.svg" width="50" height="50"  alt="Allure_TO"/>
</p>

## Описание
В проекте реализованы UI, API и Mobile тесты, небольшой части функционала и приложения сайта Habr.com и сайта Reqres.in для демонстрации возможностей проекта автоматизации. Использован паттерн проектирования автотестов PageObject.

## <a href="https://github.com/aleksei-perchukov/Diploma#check_mark">Что проверяем:</b>
- API-тесты сайта <a href=reqres.in>Reqres.in</a>
- WEB-тесты сайта <a href=habr.com>Habr.com</a>
- Мобильное приложение для сайта <a href=habr.com>Habr.com</a> - HABAR (неофициальное)

## <img width="4%" title="Jenkins" src="src/test/resources/img/logo/Jenkins.svg"> Запуск тестов из Jenkins (<a href=https://jenkins.autotests.cloud/job/aleksei-perchukov-Diploma-Browserstack/>Browserstack</a>  & <a href=https://jenkins.autotests.cloud/job/aleksei-perchukov-Diploma-Desktop/>WEB+API</a>): 

<p>Для запуска тестов из Jenkins:
<br>Необходимо нажать кнопку "Собрать сейчас".
<br>
<img src="src/test/resources/img/screen/Jenkins-run.jpg" alt="Jenkins"/>

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

### <img width="3%" title="Allure" src="src/test/resources/img/logo/Allure.svg"> Allure

#### Главная страница

<img src="src/test/resources/img/screen/AllureMain.jpg" alt="Allure"/>

#### Графики

<img src="src/test/resources/img/screen/AllureGraph.jpg" alt="Allure"/>

#### Тесты

<img src="src/test/resources/img/screen/AllureTests.jpg" alt="Allure"/>

### <img width="3%" title="Telegram" src="src/test/resources/img/logo/Telegram.svg"> Telegram

Настроена отправка отчета ботом в Telegram

<img src="src/test/resources/img/screen/Bot.jpg" alt="Telegram"/>

## Видео с прогоном тестов

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста

<p align="center">
  <img title="Video" src="src/test/resources/img/gif/test.gif">
</p>

## Проект интегрирован с Allure TestOps
<img width="3%" title="Allure" src="src/test/resources/img/logo/Allure_TO.svg"> 

#### Представлены тест-кейсы

<img src="src/test/resources/img/screen/TOTest.jpg" alt="TO"/>

#### Представлены дашборды аналитики

<img src="src/test/resources/img/screen/TODash.jpg" alt="TO"/>

#### Представлены запуски

<img src="src/test/resources/img/screen/TOLaunch.jpg" alt="TO"/>

