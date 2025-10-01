-- Inserindo dados iniciais nos patios
INSERT INTO patio (nome, endereco, capacidade_maxima, cidade, estado, pais, dimensaox, dimensaoy)
VALUES
    ('Patio Central', 'Rua A, 123', 50, 'São Paulo', 'SP', 'Brasil', 100.0, 200.0),
    ('Patio Norte', 'Av. B, 456', 30, 'Rio de Janeiro', 'RJ', 'Brasil', 80.0, 150.0);

-- Inserindo eventos das motos
INSERT INTO evento_moto (tipo, times_tamp, observacao, fonte_evento)
VALUES
    ('Entrada', '2025-09-30 10:30:00', 'Moto chegou no patio', 'MANUAL'),
    ('Saida', '2025-09-30 12:00:00', 'Moto saiu para manutenção', 'SISTEMA'),
    ('Manutencao', '2025-09-30 14:00:00', 'Troca de óleo realizada', 'SISTEMA'),
    ('Entrada', '2025-09-30 15:30:00', 'Moto retornou da manutenção', 'MANUAL'),
    ('Saida', '2025-09-30 16:00:00', 'Moto saiu para entrega', 'MANUAL');
