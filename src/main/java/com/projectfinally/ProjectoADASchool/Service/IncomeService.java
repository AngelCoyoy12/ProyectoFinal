package com.projectfinally.ProjectoADASchool.Service;

import com.projectfinally.ProjectoADASchool.Model.Income;
import com.projectfinally.ProjectoADASchool.Repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotación que indica que esta clase es un componente de servicio en Spring
@Service
public class IncomeService {

    // Inyección de dependencia del repositorio de ingresos
    @Autowired
    private IncomeRepository incomeRepository;

    // Método para obtener todos los ingresos
    public List<Income> getAllIncomes() {
        // Llama al método findAll del repositorio para obtener todos los ingresos
        return incomeRepository.findAll();
    }

    // Método para obtener un ingreso por su ID
    public Optional<Income> getIncomeById(String id) {
        // Llama al método findById del repositorio para obtener un ingreso por su ID
        return incomeRepository.findById(id);
    }

    // Método para crear un nuevo ingreso
    public Income createIncome(Income income) {
        // Llama al método save del repositorio para guardar el nuevo ingreso
        return incomeRepository.save(income);
    }

    // Método para actualizar un ingreso existente
    public Income updateIncome(String id, Income income) {
        // Verifica si el ingreso con el ID dado existe en el repositorio
        if (incomeRepository.existsById(id)) {
            // Establece el ID del ingreso para asegurarse de que el documento actualizado tenga el ID correcto
            income.setId(id);
            // Llama al método save del repositorio para guardar el ingreso actualizado
            return incomeRepository.save(income);
        }
        // Si el ingreso no existe, devuelve null
        return null;
    }

    // Método para eliminar un ingreso por su ID
    public void deleteIncome(String id) {
        // Llama al método deleteById del repositorio para eliminar el ingreso con el ID dado
        incomeRepository.deleteById(id);
    }
}
