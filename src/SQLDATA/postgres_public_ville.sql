-- Table: public.ville

-- DROP TABLE public.ville;

CREATE TABLE public.ville
(
  vid integer NOT NULL DEFAULT nextval('ville_vid_seq'::regclass),
  nom character varying(25) NOT NULL,
  CONSTRAINT pk_ville PRIMARY KEY (vid)
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.ville
  OWNER TO postgres;




INSERT INTO public.ville (vid, nom) VALUES (1, 'burr Alpha');
INSERT INTO public.ville (vid, nom) VALUES (2, 'saint Cloud');
INSERT INTO public.ville (vid, nom) VALUES (3, 'defense');
INSERT INTO public.ville (vid, nom) VALUES (5, 'conakry');
INSERT INTO public.ville (vid, nom) VALUES (6, 'lyon');
INSERT INTO public.ville (vid, nom) VALUES (7, 'bust Alpha');
INSERT INTO public.ville (vid, nom) VALUES (28, 'Riviere du Loup');
INSERT INTO public.ville (vid, nom) VALUES (4, 'cdg');