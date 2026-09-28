curl --location 'http://localhost:8080/messages/string' \
--header 'Content-Type: text/plain' \
--data 'this is a text message'

curl --location 'http://localhost:8080/messages/json' \
--header 'Content-Type: application/json' \
--data '{
"customerId": 101,
"name": "Sumanth",
"accountType": "SAVINGS",
"amount": 5000
}'

curl --location 'http://localhost:8080/messages/xml' \
--header 'Content-Type: application/xml' \
--data '<CustomerMessage>
<customerId>101</customerId>
<name>Sumanth</name>
<accountType>SAVINGS</accountType>
<amount>5000</amount>
</CustomerMessage>'