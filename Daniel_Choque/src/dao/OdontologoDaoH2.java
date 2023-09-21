package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getDriver;

public class OdontologoDaoH2 implements Dao<Odontologo>{

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);

    public static final String DB_URL = "jdbc:h2:~/odontologo;PASSWORD=sa;USER=sa;INIT=RUNSCRIPT FROM 'create.sql'";

    public static final String DRIVER = "org.h2.Driver";




    @Override
    public List<Odontologo> listarOdontologos(int id, int matricula, String nombre, String apellido) {

        getDriver();

        Connection connection = null;

        List<Odontologo> listaOdontologos = new ArrayList<>();

        try{
            connection = DriverManager.getConnection(DB_URL);

            String select = "SELECT * FROM ODONTOLOGO";

            PreparedStatement p = connection.prepareStatement(select);
            //p.setInt(1, id);
            //p.setInt(2, matricula);
            //p.setString(3, nombre);
            //p.setString(4, apellido);

            ResultSet result = p.executeQuery();

            while (result.next()){
                id = result.getInt(1);
                matricula = result.getInt(2);
                nombre = result.getString(3);
                apellido = result.getString(4);

                Odontologo odontologo = new Odontologo();
                odontologo.setId(id);
                odontologo.setMatricula(matricula);
                odontologo.setNombre(nombre);
                odontologo.setApellido(apellido);
                listaOdontologos.add(odontologo);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return listaOdontologos;
    }

    @Override
    public void guardar(Odontologo odontologo) {

        getDriver();

        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL);

            String insert = "INSERT INTO ODONTOLOGO (MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)";
            PreparedStatement p = connection.prepareStatement(insert);
            p.setInt(1, odontologo.getMatricula());
            p.setString(2, odontologo.getNombre());
            p.setString(3, odontologo.getApellido());

            p.executeUpdate();


        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Override
    public Odontologo buscar(Odontologo o) {
        return null;
    }

    @Override
    public Odontologo listar(int id) {
        return null;
    }

    private void getDriver() {
        try{
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }


}
