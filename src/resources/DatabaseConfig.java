package resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    //Cria um objeto Properties estático - só existe um pra toda a classe
    private static Properties props = new Properties();

    //Bloco estático, roda automaticamente uma vez quando a classe é executada
    static {
        try (//Abre o arquivo db.properties que está dentro da pasta resources
             //getResourceAsStream procura dentro do classpath (No caso, src/resources
                InputStream input = DatabaseConfig.class
                .getClassLoader().
                getResourceAsStream("resources/db.properties")) {

            //Se o arquivo não for encontrado, lança um erro
            if (input == null) {
                throw new RuntimeException("Arquivo não encontrado");
            }

            //Carrega todas as chaves e valores do arquivo para o objeto props
            props.load(input);
        } catch (IOException e) {
            //Caso aconteça algum erro na leitura, mostra uma exceção com detalhes
            throw new  RuntimeException("Erro ao carregar db.properties");
        }
    }

    public static String getUrl() {
        return props.getProperty("db.url");
    }

    public static String getUsername() {
        return props.getProperty("db.username");
    }

    public static String getPassword() {
        return props.getProperty("db.password");
    }

}
