<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="UpdateInformation.aspx.cs" Inherits="ParkingPalsClientSide.UpdateInformation" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        .auto-style1 {
            text-align: center;
            font-size: xx-large;
        }
        .auto-style2 {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div class="auto-style1">
            <asp:Label ID="userLabel" runat="server" Text="username" style="font-weight: 700"></asp:Label>
            <strong>, Update Information<br />
            <asp:Image ID="Image1" runat="server" Height="250px" src="images/Parking Pals Logo.PNG" Width="250px" />
            <br />
            </strong>
            New Email: <asp:TextBox ID="newEmailLabel" runat="server" Height="22px" style="margin-top: 6px" Width="185px" CssClass="auto-style2"></asp:TextBox>
            <br />
            New Phone Number:
            <asp:TextBox ID="newPhoneLabel" runat="server" Height="22px" style="margin-top: 6px" Width="185px" CssClass="auto-style2"></asp:TextBox>
            <br />
            New Password:
            <asp:TextBox ID="newPasswordLabel" runat="server" Height="22px" style="margin-top: 6px" Width="185px" CssClass="auto-style2"></asp:TextBox>
            <br />
            Repeat New Password:
            <asp:TextBox ID="repeatLabel" runat="server" Height="22px" style="margin-top: 6px; font-weight: 700;" Width="185px"></asp:TextBox>
            <strong>
            <br />
            <br />
            <asp:Button ID="updateButton" runat="server" Height="60px" Text="Update" Width="120px" style="font-weight: 700" OnClick="updateButton_Click" />
            <br />
            </strong>
        </div>
    </form>
</body>
</html>
