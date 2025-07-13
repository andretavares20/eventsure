# 💡 Comandos cURL - EventSure

### 1. Criar uma assinatura (subscription)

```bash
curl -X POST http://localhost:8080/api/subscriptions \
  -H "Content-Type: application/json" \
  -d '{
    "name": "MeuWebhook",
    "url": "http://localhost:4000/webhook",
    "eventTypes": ["user.created", "user.updated"]
}'

curl -X POST http://localhost:8080/api/events \
  -H "Content-Type: application/json" \
  -d '{
    "eventType": "user.created",
    "payload": {
      "id": "123",
      "name": "João"
    },
    "eventId": "evt-001"
}'

curl http://localhost:8080/api/events/evt-001/delivery-status
