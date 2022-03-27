package com.ysjleader.tobyspringkotlin.chapter01.chater1_1

import com.ysjleader.tobyspringkotlin.chapter01.common.EncryptPassword
import java.sql.DriverManager

class UserDAO {

    fun add(user: User) {
        Class.forName("com.mysql.cj.jdbc.Driver")
        val connection = DriverManager.getConnection("jdbcUrl", "username", "password")

        val preparedStatement = connection.prepareStatement(
            "INSERT INTO USERS(id, name, password) VALUES(?, ?, ?)"
        )
        preparedStatement.setString(1, user.id)
        preparedStatement.setString(2, user.name)
        preparedStatement.setString(3, EncryptPassword.encrypt(user.password))

        preparedStatement.executeUpdate()

        preparedStatement.close()
        connection.close()
    }

    fun find(id: String): User {
        Class.forName("com.mysql.cj.jdbc.Driver")
        val connection = DriverManager.getConnection("jdbcUrl", "username", "password")

        val preparedStatement = connection.prepareStatement(
            "SELECT * FROM USERS WHERE ID = ?"
        )
        preparedStatement.setString(1, id)

        val resultSet = preparedStatement.executeQuery()
        resultSet.next()

        val findUser = User(
            id = resultSet.getString("id"),
            name = resultSet.getString("name")
        )

        preparedStatement.executeUpdate()

        preparedStatement.close()
        connection.close()

        return findUser
    }
}