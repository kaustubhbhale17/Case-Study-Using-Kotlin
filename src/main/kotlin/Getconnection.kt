import java.sql.Connection
import java.sql.DriverManager

class Getconnection {

    fun establishConnection(): Connection {
        val url = "jdbc:mysql://localhost:3306/onlineBookingSystem"
        val user = "root"
        val pass = "root"
        return DriverManager.getConnection(url, user, pass)
    }
}