-- Table: public.electeur

-- DROP TABLE public.electeur;

CREATE TABLE public.electeur
(
  eid integer NOT NULL DEFAULT nextval('electeur_eid_seq'::regclass),
  nom character varying(25) NOT NULL,
  prenom character varying(55),
  bid integer NOT NULL,
  vid bigint,
  CONSTRAINT pk_electeur PRIMARY KEY (eid),
  CONSTRAINT fkr2hq6aytbx9cd7amarph20d7b FOREIGN KEY (bid, vid)
  REFERENCES public.bureauvote (bid, vid) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.electeur
  OWNER TO postgres;


INSERT INTO public.electeur (eid, nom, prenom, bid, vid) VALUES (2, 'Diallo', 'Alpha', 7, 1);
INSERT INTO public.electeur (eid, nom, prenom, bid, vid) VALUES (1, 'Diallo', 'Aissatou t', 7, 1);