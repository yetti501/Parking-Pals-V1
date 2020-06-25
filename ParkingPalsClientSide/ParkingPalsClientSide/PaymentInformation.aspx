<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PaymentInformation.aspx.cs" Inherits="ParkingPalsClientSide.PaymentInformation" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div style="text-align:center">
            <asp:Label ID="TitleLabel" runat="server" style="color: #6600FF; font-size: xx-large; font-weight: 700;" Text="Payment"></asp:Label>

            <br />
            <br />
            <br />
            <asp:Button ID="Paypal" runat="server" Height="59px" OnClick="Paypal_Click" style="font-size: larger; font-weight: 700" Text="Paypal" Width="132px" />
            <br />
            <br />
            <br />
            <asp:Button ID="Apple" runat="server" Height="59px" style="font-size: larger; font-weight: 700" Text="Apple Pay" Width="132px" OnClick="Apple_Click" />
            <br />
            <br />
            <br />
            <asp:Button ID="Google" runat="server" Height="59px" OnClick="Google_Click" style="font-size: larger; font-weight: 700" Text="Google Pay" Width="132px" />

        </div>
    </form>
</body>
</html>
