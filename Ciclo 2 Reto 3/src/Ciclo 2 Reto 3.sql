-- SQLite
/* Obtener el listado de los identificadores (id) de los materiales de construcción
importados, incluyendo: sus nombres y precios (ordenados por nombre). Utilice los
siguientes alias: ID_MATERIALCONSTRUCCION como ID,
NOMBRE_MATERIAL como NOMBRE y PRECIO_UNIDAD como PRECIO. */


SELECT ID_MATERIALCONSTRUCCION as ID,
 NOMBRE_MATERIAL as NOMBRE, 
 PRECIO_UNIDAD as PRECIO
FROM MaterialConstruccion
WHERE Importado = 'Si'
ORDER BY NOMBRE;


-- Se necesita conocer el listado de los proyectos, incluyendo la siguiente información:
-- id del proyecto, constructora, ciudad, clasificación, estrato y nombre completo del
-- líder de los proyectos que fueron financiados por el banco “Conavi”. Ordenados
-- desde el proyecto más reciente hasta el más antiguo, por nombre de la ciudad (de
-- forma ascendente) y por constructora. Para construir el listado mencionado, se debe
-- realizar un JOIN entre las tablas Proyecto y Tipo, Proyecto Líder. Utilice los
-- siguientes alias: ID_PROYECTO como ID y la unión del nombre + apellido del
-- líder como LIDER, el resto, queda en su forma natural.


    SELECT 
        Proyecto.ID_Proyecto AS ID,
        Proyecto.Constructora,
        Proyecto.Ciudad,
        Proyecto.Clasificacion,
        Tipo.Estrato,
        Lider.Nombre || ' ' || Lider.Primer_Apellido || ' ' || Lider.Segundo_Apellido AS LIDER
    FROM 
        Proyecto
    JOIN Tipo 
        ON Proyecto.ID_Tipo = Tipo.ID_Tipo
    JOIN Lider
        ON Proyecto.ID_Lider = Lider.ID_Lider
    WHERE Banco_Vinculado = 'Conavi'
    ORDER BY Proyecto.Fecha_Inicio DESC, Proyecto.Ciudad ASC, Proyecto.Constructora;


--     Se desea conocer por cada ciudad y clasificación: el total de proyectos, la fecha del
-- proyecto más antiguo y la fecha del proyecto más reciente (ordenados por ciudad y
-- clasificación). No se deben incluir los proyectos tipo “Casa Campestre” ni
-- “Condominio”.

    SELECT 
        Ciudad,
        Clasificacion,
        COUNT(*) AS TOTAL,
        MIN(Fecha_Inicio) AS VIEJO,
        MAX(Fecha_Inicio) AS RECIENTE
    FROM 
        Proyecto
    WHERE Clasificacion NOT IN ('Casa Campestre', 'Condominio')
    GROUP BY Ciudad, Clasificacion
    ORDER BY Ciudad, Clasificacion;

-- Se debe presentar el total adeudado en cada proyecto (por las compras no pagadas a
-- los proveedores). Se debe agrupar los datos por el ID_proyecto y el valor total de la
-- deuda, siempre y cuando esta última sea superior a $50.000. Ordene los datos de
-- mayor a menor deuda.

    SELECT 
       Compra.ID_Proyecto,
       SUM(Compra.Cantidad * MaterialConstruccion.Precio_Unidad) AS VALOR
    FROM 
        Compra
    JOIN MaterialConstruccion
        ON Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion
    WHERE Compra.Pagado = "No"
    GROUP BY Compra.ID_Proyecto
    HAVING VALOR > 50000
    ORDER BY VALOR DESC;

--     Seleccione los 10 líderes que han realizado más compras en sus proyectos. Se debe
-- presentar el nombre completo del líder y el valor total de las compras realizadas.
-- Para limitar el número de registros, usar al final de la consulta la instrucción LIMIT
-- <numero>.

    SELECT 
    Lider.Nombre || ' ' || Lider.Primer_Apellido || ' ' || Lider.Segundo_Apellido AS LIDER,
    SUM(Compra.Cantidad * MaterialConstruccion.Precio_Unidad) AS VALOR  
    FROM
        Lider
    JOIN Proyecto
        ON Lider.ID_Lider = Proyecto.ID_Lider
    JOIN Compra
        ON Proyecto.ID_Proyecto = Compra.ID_Proyecto
    JOIN MaterialConstruccion
        ON Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion
    GROUP BY LIDER
    ORDER BY VALOR DESC
    LIMIT 10;

