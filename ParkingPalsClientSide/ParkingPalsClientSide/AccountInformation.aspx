<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="AccountInformation.aspx.cs" Inherits="ParkingPalsClientSide.AccountInformation" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            text-align: center;
        }
    </style>

</head>
<body style="text-align: center">
    <form id="form1" runat="server">
        <div class="auto-style1">
            <asp:Table ID="MainTable" runat="server" CellPadding="10" GridLines="Both" HorizontalAlign="Center">
                <asp:TableRow>
                    <asp:TableCell>

                        <asp:Table ID="InfoTable" runat="server" CellPadding="10" GridLines="Both" HorizontalAlign="Center">
                            <asp:TableRow>
                                <asp:TableCell>
                                    Account Information                           
                                </asp:TableCell>
                            </asp:TableRow>
                            
                            <asp:TableRow>
                                <asp:TableCell>
                                    Username: <asp:Label ID="userLabel" runat="server" Text="user"></asp:Label>
                                </asp:TableCell>
                            </asp:TableRow>

                            <asp:TableRow>
                                <asp:TableCell>
                                    Email: <asp:Label ID="emailLabel" runat="server" Text="email"></asp:Label>
                                </asp:TableCell>
                            </asp:TableRow>

                            <asp:TableRow>
                                <asp:TableCell>
                                    Phone number: <asp:Label ID="phoneLabel" runat="server" Text="phone"></asp:Label>
                                </asp:TableCell>
                            </asp:TableRow>

                            <asp:TableRow>
                                <asp:TableCell>
                                    <asp:Button ID="updateButtton" runat="server" Text="Update Information" OnClick="UpdateButton_Click"/>
                                </asp:TableCell>
                            </asp:TableRow>


                            <asp:TableRow>
                                <asp:TableCell style="border-color:white">
                                    <asp:Image ID="Image1" runat="server" src = "images/Parking Pals Logo.PNG" Height="250px" Width="250px" />
                                </asp:TableCell>
                            </asp:TableRow>

                            <asp:TableRow>
                                <asp:TableCell>
                                    <asp:Button ID="backButton" runat="server" Text="Back" OnClick="BackButton_Click"/>
                                </asp:TableCell>
                            </asp:TableRow>
                        </asp:Table>

                    </asp:TableCell>
                    <asp:TableCell>
                        
                        <asp:Table ID="UsageTable" runat="server" CellPadding="10" GridLines="Both" HorizontalAlign="Center">
                         
                            <asp:TableRow>
                                <asp:TableCell>
                                    Membership Status: <asp:Label ID="statusLabel" runat="server" Text="status"></asp:Label>
                                </asp:TableCell>
                            </asp:TableRow>
                            
                            <asp:TableRow>
                                <asp:TableCell>
                                    Next Payment: <asp:Label ID="nextLabel" runat="server" Text="next"></asp:Label>
                                </asp:TableCell>
                            </asp:TableRow>

                            <asp:TableRow>
                                <asp:TableCell>
                                    Account Balance: <asp:Label ID="balanceLabel" runat="server" Text="balance"></asp:Label>
                                </asp:TableCell>
                            </asp:TableRow>

                            <asp:TableRow>
                                <asp:TableCell>
                                    Monthly Usage: <asp:Label ID="usageLabel" runat="server" Text="usage"></asp:Label>
                                </asp:TableCell>
                            </asp:TableRow>



                        </asp:Table>


                    </asp:TableCell>
                </asp:TableRow>
            </asp:Table>

            
        </div>
        
    </form>
</body>
</html>
