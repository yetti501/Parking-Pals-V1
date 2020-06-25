using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ParkingPalsClientSide
{
    public partial class PopLogin : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void getUsernameText_TextChanged(object sender, EventArgs e)
        {

        }

        protected void getPasswordText_TextChanged(object sender, EventArgs e)
        {

        }

        protected void checkCredentialsButton_Click(object sender, EventArgs e)
        {
            string connStr = "Data Source=(LocalDB)\\MSSQLLocalDB;AttachDbFilename=|DataDirectory|ParkingPalConnection.mdf;Integrated Security=True";
            SqlConnection conn = new SqlConnection(connStr);
            conn.Open();
            //SqlCommand command = new SqlCommand("SELECT * FROM userProfile WHERE username=" + getUsernameText.Text + ";", conn);
            SqlCommand command = new SqlCommand("SELECT * FROM userProfile WHERE username=@user;", conn);
            command.Parameters.AddWithValue("@user", getUsernameText.Text);

            using (SqlDataReader reader = command.ExecuteReader())
            {
                if (reader.HasRows)
                {
                    string userPassword = "";
                    while (reader.Read())
                    {
                        userPassword = reader.GetString(2);
                    }
                    if (string.Equals(getPasswordText.Text, userPassword))
                    {
                        Response.Redirect("https://localhost:44373/HomePage.aspx?username="+getUsernameText.Text);
                    } 
                    else
                    {
                        labelError.Text = "You have entered an incorrect password.";
                        
                    }
                }
                else
                {
                    labelError.Text = "You have entered an incorrect username.";
                }
            }

            /*
                try
                {
                    HttpWebRequest credentials = (HttpWebRequest)WebRequest.Create("http://localhost:8080/ParkingPalsServer/getUserInformation/checkCredentials");
                    credentials.Method = "GET";
                    credentials.ContentLength = 0;
                    credentials.ContentType = "text/html";
                    credentials.Accept = "text/html";

                    credentials.Headers.Add("username", getUsernameText.Text);
                    credentials.Headers.Add("password", getPasswordText.Text);
                    try
                    {
                        HttpWebResponse serviceResponse = (HttpWebResponse)credentials.GetResponse();

                        //String ticket = serviceResponse.GetResponseHeader("ticketNumber");
                        bool vaild = bool.Parse(serviceResponse.GetResponseHeader("valid"));

                        if (vaild)
                        {
                            Response.Redirect("https://localhost:44373/HomePage.aspx");
                        }
                        else
                        {
                            string errorMessage = serviceResponse.GetResponseHeader("Error");
                            labelError.Text = errorMessage;
                        }
                    }
                    catch (Exception ex)
                    {
                        string statusError = "Something went wrongin receieving headers";
                        labelError.Text = statusError;
                    }

                }
                catch (Exception ex)
                {
                    string statusError = "Something went wrong in sending headers";
                    labelError.Text = statusError;
                }
                */
        }
    }
}