CREATE TABLE valores_margem (
                                id_valores NVARCHAR(255) PRIMARY KEY,
                                fm FLOAT,
                                fe FLOAT,
                                fm_truck FLOAT,
                                fe_truck FLOAT,
                                fm_bitrem FLOAT,
                                fe_bitrem FLOAT,
                                fm_carreta FLOAT,
                                fe_carreta FLOAT,
                                fm_granel FLOAT,
                                fe_granel FLOAT,
                                fm_rodotrem FLOAT,
                                fe_rodotrem FLOAT,
                                id_margem VARCHAR(255) not null,
                                FOREIGN KEY (id_margem) REFERENCES margem(id)
);
