using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ParkingPalsClientSide
{
    public partial class HomePage : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            getTicketNumber();
            getParkedTime();
            getParkedCost();
            getParkedStallNumber();
            getReservedStallNumber();
            getAvaiableSpots();

            getGasPrice();
            getWeatherInformation();
            getNotifications();
            getDirections();

        }

        void getGasPrice()
        {
            HttpWebRequest serviceRequest = (HttpWebRequest)WebRequest.Create("http://localhost:8080/ParkingPalsServer/service/GasPrice");
            serviceRequest.Method = "GET";
            serviceRequest.ContentLength = 0;
            serviceRequest.ContentType = "text/html";
            serviceRequest.Accept = "text/html";

            try
            {
                HttpWebResponse serviceResponse = (HttpWebResponse)serviceRequest.GetResponse();
                String status = serviceResponse.StatusCode.ToString();
                String gasInfo = serviceResponse.GetResponseHeader("Price");
                getGasInformation.Text = "Regular: $" + gasInfo;
            }
            catch (Exception ex)
            {
                getGasInformation.Text = "MyGasFeed is currently unavaiable.";
            }

        }

        void getWeatherInformation()
        {
            HttpWebRequest serviceRequest = (HttpWebRequest)WebRequest.Create("http://localhost:8080/ParkingPalsServer/service/Weather");
            serviceRequest.Method = "GET";
            serviceRequest.ContentLength = 0;
            serviceRequest.ContentType = "text/html";
            serviceRequest.Accept = "text/html";

            try
            {
                HttpWebResponse serviceResponse = (HttpWebResponse)serviceRequest.GetResponse();
                String status = serviceResponse.StatusCode.ToString();
                String weatherInfo = serviceResponse.GetResponseHeader("Weather");
                labelGetWeather.Text = "Forcast: " + weatherInfo;
            }
            catch (Exception ex)
            {
                labelGetWeather.Text = "OpenWeatherMap is currently unavaiable.";
            }
        }

        void getNotifications()
        {

        }

        void getDirections()
        {

        }

        void getTicketNumber()
        {

            parkingDB.ParkingDBWSSoapClient obj = new parkingDB.ParkingDBWSSoapClient();
            if (Request.QueryString["ticketid"] == null)
            {
                ticketNumberText.Text = "User Name: " + Request.QueryString["username"];
            }
            else
            {
                ticketNumberText.Text = "Ticket ID: " + Request.QueryString["ticketid"];
            }

            /*
            HttpWebRequest serviceRequest = (HttpWebRequest)WebRequest.Create("http://localhost:8080/ParkingPalsServer/getTicketNumber");
            serviceRequest.Method = "GET";
            serviceRequest.ContentLength = 0;
            serviceRequest.ContentType = "text/html";
            serviceRequest.Accept = "text/html";

            try
            {
                HttpWebResponse serviceResponse = (HttpWebResponse)serviceRequest.GetResponse();
                String status = serviceResponse.StatusCode.ToString();
                String ticket = serviceResponse.GetResponseHeader("ticketNumber");
                ticketNumberText.Text = ticket;
            } catch (Exception ex)
            {
                ticketNumberText.Text = "Error in DB Call.";
            }
            */
        }

        void getParkedTime()
        {
            HttpWebRequest serviceRequest = (HttpWebRequest)WebRequest.Create("http://localhost:8080/ParkingPalsServer/getTicketTotalTime");
            serviceRequest.Method = "GET";
            serviceRequest.ContentLength = 0;
            serviceRequest.ContentType = "text/html";
            serviceRequest.Accept = "text/html";

            try
            {
                HttpWebResponse serviceResponse = (HttpWebResponse)serviceRequest.GetResponse();
                String status = serviceResponse.StatusCode.ToString();
                String totalTime = serviceResponse.GetResponseHeader("ticketTotalTime");
                labelGetParkedTime.Text = totalTime;
            }
            catch (Exception ex)
            {
                labelGetParkedTime.Text = "Error: Could not get total parked time.";
            }
        }

        void getParkedCost()
        {
            HttpWebRequest serviceRequest = (HttpWebRequest)WebRequest.Create("http://localhost:8080/ParkingPalsServer/getTicketCost");
            serviceRequest.Method = "GET";
            serviceRequest.ContentLength = 0;
            serviceRequest.ContentType = "text/html";
            serviceRequest.Accept = "text/html";

            try
            {
                HttpWebResponse serviceResponse = (HttpWebResponse)serviceRequest.GetResponse();
                String status = serviceResponse.StatusCode.ToString();
                String totalCost = serviceResponse.GetResponseHeader("ticketCost");
                labelGetParkedCost.Text = totalCost;
            }
            catch (Exception ex)
            {
                labelGetParkedCost.Text = "Error: Could not get total cost.";
            }
        }

        void getParkedStallNumber()
        {
            HttpWebRequest serviceRequest = (HttpWebRequest)WebRequest.Create("http://localhost:8080/ParkingPalsServer/getStallNumber");
            serviceRequest.Method = "GET";
            serviceRequest.ContentLength = 0;
            serviceRequest.ContentType = "text/html";
            serviceRequest.Accept = "text/html";

            try
            {
                HttpWebResponse serviceResponse = (HttpWebResponse)serviceRequest.GetResponse();
                String status = serviceResponse.StatusCode.ToString();
                String stallNumber = serviceResponse.GetResponseHeader("ticketStallNumber");
                labelGetParkedStall.Text = stallNumber;
            }
            catch (Exception ex)
            {
                labelGetParkedStall.Text = "Error: Could not get stall number.";
            }
        }

        void getReservedStallNumber()
        {
            HttpWebRequest serviceRequest = (HttpWebRequest)WebRequest.Create("http://localhost:8080/ParkingPalsServer/getStallNumber");
            serviceRequest.Method = "GET";
            serviceRequest.ContentLength = 0;
            serviceRequest.ContentType = "text/html";
            serviceRequest.Accept = "text/html";

            try
            {
                HttpWebResponse serviceResponse = (HttpWebResponse)serviceRequest.GetResponse();
                String status = serviceResponse.StatusCode.ToString();
                //String reservation = serviceResponse.GetResponseHeader("####");
                labelGetReservation.Text = "STALL NUMBER";//reservation;
            }
            catch (Exception ex)
            {
                labelGetReservation.Text = "Error: Could not get reservation.";
            }
        }

        void getAvaiableSpots()
        {
            HttpWebRequest serviceRequest = (HttpWebRequest)WebRequest.Create("http://localhost:8080/ParkingPalsServer/getStallNumber");
            serviceRequest.Method = "GET";
            serviceRequest.ContentLength = 0;
            serviceRequest.ContentType = "text/html";
            serviceRequest.Accept = "text/html";

            try
            {
                HttpWebResponse serviceResponse = (HttpWebResponse)serviceRequest.GetResponse();
                String status = serviceResponse.StatusCode.ToString();
                //String avaiableSpot = serviceResponse.GetResponseHeader("####");
                labelGetAvaiableSpots.Text = "####";// avaiableSpot;
            }
            catch (Exception ex)
            {
                labelGetAvaiableSpots.Text = "Error: Could get Avaiable Spot count.";
            }
        }




        protected void Button1_Click(object sender, EventArgs e)
        {

        }

        protected void accountInformationButton_Click(object sender, EventArgs e)
        {
            if (Request.QueryString["ticketid"] == null)
            {
                string username = Request.QueryString["username"];
                Response.Redirect("https://localhost:44373/AccountInformation.aspx?username=" + username);
                
            }
            else
            {
                AccountInfo.Text = "This is a temporary ticket without account information.";
            }
            
        }

        protected void PaymentButton_Click(object sender, EventArgs e)
        {
            Response.Redirect("https://localhost:44373/PaymentInformation.aspx");
        }
    }
}