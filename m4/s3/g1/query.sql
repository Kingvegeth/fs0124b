SELECT * FROM g1.clienti
		WHERE "Nome" = 'Mario';
		
SELECT "Nome", "Cognome" FROM g1.clienti
		WHERE "AnnoNascita" = 1982;
		
SELECT "NumeroFattura" FROM g1.fatture
		WHERE "Iva" = 20;
		
SELECT * FROM g1.prodotti
		WHERE EXTRACT(YEAR FROM "DataAttivazione") = 1997 AND ("InProduzione" = true OR "InCommercio" = true);
		
SELECT * FROM g1.fatture
		JOIN g1.clienti ON "NumeroCliente" = "IdCliente"
		WHERE "Importo" < 1000;
		
SELECT EXTRACT(YEAR FROM "DataFattura") AS "Anno", COUNT("DataFattura") AS "Numero Fatture" 
		FROM g1.fatture
		WHERE "Iva" = 20
		GROUP BY EXTRACT(YEAR FROM "DataFattura");
		
SELECT EXTRACT(YEAR FROM "DataFattura") AS "Anno", COUNT("DataFattura") AS "Numero Fatture", SUM("Importo") AS "Importo Totale" 
		FROM g1.fatture
		GROUP BY EXTRACT(YEAR FROM "DataFattura");
		
SELECT EXTRACT(YEAR FROM "DataFattura") AS "Anno", COUNT("DataFattura") AS "Numero Fatture"
		FROM g1.fatture
		WHERE "Tipologia" = 'A'
		GROUP BY EXTRACT(YEAR FROM "DataFattura")
		HAVING COUNT("DataFattura") > 2;
		
SELECT COUNT(*),  SUM("Importo") AS "Importo Totale", "RegioneResidenza" AS "Regione"
		FROM g1.fatture
		JOIN g1.clienti ON "NumeroCliente" = "IdCliente"
		GROUP BY "RegioneResidenza";
		
SELECT * FROM g1.fatture 
		WHERE "IdCliente" IN 
		(SELECT "NumeroCliente" FROM g1.clienti WHERE "AnnoNascita" = 1980) 
		AND "Importo" > 50