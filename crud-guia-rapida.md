# CRUD Sección PET - Swagger Petstore

## 🔑 Autenticación (ÚNICO REQUISITO)

**API Key:** `special-key`

### Cómo Configurar:
1. Ir a https://petstore.swagger.io/#/
2. Clic en **"Authorize"**
3. En el campo "Value:" ingresar: `special-key`
4. Clic **"Authorize"** → **"Close"**

> Esta es la **única autenticación** necesaria para usar todos los endpoints de PET.

---

## 📋 Operaciones CRUD - Sección PET

### ✅ CREATE - Crear Mascota
**Endpoint:** `POST /pet`

**JSON:**
```json
{
  "id": 1,
  "name": "juand",
  "status": "available",
  "photoUrls": ["https://example.com/photo.jpg"]
}
```

**Pasos:**
1. Expandir `POST /pet`
2. "Try it out"
3. Pegar JSON
4. "Execute"

---

### 📖 READ - Consultar Mascota
**Endpoint:** `GET /pet/{petId}`

**Pasos:**
1. Expandir `GET /pet/{petId}`
2. "Try it out"
3. Ingresar petId: `1`
4. "Execute"

---

### 🔄 UPDATE - Actualizar Mascota
**Endpoint:** `PUT /pet`

**JSON:**
```json
{
  "id": 1,
  "name": "juand-updated",
  "status": "sold",
  "photoUrls": ["https://example.com/photo.jpg"]
}
```

**Pasos:**
1. Expandir `PUT /pet`
2. "Try it out"
3. Modificar JSON
4. "Execute"

---

### ❌ DELETE - Eliminar Mascota
**Endpoint:** `DELETE /pet/{petId}`

**Pasos:**
1. Expandir `DELETE /pet/{petId}`
2. "Try it out"
3. Ingresar petId: `1`
4. "Execute"

---

## 🎯 Resumen

**Autenticación:**
- Solo necesitas `special-key` como API key
- Se configura una vez al inicio
- Funciona para todos los endpoints de PET

**Endpoints PET:**
- CREATE: `POST /pet`
- READ: `GET /pet/{petId}`
- UPDATE: `PUT /pet`
- DELETE: `DELETE /pet/{petId}`

**Campos obligatorios:**
- `name`
- `photoUrls` (array con al menos 1 URL)

**Status válidos:**
- `available`
- `pending`
- `sold`
