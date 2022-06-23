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

package ConexaoBancos;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Adriano Silva
 */
public class conexao_postgres
{
    
             
    public static void main(String args[])
    {
         String driver = "org.postgresql.Driver";
         String url = "jdbc:postgresql://localhost:5432/estoque";
         String usuario = "postgres";
         String senha = "@As#97002574!";
         Connection conexao;    
         Statement statement;    
         ResultSet resultset;
        //public boolean conecta();
            try 
            {
                Class.forName(driver);
                conexao = DriverManager.getConnection(url, usuario, senha);
                JOptionPane.showMessageDialog(null,"Conectado ao Banco de Dados Postgres");
            }
            catch(ClassNotFoundException Driver) 
            {
               JOptionPane.showMessageDialog(null,"Driver não localizado: "+Driver);
               //result = false;
            }
            catch(SQLException Fonte) 
            {
                JOptionPane.showMessageDialog(null,"Deu erro na conexão "+
                        "com a fonte de dados: "+Fonte);
               // result = false;
            }
    }
}