# API Автотесты для Petstore Swagger
Написать API - автотесты для сайта https://petstore.swagger.io/ по одному методу из любых блоков (GET,PUT,POST,DELETE). 

![Petstore Swagger](https://petstore.swagger.io/favicon-32x32.png)


## 🛠 Технологии

- Java
- REST Assured
- JUnit
- Allure
- Maven

## 📋 Предварительные требования

- Java JDK 8 или выше
- Maven
- Allure CLI (для просмотра отчетов)

## 🔧 Установка

1. Клонируйте репозиторий:
   git clone https://github.com/MrKiller941/API_Test
2. Перейдите в директорию проекта:
   cd API_Test

## 🏃‍♂️ Запуск тестов

Для запуска всех тестов выполните:

mvn test

## 📊 Генерация отчетов

Для генерации отчетов Allure выполните:


mvn allure:report

## 👀 Просмотр отчетов

Для запуска сервера Allure и просмотра отчетов выполните:


allure serve allure-results

## 📁 Структура проекта

```
src
└── test
    └── java
    ├── OrderTests.java
    ├── PetStoreTests.java
    ├── UserTests.java
```
