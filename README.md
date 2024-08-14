docker run -d --name rabbitmq -p5672:5672 -p 15672:15672 --restart=unless-stopped rabbitmq:management  -> 도커 를 통해 RabbiMq 설치 후 실습 진행 했습니다

\n

Order 프로젝트에서 발행한 메시지가 Payment Consumer가 실행되자마자 소모 화면
<img width="1000" alt="result1" src="https://github.com/user-attachments/assets/79090809-3e6f-437d-9027-ee7b7d26b86c">
![RabbitMq 화면](https://github.com/user-attachments/assets/d3f746c8-40d9-4620-be0a-6f9b8b9871bc)



\n

order에서 요청 할때마다 Product Application이 번갈아 가면서 메시지를 수신 결과 화면
<img width="710" alt="1" src="https://github.com/user-attachments/assets/309c9d9d-ffe8-4554-becc-7ea96c227710">
<img width="710" alt="2" src="https://github.com/user-attachments/assets/deb99eca-4d6c-4cb2-acf9-cdf81ac2a357">
