package service;

import dao.OdontologoDaoH2;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private OdontologoDaoH2 odontologoDaoH2;

    public OdontologoService(OdontologoDaoH2 odontologoDaoH2) {
        this.odontologoDaoH2 = odontologoDaoH2;
    }

    List<Odontologo> listarOdontologos(int id, int matricula, String nombre, String apellido){
        return odontologoDaoH2.listarOdontologos(id, matricula, nombre, apellido);
    }

    public void registrar(int matricula, String nombre, String apellido){
        if(nombre == " "){
            throw new RuntimeException("Tenes que agregar un nombre");
        }
        Odontologo odontologo = new Odontologo(matricula, nombre, apellido);
        odontologoDaoH2.guardar(odontologo);
    }
}
