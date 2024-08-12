package com.projectfinally.ProjectoADASchool.Model;

// Importación de las clases necesarias para trabajar con anotaciones y MongoDB
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Anotación para indicar que esta clase es un documento de MongoDB y corresponde a la colección "categories"
@Document(collection = "categories")
public class Category {

    // Anotación para indicar que este campo es el identificador único del documento (ID en MongoDB)
    @Id
    private String id;

    // Campo para almacenar el nombre de la categoría
    private String name;

    // Getters y Setters para acceder y modificar los valores de los campos privados

    // Devuelve el valor del campo 'id'
    public String getId() {
        return id;
    }

    // Establece el valor del campo 'id'
    public void setId(String id) {
        this.id = id;
    }

    // Devuelve el valor del campo 'name'
    public String getName() {
        return name;
    }

    // Establece el valor del campo 'name'
    public void setName(String name) {
        this.name = name;
    }
}
