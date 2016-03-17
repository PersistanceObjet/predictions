--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.1

-- Started on 2016-03-17 19:37:44

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 16511)
-- Name: confirmation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE confirmation (
    confirmation_id integer NOT NULL,
    confirmation_flag boolean NOT NULL,
    user_id integer NOT NULL,
    indication_id integer NOT NULL
);


ALTER TABLE confirmation OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16509)
-- Name: confirmation_confirmation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE confirmation_confirmation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE confirmation_confirmation_id_seq OWNER TO postgres;

--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 181
-- Name: confirmation_confirmation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE confirmation_confirmation_id_seq OWNED BY confirmation.confirmation_id;


--
-- TOC entry 190 (class 1259 OID 16543)
-- Name: indication; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE indication (
    indication_id integer NOT NULL,
    indication_temp double precision,
    indication_hum double precision,
    indication_weather character varying(50),
    indication_count integer,
    user_id integer NOT NULL,
    prediction_id integer NOT NULL
);


ALTER TABLE indication OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 16541)
-- Name: indication_indication_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE indication_indication_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE indication_indication_id_seq OWNER TO postgres;

--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 189
-- Name: indication_indication_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE indication_indication_id_seq OWNED BY indication.indication_id;


--
-- TOC entry 188 (class 1259 OID 16535)
-- Name: prediction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE prediction (
    prediction_id integer NOT NULL,
    temperature double precision,
    humidity double precision,
    weather character varying(25),
    prediction_date date,
    region character varying(25),
    country character varying(25),
    city character varying(25),
    website_id integer NOT NULL
);


ALTER TABLE prediction OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16533)
-- Name: prediction_prediction_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE prediction_prediction_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE prediction_prediction_id_seq OWNER TO postgres;

--
-- TOC entry 2159 (class 0 OID 0)
-- Dependencies: 187
-- Name: prediction_prediction_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE prediction_prediction_id_seq OWNED BY prediction.prediction_id;


--
-- TOC entry 186 (class 1259 OID 16527)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "user" (
    user_id integer NOT NULL,
    first_name character varying(25),
    last_name character varying(25),
    user_login character varying(25),
    user_password character varying(25),
    user_sincerity double precision
);


ALTER TABLE "user" OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16525)
-- Name: user_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_user_id_seq OWNER TO postgres;

--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 185
-- Name: user_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE user_user_id_seq OWNED BY "user".user_id;


--
-- TOC entry 184 (class 1259 OID 16519)
-- Name: website; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE website (
    website_id integer NOT NULL,
    website_name character varying(25),
    website_url character varying(200)
);


ALTER TABLE website OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 16517)
-- Name: website_website_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE website_website_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE website_website_id_seq OWNER TO postgres;

--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 183
-- Name: website_website_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE website_website_id_seq OWNED BY website.website_id;


--
-- TOC entry 2005 (class 2604 OID 16514)
-- Name: confirmation_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY confirmation ALTER COLUMN confirmation_id SET DEFAULT nextval('confirmation_confirmation_id_seq'::regclass);


--
-- TOC entry 2009 (class 2604 OID 16546)
-- Name: indication_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indication ALTER COLUMN indication_id SET DEFAULT nextval('indication_indication_id_seq'::regclass);


--
-- TOC entry 2008 (class 2604 OID 16538)
-- Name: prediction_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prediction ALTER COLUMN prediction_id SET DEFAULT nextval('prediction_prediction_id_seq'::regclass);


--
-- TOC entry 2007 (class 2604 OID 16530)
-- Name: user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user" ALTER COLUMN user_id SET DEFAULT nextval('user_user_id_seq'::regclass);


--
-- TOC entry 2006 (class 2604 OID 16522)
-- Name: website_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY website ALTER COLUMN website_id SET DEFAULT nextval('website_website_id_seq'::regclass);


--
-- TOC entry 2140 (class 0 OID 16511)
-- Dependencies: 182
-- Data for Name: confirmation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY confirmation (confirmation_id, confirmation_flag, user_id, indication_id) FROM stdin;
\.


--
-- TOC entry 2162 (class 0 OID 0)
-- Dependencies: 181
-- Name: confirmation_confirmation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('confirmation_confirmation_id_seq', 1, false);


--
-- TOC entry 2148 (class 0 OID 16543)
-- Dependencies: 190
-- Data for Name: indication; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY indication (indication_id, indication_temp, indication_hum, indication_weather, indication_count, user_id, prediction_id) FROM stdin;
\.


--
-- TOC entry 2163 (class 0 OID 0)
-- Dependencies: 189
-- Name: indication_indication_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('indication_indication_id_seq', 1, false);


--
-- TOC entry 2146 (class 0 OID 16535)
-- Dependencies: 188
-- Data for Name: prediction; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY prediction (prediction_id, temperature, humidity, weather, prediction_date, region, country, city, website_id) FROM stdin;
\.


--
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 187
-- Name: prediction_prediction_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('prediction_prediction_id_seq', 1, false);


--
-- TOC entry 2144 (class 0 OID 16527)
-- Dependencies: 186
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "user" (user_id, first_name, last_name, user_login, user_password, user_sincerity) FROM stdin;
\.


--
-- TOC entry 2165 (class 0 OID 0)
-- Dependencies: 185
-- Name: user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_user_id_seq', 1, false);


--
-- TOC entry 2142 (class 0 OID 16519)
-- Dependencies: 184
-- Data for Name: website; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY website (website_id, website_name, website_url) FROM stdin;
\.


--
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 183
-- Name: website_website_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('website_website_id_seq', 1, false);


--
-- TOC entry 2011 (class 2606 OID 16516)
-- Name: prk_constraint_confirmation; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY confirmation
    ADD CONSTRAINT prk_constraint_confirmation PRIMARY KEY (confirmation_id);


--
-- TOC entry 2019 (class 2606 OID 16548)
-- Name: prk_constraint_indication; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indication
    ADD CONSTRAINT prk_constraint_indication PRIMARY KEY (indication_id);


--
-- TOC entry 2017 (class 2606 OID 16540)
-- Name: prk_constraint_prediction; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prediction
    ADD CONSTRAINT prk_constraint_prediction PRIMARY KEY (prediction_id);


--
-- TOC entry 2015 (class 2606 OID 16532)
-- Name: prk_constraint_user; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT prk_constraint_user PRIMARY KEY (user_id);


--
-- TOC entry 2013 (class 2606 OID 16524)
-- Name: prk_constraint_website; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY website
    ADD CONSTRAINT prk_constraint_website PRIMARY KEY (website_id);


--
-- TOC entry 2021 (class 2606 OID 16554)
-- Name: fk_confirmation_indication_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY confirmation
    ADD CONSTRAINT fk_confirmation_indication_id FOREIGN KEY (indication_id) REFERENCES indication(indication_id);


--
-- TOC entry 2020 (class 2606 OID 16549)
-- Name: fk_confirmation_user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY confirmation
    ADD CONSTRAINT fk_confirmation_user_id FOREIGN KEY (user_id) REFERENCES "user"(user_id);


--
-- TOC entry 2024 (class 2606 OID 16569)
-- Name: fk_indication_prediction_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indication
    ADD CONSTRAINT fk_indication_prediction_id FOREIGN KEY (prediction_id) REFERENCES prediction(prediction_id);


--
-- TOC entry 2023 (class 2606 OID 16564)
-- Name: fk_indication_user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indication
    ADD CONSTRAINT fk_indication_user_id FOREIGN KEY (user_id) REFERENCES "user"(user_id);


--
-- TOC entry 2022 (class 2606 OID 16559)
-- Name: fk_prediction_website_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prediction
    ADD CONSTRAINT fk_prediction_website_id FOREIGN KEY (website_id) REFERENCES website(website_id);


--
-- TOC entry 2155 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-03-17 19:37:45

--
-- PostgreSQL database dump complete
--

