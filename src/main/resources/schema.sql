CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    profile_completed BOOLEAN DEFAULT FALSE,
    referral_code VARCHAR(20) UNIQUE NOT NULL,
    referred_by VARCHAR(20)
    );

CREATE TABLE IF NOT EXISTS referral (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        referral_code VARCHAR(20) NOT NULL,
    referred_user_id BIGINT NOT NULL,
    is_successful BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (referred_user_id) REFERENCES users(id)
    );
