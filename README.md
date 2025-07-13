# 🛰️ EventSure

**EventSure** é uma plataforma robusta e extensível para **entrega confiável de eventos via Webhooks**.  
Projetado para resolver problemas de confiabilidade, escalabilidade e rastreabilidade no envio de eventos entre sistemas distribuídos.

---

## 🚀 Visão Geral

O EventSure atua como um **event delivery gateway**, permitindo que sistemas publiquem eventos que são processados, armazenados, entregues e monitorados com segurança.

### Funcionalidades principais:
- Garantia de entrega com retries e backoff exponencial
- Controle de assinaturas e destinos por serviço
- Observabilidade com logs, métricas e dead-letter
- Isolamento entre serviços via partições
- API simples e escalável para publicação e gerenciamento

---

## 🧩 Principais Recursos

- ✅ Publicação de eventos via API REST
- ✅ Entregas assíncronas com mecanismo de retries configurável
- ✅ Particionamento de filas por tenant ou cliente
- ✅ Armazenamento persistente com MySQL
- ✅ Dead Letter Queue (DLQ) para eventos não entregues
- ✅ Monitoramento com Prometheus e Grafana
- ✅ Gerenciamento de assinaturas (endpoints, headers, status)
- ✅ Idempotência com controle por `eventId`

---

## 🧱 Arquitetura

<img width="1612" height="693" alt="image" src="https://github.com/user-attachments/assets/051a4db3-e64c-4058-a0d6-23f22aee72a3" />

---

## ⚙️ Stack Utilizada

| Camada             | Tecnologia                |
|--------------------|---------------------------|
| Linguagem          | Java 17                   |
| Framework          | Spring Boot 3             |
| Mensageria         | RabbitMQ ou Kafka         |
| Banco de dados     | MySQL                     |
| Cache e DLQ        | Redis                     |
| Documentação API   | SpringDoc OpenAPI         |
| Observabilidade    | Micrometer + Prometheus   |
| Orquestração local | Docker Compose            |
| Testes             | JUnit 5, Testcontainers   |

---

## 🔎 Swagger UI

Após subir a aplicação, acesse:

👉 [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

📄 Para visualizar a especificação OpenAPI:

- JSON: [`http://localhost:8080/v3/api-docs`](http://localhost:8080/v3/api-docs)
- [Editor Swagger Online](https://editor.swagger.io/?url=http://localhost:8080/v3/api-docs)

---

## 🧪 Como Rodar

### 🔹 Usando Docker Compose

```bash
git clone https://github.com/andretavares20/eventsure.git
cd eventsure
cp .env.example .env
docker-compose up --build -d
```

A aplicação será exposta em `http://localhost:8080`.

### 🔹 Rodando localmente com Maven

> Requer MySQL, Redis e RabbitMQ rodando localmente (ou via Docker).

```bash
./mvnw spring-boot:run
```

---

## 📄 .env.example

```env
# Database
SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/eventsure
SPRING_DATASOURCE_USERNAME=eventsure
SPRING_DATASOURCE_PASSWORD=eventsure123

# Redis
SPRING_REDIS_HOST=redis
SPRING_REDIS_PORT=6379

# RabbitMQ
SPRING_RABBITMQ_HOST=rabbitmq
SPRING_RABBITMQ_PORT=5672
SPRING_RABBITMQ_USERNAME=guest
SPRING_RABBITMQ_PASSWORD=guest

# Server
SERVER_PORT=8080
```

---

## 🧪 Exemplo de Uso End-to-End

### 🔹 Comandos `cURL`

```bash
# Criar assinatura
curl -X POST http://localhost:8080/api/subscriptions   -H "Content-Type: application/json"   -d '{
    "name": "MeuWebhook",
    "url": "http://localhost:4000/webhook",
    "eventTypes": ["user.created", "user.updated"]
}'

# Enviar evento
curl -X POST http://localhost:8080/api/events   -H "Content-Type: application/json"   -d '{
    "eventType": "user.created",
    "payload": {
      "id": "123",
      "name": "João"
    },
    "eventId": "evt-001"
}'

# Verificar status de entrega
curl http://localhost:8080/api/events/evt-001/delivery-status
```

---

### 🔹 Postman Collection

Importe o arquivo `examples/postman-collection.json` no Postman para testar:

- Criar assinatura
- Enviar evento
- Verificar status da entrega

---

### 🔹 Mock Webhook Receiver (opcional)

Execute um receptor de webhook local para testes:

```bash
cd examples
npm install express
node mock-server.js
```

> Isso inicia um servidor escutando em `http://localhost:4000/webhook` que imprime os eventos recebidos.

---
