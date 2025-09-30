ALTER TABLE patio
    ADD capacidade_maxima INTEGER;

ALTER TABLE patio
    ALTER COLUMN capacidade_maxima SET NOT NULL;
