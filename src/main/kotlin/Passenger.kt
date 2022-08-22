import java.sql.*

data class Passenger(var id:Int,var name:String,var age:Int,var gender:String,var phone:String)

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
    var listOfPassenger : ArrayList<Passenger> = ArrayList()

    //inserting into database
//    query = "insert into passengers values (8,'Mohan',37,'Male','8976613200') "
//    statement = connection.createStatement()
//    result = statement.executeUpdate(query)
//    if(result>0){
//        println("Record inserted successfully ! ")
//    }else{
//        println("Insertion failed ! ")
//    }

    //update name to Soham for id=8
//    query = "update passengers set passenger_name = 'Soham' where passenger_id=8"
//    statement=connection.createStatement()
//    result=statement.executeUpdate(query)
//    if(result>0){
//        println("Value updated successfully ! ")
//    }else{
//        println("Failed to update ")
//    }

//deleting record
//     query ="delete from train where passenger_id=7
//     statement = connection.createStatement()
//     result=statement.executeUpdate(query)
//     if(result>0){
//       println("Data deleted successfully")
//     }else{
//       println("failed to delete due of foreign key constrain")
//       return
//     }

    //displaying all the values
    query="select * from passengers"
    statement=connection.createStatement()
    resultSet = statement.executeQuery(query)
    while(resultSet.next()){
        var id= resultSet.getInt("passenger_id")
        var name= resultSet.getString("passenger_name")
        var age= resultSet.getInt("passenger_age")
        var gender= resultSet.getString("passenger_gender")
        var phone = resultSet.getString("passenger_phone")

        var passenger = Passenger(id,name,age,gender,phone)
        listOfPassenger.add(passenger)
    }
    println("List of all passengers - ")
    println(listOfPassenger)
    connection.close()
}
