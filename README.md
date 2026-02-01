# Gendiff — Difference Calculator ⚙️

### Hexlet tests, CI & Code Quality
[![SonarQube](https://github.com/nodirbek9/java-project-71/actions/workflows/build.yml/badge.svg)](https://github.com/nodirbek9/java-project-71/actions/workflows/build.yml)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=nodirbek9_java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=nodirbek9_java-project-71)
[![Actions Status](https://github.com/nodirbek9/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/nodirbek9/java-project-71/actions)

---

## 🧩 Описание проекта

**Gendiff** — консольная утилита для сравнения двух конфигурационных файлов.  
Поддерживает форматы **JSON** и **YAML**, умеет работать с **вложенными структурами** и выводить результат в нескольких форматах.

Проект реализован в рамках обучения на **Hexlet (Java Developer)** с упором на:
- TDD (разработка через тестирование)
- чистую архитектуру
- автоматическую проверку качества кода (CI, Coverage, Linter)

---

## 📦 Поддерживаемые форматы файлов

- JSON (`.json`)
- YAML (`.yml`, `.yaml`)

---

## 🖨 Форматы вывода

- **stylish** (по умолчанию) — древовидный дифф
- **plain** — текстовый формат для логов
- **json** — структурированный вывод для интеграций

---

## 🚀 Установка и запуск

### Требования
- **Java 21** или новее
- **Gradle**

### Клонирование репозитория
```bash
git clone https://github.com/nodirbek9/java-project-71.git
cd java-project-71/app
``` 
Сборка проекта
``` 
./gradlew build
```

Запуск утилиты
``` 
./build/install/app/bin/app file1.json file2.json
```

🔧 Использование
Формат stylish (по умолчанию)
```
./build/install/app/bin/app file1.json file2.json
```

Формат plain
```
./build/install/app/bin/app -f plain file1.json file2.json
```
Формат json
```
./build/install/app/bin/app -f json file1.json file2.json
```


### 📊 Примеры работы
🔹 Сравнение JSON файлов

https://asciinema.org/a/Wr3SKi7qlW47MtNP

🔹 Сравнение YAML файлов

https://asciinema.org/a/AQiURjm1mRqWjdMK

🔹 Вложенные структуры (stylish)

https://asciinema.org/a/FIuxE09YiGGtmJ3q

🔹 Формат plain

https://asciinema.org/a/vmBSOU9AzGZmTeUQ

🔹 Формат json

https://asciinema.org/a/LdOKa92G6jFkZuZ2

### 🛠 Технологии и инструменты

- Java 21
- Gradle
- JUnit 5 — модульное тестирование
- Jackson — парсинг JSON / YAML
- Picocli — CLI интерфейс
- Checkstyle — статический анализ кода
- JaCoCo — покрытие тестами
- GitHub Actions — CI
- SonarQube / SonarCloud — анализ качества кода

### 🧱 Архитектура проекта
```
App
 └─ Differ
     ├─ Parser (json / yaml)
     ├─ DiffBuilder (формирование дифа)
     ├─ Diff / DiffNode (внутреннее представление)
     └─ formatters
         ├─ StylishFormat
         ├─ PlainFormat
         └─ JsonFormat
```
### Ключевые идеи:

- парсинг отделён от логики сравнения

- форматирование отделено от вычисления дифа

- легко добавлять новые форматы вывода

- единое внутреннее представление дифа

## 👨‍💻 Автор

Нодирбек
Java Backend Developer (in progress 🚀)