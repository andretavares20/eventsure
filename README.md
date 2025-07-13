<img width="1591" height="651" alt="image" src="https://github.com/user-attachments/assets/7d34fe6b-c09a-4742-b286-c43f14a7359c" /># 🛰️ EventSure

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
- ✅ Armazenamento persistente com PostgreSQL
- ✅ Dead Letter Queue (DLQ) para eventos não entregues
- ✅ Monitoramento com Prometheus e Grafana
- ✅ Gerenciamento de assinaturas (endpoints, headers, status)
- ✅ Idempotência com controle por `eventId`

---

## 🧱 Arquitetura

<img width="1158" height="470" alt="image" src="https://github.com/user-attachments/assets/f1992c4f-7b99-4953-a152-4f60fd11e955" />

---

## ⚙️ Stack Utilizada

| Camada             | Tecnologia                |
|--------------------|---------------------------|
| Linguagem          | Java 17                   |
| Framework          | Spring Boot 3             |
| Mensageria         | RabbitMQ ou Kafka         |
| Banco de dados     | PostgreSQL                |
| Cache e DLQ        | Redis                     |
| Documentação API   | SpringDoc OpenAPI         |
| Observabilidade    | Micrometer + Prometheus   |
| Orquestração local | Docker Compose            |
| Testes             | JUnit 5, Testcontainers   |

---

## 🔎 Swagger UI

Após subir a aplicação, acesse:

👉 [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

---

## 🧪 Como Rodar

### 🔹 Usando Docker Compose

```bash
git clone https://github.com/andretavares20/eventsure.git
cd eventsure
cp .env.example .env
docker-compose up --build
