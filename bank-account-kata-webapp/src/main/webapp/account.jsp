<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@page import="fr.ing.interview.kata.model.bean.Account"%>

<%@ include file="header.jsp" %>

<%
    Account account = (Account) request.getAttribute("selectedAccount");
    double balance = account.getBalance();
    String accountNumber = account.getAccountNumber();
%>

<center>
    <table>
        <tr>
            <td style="border:1; border-style:inset; padding:40px">
                <center>
                    <h2>Vous consultez le compte n° <%=accountNumber%></h2>
                    <h3>Le solde de votre compte est de <%=balance%> €.</h2>
                    <br/>
                    <br/>
                    <input type="submit" value="Consulter l'historiques de mes transactions" style="width:350px" onclick="location.href='../../transactionHistory.jsp'"/>
                    <br/>
                    <br/>
                    <input type="submit" value="Déposer/Retirer de l'argent" style="width:350px" onclick="location.href='../../addWithdrawMoney.jsp"/>
                </center>
            </td>
        </tr>
    </table>
</center>
<br/>
<br/>
<center><input type="submit" value="Retour" onclick="javascript:window.history.back();"/></center>
