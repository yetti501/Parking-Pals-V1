<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="SignupPage.aspx.cs" Inherits="ParkingPalsClientSide.SignupPage" %>

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
            Sign Up Information<br />
            <strong>
            <asp:Image ID="Image1" runat="server" Height="250px" src="images/Parking Pals Logo.PNG" Width="250px" />
            <br />
            </strong>
            Username: <asp:TextBox ID="UserLabel" runat="server" Height="22px" style="margin-top: 6px" Width="185px" CssClass="auto-style2"></asp:TextBox>
            <br />
            First Name: <asp:TextBox ID="FirstnameLabel" runat="server" Height="22px" style="margin-top: 6px" Width="185px" CssClass="auto-style2"></asp:TextBox>
            <br />
            Last Name: <asp:TextBox ID="LastnameLabel" runat="server" Height="22px" style="margin-top: 6px" Width="185px" CssClass="auto-style2"></asp:TextBox>
            <br />
            Email: <asp:TextBox ID="EmailLabel" runat="server" Height="22px" style="margin-top: 6px" Width="185px" CssClass="auto-style2"></asp:TextBox>
            <br />
            Phone Number:
            <asp:TextBox ID="PhoneLabel" runat="server" Height="22px" style="margin-top: 6px" Width="185px" CssClass="auto-style2"></asp:TextBox>
            <br />
            &nbsp;&nbsp;
            Account Type:&nbsp;
            <asp:CheckBoxList ID="AccountList" runat="server" style="text-align: center; margin-left: 378px" Width="758px">
                <asp:ListItem>Premium</asp:ListItem>
                <asp:ListItem>Standard</asp:ListItem>
                <asp:ListItem>Free</asp:ListItem>
            </asp:CheckBoxList>
            Password:
            <asp:TextBox ID="PasswordLabel" runat="server" Height="22px" style="margin-top: 6px" Width="185px" CssClass="auto-style2"></asp:TextBox>
            <br />
            Repeat Password:
            <asp:TextBox ID="RepeatLabel" runat="server" Height="22px" style="margin-top: 6px; font-weight: 700;" Width="185px"></asp:TextBox>
            <strong>
            <br />
            <br />
            <asp:Button ID="SignupButton" runat="server" Height="60px" Text="Sign up" Width="120px" style="font-weight: 700" OnClick="signupButton_Click" />
            <br />
            </strong>
        </div>
    </form>
</body>
</html>