<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ParkingPalsPage.aspx.cs" Inherits="ParkingPalsClientSide.ParkingPals" %>

<!DOCTYPE html>
<style>
.myButton {
	box-shadow: 0px 1px 0px 0px #1c1b18;
	background:linear-gradient(to bottom, #eae0c2 5%, #ccc2a6 100%);
	background-color:#eae0c2;
	border-radius:15px;
	border:2px solid #333029;
	display:inline-block;
	cursor:pointer;
	color:#505739;
	font-family:Arial;
	font-size:12px;
	font-weight:bold;
	padding:10px 12px;
	text-decoration:none;
	text-shadow:0px 1px 0px #ffffff;
}
</style>
<html xmlns="http://www.w3.org/1999/xhtml">
 
<head runat="server">
    <title></title>
</head>
<body style="text-align: center">
    <form id="form1" runat="server">
        <div>
            <h1>
            <asp:Label ID="TitleLabel" runat="server" style="color: #6600FF;" Text="Parking Pals"></asp:Label>
            </h1>
            <h1 style="text-align: center">
                <asp:Button CssClass="myButton" ID="homeLoginButton" runat="server" Text="Login" OnClick="homeLoginButton_Click" />
                <br/>
                <br/>
                <asp:Button CssClass="myButton" ID="homeSignupButton" runat="server" Text="Sign up" OnClick="homeSignupButton_Click" Height="49px" Width="71px" />
            </h1>

            <h1> 
                <asp:Image ID="Image1" runat="server" src = "images/Parking Pals Logo.PNG" Height="250px" Width="250px" />
            </h1>
            <address>
                <asp:Label ID="Label1" runat="server" style="font-family:Arial" Text="Enter Ticket Number:"></asp:Label>
            </address>
            <h1 style="text-align: center">
                <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
                <asp:Button CssClass="myButton" ID="Button1" runat="server" Text="Check Ticket" OnClick="Button1_Click1" />
            </h1>
            <p>
                <asp:Label ID="ticketNumber" runat="server"></asp:Label>
               
            </p>
        </div>
    </form>
</body>
</html>
