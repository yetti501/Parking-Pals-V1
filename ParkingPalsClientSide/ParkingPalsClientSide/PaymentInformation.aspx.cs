using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ParkingPalsClientSide
{
    public partial class PaymentInformation : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Paypal_Click(object sender, EventArgs e)
        {
            Response.Redirect("https://www.paypal.com");
        }

        protected void Apple_Click(object sender, EventArgs e)
        {
           
            Response.Redirect("https://www.apple.com/apple-pay/");
        }

        protected void Google_Click(object sender, EventArgs e)
        {
            Response.Redirect("https://pay.google.com/");
        }
    }
}