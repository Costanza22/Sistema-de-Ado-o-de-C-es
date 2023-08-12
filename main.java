package Sistema;
import java.sql.*;

class Canil {
    public static void main(String[] args) {
        try {
            // Conectar ao banco de dados
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/canil", "usuario", "senha");

            // Criar tabela "caes" no banco de dados
            Statement statement = connection.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS caes (id INT AUTO_INCREMENT PRIMARY KEY, raca VARCHAR(100), nome VARCHAR(100), coleira VARCHAR(100))";
            statement.executeUpdate(createTableQuery);

            // Inserir dados de exemplo na tabela
            String insertDataQuery = "INSERT INTO caes (raca, nome, coleira) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertDataQuery);
            preparedStatement.setString(1, "Labrador");
            preparedStatement.setString(2, "Max");
            preparedStatement.setString(3, "12345");
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "Poodle");
            preparedStatement.setString(2, "Bella");
            preparedStatement.setString(3, "67890");
            preparedStatement.executeUpdate();

            // Consultar e exibir os cães cadastrados
            String selectDataQuery = "SELECT * FROM caes";
            ResultSet resultSet = statement.executeQuery(selectDataQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String raca = resultSet.getString("raca");
                String nome = resultSet.getString("nome");
                String coleira = resultSet.getString("coleira");

                System.out.println("ID: " + id + ", Raça: " + raca + ", Nome: " + nome + ", Coleira: " + coleira);
            }

            // Fechar conexões
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
