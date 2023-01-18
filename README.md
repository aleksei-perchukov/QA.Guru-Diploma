# Test automation project for <a target="_blank" href="https://habr.com/">Habr</a> & <a target="_blank" href="https://reqres.in/">Reqres.in</a>

## Contents:
- [Technologies and instruments](#gear)
- [Description](#description)
- [What we check](#check_mark)
- [Launch from Jenkins](#jenkins)
- [Launch from terminal](#terminal)
- [Reports](#reports)
- - [Allure](#allure)
- - [Telegram notifications](#telegram)
- [Test execution video](#test_video)
- [Allure TestOps](#testops)

## <b id="gear">Technology stack:</b>

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

## <b id="description">Description</b>
In project were implemented the WEB, API and mobile tests of a small part of the functionality of Habr.com and Reqres.in websites. The PageObject autotest design pattern is used.

## <b id="check_mark">Что проверяем:</b>
- API-tests <a href=reqres.in>Reqres.in</a>
- WEB-tests <a href=habr.com>Habr.com</a>
- Android mobile app of <a href=habr.com>Habr.com</a> - HABAR (Unofficial)

## <img width="4%" title="Jenkins" src="src/test/resources/img/logo/Jenkins.svg"> Launching tests from Jenkins (<a href=https://jenkins.autotests.cloud/job/aleksei-perchukov-Diploma-Browserstack/>Browserstack</a>  & <a href=https://jenkins.autotests.cloud/job/aleksei-perchukov-Diploma-Desktop/>WEB+API</a>): 

<p><b id="jenkins">For launching from Jenkins:</b>
<br>Click "Собрать сейчас" button.
<br>
<img src="src/test/resources/img/screen/Jenkins-run.jpg" alt="Jenkins"/>

## <b id="terminal">For launching from terminal</b>

For local launching of WEB & API tests execute command:
```
gradle clean web_api_test -Dos=desktop-local
```

For local launching of  WEB & API тестов via selenoid execute command:
```
gradle clean web_api_test -Dos=desktop-remote
```

For local launching of mobile tests via Browserstack execute command:
```
gradle clean mobile_test -Dos=mobile-browserstack
```

For local launching of mobile tests via Android Studio emulator execute command:
```
gradle clean mobile_test -Dos=mobile-local
```

For local launching of mobile tests on real device execute command:
```
gradle clean mobile_test -Dos=mobile-real
```

## <b id="reports">Test reports available in Allure</b>

### <b id="allure"><img width="3%" title="Allure" src="src/test/resources/img/logo/Allure.svg"> Allure</b>

#### Main page

<img src="src/test/resources/img/screen/AllureMain.jpg" alt="Allure"/>

#### Graphics

<img src="src/test/resources/img/screen/AllureGraph.jpg" alt="Allure"/>

#### Tests

<img src="src/test/resources/img/screen/AllureTests.jpg" alt="Allure"/>

### <img width="3%" title="Telegram" src="src/test/resources/img/logo/Telegram.svg" id="telegram"> Telegram

Configured sending a report by a bot to Telegram

<img src="src/test/resources/img/screen/Bot.jpg" alt="Telegram"/>

## <b id="test_video">Test execution video</b>

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста
Allure reports have not only a screenshot, but also a video of passing each test attached

<p align="center">
  <img title="Video" src="src/test/resources/img/gif/test.gif">
</p>

## <b id="testops">Project is integrated with Allure TestOps</b>
<img width="3%" title="Allure" src="src/test/resources/img/logo/Allure_TO.svg"> 

#### Test-cases

<img src="src/test/resources/img/screen/TOTest.jpg" alt="TO"/>

#### Analytics dashboards

<img src="src/test/resources/img/screen/TODash.jpg" alt="TO"/>

#### Launchs

<img src="src/test/resources/img/screen/TOLaunch.jpg" alt="TO"/>

