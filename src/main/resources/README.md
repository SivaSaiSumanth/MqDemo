			Postman
			│
			│ POST /messages
			▼
			Spring Boot Controller
			│
			▼
			JmsTemplate
			│
			▼
			IBM MQ Client
			│
			│ DEV.APP.SVRCONN
			▼
			DEVQM
			│
			▼
			DEV.QUEUE.1
			│
			▼
			@JmsListener
			│
			▼
			Received message from IBM MQ:
			Hello from Postman to IBM MQ!