<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ include file="header.jsp" %>

<%
    List<Transaction> transactions = (List<Transaction>) request.getSession().getAttribute("transactions");
    Account account = (Account) request.getSession().getAttribute("selectedAccount");
%>

<center>
    <table>
        <tr>
            <td style="border:1; border-style:inset; padding:40px">
                <center>
                    <h2>Vous consultez le compte n° <%=account.getAccountNumber()%></h2>
                    <h3>Le solde de votre compte est de <%=account.getBalance()%> €.</h3>
                    <h3>Voici la liste des transactions effectuées sur ce compte.</h3>
                    <br/>
                    <br/>
                    <table id="transactions">
                        <tr style="font-weight: bold">
                            <td>Date de la transaction</td>
                            <td>Montant</td>
                        </tr>

                        <% for (int i = 0; i < transactions.size(); i++) {%>
                            <%Date date = transactions.get(i).getDate();
                              double amount = transactions.get(i).getAmount();%>
                            <tr>
                                <td><%=date%></td>
                                <td><%=amount%>€</td>
                            </tr>
                         <%}%>
                    </table>
                </center>
            </td>
        </tr>
    </table>
</center>
<br/>
<br/>
<center>
    <form action="../../../rest/account/<%=account.getAccountNumber()%>" method="get">
        <input type="submit" value="Retour"/>
    </form>
</center>
