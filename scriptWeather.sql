------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------



------------------------------------------------------------
-- Table: Confirmation
------------------------------------------------------------
CREATE TABLE public.Confirmation(
	Confirmation_id   SERIAL NOT NULL ,
	Confirmation_Flag BOOL  NOT NULL ,
	User_Id           INT  NOT NULL ,
	Indication_Id     INT  NOT NULL ,
	CONSTRAINT prk_constraint_Confirmation PRIMARY KEY (Confirmation_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: WebSite
------------------------------------------------------------
CREATE TABLE public.WebSite(
	WebSite_Id   SERIAL NOT NULL ,
	WebSite_Name VARCHAR (25)  ,
	WebSite_URL  VARCHAR (200)  ,
	CONSTRAINT prk_constraint_WebSite PRIMARY KEY (WebSite_Id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: User
------------------------------------------------------------
CREATE TABLE public.User(
	User_Id        SERIAL NOT NULL ,
	First_Name     VARCHAR (25)  ,
	Last_Name      VARCHAR (25)  ,
	User_Login     VARCHAR (25)  ,
	User_Password  VARCHAR (25)  ,
	User_Sincerity FLOAT   ,
	CONSTRAINT prk_constraint_User PRIMARY KEY (User_Id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Prediction
------------------------------------------------------------
CREATE TABLE public.Prediction(
	Prediction_Id   SERIAL NOT NULL ,
	Temperature     FLOAT   ,
	Humidity        FLOAT   ,
	Weather         VARCHAR (25)  ,
	Prediction_Date DATE   ,
	Region          VARCHAR (25)  ,
	Country         VARCHAR (25)  ,
	City            VARCHAR (25)  ,
	WebSite_Id      INT  NOT NULL ,
	CONSTRAINT prk_constraint_Prediction PRIMARY KEY (Prediction_Id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Indication
------------------------------------------------------------
CREATE TABLE public.Indication(
	Indication_Id      SERIAL NOT NULL ,
	Indication_Temp    FLOAT   ,
	Indication_Hum     FLOAT   ,
	Indication_Weather VARCHAR (50)  ,
	Indication_Count   INT   ,
	User_Id            INT  NOT NULL ,
	Prediction_Id      INT  NOT NULL ,
	CONSTRAINT prk_constraint_Indication PRIMARY KEY (Indication_Id)
)WITHOUT OIDS;



ALTER TABLE public.Confirmation ADD CONSTRAINT FK_Confirmation_User_Id FOREIGN KEY (User_Id) REFERENCES public.User(User_Id);
ALTER TABLE public.Confirmation ADD CONSTRAINT FK_Confirmation_Indication_Id FOREIGN KEY (Indication_Id) REFERENCES public.Indication(Indication_Id);
ALTER TABLE public.Prediction ADD CONSTRAINT FK_Prediction_WebSite_Id FOREIGN KEY (WebSite_Id) REFERENCES public.WebSite(WebSite_Id);
ALTER TABLE public.Indication ADD CONSTRAINT FK_Indication_User_Id FOREIGN KEY (User_Id) REFERENCES public.User(User_Id);
ALTER TABLE public.Indication ADD CONSTRAINT FK_Indication_Prediction_Id FOREIGN KEY (Prediction_Id) REFERENCES public.Prediction(Prediction_Id);
