package com.projectfinally.ProjectoADASchool.Model;

// Importación de las clases necesarias para trabajar con anotaciones y MongoDB
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

// Anotación para indicar que esta clase es un documento de MongoDB y corresponde a la colección "incomes"
@Document(collection = "incomes")
public class Income {

    // Anotación para indicar que este campo es el identificador único del documento (ID en MongoDB)
    @Id
    private String id;

    // Campo para almacenar la descripción del ingreso
    private String description;

    // Campo para almacenar la cantidad del ingreso
    private double amount;

    // Campo para almacenar la fecha en que se realizó el ingreso
    private LocalDate date;

    // Getters y Setters para acceder y modificar los valores de los campos privados

    // Devuelve el valor del campo 'id'
    public String getId() {
        return id;
    }

    // Establece el valor del campo 'id'
    public void setId(String id) {
        this.id = id;
    }

    // Devuelve el valor del campo 'description'
    public String getDescription() {
        return description;
    }

    // Establece el valor del campo 'description'
    public void setDescription(String description) {
        this.description = description;
    }

    // Devuelve el valor del campo 'amount'
    public double getAmount() {
        return amount;
    }

    // Establece el valor del campo 'amount'
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Devuelve el valor del campo 'date'
    public LocalDate getDate() {
        return date;
    }

    // Establece el valor del campo 'date'
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
