<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="HomePage.aspx.cs" Inherits="ParkingPalsClientSide.HomePage" %>

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
            This is the home page.<br />
            <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
            <br />
            <asp:Button ID="Button1" runat="server" Text="Button" OnClick="Button1_Click" />
            <br />
            <asp:Table ID="MainTable" runat="server" CellPadding="10" GridLines="Both" HorizontalAlign="Center">
                <asp:TableRow>
                    <asp:TableCell>

                        <asp:Table ID="ButtonTable" runat="server" CellPadding="10" GridLines="Both" HorizontalAlign="Center">
                            <asp:TableRow>
                                <asp:TableCell> 
                                    <asp:Label ID="ticketNumberText" runat="server"></asp:Label>
                                </asp:TableCell>
                            </asp:TableRow>

                            <asp:TableRow>
                                <asp:TableCell>
                                    <asp:Button ID="accountInformationButton" runat="server" Text="Account Information" OnClick="accountInformationButton_Click"/>
                                </asp:TableCell>
                            </asp:TableRow>

                            <asp:TableRow>
                                <asp:TableCell>
                                    <asp:Button ID="PaymentButton" runat="server" Text="Payment" OnClick="PaymentButton_Click"/>
                                </asp:TableCell>
                            </asp:TableRow>

                            <asp:TableRow>
                                <asp:TableCell>
                                    Direction
                                    Ian Code? 
                                </asp:TableCell>
                            </asp:TableRow>

                            <asp:TableRow>
                                <asp:TableCell>
                                    Notification
                                    getNotifications();
                                </asp:TableCell>
                            </asp:TableRow>

                            <asp:TableRow>
                                <asp:TableCell>
                                    Login / Create Account
                                    <br />
                                    needToBuild();
                                </asp:TableCell>
                            </asp:TableRow>

                            <asp:TableRow>
                                <asp:TableCell>
                                    <asp:Label ID="getGasInformation" runat="server"></asp:Label>
                                </asp:TableCell>
                            </asp:TableRow>

                            <asp:TableRow>
                                <asp:TableCell style="border-color:white">
                                    <asp:Image ID="Image1" runat="server" src = "images/Parking Pals Logo.PNG" Height="250px" Width="250px" />
                                </asp:TableCell>
                            </asp:TableRow>

                        </asp:Table>

                    </asp:TableCell>
                    <asp:TableCell>
                        
                        <asp:Table ID="WedgitTable" runat="server" CellPadding="10" GridLines="Both" HorizontalAlign="Center">
                            <asp:TableRow>
                                <asp:TableCell>
                                    
                                    <asp:Table ID="TimeParkedTable" runat="server" CellPadding="10" GridLines="Both" HorizontalAlign="Center">
                                        <asp:TableRow>
                                            <asp:TableCell>
                                                Time you have parked
                                            </asp:TableCell>
                                        </asp:TableRow>
                                        <asp:TableRow>
                                            <asp:TableCell>
                                                <asp:Label ID="labelGetParkedTime" runat="server"></asp:Label>
                                            </asp:TableCell>
                                        </asp:TableRow>
                                    </asp:Table>
                                    
                                </asp:TableCell>
                                <asp:TableCell>

                                    <asp:Table ID="CostParkedTable" runat="server" CellPadding="10" GridLines="Both" HorizontalAlign="Center">
                                        <asp:TableRow>
                                            <asp:TableCell>
                                                Total Cost based off time
                                            </asp:TableCell>
                                        </asp:TableRow>
                                        <asp:TableRow>
                                            <asp:TableCell>
                                                <asp:Label ID="labelGetParkedCost" runat="server"></asp:Label>
                                            </asp:TableCell>
                                        </asp:TableRow>
                                    </asp:Table>

                                </asp:TableCell>
                            </asp:TableRow>
                            <asp:TableRow>
                                <asp:TableCell>

                                    <asp:Table ID="ReservationTable" runat="server" CellPadding="10" GridLines="Both" HorizontalAlign="Center">
                                        <asp:TableRow>
                                            <asp:TableCell>
                                                Reservation
                                            </asp:TableCell>
                                        </asp:TableRow>
                                        <asp:TableRow>
                                            <asp:TableCell>
                                                <asp:Label ID="labelGetReservation" runat="server"></asp:Label>
                                            </asp:TableCell>
                                        </asp:TableRow>
                                    </asp:Table>

                                </asp:TableCell>
                                <asp:TableCell>
                                    
                                    <asp:Table ID="StallLocationTable" runat="server" CellPadding="10" GridLines="Both" HorizontalAlign="Center">
                                        <asp:TableRow>
                                            <asp:TableCell>
                                                Stall Number
                                            </asp:TableCell>
                                        </asp:TableRow>
                                        <asp:TableRow>
                                            <asp:TableCell>
                                                <asp:Label ID="labelGetParkedStall" runat="server"></asp:Label>
                                            </asp:TableCell>
                                        </asp:TableRow>
                                    </asp:Table>
                                    
                                </asp:TableCell>
                            </asp:TableRow>
                            <asp:TableRow>
                                <asp:TableCell>
                                    
                                    <asp:Table ID="AvaiableSpotTable" runat="server" CellPadding="10" GridLines="Both" HorizontalAlign="Center">
                                        <asp:TableRow>
                                            <asp:TableCell>
                                                Avaiable Spots
                                            </asp:TableCell>
                                        </asp:TableRow>
                                        <asp:TableRow>
                                            <asp:TableCell>
                                                <asp:Label ID="labelGetAvaiableSpots" runat="server"></asp:Label>
                                            </asp:TableCell>
                                        </asp:TableRow>
                                    </asp:Table>

                                </asp:TableCell>
                                <asp:TableCell>
                                    
                                    <asp:Table ID="WeatherTabel" runat="server" CellPadding="10" GridLines="Both" HorizontalAlign="Center">
                                        <asp:TableRow>
                                            <asp:TableCell>
                                                Weather
                                            </asp:TableCell>
                                        </asp:TableRow>
                                        <asp:TableRow>
                                            <asp:TableCell>
                                                <asp:Label ID="labelGetWeather" runat="server"></asp:Label>
                                            </asp:TableCell>
                                        </asp:TableRow>
                                    </asp:Table>

                                </asp:TableCell>
                            </asp:TableRow>
                        </asp:Table>


                    </asp:TableCell>
                </asp:TableRow>
            </asp:Table>

            
        </div>
        <asp:Label ID="AccountInfo" runat="server"></asp:Label>
    </form>
</body>
</html>
