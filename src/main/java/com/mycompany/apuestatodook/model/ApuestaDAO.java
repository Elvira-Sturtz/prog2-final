package com.mycompany.apuestatodook.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session; 


public class ApuestaDAO {

    public void add(Apuesta apuesta) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession() ){
            session.beginTransaction();
            session.persist(apuesta);
            session.getTransaction().commit();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    
    
    public List<Apuesta> getApuestasPorUsuario(int idUsuario) {
        List<Apuesta> apuestas = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession() ){
            session.beginTransaction();
            apuestas = session.createQuery("FROM Apuesta WHERE idUsuario = ?1", Apuesta.class)
                    .setParameter(1, idUsuario)
                    .getResultList();
            session.getTransaction().commit();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
        return apuestas;
    }
    
    public String getResultadoPorPartido(int idPartido) {
    String query = "SELECT ganador FROM resultado WHERE id_partido = ?";
    try (Connection con = ConnectionPool.getInstance().getConnection();
         PreparedStatement preparedStatement = con.prepareStatement(query)) {
        preparedStatement.setInt(1, idPartido);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getString("ganador");
            }
        }
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
    return null;
    }


    private Apuesta rsRowToApuesta(ResultSet rs) throws SQLException {
    int monto = rs.getInt("monto");
    String por_quien = rs.getString("por_quien");
    int idUsuario = rs.getInt("fk_id_usuario");
    int idPartido = rs.getInt("fk_id_partido");
    int fk_id_resultado = rs.getInt("fk_id_resultado");

    Apuesta apuesta = new Apuesta(monto, por_quien, idUsuario, idPartido, fk_id_resultado);

    return apuesta;
    }
    
    public void updateEstado(Apuesta apuesta) {
    String query = "UPDATE apuesta SET estado = ? WHERE id_apuesta = ?";
    try (Connection con = ConnectionPool.getInstance().getConnection();
         PreparedStatement preparedStatement = con.prepareStatement(query)) {
        System.out.println("ID de apuesta antes de la actualización: " + apuesta.getIdApuesta());
        preparedStatement.setString(1, String.valueOf(apuesta.getEstado()));
        preparedStatement.setInt(2, apuesta.getIdApuesta());
        preparedStatement.executeUpdate();
        
        // Imprimir el estado después de la actualización
        System.out.println("Estado actualizado: " + apuesta.getEstado());
    } catch (SQLException ex) {
        System.out.println("Error al actualizar el estado: " + ex.getMessage());
        throw new RuntimeException(ex);
    }
    }
    public List<Apuesta> getAllApuestasConResultado() {
    List<Apuesta> apuestasConResultado = new ArrayList<>();
    String query = "SELECT apuesta.por_quien, apuesta.monto, partido.local, partido.visitante, partido.fecha " +
            "FROM apuesta " +
            "JOIN resultado ON resultado.fk_id_partido = apuesta.fk_id_partido " +
            "JOIN partido ON partido.id_partido = apuesta.fk_id_partido";

    try (Connection con = ConnectionPool.getInstance().getConnection();
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            String por_quien = rs.getString("por_quien");
            int monto = rs.getInt("monto");
            String local = rs.getString("local");
            String visitante = rs.getString("visitante");
            String fecha = rs.getString("fecha");

            Apuesta apuesta = new Apuesta(local, visitante, fecha, monto, por_quien);
            apuestasConResultado.add(apuesta);
        }
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
    return apuestasConResultado;
    }
    public List<Apuesta> getApuestasConResultadoPorUsuario(int idUsuario) {
    List<Apuesta> apuestasConResultado = new ArrayList<>();
    String query = "SELECT apuesta.por_quien, apuesta.monto, partido.local, partido.visitante, partido.fecha " +
            "FROM apuesta " +
            "JOIN resultado ON resultado.fk_id_partido = apuesta.fk_id_partido " +
            "JOIN partido ON partido.id_partido = apuesta.fk_id_partido " +
            "WHERE apuesta.fk_id_usuario = ?";  // Agregar condición por fk_id_usuario

    try (Connection con = ConnectionPool.getInstance().getConnection();
         PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, idUsuario);  // Establecer el valor del parámetro

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String por_quien = rs.getString("por_quien");
                int monto = rs.getInt("monto");
                String local = rs.getString("local");
                String visitante = rs.getString("visitante");
                String fecha = rs.getString("fecha");

                Apuesta apuesta = new Apuesta(local, visitante, fecha, monto, por_quien);
                apuestasConResultado.add(apuesta);
            }
        }
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
    return apuestasConResultado;
}

}