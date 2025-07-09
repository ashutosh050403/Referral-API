# 📌 Spring Boot PDF Reader API (LLM-powered)

This is a **Java Spring Boot** API that  tracks user signups via referral codes and generates detailed referral reports in CSV format. .

🚀 **Live Deployment:** Hosted on Railway

---

## 🔧 Features
- 📄 Extracts referral report in form of csv file from DB.
- 🌍 Publicly deployable API.

---

## 🛠️ Tech Stack
- **Backend:** Java, Spring Boot
- **Hosting:** Railway
- **Version Control:** Git & GitHub

---

## 🛠️ Testing api
- Hit this curl
```
curl --location 'https://casaextracter-98b49cc702e1.herokuapp.com/casa/pdf/parse' \
--form 'file=@"/C:/Users/adars/Downloads/sample_casa_statement.pdf"'
```

- Download the sample pdf from here
```
https://github.com/Adars987h/casaextracter/blob/main/sample_casa_statement.pdf
```

- In postman go to body then form-data and attach this file.
