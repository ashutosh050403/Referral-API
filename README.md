# 📌 Spring Boot Referral Api

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
✅ 1. Signup a User (with referral code)
POST /api/users/signup

curl -X POST https://referral-api-production-a28f.up.railway.app/api/users/signup \
-H "Content-Type: application/json" \
-d '{
"name": "Ashish Maurya",
"email": "ashish@example.com",
"referredBy": "ac26fb35"
}'

✅ 2. Complete Profile
POST /api/users/complete-profile

curl -X POST https://referral-api-production-a28f.up.railway.app/api/users/complete-profile \
-H "Content-Type: application/json" \
-d '{
"userId": 2,
"name": "Ashish Maurya",
"profileCompleted": true
}'

✅ 3. Get Referrals by Referral Code
GET /api/referrals/code/{referralCode}

 CURL https://referral-api-production-a28f.up.railway.app/api/referrals/code/ac26fb35

✅ 4. Download CSV Referral Report
GET /api/referrals/full-report

curl -o referral_report.csv https://referral-api-production-a28f.up.railway.app/api/referrals/full-report
✅ This saves the CSV as referral_report.csv in your current directory.


- Download the sample csv from here
```
https://github.com/ashutosh050403/Referral-API/blob/master/referral_report.csv
```


