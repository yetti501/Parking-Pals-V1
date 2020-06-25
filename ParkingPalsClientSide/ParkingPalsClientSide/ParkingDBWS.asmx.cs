using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace ParkingPalsClientSide
{
    /// <summary>
    /// ParkingDBWS 的摘要说明
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // 若要允许使用 ASP.NET AJAX 从脚本中调用此 Web 服务，请取消注释以下行。 
    // [System.Web.Script.Services.ScriptService]
    public class ParkingDBWS : System.Web.Services.WebService
    {

        [WebMethod]
        public string HelloWorld()
        {
            return "Hello World";
        }

        [WebMethod]
        public bool PostUser(string username, string firstname, string lastname, string email, string phonenumber, string password, string accounttype)
        {
            // connect with database
            String connStr = "Data Source=(LocalDB)\\MSSQLLocalDB;AttachDbFilename=|DataDirectory|ParkingPalConnection.mdf;Integrated Security = True";
            SqlConnection conn = new SqlConnection(connStr);
            SqlCommand numberCommand = new SqlCommand("Select * from managementDB where parkingStructureID=1", conn);
            SqlCommand insertcommand = new SqlCommand("INSERT INTO userProfile (userID, username, password, firstname, lastname, email, phoneNumber, accountType) " +
                "VALUES(@id, @username, @password, @firstname, @lastname, @email, @phonenumber, @accountType); ", conn);
            conn.Open();
            int number = 0;
            int premium = 0;
            int standard = 0;
            int free = 0;
            using (SqlDataReader reader = numberCommand.ExecuteReader())
            {
                while (reader.Read())
                {
                    // add information to int
                    premium = reader.GetInt32(2);
                    standard = reader.GetInt32(3);
                    free = reader.GetInt32(4);
                    number = premium + standard + free;
                }
            }
            insertcommand.Parameters.AddWithValue("@id", number+1);
            insertcommand.Parameters.AddWithValue("@username", username);
            insertcommand.Parameters.AddWithValue("@password", password);
            insertcommand.Parameters.AddWithValue("@firstname", firstname);
            insertcommand.Parameters.AddWithValue("@lastname", lastname);
            insertcommand.Parameters.AddWithValue("@email", email);
            insertcommand.Parameters.AddWithValue("@phonenumber", phonenumber);
            insertcommand.Parameters.AddWithValue("@accountType",accounttype);
            insertcommand.ExecuteNonQuery();

     
            if (string.Equals(accounttype, "Premium"))
            {
                SqlCommand updatetotal = new SqlCommand("UPDATE managementDB SET numPremium = @number WHERE parkingStructureID = 1;", conn);
                updatetotal.Parameters.AddWithValue("@number", premium+1);
                updatetotal.ExecuteNonQuery();
            }
            else if (string.Equals(accounttype, "Standard"))
            {
                SqlCommand updatetotal = new SqlCommand("UPDATE managementDB SET numStandard = @number WHERE parkingStructureID = 1;", conn);
                updatetotal.Parameters.AddWithValue("@number", standard+1);
                updatetotal.ExecuteNonQuery();
            }
            else
            {
                SqlCommand updatetotal = new SqlCommand("UPDATE managementDB SET numFree = @number WHERE parkingStructureID = 1;", conn);
                updatetotal.Parameters.AddWithValue("@number", free+1);
                updatetotal.ExecuteNonQuery();
            }

            return true;


        }
        [WebMethod]
        public bool PutUser(string username, string email, string password, string phonenumber)
        {
            // connect with the database
            String connStr = "Data Source=(LocalDB)\\MSSQLLocalDB;AttachDbFilename=|DataDirectory|ParkingPalConnection.mdf;Integrated Security = True";
            SqlConnection conn = new SqlConnection(connStr);

            conn.Open();
            if (!string.Equals(email,""))
            {
                SqlCommand updatecommand = new SqlCommand("UPDATE userProfile SET email = @email WHERE username = @username;", conn);
                updatecommand.Parameters.AddWithValue("@email", email);
                updatecommand.Parameters.AddWithValue("@username", username);

                updatecommand.ExecuteNonQuery();
            }
            if (!string.Equals(phonenumber, ""))
            {
                SqlCommand updatecommand = new SqlCommand("UPDATE userProfile SET phonenumber = @phonenumber WHERE username = @username;", conn);
                updatecommand.Parameters.AddWithValue("@phonenumber", phonenumber);
                updatecommand.Parameters.AddWithValue("@username", username);

                updatecommand.ExecuteNonQuery();
            }
            if (!string.Equals(password, ""))
            {
                SqlCommand updatecommand = new SqlCommand("UPDATE userProfile SET password = @password WHERE username = @username;", conn);
                updatecommand.Parameters.AddWithValue("@password", password);
                updatecommand.Parameters.AddWithValue("@username", username);

                updatecommand.ExecuteNonQuery();
            }
           
            

            return true;

        }
        [WebMethod]
        public string GetUsername(string username)
        {
            String connStr = "Data Source=(LocalDB)\\MSSQLLocalDB;AttachDbFilename=|DataDirectory|ParkingPalConnection.mdf;Integrated Security = True";
            SqlConnection conn = new SqlConnection(connStr);
            SqlCommand command = new SqlCommand("Select * from userProfile where username=@id", conn);
            command.Parameters.AddWithValue("@id", username);
            conn.Open();
            using (SqlDataReader reader = command.ExecuteReader())
            {
                if (reader.Read())
                {
                    // add information to string and return
                 
                    return reader.GetString(1);
                }
            }
            return "Error";
        }

        [WebMethod]
        public string GetEmail(string username)
        {
            String connStr = "Data Source=(LocalDB)\\MSSQLLocalDB;AttachDbFilename=|DataDirectory|ParkingPalConnection.mdf;Integrated Security = True";
            SqlConnection conn = new SqlConnection(connStr);
            SqlCommand command = new SqlCommand("Select * from userProfile where username=@id", conn);
            command.Parameters.AddWithValue("@id", username);
            conn.Open();
            using (SqlDataReader reader = command.ExecuteReader())
            {
                if (reader.Read())
                {
                    // add information to string and return

                    return reader.GetString(5);
                }
            }
            return "Error";
        }

        [WebMethod]
        public string GetPhonenumber(string username)
        {
            String connStr = "Data Source=(LocalDB)\\MSSQLLocalDB;AttachDbFilename=|DataDirectory|ParkingPalConnection.mdf;Integrated Security = True";
            SqlConnection conn = new SqlConnection(connStr);
            SqlCommand command = new SqlCommand("Select * from userProfile where username=@id", conn);
            command.Parameters.AddWithValue("@id", username);
            conn.Open();
            using (SqlDataReader reader = command.ExecuteReader())
            {
                if (reader.Read())
                {
                    // add information to string and return

                    return reader.GetString(6);
                }
            }
            return "Error";
        }

        [WebMethod]
        public string GetAccountType(string username)
        {
            String connStr = "Data Source=(LocalDB)\\MSSQLLocalDB;AttachDbFilename=|DataDirectory|ParkingPalConnection.mdf;Integrated Security = True";
            SqlConnection conn = new SqlConnection(connStr);
            SqlCommand command = new SqlCommand("Select * from userProfile where username=@id", conn);
            command.Parameters.AddWithValue("@id", username);
            conn.Open();
            using (SqlDataReader reader = command.ExecuteReader())
            {
                if (reader.Read())
                {
                    // add information to string and return

                    return reader.GetString(7);
                }
            }
            return "Error";
        }

        [WebMethod]
        public bool checkTicket(string ticketid)
        {
            String connStr = "Data Source=(LocalDB)\\MSSQLLocalDB;AttachDbFilename=|DataDirectory|ParkingPalConnection.mdf;Integrated Security = True";
            SqlConnection conn = new SqlConnection(connStr);
            SqlCommand command = new SqlCommand("Select * from ticketDB where ticketID=@id", conn);
            command.Parameters.AddWithValue("@id", ticketid);
            conn.Open();
            using (SqlDataReader reader = command.ExecuteReader())
            {
                if (reader.Read())
                {
                    

                    return true;
                }
            }
            return false;
        }

        [WebMethod]
        public bool checkUser(string userid)
        {
            String connStr = "Data Source=(LocalDB)\\MSSQLLocalDB;AttachDbFilename=|DataDirectory|ParkingPalConnection.mdf;Integrated Security = True";
            SqlConnection conn = new SqlConnection(connStr);
            SqlCommand command = new SqlCommand("Select * from userProfile where userID=@id", conn);
            command.Parameters.AddWithValue("@id", userid);
            conn.Open();
            using (SqlDataReader reader = command.ExecuteReader())
            {
                if (reader.Read())
                {
                   
                    return true;
                }
            }
            return false;
        }

    }
}

