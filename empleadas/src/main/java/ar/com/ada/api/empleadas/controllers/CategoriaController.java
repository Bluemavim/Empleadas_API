package ar.com.ada.api.empleadas.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import ar.com.ada.api.empleadas.entities.*;
import ar.com.ada.api.empleadas.models.response.GenericResponse;
import ar.com.ada.api.empleadas.services.CategoriaService;

@RestController
public class CategoriaController {
    
    @Autowired
    private CategoriaService service;

    @PostMapping("/categorias") 
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria){
        
        GenericResponse respuesta = new GenericResponse();

        
        service.crearCategoria(categoria); 

        respuesta.isOk = true;
        respuesta.id = categoria.getCategoriaId();
        respuesta.message = "La categoria fue creada con éxito";

        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/categorias") 
    public ResponseEntity<List<Categoria>> traerCategorias (){ 
        return ResponseEntity.ok(service.traerCategorias()); 
    }

}
