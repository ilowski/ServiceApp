package dao;

import api.UserDao;
import entity.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance = null;
    private final String databaseName = "management";
    private final String tableName = "users";
    private final String user = "root";
    private final String password = "ziomek123";
    private Connection connection;

    private UserDaoImpl() {
        init();
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?useSSL=false", user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(User user) throws IOException {
        PreparedStatement preparedStatement = null;
        try {
            String query = "INSERT INTO " + tableName + " (login,password) VALUES(?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        List<User> users = new LinkedList<User>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                User user = new User(id, login, password);
                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User getUserByLogin(String login) throws IOException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM " + tableName + " WHERE login ='" + login + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                User user = new User(id, login, password);
                return user;
            }
            statement.close();
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) throws IOException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM " + tableName + " WHERE id = '" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                User user = new User(id, login, password);
                return user;
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserByLogin(String login) throws IOException {
        PreparedStatement statement = null;

        try {

            String query = "DELETE FROM " + tableName + " WHERE login=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, login);
            statement.execute();
            statement.close();

        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(int id) throws IOException {

        PreparedStatement preparedStatement = null;

        try {
            String query = "DELETE FROM  " + tableName + " WHERE id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }


    }


}
