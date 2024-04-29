create table tb_Dono (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NUll,
    telefone VARCHAR(255) NOT NULL,
    rg VARCHAR(15) NOT NULL,
    data_nascimento DATE NOT NULL
);

create table tb_Raca(
	id SERIAL PRIMARY KEY,
	nome_raca VARCHAR(255) NOT NULL,
	especie VARCHAR(255) NOT NULL,
	porte_medio VARCHAR(50) NOT NULL,
	temperamento VARCHAR(50) NOT NULL
)

create table tb_Pet (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    especie VARCHAR(255) NOT NULL ,
    idade INT NOT NULL,
    gereno VARCHAR(50) NOT NULL,
    peso DECIMAL(5, 2) NOT NULL,
    raca_id INT,
    FOREIGN KEY (raca_id) REFERENCES tb_Raca(id)
)

CREATE TABLE tb_Veterinario(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    especialidade VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    crmv VARCHAR(20)
)

CREATE TABLE tb_Consulta(
    id SERIAL PRIMARY KEY,
    data_consulta TIMESTAMP NOT NULL,
    veterinario_id INT,
    pet_id INT,
    FOREIGN KEY (veterinario_id) REFERENCES tb_Veterinario(id),
    FOREIGN KEY (pet_id) REFERENCES tb_Pet(id)
)

CREATE TABLE tb_DonoPet (
    id SERIAL,
    pet_id SERIAL,
    dono_id SERIAL,
    FOREIGN KEY (dono_id) REFERENCES tb_Dono(id),
    FOREIGN KEY (pet_id) REFERENCES tb_Pet(id)
);







