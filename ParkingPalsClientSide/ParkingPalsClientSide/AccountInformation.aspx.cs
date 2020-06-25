using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ParkingPalsClientSide
{
    public partial class AccountInformation : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            parkingDB.ParkingDBWSSoapClient obj = new parkingDB.ParkingDBWSSoapClient();
            userLabel.Text = obj.GetUsername(Request.QueryString["username"]);
            emailLabel.Text = obj.GetEmail(Request.QueryString["username"]);
            phoneLabel.Text = obj.GetPhonenumber(Request.QueryString["username"]);
            statusLabel.Text = obj.GetAccountType(Request.QueryString["username"]);

        }

        protected void UpdateButton_Click(object sender, EventArgs e)
        {
            Response.Redirect("https://localhost:44373/UpdateInformation.aspx?username="+ Request.QueryString["username"]) ;
        }

        protected void BackButton_Click(object sender, EventArgs e)
        {
            Response.Redirect("https://localhost:44373/HomePage.aspx?username=" + Request.QueryString["username"]); 
        }
       
    }
}