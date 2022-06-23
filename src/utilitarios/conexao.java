/*
 * Copyright (C) 2022 Adriano Silva
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package utilitarios;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Adriano Silva
 */
public class conexao
{
    
        final private String driver = "org.postgresql.Driver";
        final private String url = "jdbc:postgresql://192.168.0.44:5432/estoque";
        final private String usuario = "postgres";
        final private String senha = "@As#97002574!";
        private Connection conexao;

    /**
     *
     */
    public Statement statement;

    /**
     *
     */
    public ResultSet resultset;
        
    /**
     *
     * @return
     */
    public boolean conecta()
       {
            boolean result = true;
            try 
            {
                Class.forName(driver);
                conexao = DriverManager.getConnection(url, usuario, senha);
               // JOptionPane.showMessageDialog(null,"Conectado ao Banco de Dados");
            }
            catch(ClassNotFoundException Driver) 
            {
               JOptionPane.showMessageDialog(null,"Driver não localizado: "+Driver);
               result = false;
            }
            catch(SQLException Fonte) 
            {
                JOptionPane.showMessageDialog(null,"Deu erro na conexão "+
                        "com a fonte de dados: "+Fonte);
                result = false;
            }
            return result; 
       }
       
    /**
     *
     */
    public void desconecta()
       {
            boolean result = true;
            try 
            {
                conexao.close();
                JOptionPane.showMessageDialog(null,"banco fechado");
            }
            catch(SQLException fecha) 
            {
                JOptionPane.showMessageDialog(null,"Não foi possivel "+
                        "fechar o banco de dados: "+fecha);
                result = false;
            }

       }
       
    /**
     *
     * @param sql
     */
    public void executeSQL(String sql)
       {
            try 
            {
                statement = conexao.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                resultset = statement.executeQuery(sql);
            } 
            catch(SQLException sqlex) 
            {
               JOptionPane.showMessageDialog(null,"Não foi possível "+
                       "executar o comando sql, "+sqlex+", o sql passado foi "+sql);
            }

       }
       
}
