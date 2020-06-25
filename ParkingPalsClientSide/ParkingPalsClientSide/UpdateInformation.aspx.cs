using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ParkingPalsClientSide
{
    public partial class UpdateInformation : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            parkingDB.ParkingDBWSSoapClient obj = new parkingDB.ParkingDBWSSoapClient();
            userLabel.Text = obj.GetUsername(Request.QueryString["username"]);
        }

        protected void updateButton_Click(object sender, EventArgs e)
        {
            parkingDB.ParkingDBWSSoapClient obj = new parkingDB.ParkingDBWSSoapClient();
            obj.PutUser(userLabel.Text, newEmailLabel.Text, newPasswordLabel.Text, newPhoneLabel.Text);
        }
    }
}