package com.miw.upm.persistence.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloJDBC {

    private Connection conexion = null;
    private Statement sentencia = null;

    private static String driver = "";
    private static String url = "";
    private static String user = "";
    private static String password = "";
    private static String createTable = "";
    private static String delete = "";
    private static String insert1 = "";
    private static String insert2 = "";
    private static String insert3 = "";
    private static String select = "";

    private static String insertTrans1 = "";
    private static String insertTrans2 = "";

    // https://sematext.com/blog/slf4j-tutorial/
    private static Logger log = LoggerFactory.getLogger(HelloJDBC.class);

    /**
     * Mas INFO: https://mkyong.com/java/java-properties-file-examples/
     * src/main/resources/config.properties
     */
    private void loadConfig() {

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                return;
            }

            // load a properties file from class path, inside static method
            prop.load(input);

            // get the property value and print it out
            driver = prop.getProperty("db.driver");
            url = prop.getProperty("db.url");
            user = prop.getProperty("db.user");
            password = prop.getProperty("db.password");
            createTable = prop.getProperty("db.create.table");
            delete = prop.getProperty("db.delete");
            insert1 = prop.getProperty("db.insert.1");
            insert2 = prop.getProperty("db.insert.2");
            insert3 = prop.getProperty("db.insert.3");
            select = prop.getProperty("db.select");

            insertTrans1 = prop.getProperty("db.insert.transc.1");
            insertTrans2 = prop.getProperty("db.insert.transc.2");

        } catch (IOException e) {
            log.error("No se puedieron cargar las propiedades ", e);
        }
    }

    public HelloJDBC() {
        this.loadConfig();
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        // Class.forName("com.mysql.jdbc.Driver");
        // https://stackoverflow.com/questions/52032739/loading-class-com-mysql-jdbc-driver-this-is-deprecated-the-new-driver-class

        if (conexion == null || !conexion.isClosed()) {
            // Create instance of MySQLDriver.
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
        }

        return conexion;
    }

    /**
     * Lenguaje de Definición de Datos (DDL)
     * CREATE, se usa para crear una base de datos, tabla, vistas, etc.
     * ALTER, se utiliza para modificar la estructura, por ejemplo añadir o borrar
     * columnas de una tabla.
     * DROP, con esta sentencia, podemos eliminar los objetos de la estructura, por
     * ejemplo un índice o una secuencia.
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private boolean ejecutarSentenciaNoSelect(String instruccion) throws SQLException, ClassNotFoundException {
        boolean result = true;

        conexion = this.getConnection();

        sentencia = conexion.createStatement();

        result = (sentencia.executeUpdate(instruccion)) > 0;

        return result;
    }

    private boolean ejecutarConsulta(String consulta) throws SQLException, ClassNotFoundException {
        boolean hayResultados = false;

        conexion = this.getConnection();

        sentencia = conexion.createStatement();

        ResultSet rs = sentencia.executeQuery(consulta);

        while (rs.next()) {
            hayResultados = true;

            log.info("id1: " + rs.getLong("id1") + ", nombre: " + rs.getString("nombre"));
        }

        rs.close();

        return hayResultados;
    }

    public void consumirDBjee() {

        String mensaje = null;

        try {
            // Creamos la tabla NOTA: puede devolver false
            /*
             * if (!this.ejecutarSentenciaNoSelect(createTable)) {
             * mensaje = "Fallo al crear la tabla: " + createTable;
             * log.error(mensaje);
             * throw new Exception(mensaje);
             * }
             */
            this.ejecutarSentenciaNoSelect(createTable);

            if (!this.ejecutarSentenciaNoSelect(delete)) {
                mensaje = "No se eliminó ningún registro";
                log.error(mensaje);
                throw new Exception(mensaje);
            }

            if (!this.ejecutarSentenciaNoSelect(insert1)) {
                mensaje = "Fallo al hacer el insert: " + insert1;
                log.error(mensaje);
                throw new Exception(mensaje);
            }

            if (!this.ejecutarSentenciaNoSelect(insert2)) {
                mensaje = "Fallo al hacer el insert: " + insert2;
                log.error(mensaje);
                throw new Exception(mensaje);
            }

            if (!this.ejecutarSentenciaNoSelect(insert3)) {
                mensaje = "Fallo al hacer la inserción: " + insert3;
                log.error(mensaje);
                throw new Exception(mensaje);
            }

            if (!this.ejecutarConsulta(select)) {
                mensaje = "La consulta no devuelve resultados";
                log.error(mensaje);
                throw new Exception(mensaje);
            }

            if (!this.ejecutarSentenciaNoSelect(delete)) {
                mensaje = "No se eliminó ningún registro";
                log.error(mensaje);
                throw new Exception(mensaje);
            }

        } catch (Exception e) {
            log.error("Fallo al utilizar la Base de datos 'jee' ", e);
        } finally {
            try {
                if (sentencia != null && !sentencia.isClosed()) {
                    sentencia.close();
                }
                if (conexion != null && !conexion.isClosed()) {
                    conexion.close();
                }
            } catch (SQLException e) {
                log.error(e.getMessage());
            }

        }
    }

    public void transaccionDBjee() {
        String mensaje = null;

        try {

            // Creamos la tabla NOTA: puede devolver false
            this.ejecutarSentenciaNoSelect(createTable);

            // iniciamos la transacción
            this.conexion.setAutoCommit(false);

            log.info("Transacción....");

            if (!this.ejecutarSentenciaNoSelect(insertTrans1)) {
                mensaje = "Fallo al hacer el insert: " + insertTrans1;
                log.error(mensaje);
                throw new Exception(mensaje);
            }

            if (!this.ejecutarSentenciaNoSelect(insertTrans2)) {
                mensaje = "Fallo al hacer el insert: " + insertTrans2;
                log.error(mensaje);
                throw new Exception(mensaje);
            }

            // Si se llega a este punto finalizamos la transacción confirmando los cambios
            // en BBDD;
            this.conexion.commit();

        } catch (Exception e) {
            log.error("Fallo al utilizar la Base de datos 'jee' ", e);

            // Si hay problemas deshacemos la transacción.
            try {
                this.conexion.setAutoCommit(false);
                this.conexion.rollback();
                log.error("Deshaciendo la transacción por ROLLBACK.");
            } catch (SQLException e1) {
                log.error("ERROR en el ROLLBACK: ", e1);
            }

        } finally {
            try {
                this.conexion.setAutoCommit(true);
                if (sentencia != null && !sentencia.isClosed()) {
                    sentencia.close();
                }
                if (conexion != null && !conexion.isClosed()) {
                    conexion.close();
                }
            } catch (SQLException e) {
                log.error(e.getMessage());
            }

        }
    }

}
