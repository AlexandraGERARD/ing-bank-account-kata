<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ include file="header.jsp" %>

<%
    Account account = (Account) request.getSession().getAttribute("selectedAccount");
    double balance = account.getBalance();
%>

<center>
    <table>
        <tr>
            <td style="border:1; border-style:inset; padding:40px">
                <center>
                    <h2>Vous consultez le compte n° <%=accountNumber%></h2>
                    <h3>Le solde de votre compte est de <%=account.getBalance()%> €.</h3>
                    <br/>
                    <br/>
                    <form action="../../rest/transaction/list/<%=accountNumber%>" method="get">
                        <input type="submit" value="Consulter l'historique de mes transactions" style="width:350px"/>
                    </form>
                    <br/>
                    <br/>
                    <form action="../../rest/transaction/addWithdraw/<%=accountNumber%>" method="get">
                        <input type="submit" value="Déposer/Retirer de l'argent" style="width:350px"/>
                    </form
                </center>
            </td>
        </tr>
    </table>
</center>
<br/>
<br/>
<center><input type="submit" value="Retour" onclick="javascript:window.history.back();"/></center>
