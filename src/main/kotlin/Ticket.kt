import java.sql.*

data class Ticket(var id:Int,var ticket_number:Int,var passenger_id:Int,var train_id:Int,var price:Double)
fun main() {
    var query : String
    var result : Int
    var statement: Statement
    var resultSet: ResultSet

    var connection = Getconnection().establishConnection()

    if(connection.isValid(0)){
        println("successfully connected to db")
    }else{
        println("Failed to connect to db")
        return
    }
    var listOfTicket = ArrayList<Ticket>()

    //inserting into ticket
//    query="insert into ticket values(7,1006,7,12,199.25)"
//    statement=connection.createStatement()
//    result=statement.executeUpdate(query)
//    if(result>0){
//        println("Record Inserted successfully ")
//    }else{
//        println("Insertion Failed")
//    }

    //updating record-> set price to 500 for id=7
//    query="update ticket set ticket_price=500  where ticket_id=7"
//    statement=connection.createStatement()
//    result=statement.executeUpdate(query)
//    if(result>0){
//        println("Record Updated successfully")
//    }else{
//        println("update failed")
//    }

    //delete ticket_id=7
//    query="delete from ticket where ticket_id=7"
//    statement=connection.createStatement()
//    result=statement.executeUpdate(query)
//    if(result>0){
//        println("Record Deleted successfully")
//    }else{
//        println("Failed to delete")
//    }

    //displaying values
    query="select * from ticket"
    statement=connection.createStatement()
    resultSet=statement.executeQuery(query)
    while(resultSet.next()){
        var id=resultSet.getInt(1)
        var num = resultSet.getInt(2)
        var p_id=resultSet.getInt(3)
        var t_id=resultSet.getInt(4)
        var price=resultSet.getDouble(5)

        var ticket = Ticket(id,num,p_id,t_id,price)
        listOfTicket.add(ticket)
    }

    println("List of tickets - ")
    println(listOfTicket)


    connection.close()
}