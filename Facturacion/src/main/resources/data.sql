INSERT INTO CLIENT (client_id, client_name, client_lastname, client_docnumber) values
(1, 'Franco', 'Ciprian', 12345678),
(2, 'María', 'Rodríguez', 23456789),
(3, 'Carlos', 'González', 34567890);

INSERT INTO PRODUCT (prod_id, prod_description, prod_code, prod_stock, prod_price) values
(1, 'Cafe' , '000', 20, 100.00),
(2, 'Leche', '001', 30, 110.05),
(3, 'Azucar', '002', 40, 90.10);

INSERT INTO INVOICE (invc_id, invc_client_id, invc_created_at, invc_total) values
(1, 1, '2023-09-10 17:25:01', 960.40),
(2, 1, '2023-09-10 12:52:26', 221.00),
(3, 3, '2023-09-10 19:00:00', 270.30);

INSERT INTO INVOICE_DETAIL (invc_detail_id, invc_detail_invc_id, invc_detail_amount, invc_detail_prod_id, invc_detail_price) values
(1, 1, 6, 1, 600.00),
(2, 2, 2, 2, 221.00),
(3, 3, 3, 3, 270.30),
(4, 1, 4, 3, 360.40);
