<h1 align="center">CODERHOUSE - Programación con Java</h1>

# 🧾 Proyecto de Facturación

1. [Descripción del Proyecto](#descripción-del-proyecto)
2. [Endpoints](#endpoints)
   - [Cliente](#cliente)
   - [Producto](#producto)
   - [Factura](#factura)
3. [Ejemplos de Solicitudes POST](#ejemplos-de-solicitudes-post)
4. [Ejemplos de Solicitudes POST](#ejemplos-de-solicitudes-get)


### Descripción del Proyecto

Proyecto final para el curso de Programación con Java dictado por CoderHouse.

# ⚡️ Endpoints

### Cliente

- **POST** `/api/client/` Guardar un nuevo cliente.
- **GET** `/api/client/{id}` Buscar un cliente por Id.
- **GET** `/api/client/all` Buscar todos los clientes.
- **DELETE** `/api/client/{id}` Eliminar un cliente por Id.

### Producto

- **POST** `/api/product/` Guardar un nuevo producto.
- **GET** `/api/product/{id}` Buscar un producto por Id.
- **GET** `/api/product/all` Buscar todos los productos.
- **DELETE** `/api/product/{id}` Eliminar un producto por Id.

### Factura

- **GET** `/api/invoice/` Guardar una nueva factura.
- **POST** `/api/invoice/` Buscar una factura por Id.
- **GET** `/api/invoice/{id}` Buscar todas las facturas.
- **DELETE** `/api/invoice/{id}` Eliminar una factura por Id.

# ⚡️ Ejemplos de Solicitudes POST

A continuación se muestran ejemplos de solicitudes POST para crear clientes, productos y facturas:

**Ejemplo de `POST` para crear un nuevo cliente:**

```json
POST /api/client/
{
  "name": "Franco",
  "lastname": "Ciprian",
  "docnumber": "123154678"
}
```

**Ejemplo `POST` para crear un nuevo producto:**

```json
POST /api/product/
{
  "description": "Book",
  "code": "A001",
  "stock": 50,
  "price": 45.25
},
{
  "description": "Pen",
  "code": "A002",
  "stock": 100,
  "price": 3.75
}
```

**Ejemplo `POST` para crear un nueva factura:**

```json
POST /api/invoice/
{
  "client": {
    "id": 1
  },
  "invoiceDetails": [
    {
      "amount": 3,
      "product": {
        "productId": 1
      }
    },
    {
      "amount": 10,
      "product": {
        "productId": 2
      }
    }
  ]
}
```

# ⚡️ Ejemplos de Solicitudes GET

**Ejemplo `GET` cliente by ID:**

```json
GET /api/client/1
{
  "data": {
      "id": 1,
      "name": "Franco",
      "lastname": "Ciprian",
      "docnumber": "87654321"
  },
  "message": "Client found",
  "status": 200
}
```

**Ejemplo `GET` ver todos los clientes:**

```json
GET /api/client/all
{
  "data": [
  {
      "id": 1,
      "name": "Franco",
      "lastname": "Ciprian",
      "docnumber": "876547781"
  },
  {
      "id": 2,
      "name": "Luis",
      "lastname": "Ciprian",
      "docnumber": "85554321"
  },
  {
      "id": 3,
      "name": "Jeremias",
      "lastname": "Ciprian",
      "docnumber": "876921871"
  }
  ],
  "count": 3,
  "message": "Clients",
  "status": 200
}
```

**Ejemplo `GET` producto by ID:**

```json
GET /api/product/1
{
  "data": {
    "productId": 1,
    "description": "Book",
    "code": "A001",
    "stock": 50,
    "price": 45.25
  },
  "message": "Product found",
  "status": 200
}
```

**Ejemplo `GET` ver todos los productos:**

```json
GET /api/product/all
{
    "data": [
        {
          "productId": 1,
          "description": "Book",
          "code": "A001",
          "stock": 50,
          "price": 45.25
        },
        {
          "productId": 2,
          "description": "Pen",
          "code": "A002",
          "stock": 100,
          "price": 3.75
        }
    ],
    "count": 2,
    "message": "All Products",
    "status": 200
}
```


**Ejemplo `GET` Invoice by ID:**

```json
GET /api/invoice/1
{
  "data": {
    "invoiceId": 1,
    "createdAt": "2023-09-30T02:29:24.039+00:00",
    "total": 173.25,
    "totalProduct": 13,
    "client": {
      "id": 1,
      "name": "Franco",
      "lastname": "Ciprian",
      "docnumber": "87654321"
    },
    "invoiceDetails": [
      {
        "id": 1,
        "amount": 3,
        "price": 135.75,
        "product": {
          "productId": 1,
          "description": "Book",
          "code": "A001",
          "stock": 47,
          "price": 45.25
        }
      },
      {
        "id": 2,
        "amount": 10,
        "price": 37.5,
        "product": {
          "productId": 2,
          "description": "Pen",
          "code": "A002",
          "stock": 90,
          "price": 3.75
        }
      }
    ]
  },
  "message": "Invoice found",
  "status": 200
}
```


