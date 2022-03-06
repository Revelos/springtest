INSERT INTO cliente (cod_cliente, nombre, apellidos, dui, fecha_registro) VALUES (1, 'Cristian', 'Revelo', '1234567-9', '2017-08-28');
INSERT INTO cliente (cod_cliente, nombre, apellidos, dui, fecha_registro) VALUES (2, 'Fabiola', 'Martinez', '1235698-9', '1998-08-28');

INSERT INTO tipo_transaccion(id_tipo_transaccion, nombre_transaccion) VALUES(1,'Abonar');
INSERT INTO tipo_transaccion(id_tipo_transaccion, nombre_transaccion) VALUES(2,'Retirar');


INSERT INTO cuenta VALUES('ah1234','F','2022-01-01',560.60,'Cuenta de Ahorro',156540.60,1);
INSERT INTO cuenta VALUES('ah123','A','2022-01-01',1400.60,'Cuenta de Debito',560.60,1);
INSERT INTO cuenta VALUES('ah124','F','2022-01-01',56050.60,'Cuenta de Ahorro',560.60,2);



CREATE TRIGGER `Cambiar_Saldo` 
AFTER INSERT ON `transaccion` 
FOR EACH ROW BEGIN 
IF new.id_tipo_transaccion=1 THEN 
UPDATE cuenta SET cuenta.saldo=cuenta.saldo+new.valor_monetario WHERE cuenta.numero_cuenta=new.cuenta_numero_cuenta; 
ELSE 
UPDATE cuenta SET cuenta.saldo=cuenta.saldo-new.valor_monetario WHERE cuenta.numero_cuenta=new.cuenta_numero_cuenta; 
END IF; 
END 