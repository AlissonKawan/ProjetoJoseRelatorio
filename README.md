# 📊 Projeto José Relatório

Sistema desenvolvido em **Java + Spring Boot** para processar relatórios de atividades (como uso de moto 🛵), calculando automaticamente:

- Quilometragem total
- Tempo extra trabalhado
- Valor a receber

---

## 🚀 Acesse o projeto online

🔗 https://projetojoserelatorio.onrender.com

> ⚠️ O servidor gratuito pode demorar alguns segundos para responder após inatividade.

---

## 🧠 Como funciona

O sistema recebe uma lista de textos (relatórios) e:

1. Identifica informações como KM e horário
2. Processa cada relatório
3. Calcula automaticamente:
    - Total de KM rodados
    - Minutos extras
    - Valor total

---

## 📡 Endpoints

### 🔹 Teste da API

GET /relatorios/teste

Resposta:
API funcionando!

---

### 🔹 Processar relatórios

POST /relatorios

### 📥 Exemplo de requisição:

```json
[
  "Relatório de Moto 🛵 Saída: 18:30 Total Rodado: 10km",
  "Relatório de Moto 🛵 Saída: 19:10 Total Rodado: 5km"
]
```

### 📤 Exemplo de resposta:

KM: 15 | Minutos: 70 | Valor: 38.50

---

## 🛠️ Tecnologias

- Java 17
- Spring Boot
- Maven
- Docker
- Render

---

## 💻 Rodando localmente

### Pré-requisitos

- Java 17+
- Maven (ou usar `mvnw`)

### Executar o projeto

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

---

## 📦 Gerar arquivo .jar

```bash
./mvnw clean package
```

O arquivo será gerado em:

target/JoseRelatorio-0.0.1-SNAPSHOT.jar

---

## ☁️ Deploy

O projeto está hospedado no **Render**, utilizando Docker para garantir compatibilidade com Java.

---

## 📌 Melhorias futuras

- Interface web (frontend) para facilitar uso
- Upload de arquivos de relatório
- Histórico de relatórios processados
- Sistema de autenticação

---

## 👨‍💻 Autor

**Alisson Kawan**  
Estudante de Análise e Desenvolvimento de Sistemas

---

## ❤️ Objetivo

Projeto criado para resolver um problema real:  
automatizar o cálculo de relatórios de trabalho de forma simples, rápida e acessível.