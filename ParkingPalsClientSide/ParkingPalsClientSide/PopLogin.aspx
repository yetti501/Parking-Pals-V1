<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PopLogin.aspx.cs" Inherits="ParkingPalsClientSide.PopLogin" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
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

</head>
<body>
    <form id="form1" runat="server">
        <asp:Table ID="MainTable" runat="server" CellPadding="10" GridLines="Both" HorizontalAlign="Center" BorderColor="white">
            <asp:TableRow>
                <asp:TableCell>
                    <asp:Image ID="Image1" runat="server" src = "images/Parking Pals Logo.PNG" Height="250px" Width="250px" />
                </asp:TableCell>
                <asp:TableCell>
                <div style="text-align: center">
                    <asp:Label ID="labelUsername" runat="server" style="text-align: center" Text="Enter Username"></asp:Label>
                    :
                    <asp:TextBox ID="getUsernameText" runat="server" OnTextChanged="getUsernameText_TextChanged"></asp:TextBox>
                    <br />
                    <asp:Label ID="labelPassword" runat="server" Text="Enter Password"></asp:Label>
                    :
                    <asp:TextBox ID="getPasswordText" runat="server" TextMode="Password" OnTextChanged="getPasswordText_TextChanged"></asp:TextBox>
                    <br />
                    <asp:Button ID="checkCredentialsButton" runat="server" style="text-align: center" Text="Login" OnClick="checkCredentialsButton_Click" />
                    
                    <asp:Button ID="Button1" runat="server" style="text-align: center" Text="Forgot Password" OnClick="checkCredentialsButton_Click" />
                    <br />
                    <asp:Label ID="labelError" runat="server"></asp:Label>
                </div>
                </asp:TableCell>
            </asp:TableRow>
        </asp:Table>
    </form>
</body>
</html>
