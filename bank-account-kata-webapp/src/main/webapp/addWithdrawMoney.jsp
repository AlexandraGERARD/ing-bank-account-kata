<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ include file="header.jsp" %>

<%
    Account account = (Account) request.getSession().getAttribute("selectedAccount");
    double balance = account.getBalance();
    String accountNumber = account.getAccountNumber();
%>

<center>
    <table>
        <tr>
            <td style="border:1; border-style:inset; padding:40px">
                <center>
                    <h2>Vous consultez le compte n° <%=accountNumber%></h2>
                    <h3>Le solde de votre compte est de <%=balance%> €.</h3>
                    <br/>
                    <br/>

                    <table>
                        <tr>
                            <td style="border:1; border-style:inset; padding:20px">
                                <center>
                                    <h3>Effectuer un crédit</h3>
                                    <p style="color:red">Montant minimum: 0.01€</p>
                                    <form action="add" method="post">
                                        <input type="text" id="addAmount" pattern="[0-9]+([,.][0-9]{1,2})?" style="text-align:right;"/> <output style="color:black" visibility="visible" value="€"/>
                                        <br/>
                                        <br/>
                                        <input type="submit" value="Valider"/>
                                    </form>
                                </center>
                            </td>
                            <td style="border:1; border-style:inset; padding:20px">
                                <center>
                                    <h3>Effectuer un débit</h3>
                                    <p style="color:red">Montant maximum: <%=balance%> €</p>
                                    <form action="withdraw" method="post">
                                        <input type="text" id="withdrawAmount" pattern="[0-9]+([,.][0-9]{1,2})?" style="text-align:right"/> €
                                        <br/>
                                        <br/>
                                        <input type="submit" value="Valider"/>
                                    </form>
                                </center>
                            </td>
                        </tr>
                    </table>
                </center>
            </td>
        </tr>
    </table>
</center>
<br/>
<br/>
<center>
    <form action="../../../rest/account/<%=accountNumber%>" method="get">
        <input type="submit" value="Retour"/>
    </form>
</center>
