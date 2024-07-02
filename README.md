# java-whatsapp-business-platform-tests
Connect to a whatsapp 4 business platform with java

### 1.configure account on facebook developers
Register a FB user on [https://developers.facebook.com/](https://developers.facebook.com/)

### 2.create a facebook application
Create an app with whatsapp-business enabled. see: [https://developers.facebook.com/docs/whatsapp/solution-providers/get-started-for-tech-providers](https://developers.facebook.com/docs/whatsapp/solution-providers/get-started-for-tech-providers)

### 3.associate fb user with the app
Follow the instruction provided by Meta on developers portal

### 4.associate webhooks
In the left menu of developer's site, in the "WhatsApp" sub-menu, open "configuration" in order to register a WebHook.  
Once the webhook URL has been registered, the list of events a webhook will receive can be configured in the WhatsApp > Configuration > WebHook fields


*NOTE:* webhook url cannot be a direct ngrok link (as whatsapp doesn't validate it). An AWS-ApiGateway can be created to forward calls like a reverse proxy. whatsapp accepts urls such as "https://XXX.execute-api.YYY.amazonaws.com/ZZZ"  
Guide: [https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-call-api.html](https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-call-api.html)

*NOTE2:* when a webhook is registered, whatsapp calls the endpoint with "subscribe" parameters, and the webhook must answer correctly with hub.challenge parameter. for details see: [https://glitch.com/edit/#!/whatsapp-cloud-api-echo-bot?path=server.js](https://glitch.com/edit/#!/whatsapp-cloud-api-echo-bot?path=server.js)
