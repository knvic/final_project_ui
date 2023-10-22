
<h1> Проект по автоматизации тестовых сценариев для сайта цифровой платформы для организации командировок и управления расходами  </h1>

## :pushpin: Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Запуск тестов из терминала](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-тестов-в-selenoid)
  
## :computer: Использованный стек технологий


<p align="center">
<img width="6%" title="Java" src="media/logo/Java.svg">
<img width="6%" title="Selenide" src="media/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="media/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="media/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="media/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="media/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="media/logo/Jenkins.svg">
<img width="6%" title="Jenkins" src="media/logo/AllureTestOps.svg">
<img width="6%" title="Jenkins" src="media/logo/Jira.svg">
<img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg">
<img width="6%" title="Telegram" src="media/logo/Telegram.svg">
</p>

- В данном проекте автотесты написаны на языке `Java` с использованием фреймворка для тестирования `Selenide`.
- В качестве сборщика был использован - `Gradle`.
- Использованы фреймворки `JUnit 5` и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в `Jenkins` с формированием Allure-отчета и отправкой результатов в `Telegram` при помощи бота.


Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала
```
gradle clean run_raketa  -Denv=remote

```
При выполнении команды, данные тесты запустятся удаленно в <code>Selenoid</code>.


При необходимости также можно переопределить параметры запуска

```
clean
${TASK} -DremoteUrl=${SELENOID_URL}

```

### Параметры сборки

* <code>REMOTE_BROWSER_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.

## <img src="media/logo/Jenkins.svg" title="Jenkins" width="4%"/> Сборка в Jenkins

Для запуска сборки необходимо перейти в раздел Собрать с параметрами и нажать кнопку Собрать.



<kbd>[![](media/screens/jenkins1.PNG)](https://jenkins.autotests.cloud/job/021-knvik-jenkins_raketa_all_alltops_jira_tg/)</kbd>

## <img src="media/logo/Allure_Report.svg" title="Allure Report" width="4%"/> Пример Allure-отчета
### Overview



<kbd>[![](media/screens/Allure1.PNG)](https://jenkins.autotests.cloud/job/021-knvik-jenkins_raketa_all_alltops_jira_tg/16/allure/#)</kbd>

### Результат выполнения теста

<kbd>[![](media/screens/Allure2.PNG)](https://jenkins.autotests.cloud/job/021-knvik-jenkins_raketa_all_alltops_jira_tg/16/allure/#suites/129ac936ae3c796ae95cabb5edc1b869/16a8391194530603/
)</kbd>



<kbd>[![](media/screens/Allure3.PNG)](https://jenkins.autotests.cloud/job/021-knvik-jenkins_raketa_all_alltops_jira_tg/16/allure/#behaviors/ad278f761a7c8b2f9f37925e0bd8ca8e/db272aebe61ef5c/
)</kbd>

## <img src="media/logo/AllureTestOps.svg" title="Allure TestOps" width="4%"/> Интеграция с Allure TestOps

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.


<kbd>[![](media/screens/AllureTestOpsDash.PNG)](https://allure.autotests.cloud/project/3718/dashboards)</kbd>


<kbd>[![](media/screens/AllureTestOps.PNG)](https://allure.autotests.cloud/project/3718/test-cases/26691?treeId=0)</kbd>

## <img src="media/logo/Jira.svg" title="Jira" width="4%"/> Интеграция с Jira

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается информация, какие тест-кейсы были написаны в рамках задачи и результат их прогона.



<kbd>[![](media/screens/Jira.PNG)](https://jira.autotests.cloud/browse/HOMEWORK-914)</kbd>


## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/telegram.PNG">
</p>

## Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/screens/VideoTest.gif">
</p>