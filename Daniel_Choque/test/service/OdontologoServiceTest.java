package service;

import dao.OdontologoDaoH2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {
    @Test
    public void test_odontologo_h2(){
        //ARRANGE
        OdontologoDaoH2 odontologoDaoH2 = new OdontologoDaoH2();
        OdontologoService odontologoService = new OdontologoService(odontologoDaoH2);

        //ACT
        odontologoService.registrar(1, "Dani", "Choque");

        //ASSERT
        Assertions.assertTrue(odontologoService.listarOdontologos(1, 1, "Dani", "Choque") != null);


    }


}