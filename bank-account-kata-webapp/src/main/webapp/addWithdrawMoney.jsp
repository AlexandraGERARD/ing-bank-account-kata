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
                    <form action="balance/<%=accountNumber%>" method="post" style="width: 450px;margin-left: auto;margin-right: auto">
                        <input type="submit" value="Consulter le solde de mon compte" style="width:350px"/>
                    </form>
                    <br/>
                    <br/>
                    <input type="submit" value="Déposer/Retirer de l'argent" style="width:350px" onclick="location.href='../addWithdraw.jsp"/>
                </center>
            </td>
        </tr>
    </table>
</center>
<br/>
<br/>
<center><input type="submit" value="Retour" onclick="javascript:window.history.back();"/></center>
