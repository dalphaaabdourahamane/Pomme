-- Table: public.bureauvote

-- DROP TABLE public.bureauvote;

CREATE TABLE public.bureauvote
(
  bid integer NOT NULL,
  nom character varying(25) NOT NULL,
  cp integer,
  rue character varying(55),
  vid integer NOT NULL,
  CONSTRAINT bureauvote_bid_vid_pk PRIMARY KEY (bid, vid),
  CONSTRAINT fkkh460go2jgyqa7f83i3j8x38r FOREIGN KEY (vid)
  REFERENCES public.ville (vid) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.bureauvote
  OWNER TO postgres;



INSERT INTO public.bureauvote (bid, nom, cp, rue, vid) VALUES (7, 'alpha bur', 92210, 'king alpha', 1);
INSERT INTO public.bureauvote (bid, nom, cp, rue, vid) VALUES (7, 'beta ', 92190, 'saint beta', 2);
INSERT INTO public.bureauvote (bid, nom, cp, rue, vid) VALUES (7, 'alpha bur', 92210, 'king alpha', 3);
INSERT INTO public.bureauvote (bid, nom, cp, rue, vid) VALUES (6, 'Alpha Pres', 92110, 'king alpha Pres', 28);
INSERT INTO public.bureauvote (bid, nom, cp, rue, vid) VALUES (7, 'Alpha delta', 92110, 'king alpha delta', 28);
INSERT INTO public.bureauvote (bid, nom, cp, rue, vid) VALUES (7, 'Alpha delta', 92110, 'king alpha delta', 4);