package ru.job4j.grabber;

import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;

public class PsqlStore implements Store, AutoCloseable {

    private Connection cnn;

    private static final Logger LOG = LoggerFactory.getLogger(PsqlStore.class.getName());

    public PsqlStore(Properties cfg) throws SQLException {
        try {
            Class.forName(cfg.getProperty("driver_class"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        cnn = DriverManager.getConnection(
                cfg.getProperty("url"),
                cfg.getProperty("login"),
                cfg.getProperty("password")
        );
    }

    @Override
    public void save(Post post) {
        try (PreparedStatement statement =
                     cnn.prepareStatement("insert into post(name, text, link, created) values (?, ?, ?, ?)"
                             + "ON CONFLICT (link) DO NOTHING;", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getDescription());
            statement.setString(3, post.getLink());
            statement.setTimestamp(4, Timestamp.valueOf(post.getLocalDateTime()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    post.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            LOG.error("Ошибка создания вакансии", e);
        }
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        try (PreparedStatement statement = cnn.prepareStatement("select * from post")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    posts.add(resulted(resultSet));
                }
            }
        } catch (Exception e) {
            LOG.error("Ошибка получения списка всех вакнсий", e);
        }
        return posts;
    }

    @Override
    public Post findById(int id) {
        Post post = null;
        try (PreparedStatement statement = cnn.prepareStatement("select * from post where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    post = resulted(resultSet);
                }
            }
        } catch (Exception e) {
            LOG.error("Ошибка при получении по id", e);
        }
        return post;
    }

    public Post resulted(ResultSet resultSet) throws Exception {
        return new Post(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("text"),
                resultSet.getString("link"),
                resultSet.getTimestamp("created").toLocalDateTime()
        );
    }

    @Override
    public void close() throws Exception {
        if (cnn != null) {
            cnn.close();
        }
    }

    public static void main(String[] args) {
        try (InputStream in = PsqlStore.class.getClassLoader().getResourceAsStream("post.properties")) {
            Properties config = new Properties();
            config.load(in);
            LocalDateTime localTime = LocalDateTime.now();
            try (PsqlStore psqlStore = new PsqlStore(config)) {
                Post post = new Post("java", "https://career.habr.com/vacancies/1000110280",
                        "Бэкенд разработчик, Старший (Senior) • Java", localTime);
                Post post1 = new Post("java", "https://career.habr.com/vacancies/1000110280",
                        "Бэкенд разработчик, Старший (Senior) • Java", localTime);
                Post post2 = new Post("java", "https://career.habr.com/vacancies/1000110333",
                        "Бэкенд разработчик, Младший(Junior) • Java", localTime);
                psqlStore.save(post);
                psqlStore.save(post1);
                psqlStore.save(post2);
                System.out.println(psqlStore.getAll());
                System.out.println(psqlStore.findById(1));
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        } catch (Exception e) {
            LOG.error("Ошибка соеденения или параметров", e);
        }
    }
}