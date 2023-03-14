CREATE TABLE top3
(
    id        SERIAL NOT NULL,
    created_at DATE   NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT top3_pkey PRIMARY KEY (id)
);

CREATE TABLE todo
(
    id       SERIAL  NOT NULL,
    title    TEXT    NOT NULL,
    complete BOOLEAN NOT NULL DEFAULT false,
    top3_id   INTEGER NOT NULL,

    CONSTRAINT todo_pkey PRIMARY KEY (id)
);

ALTER TABLE todo
    ADD CONSTRAINT todo_top3_id_fkey
        FOREIGN KEY (top3_id) REFERENCES top3 (id)
            ON DELETE CASCADE ON UPDATE CASCADE;
