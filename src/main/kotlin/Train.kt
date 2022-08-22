import java.sql.*

data class Train(var id:Int,var number:String,var name:String,var source:String,var destination:String,
                 var startTime:String,var endTime:String)
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

    var listOfTrains = ArrayList<Train>()
    //inserting into train
//    query= " insert into train values(17,\"66453\",\"UP Express\",\"Delhi\",\"Kanpur\",\"02-12-22 14:15 PM\",\"04-12-22 10:00 AM\");"
//    statement=connection.createStatement()
//    result=statement.executeUpdate(query)
//    if(result>0){
//        println("Inserted record successfully")
//    }else{
//        println("Failed to insert the record")
//    }

    //updating record -> set source to lucknow
//    query="update train set train_source='Lucknow' where train_id=17"
//    statement=connection.createStatement()
//    result=statement.executeUpdate(query)
//    if(result>0){
//        println("Data Updated successfully ")
//    }else{
//        println("Update operation failed")
//    }

//deletig record
//     query ="delete from train where trin_id=11
//     statement = connection.createStatement()
//     result=statement.executeUpdate(query)
//     if(result>0){
//       println("Data deleted successfully")
//     }else{
//       println("failed to delete due of foreign key constrain")
//       return
//     }

    //displaying table
    query="select * from train"
    statement=connection.createStatement()
    resultSet=statement.executeQuery(query)
    while(resultSet.next()){
        var id=resultSet.getInt("train_id")
        var number=resultSet.getString("train_number")
        var name=resultSet.getString("train_name")
        var source=resultSet.getString("train_source")
        var destination=resultSet.getString("train_destination")
        var sTime=resultSet.getString("start_date")
        var aTime=resultSet.getString("arrival_time")

        val train = Train(id,number,name,source,destination,sTime,aTime)
        listOfTrains.add(train)
    }
    println("list of all trains - ")
    println(listOfTrains)
    connection.close()
}
