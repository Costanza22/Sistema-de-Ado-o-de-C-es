package Sistema;
import java.sql.*;

 class Canil {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:canil.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            createTable(conn);

            cadastrarCao(conn, "Rex", "Labrador", "C123", "Ração A", true, true, true);
            cadastrarCao(conn, "Luna", "Golden Retriever", "G456", "Ração B", true, false, true);

            exibirCaes(conn);
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e.getMessage());
        }
    }

    static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS caes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "raca TEXT NOT NULL," +
                "coleira TEXT NOT NULL," +
                "racao TEXT NOT NULL," +
                "vacinaPulgas INTEGER NOT NULL," +
                "vacinaVermes INTEGER NOT NULL," +
                "vacinaCarrapatos INTEGER NOT NULL" +
                ")";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    static void cadastrarCao(Connection conn, String nome, String raca, String coleira, String racao, boolean vacinaPulgas, boolean vacinaVermes, boolean vacinaCarrapatos) throws SQLException {
        String sql = "INSERT INTO caes (nome, raca, coleira, racao, vacinaPulgas, vacinaVermes, vacinaCarrapatos) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, raca);
            stmt.setString(3, coleira);
            stmt.setString(4, racao);
            stmt.setBoolean(5, vacinaPulgas);
            stmt.setBoolean(6, vacinaVermes);
            stmt.setBoolean(7, vacinaCarrapatos);

            stmt.executeUpdate();
        }
    }

    static void exibirCaes(Connection conn) throws SQLException {
        String sql = "SELECT * FROM caes";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Cães cadastrados no canil:");
            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Raça: " + rs.getString("raca"));
                System.out.println("Coleira: " + rs.getString("coleira"));
                System.out.println("Ração: " + rs.getString("racao"));
                System.out.println("Vacina contra pulgas: " + (rs.getBoolean("vacinaPulgas") ? "Sim" : "Não"));
                System.out.println("Vacina contra vermes: " + (rs.getBoolean("vacinaVermes") ? "Sim" : "Não"));
                System.out.println("Vacina contra carrapatos: " + (rs.getBoolean("vacinaCarrapatos") ? "Sim" : "Não"));
                System.out.println("---------------------------");
            }
        }
    }
}
