package com.mycompany.apuestatodook.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;


public class UsuarioDAO {

         
    public List<Usuario> getAll() {
        List<Usuario> usuarios = new LinkedList();
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession() ){
            session.beginTransaction();
            usuarios = session.createQuery("FROM Usuario", Usuario.class).getResultList();
            session.getTransaction().commit();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
        return usuarios;
    }
 
    
    
    
    public Usuario autenticar(String usuario, String contrasenia) {
        
        Usuario validado = null;
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession() ){
            session.beginTransaction();
            validado = session.createQuery("FROM Usuario WHERE usuario = ?1 AND contrasenia = ?2", Usuario.class)
                    .setParameter(1, usuario)
                    .setParameter(2, contrasenia)
                    .getSingleResultOrNull();
            session.getTransaction().commit();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
        return validado;
  }
    
    
  

/*private Usuario rsRowToUsuario(ResultSet rs) throws SQLException {
    int IDusuario = rs.getInt("id_usuario");
    String usuario = rs.getString("usuario");
    String contrasenia = rs.getString("contrasenia");
    
 
    double dinero = rs.getDouble("dinero");
    String tipo = rs.getString("rol");

    return new Usuario(IDusuario, usuario, contrasenia, dinero, tipo);
}
*/
      
    public int add(String usuario, String contrasenia, String rol) {
        Usuario user = new Usuario(usuario, contrasenia, 0.0, rol);
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession() ){
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            return user.getIDusuario();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    
       
    public double getDineroPorIdUsuario (Integer Id) {
        double dinero = 0.0;
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession() ){
            session.beginTransaction();
            dinero = session.createQuery("SELECT dinero FROM Usuario WHERE IDusuario= ?1", Double.class)
                    .setParameter(1, Id)
                    .getSingleResult();
            session.getTransaction().commit();
             
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
        
        return dinero;
    }
 
 
 
    
    public void updateDinero(Usuario usuario) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession() ){
            session.beginTransaction();
            session.createMutationQuery("UPDATE Usuario SET dinero = ?1 WHERE IDusuario = ?2")
                    .setParameter(1, usuario.getDinero())
                    .setParameter(2, usuario.getIDusuario())
                    .executeUpdate();
            session.getTransaction().commit();
            System.out.println("Actualización del dinero del usuario en la base de datos. Nuevo saldo: " + usuario.getDinero());
            
        } catch(Exception ex){
            System.out.println("Error al actualizar el dinero del usuario: " + ex.getMessage()); 
            throw new RuntimeException(ex);
        }
    }
    
}


