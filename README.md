🛰️ EventSure
EventSure é uma plataforma robusta e extensível para entrega confiável de eventos via Webhooks. Foi projetada para resolver problemas de confiabilidade, escalabilidade e rastreabilidade no envio de eventos entre sistemas distribuídos.

🚀 Visão Geral
O EventSure atua como um event delivery gateway, permitindo que sistemas publiquem eventos que são processados, armazenados, entregues e monitorados com segurança. A plataforma oferece:

Garantia de entrega com retries e backoff exponencial

Controle de assinaturas e destinos por serviço

Observabilidade com logs, métricas e dead-letter

Isolamento entre serviços via partições

API simples e escalável para publicação e gerenciamento

🧩 Principais Recursos
✅ Publicação de Eventos via API REST

✅ Entregas assíncronas com mecanismo de retries

✅ Particionamento de filas por tenant ou cliente

✅ Armazenamento persistente com PostgreSQL

✅ Dead Letter Queue (DLQ) para eventos falhos

✅ Monitoramento e métricas com Prometheus/Grafana

✅ Gerenciamento de assinaturas (endpoints + headers customizados)

✅ Idempotência com controle por eventId

✅ Diagrama de fluxo incluído

🧱 Arquitetura

<sub>Você pode gerar o diagrama no https://excalidraw.com ou usar Mermaid no README se preferir Markdown puro.</sub>

⚙️ Stack Utilizada
Camada	Tecnologia
Linguagem	Java 17
Framework	Spring Boot 3
Mensageria	RabbitMQ ou Kafka
Banco de dados	PostgreSQL
Cache e DLQ	Redis
Documentação API	SpringDoc OpenAPI
Observabilidade	Micrometer, Prometheus
Orquestração local	Docker Compose
Testes	JUnit 5, Testcontainers

🔎 Swagger UI
Após rodar a aplicação localmente, acesse:

👉 http://localhost:8080/swagger-ui.html

🧪 Como Rodar
🔹 Com Docker Compose
bash
Copiar
Editar
git clone https://github.com/andretavares20/eventsure.git
cd eventsure
cp .env.example .env
docker-compose up --build
🔹 Ou com Maven (modo dev)
Certifique-se que PostgreSQL e Redis estejam ativos localmente.

bash
Copiar
Editar
./mvnw spring-boot:run
