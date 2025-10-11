CREATE DATABASE tripbudgetplanner;

CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE Location (
                          id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                          city VARCHAR(150) NOT NULL,
                          country VARCHAR(100) NOT NULL
);

CREATE TABLE Users (
                       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                       last_name VARCHAR(250),
                       first_name VARCHAR(250),
                       username VARCHAR(250) UNIQUE NOT NULL,
                       password VARCHAR(250) NOT NULL,
                       mail VARCHAR(250) UNIQUE NOT NULL,
                       phone_numb VARCHAR(20),
                       birthday DATE,
                       pp VARCHAR(250),
                       location_id UUID REFERENCES Location(id) ON DELETE SET NULL
);

CREATE TABLE Friends (
                         id UUID PRIMARY KEY REFERENCES Users(id) ON DELETE CASCADE,
                         friends_ids UUID[] NOT NULL DEFAULT '{}'
);

CREATE TABLE TravelGroup (
                             id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                             name VARCHAR(100) NOT NULL,
                             member_ids UUID[] NOT NULL DEFAULT '{}',
                             created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

