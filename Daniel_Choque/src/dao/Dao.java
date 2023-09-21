package dao;

import java.util.List;

public interface Dao <O>{

    public O buscar(O o);

    public O listar(int id);

    public List<O> listarOdontologos(int id, int matricula, String nombre, String apellido);

    public void guardar(O o);
}
